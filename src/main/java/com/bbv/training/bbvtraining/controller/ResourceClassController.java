package com.bbv.training.bbvtraining.controller;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/resourceclass")
@RestController
public class ResourceClassController {

    @Autowired
    private ResourceClassRepository repository;

    @GetMapping("/all")
    public List<ResourceClassEntity> getAll() {
        return repository.findAll();
    }
    @GetMapping("/{resourceclassId}")
    public ResourceClassEntity getResourceClass(@PathVariable("resourceclassId") Long id) {
        /// http://localhost:8080/api/resourceclass/12
        ResourceClassEntity result = repository.findById(id);
        return result;
    }

    @GetMapping("/delete/{resourceclassId}")
    public String deleteResourceClassById(@PathVariable("resourceclassId") Long id) {
        /// http://localhost:8080/api/resourceclass/12
        Optional<ResourceClassEntity> result = Optional.ofNullable(repository.findById(id));
        if (result.isPresent() == true) {
            repository.deleteById(id);
            return "<h2>Resource successfully deleted.</h2>";
        }
        return "<h2>No resource with id =  " + id + "</h2>";
    }

}
