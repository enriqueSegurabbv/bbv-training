package com.bbv.training.bbvtraining.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class ResourceClassDataRepositoryIT {

    @Autowired
    private ResourceClassDataRepository classUnderTest;

    @Autowired
    private EntityManager entityManager;

    @Test
    void simpleInsert() {
        // prepare
        ResourceClassEntity input = new ResourceClassEntity();
        input.setName("Notebook");
        String uuid = UUID.randomUUID().toString();
        input.setUuid(uuid);

        // act
        classUnderTest.save(input);

        // assert

        // wenig sinnvoll
        Optional<ResourceClassEntity> assertResult = classUnderTest.findById(input.getId());
        assertThat(assertResult).isPresent();
        ResourceClassEntity resultEntity = assertResult.get();
        assertThat(resultEntity.getName()).isEqualTo("Notebook");
        assertThat(resultEntity.getUuid()).isEqualTo(uuid);


        // so wird es gemachts
        Query query = entityManager.createNativeQuery("SELECT id FROM RESOURCE_CLASS where ID=? and NAME=? and UUID=?");

        query.setParameter(1, input.getId());
        query.setParameter(2, input.getName());
        query.setParameter(3, input.getUuid());
        @SuppressWarnings("unchecked")
        List<Long> resultList = query.getResultList();
        assertThat(resultList).hasSize(1);
    }

    @Test
    void simpleDelete() {
        // prepare
        ResourceClassEntity input = new ResourceClassEntity();
        input.setName("Test Device");
        String uuid = UUID.randomUUID().toString();
        input.setUuid(uuid);

        // act
        classUnderTest.save(input);
        classUnderTest.removeByName("Test Device");

        // assert
        Query query = entityManager.createNativeQuery("SELECT id FROM RESOURCE_CLASS where NAME=?");
        query.setParameter(1, "Test Device");
        List<Long> resultList = query.getResultList();
        assertThat(resultList).hasSize(0);
    }

}
