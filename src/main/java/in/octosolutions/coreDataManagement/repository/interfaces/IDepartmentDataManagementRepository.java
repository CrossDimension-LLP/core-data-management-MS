package in.octosolutions.coreDataManagement.repository.interfaces;

import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Department;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDepartmentDataManagementRepository extends MongoRepository<Department, String> {
}
