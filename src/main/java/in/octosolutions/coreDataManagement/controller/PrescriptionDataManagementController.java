package in.octosolutions.coreDataManagement.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import in.octosolutions.coreDataManagement.services.interfaces.ICoreDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrescriptionDataManagementController {
    @Autowired
    ICoreDataManagementService coreDataManagementService;

    /**Prescription Management APIs*/
    @GetMapping("/prescription")
    @ResponseStatus(HttpStatus.OK)
    public List<Prescription> getPrescriptions(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.getPrescriptions(filter);
    }

    @GetMapping("/prescription/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prescription getPrescriptionById(@PathVariable(name= "id", required= true) String prescriptionId){
        return coreDataManagementService.getPrescriptionById(prescriptionId);
    }

    @PostMapping("/prescription")
    @ResponseStatus(HttpStatus.CREATED)
    public Prescription savePrescription(@RequestBody Prescription prescription){
        return coreDataManagementService.savePrescription(prescription);
    }

    @DeleteMapping("/prescription")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Prescription> deletePrescriptions(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.deletePrescriptions(filter);
    }

    @DeleteMapping("/prescription/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Prescription deletePrescriptionById(@PathVariable(name= "id", required= true) String prescriptionId){
        return coreDataManagementService.deletePrescriptionById(prescriptionId);
    }

    @PatchMapping(value = "/prescription", consumes = "application/json-patch+json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Prescription updatePrescription(@RequestParam(name= "filters", required= false) String filter, @RequestBody JsonPatch payload) throws JsonPatchException {
        Prescription prescription = coreDataManagementService.getPrescriptions(filter).get(0);
        return coreDataManagementService.updatePrescription(prescription, payload);
    }
}
