package in.octosolutions.coreDataManagement.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import in.octosolutions.coreDataManagement.repository.interfaces.IPrescriptionDataManagementRepository;
import in.octosolutions.coreDataManagement.services.interfaces.IPrescriptionDataManagement;
import in.octosolutions.nucleus.service.interfaces.IGenericUtilityInterface;
import in.octosolutions.nucleus.service.interfaces.IQueryBuilder;
import in.octosolutions.nucleus.service.interfaces.IRestLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PrescriptionDataManagementService implements IPrescriptionDataManagement {

    @Autowired
    IPrescriptionDataManagementRepository prescriptionDataManagementRepository;

    @Inject
    private IRestLogic restLogic;

    @Inject
    private IQueryBuilder queryBuilder;

    @Inject
    IGenericUtilityInterface genericUtilityInterface;

    private final MongoTemplate mongoTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public PrescriptionDataManagementService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
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
        prescriptionList.stream().forEach(prescription -> mongoTemplate.remove(prescription));
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
