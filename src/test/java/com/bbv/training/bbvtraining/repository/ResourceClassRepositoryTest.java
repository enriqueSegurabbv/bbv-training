package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.BbvTrainingApplication;
import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.Query;
import java.util.List;

@SpringBootTest(classes = BbvTrainingApplication.class)
public class ResourceClassRepositoryTest {

    @Autowired
    private ResourceClassRepository repository;

    @Test
    void findById_basic() {
        ResourceClassEntity resourceClassEntity = repository.findById(4L);

        assertThat(resourceClassEntity.getName()).isEqualTo("Screen 2");
    }

    @Test
    @DirtiesContext
    void deleteById_basic() {
        repository.deleteById(7L);
        ResourceClassEntity resourceClassEntity = repository.findById(7L);
        assertThat(resourceClassEntity).isNull();
    }

    @Test
    @DirtiesContext
    void save_basic() {
        //prepare
        ResourceClassEntity entity = repository.findById(1L);
        assertThat(entity.getName()).isEqualTo("Mouse");
        //act
        entity.setName("Mouse - Updated");
        repository.save(entity);
        //assert
        assertThat(entity.getName()).isEqualTo("Mouse - Updated");
    }

}
