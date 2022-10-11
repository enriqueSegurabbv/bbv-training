package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ResourceClassRepository {
    @Autowired
    private ResourceClassDataRepository dataRepository;

    @Autowired
    private EntityManager entityManager;

    public List<ResourceClassEntity> findAll() {
        return dataRepository.findAll();
    }

    public ResourceClassEntity findById(Long id) {
        ResourceClassEntity resourceClassEntity = entityManager.find(ResourceClassEntity.class, id);
        return resourceClassEntity;
    }

    public ResourceClassEntity findByUuid(String  uuid) {

        ResourceClassEntity resourceClassEntity = entityManager.find(ResourceClassEntity.class, uuid);
        return resourceClassEntity;
    }

    public void deleteById(Long id) {
        ResourceClassEntity entity = findById(id);
        entityManager.remove(entity);
    }

    public ResourceClassEntity save(ResourceClassEntity entity) {
        if (entity.getId()==null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }

        return entity;
    }

}
