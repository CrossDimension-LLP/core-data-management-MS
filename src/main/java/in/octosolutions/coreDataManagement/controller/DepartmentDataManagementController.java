package in.octosolutions.coreDataManagement.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.services.interfaces.IDepartmentDataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentDataManagementController {

    @Autowired
    IDepartmentDataManagementService coreDataManagementService;



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
}
