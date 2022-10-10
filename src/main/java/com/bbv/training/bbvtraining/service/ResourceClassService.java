package com.bbv.training.bbvtraining.service;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceClassService {

    @Autowired
    private ResourceClassRepository repository;

    public List<ResourceClassEntity> findAll() {
        return repository.findAll();
    }

    public ResourceClassEntity findByUuid(String uuid) {

        ResourceClassEntity resourceClassEntity = repository.findByUuid(uuid);
        return resourceClassEntity;
    }

    public String deleteByUuid(String uuid) {
        Optional<ResourceClassEntity> result = Optional.ofNullable(repository.findByUuid(uuid));
        if(result.isPresent()) {
            repository.deleteByUuid(uuid);
            return "Element Successfully deleted.";
        }
        return "There is no element with Uuid = " + uuid;
    }

}
