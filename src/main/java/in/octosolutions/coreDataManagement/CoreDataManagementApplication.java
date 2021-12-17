package in.octosolutions.coreDataManagement;

import com.github.fge.jsonpatch.JsonPatchException;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Patient;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.Prescription;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class CoreDataManagementApplication {
    public static void main(String[] args) throws IOException, JsonPatchException {
        SpringApplication.run(CoreDataManagementApplication.class, args);
    }
}
