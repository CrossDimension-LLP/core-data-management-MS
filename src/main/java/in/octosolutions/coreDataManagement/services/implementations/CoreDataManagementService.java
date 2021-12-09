package in.octosolutions.coreDataManagement.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import in.octosolutions.coreDataManagement.repository.interfaces.IDepartmentDataManagementRepository;
import in.octosolutions.coreDataManagement.repository.interfaces.IDoctorDataManagementRepository;
import in.octosolutions.coreDataManagement.repository.interfaces.IPrescriptionDataManagementRepository;
import in.octosolutions.coreDataManagement.services.interfaces.ICoreDataManagementService;
import in.octosolutions.nucleus.service.interfaces.IGenericUtilityInterface;
import in.octosolutions.nucleus.service.interfaces.IQueryBuilder;
import in.octosolutions.nucleus.service.interfaces.IRestLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CoreDataManagementService implements ICoreDataManagementService {
    private final MongoTemplate mongoTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    IDoctorDataManagementRepository doctorDataManagementRepository;

    @Autowired
    IDepartmentDataManagementRepository departmentDataManagementRepository;

    @Autowired
    IPrescriptionDataManagementRepository prescriptionDataManagementRepository;

    @Inject
    private IRestLogic restLogic;

    @Inject
    private IQueryBuilder queryBuilder;

    @Inject
    IGenericUtilityInterface genericUtilityInterface;

    public CoreDataManagementService(MongoTemplate mongoTemplate) {
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
        doctor.setId(genericUtilityInterface.uniqueIdGenerator("Doctor"));
        return doctorDataManagementRepository.save(doctor);
    }

    @Override
    public List<Doctor> deleteDoctors(String filter) {
        List<Doctor> doctorList = this.getDoctors(filter);
        doctorList.stream().forEach(d -> mongoTemplate.remove(d));
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
        department.setId(genericUtilityInterface.uniqueIdGenerator("Department"));
        return departmentDataManagementRepository.save(department);
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

    @Override
    public List<Prescription> getPrescriptions(String filter) {
        if (restLogic.isValidFilter(filter)) {
            return mongoTemplate.find(queryBuilder.mongoSearchQuery(restLogic.getAttributeMap(filter)), Prescription.class);
        } else {
            return mongoTemplate.findAll(Prescription.class);
        }
    }

    @Override
    public Prescription getPrescriptionById(String prescriptionId) {
        Prescription prescription = mongoTemplate.findById(prescriptionId, Prescription.class);
        return prescription;
    }

    @Override
    public Prescription savePrescription(Prescription prescription) {
        prescription.setId(genericUtilityInterface.uniqueIdGenerator("Prescription"));
        return prescriptionDataManagementRepository.save(prescription);
    }

    @Override
    public List<Prescription> deletePrescriptions(String filter) {
        List<Prescription> prescriptionList = this.getPrescriptions(filter);
        prescriptionList.stream().forEach(p -> mongoTemplate.remove(p));
        return prescriptionList;
    }

    @Override
    public Prescription deletePrescriptionById(String prescriptionId) {
        Prescription prescription = this.getPrescriptionById(prescriptionId);
        mongoTemplate.remove(prescription);
        return prescription;
    }

    @Override
    public Prescription updatePrescription(Prescription prescription, JsonPatch payload) throws JsonPatchException {
        Prescription patchedPrescription = applyPatchToPrescription(payload, prescription);
        prescriptionDataManagementRepository.save(patchedPrescription);
        return patchedPrescription;
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

    private Department applyPatchToDepartment(JsonPatch patch, Department targetDepartment)
            throws JsonPatchException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetDepartment, JsonNode.class));
        try {
            return objectMapper.treeToValue(patched, Department.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private Prescription applyPatchToPrescription(JsonPatch patch, Prescription targetPrescription)
            throws JsonPatchException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetPrescription, JsonNode.class));
        try {
            return objectMapper.treeToValue(patched, Prescription.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
