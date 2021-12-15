package in.octosolutions.coreDataManagement.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import in.octosolutions.coreDataManagement.services.interfaces.ICoreDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorDataManagementController {
    @Autowired
    ICoreDataManagementService coreDataManagementService;

    /**Doctor Management APIs*/
    @GetMapping("/doctor")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable("allDoctorCache")
    public List<Doctor> getDoctors(@RequestParam(name= "filters", required= false) String filter){
        return coreDataManagementService.getDoctors(filter);
    }

    @GetMapping("/doctor/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable("doctorCache")
    public Doctor getDoctorById(@PathVariable(name= "id", required= true) String doctorId){
        return coreDataManagementService.getDoctorById(doctorId);
    }

    @PostMapping("/doctor")
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = "allDoctorCache", allEntries = true)
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

    @PatchMapping(value = "/doctor/{id}", consumes = "application/json-patch+json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CacheEvict(value = {"doctorCache", "allDoctorCache"}, allEntries = true)
    public Doctor updateDoctor(@PathVariable(name= "id", required= true) String doctorId, @RequestBody JsonPatch payload) throws JsonPatchException {
        Doctor doctor = coreDataManagementService.getDoctorById(doctorId);
        return coreDataManagementService.updateDoctor(doctor, payload);
    }
}
