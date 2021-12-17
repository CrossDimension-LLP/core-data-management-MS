package in.octosolutions.coreDataManagement.services.interfaces;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;

import java.util.List;

public interface IDepartmentDataManagementService {
    /**Department Management Services*/
    List<Department> getDepartments(String filter);
    Department getDepartmentById(String departmentId);
    Department saveDepartment(Department department);
    List<Department> deleteDepartments(String filter);
    Department deleteDepartmentById(String departmentId);
    Department updateDepartment(Department department, JsonPatch payload) throws JsonPatchException;

}
