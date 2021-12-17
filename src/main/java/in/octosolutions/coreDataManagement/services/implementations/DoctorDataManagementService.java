package in.octosolutions.coreDataManagement.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import in.octosolutions.coreDataManagement.repository.interfaces.IDoctorDataManagementRepository;
import in.octosolutions.coreDataManagement.services.interfaces.IDoctorDataManagementService;
import static in.octosolutions.coreDataManagement.utils.CoreDataManagementConstants.*;
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


@Service
public class DoctorDataManagementService implements IDoctorDataManagementService {
    private final MongoTemplate mongoTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    IDoctorDataManagementRepository doctorDataManagementRepository;

    @Inject
    private IRestLogic restLogic;

    @Inject
    private IQueryBuilder queryBuilder;

    @Inject
    IGenericUtilityInterface genericUtilityInterface;

    public DoctorDataManagementService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Doctor> getDoctors(String filter) {
        if (restLogic.isValidFilter(filter)) {
            return mongoTemplate.find(queryBuilder.mongoSearchQuery(restLogic.getAttributeMap(filter)), Doctor.class);
        } else {
            return mongoTemplate.findAll(Doctor.class);
        }
    }

    @Override
    public Doctor getDoctorById(String doctorId) {
        Doctor doctor = mongoTemplate.findById(doctorId, Doctor.class);
        return doctor;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        if (!isAlreadyExists(doctor.getAadharId(), doctor.getDoctorRegistrationId(), doctor.getDigiDoctorId())) {
            doctor.setId(genericUtilityInterface.uniqueIdGenerator(DOCTOR));
            doctor.setFullName(doctor.getFirstName()+" "+ doctor.getLastName());
            return doctorDataManagementRepository.save(doctor);
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Doctor> deleteDoctors(String filter) {
        List<Doctor> doctorList = this.getDoctors(filter);
        doctorList.stream().forEach(docId -> mongoTemplate.remove(docId));
        return doctorList;
    }

    @Override
    public Doctor deleteDoctorById(String doctorId) {
        Doctor doctor = this.getDoctorById(doctorId);
        mongoTemplate.remove(doctor);
        return doctor;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, JsonPatch payload) throws JsonPatchException {
        Doctor patchedDoctor = applyPatchToDoctor(payload, doctor);
        doctorDataManagementRepository.save(patchedDoctor);
        return patchedDoctor;
    }

    private Doctor applyPatchToDoctor(JsonPatch patch, Doctor targetDoctor)
            throws JsonPatchException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetDoctor, JsonNode.class));
        try {
            return objectMapper.treeToValue(patched, Doctor.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private boolean isAlreadyExists(String aadharId, String regId, String digiDocId) {
        Map<String, String> attributeMap = new HashMap<>();
            attributeMap.put(AADHAR_ID, aadharId);
            attributeMap.put(DIGI_DOC_ID, digiDocId);
            attributeMap.put(DOC_REG_ID, regId);
            List<Doctor> doctors = mongoTemplate.find(queryBuilder.mongoSearchWithAttribute(attributeMap), Doctor.class);
        return !CollectionUtils.isEmpty(doctors);
    }


}
