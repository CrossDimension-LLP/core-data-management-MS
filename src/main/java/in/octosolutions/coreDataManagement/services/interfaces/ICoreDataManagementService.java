package in.octosolutions.coreDataManagement.services.interfaces;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;

import java.util.List;

public interface ICoreDataManagementService {
    /**Doctor Management Services*/
    List<Doctor> getDoctors(String filter);
    Doctor getDoctorById(String doctorId);
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> deleteDoctors(String filter);
    Doctor deleteDoctorById(String doctorId);
    Doctor updateDoctor(Doctor doctor, JsonPatch payload) throws JsonPatchException;

    /**Department Management Services*/
    List<Department> getDepartments(String filter);
    Department getDepartmentById(String departmentId);
    Department saveDepartment(Department department);
    List<Department> deleteDepartments(String filter);
    Department deleteDepartmentById(String departmentId);
    Department updateDepartment(Department department, JsonPatch payload) throws JsonPatchException;

    /**Prescription Management Services*/
    List<Prescription> getPrescriptions(String filter);
    Prescription getPrescriptionById(String prescriptionId);
    Prescription savePrescription(Prescription prescription);
    List<Prescription> deletePrescriptions(String filter);
    Prescription deletePrescriptionById(String prescriptionId);
    Prescription updatePrescription(Prescription prescription, JsonPatch payload) throws JsonPatchException;
}
