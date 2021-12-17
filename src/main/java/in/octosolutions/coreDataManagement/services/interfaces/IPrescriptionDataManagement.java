package in.octosolutions.coreDataManagement.services.interfaces;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;

import java.util.List;

public interface IPrescriptionDataManagement {
    /**Prescription Management Services*/
    List<Prescription> getPrescriptions(String filter);
    Prescription getPrescriptionById(String prescriptionId);
    Prescription savePrescription(Prescription prescription);
    List<Prescription> deletePrescriptions(String filter);
    Prescription deletePrescriptionById(String prescriptionId);
    Prescription updatePrescription(Prescription prescription, JsonPatch payload) throws JsonPatchException;
}
