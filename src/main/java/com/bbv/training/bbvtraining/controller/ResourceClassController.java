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
    @GetMapping("/{resourceclassUuid}")
    public ResourceClassEntity getResourceClass(@PathVariable("resourceclassUuid") String  uuid) {
        /// http://localhost:8080/api/resourceclass/4bb56dcb-1d63-4215-a61f-efb32094dc22
        ResourceClassEntity result = service.findByUuid(uuid);
        return result;
    }

    @GetMapping("/delete/{resourceclassId}")
    public String deleteResourceClassById(@PathVariable("resourceclassId") String  uuid) {
        /// http://localhost:8080/api/resourceclass/12
        return service.deleteByUuid(uuid);
    }

}
