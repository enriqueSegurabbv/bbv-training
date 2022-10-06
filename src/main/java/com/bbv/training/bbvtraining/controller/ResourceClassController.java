package com.bbv.training.bbvtraining.controller;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/resourceclass")
@RestController
public class ResourceClassController {

    @Autowired
    ResourceClassRepository repository;

    @GetMapping("/{resourceclassId}")
    public ResourceClassEntity getResourceClass(@PathVariable("resourceclassId") Long id) {
        /// http://localhost:8080/api/resourceclass/12
        ResourceClassEntity result = repository.findById(id);
        return result;
    }

}
