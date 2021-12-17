package in.octosolutions.coreDataManagement.services.interfaces;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;

import java.util.List;

public interface IDoctorDataManagementService {
    /**Doctor Management Services*/
    List<Doctor> getDoctors(String filter);
    Doctor getDoctorById(String doctorId);
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> deleteDoctors(String filter);
    Doctor deleteDoctorById(String doctorId);
    Doctor updateDoctor(Doctor doctor, JsonPatch payload) throws JsonPatchException;



}
