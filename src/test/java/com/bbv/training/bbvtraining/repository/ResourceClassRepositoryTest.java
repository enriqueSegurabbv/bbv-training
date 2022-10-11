package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.service.ResourceClassService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest
public class ResourceClassRepositoryTest {

    @Autowired
    private ResourceClassService service;

    @Test
    void findById_basic() {
        ResourceClassEntity resourceClassEntity = service.findById(5L);

        assertThat(resourceClassEntity.getName()).isEqualTo("Headphones");
    }

    @Test
    @DirtiesContext
    void deleteById_basic() {
        service.deleteById(7L);
        ResourceClassEntity resourceClassEntity = service.findById(7L);
        assertThat(resourceClassEntity).isNull();
    }

    @Test
    @DirtiesContext
    void save_basic() {
        //prepare
        ResourceClassEntity entity = service.findById(4L);
        assertThat(entity.getName()).isEqualTo("Screen 2");
        //act
        entity.setName("Screen 2 - Updated");
        service.save(entity);
        //assert
        assertThat(entity.getName()).isEqualTo("Screen 2 - Updated");
    }

}
