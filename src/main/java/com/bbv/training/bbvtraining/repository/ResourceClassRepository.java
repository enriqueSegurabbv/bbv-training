package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ResourceClassRepository {

    @Autowired
    private EntityManager entityManager;

    public ResourceClassEntity findById(Long id) {
        ResourceClassEntity resourceClassEntity = entityManager.find(ResourceClassEntity.class, id);
        return resourceClassEntity;
    }
}
