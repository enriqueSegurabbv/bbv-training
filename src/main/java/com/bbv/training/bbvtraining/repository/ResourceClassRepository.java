package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
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

    public void deleteByUuid(String uuid) {
        ResourceClassEntity entity = findByUuid(uuid);
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
