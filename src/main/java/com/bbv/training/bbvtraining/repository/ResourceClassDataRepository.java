package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface ResourceClassDataRepository extends JpaRepository<ResourceClassEntity, Long> {

    List<ResourceClassEntity> findAllById(Iterable<Long> longs);

    List<ResourceClassEntity> findAll();

    List<ResourceClassEntity> findByUuid(String uuid);

    List<ResourceClassEntity> removeByName(String name);

}
