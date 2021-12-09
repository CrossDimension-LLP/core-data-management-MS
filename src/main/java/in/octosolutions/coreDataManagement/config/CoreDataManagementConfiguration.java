package in.octosolutions.coreDataManagement.config;

import in.octosolutions.nucleus.service.implementations.GenericUtilityInterface;
import in.octosolutions.nucleus.service.implementations.QueryBuilderImpl;
import in.octosolutions.nucleus.service.implementations.RestLogicImpl;
import in.octosolutions.nucleus.service.interfaces.IGenericUtilityInterface;
import in.octosolutions.nucleus.service.interfaces.IQueryBuilder;
import in.octosolutions.nucleus.service.interfaces.IRestLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreDataManagementConfiguration {
    @Bean
    public IRestLogic restLogic() {
        return  new RestLogicImpl();
    }

    @Bean
    public IQueryBuilder queryBuilder() {
        return new QueryBuilderImpl();
    }

    @Bean
    public IGenericUtilityInterface genericUtilityInterface() {
        return new GenericUtilityInterface();
    }
}
