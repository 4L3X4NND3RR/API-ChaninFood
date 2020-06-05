package com.chaninfood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //Expose entity ids
        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        // - create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();
        // - get the entity types for the entities
        for(EntityType<?> entity : entities){
            entityClasses.add(entity.getJavaType());
        }
        // - expose the entity ids for the array of entity/domain types
        Class[] domainType = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainType);
    }
}