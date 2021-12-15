package in.octosolutions.coreDataManagement.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import in.octosolutions.coreDataManagement.services.interfaces.ICoreDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoreDataManagementController {
    @Autowired
    ICoreDataManagementService coreDataManagementService;

    /**Doctor Management APIs*/
    @GetMapping("/doctor")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctors(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.getDoctors(filter);
    }

    @GetMapping("/doctor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctorById(@PathVariable(name= "id", required= true) String doctorId){
        return coreDataManagementService.getDoctorById(doctorId);
    }

    @PostMapping("/doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return coreDataManagementService.saveDoctor(doctor);
    }

    @DeleteMapping("/doctor")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Doctor> deleteDoctors(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.deleteDoctors(filter);
    }

    @DeleteMapping("/doctor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Doctor deleteDoctorById(@PathVariable(name= "id", required= true) String doctorId){
        return coreDataManagementService.deleteDoctorById(doctorId);
    }

    @PatchMapping(value = "/doctor", consumes = "application/json-patch+json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Doctor updateDoctor(@RequestParam(name= "filters", required= false) String filter, @RequestBody JsonPatch payload) throws JsonPatchException {
        Doctor doctor = coreDataManagementService.getDoctors(filter).get(0);
        return coreDataManagementService.updateDoctor(doctor, payload);
    }

    /**Department Management APIs*/
    @GetMapping("/department")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getDepartments(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.getDepartments(filter);
    }

    @GetMapping("/department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department getDepartmentById(@PathVariable(name= "id", required= true) String departmentId){
        return coreDataManagementService.getDepartmentById(departmentId);
    }

    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@RequestBody Department department){
        return coreDataManagementService.saveDepartment(department);
    }

    @DeleteMapping("/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Department> deleteDepartments(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.deleteDepartments(filter);
    }

    @DeleteMapping("/department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Department deleteDepartmentById(@PathVariable(name= "id", required= true) String departmentId){
        return coreDataManagementService.deleteDepartmentById(departmentId);
    }

    @PatchMapping(value = "/department", consumes = "application/json-patch+json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Department updateDepartment(@RequestParam(name= "filters", required= false) String filter, @RequestBody JsonPatch payload) throws JsonPatchException {
        Department department = coreDataManagementService.getDepartments(filter).get(0);
        return coreDataManagementService.updateDepartment(department, payload);
    }

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
