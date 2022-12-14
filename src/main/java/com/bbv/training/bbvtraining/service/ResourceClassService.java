package com.bbv.training.bbvtraining.service;
import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

@Service
public class ResourceClassService {

    @Autowired
    private ResourceClassDataRepository repository;

    public ResourceClassEntity findById(Long id) {

        Optional<ResourceClassEntity> result = repository.findById(id);

        if(result.isPresent()) {
            return result.get();
        } else {
            throw new EntityNotFoundException("Entity with id "+id+" not found");
        }

    }

    public ResourceClassEntity findByUuid(String uuid) {
        List<ResourceClassEntity> result = repository.findByUuid(uuid);

        if(result.isEmpty()) {
            throw new EntityNotFoundException("Entity with Uuid " + uuid + " not found");
        }

        return result.get(0);
    }

    public List<ResourceClassEntity> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {

        Optional<ResourceClassEntity> result = repository.findById(id);

        if(result.isPresent()) {
            repository.delete(result.get());
        } else {
            throw new EntityNotFoundException("Entity with id "+id+" not found");
        }

    }

    public ResourceClassEntity save(ResourceClassEntity entity) {

        repository.save(entity);

        return entity;

    }
}