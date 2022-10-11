package com.bbv.training.bbvtraining.service;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class ResourceClassService {

    @Autowired
    private ResourceClassRepository repository;

    public ResourceClassEntity findById(Long id) {
        return repository.findById(id);
    }

    public List<ResourceClassEntity> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        Optional<ResourceClassEntity> result = Optional.ofNullable(repository.findById(id));
        if(result.isPresent()) {
            repository.deleteById(id);
        }
    }

    public ResourceClassEntity save(ResourceClassEntity entity) {
        repository.save(entity);

        return entity;
    }

}
