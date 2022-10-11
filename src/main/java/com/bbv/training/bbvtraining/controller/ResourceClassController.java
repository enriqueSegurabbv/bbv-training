package com.bbv.training.bbvtraining.controller;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassRepository;
import com.bbv.training.bbvtraining.service.ResourceClassService;
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
    private ResourceClassService service;

    @GetMapping("/all")
    public List<ResourceClassEntity> getAll() {
        return service.findAll();
    }
    @GetMapping("/{resourceclassId}")
    public ResourceClassEntity getResourceClass(@PathVariable("resourceclassId") Long  id) {
        /// http://localhost:8080/api/resourceclass/7
        ResourceClassEntity result = service.findById(id);
        return result;
    }

    @GetMapping("/delete/{resourceclassId}")
    public void deleteResourceClassById(@PathVariable("resourceclassId") Long  id) {
        // http://localhost:8080/api/resourceclass/delete/4bb56dcb-1d63-4215-a61f-efb32094dc26
        service.deleteById(id);
    }

}
