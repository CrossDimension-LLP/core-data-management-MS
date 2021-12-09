package in.octosolutions.coreDataManagement.repository.interfaces;

import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPrescriptionDataManagementRepository extends MongoRepository<Prescription, String> {
}
