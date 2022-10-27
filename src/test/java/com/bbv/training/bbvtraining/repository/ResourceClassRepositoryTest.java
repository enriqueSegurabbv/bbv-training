package com.bbv.training.bbvtraining.repository;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;


@DataJpaTest
public class ResourceClassRepositoryTest {

    @Autowired
    private ResourceClassDataRepository classUnderTest;

    @Autowired
    private EntityManager entityManager;

    @Test
    void insertSimple() {
        // arrange
        ResourceClassEntity input = new ResourceClassEntity("Uuid", "BBV");

        // act
        classUnderTest.save(input);
        entityManager.flush();

        // assert
        Query query = entityManager.createNativeQuery("SELECT id FROM RESOURCE_CLASS where NAME=? and UUID=?");
        query.setParameter(1, "BBV");
        query.setParameter(2, "Uuid");

        List<Long> resultList = query.getResultList();
        assertThat(resultList).hasSize(1);
    }

    @Test
    void simpleDelete() {

        //prepare
        ResourceClassEntity input = new ResourceClassEntity("Uuid","Test Device");

        //act
        classUnderTest.save(input);
        classUnderTest.removeByName("Test Device");

        //assert
        Query query = entityManager.createNativeQuery("SELECT id FROM RESOURCE_CLASS where NAME=?");
        query.setParameter(1, "Test Device");
        List<Long> resultList = query.getResultList();
        assertThat(resultList).hasSize(0);
    }



}


