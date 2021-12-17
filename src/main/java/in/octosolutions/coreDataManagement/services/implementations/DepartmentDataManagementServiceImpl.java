package in.octosolutions.coreDataManagement.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.repository.interfaces.IDepartmentDataManagementRepository;
import in.octosolutions.coreDataManagement.services.interfaces.IDepartmentDataManagementService;
import in.octosolutions.nucleus.service.interfaces.IGenericUtilityInterface;
import in.octosolutions.nucleus.service.interfaces.IQueryBuilder;
import in.octosolutions.nucleus.service.interfaces.IRestLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static in.octosolutions.coreDataManagement.utils.CoreDataManagementConstants.DEPARTMENT;
import static in.octosolutions.coreDataManagement.utils.CoreDataManagementConstants.NAME;

@Service
public class DepartmentDataManagementServiceImpl implements IDepartmentDataManagementService {

    private final MongoTemplate mongoTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    IDepartmentDataManagementRepository departmentDataManagementRepository;
    @Inject
    IGenericUtilityInterface genericUtilityInterface;
    @Inject
    private IRestLogic restLogic;
    @Inject
    private IQueryBuilder queryBuilder;

    public DepartmentDataManagementServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Department> getDepartments(String filter) {
        if (restLogic.isValidFilter(filter)) {
            return mongoTemplate.find(queryBuilder.mongoSearchQuery(restLogic.getAttributeMap(filter)), Department.class);
        } else {
            return mongoTemplate.findAll(Department.class);
        }
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        Department department = mongoTemplate.findById(departmentId, Department.class);
        return department;
    }

    @Override
    public Department saveDepartment(Department department) {
        if (!isDepartmentAlreadyExists(department.getName())) {
            department.setId(genericUtilityInterface.uniqueIdGenerator(DEPARTMENT));
            return departmentDataManagementRepository.save(department);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Department> deleteDepartments(String filter) {
        List<Department> departmentList = this.getDepartments(filter);
        departmentList.stream().forEach(d -> mongoTemplate.remove(d));
        return departmentList;
    }

    @Override
    public Department deleteDepartmentById(String departmentId) {
        Department department = this.getDepartmentById(departmentId);
        mongoTemplate.remove(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department, JsonPatch payload) throws JsonPatchException {
        Department patchedDepartment = applyPatchToDepartment(payload, department);
        departmentDataManagementRepository.save(patchedDepartment);
        return patchedDepartment;
    }

    private Department applyPatchToDepartment(JsonPatch patch, Department targetDepartment)
            throws JsonPatchException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetDepartment, JsonNode.class));
        try {
            return objectMapper.treeToValue(patched, Department.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private boolean isDepartmentAlreadyExists(String name) {
        Map<String, String> attributeMap = new HashMap<>();
        attributeMap.put(NAME, name);
        List<Department> departments = mongoTemplate.find(queryBuilder.mongoSearchWithAttribute(attributeMap), Department.class);
        return !CollectionUtils.isEmpty(departments);
    }
}
