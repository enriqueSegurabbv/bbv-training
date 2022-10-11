package com.bbv.training.bbvtraining.service;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResourceClassServiceTest {

    @Autowired
    private ResourceClassService service;

    @Autowired
    private EntityManager entityManager;

    @BeforeAll
    private void init(){
        service.save(new ResourceClassEntity("123456789", "Test Device"));
    }

    @Test
    void findById() {
        assertThat(entityManager.find(ResourceClassEntity.class, 8L)).isNotNull();
    }

    @Test
    void deleteById_basic(){
        service.deleteById(8L);
        assertThat(entityManager.find(ResourceClassEntity.class, 8L)).isNull();
    }

    @Test
    void findAll(){
        List<ResourceClassEntity> resources = service.findAll();
        Query query = entityManager.createNativeQuery("SELECT * FROM RESOURCE_CLASS");
        List<Long> resultList = query.getResultList();
        assertThat(resultList).hasSize(resources.size());
    }

}
