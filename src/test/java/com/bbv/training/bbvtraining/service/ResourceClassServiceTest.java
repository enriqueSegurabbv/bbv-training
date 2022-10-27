package com.bbv.training.bbvtraining.service;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResourceClassServiceTest {

    @InjectMocks
    private ResourceClassService classUnderTest;

    @Mock
    private ResourceClassDataRepository repository;

    @Test
    void simpleFindAllTest() {

        //prepare
        List <ResourceClassEntity> entities = new ArrayList<ResourceClassEntity>();
        ResourceClassEntity entity1 = new ResourceClassEntity(UUID.randomUUID().toString(), "test1");
        ResourceClassEntity entity2 = new ResourceClassEntity(UUID.randomUUID().toString(), "test2");
        ResourceClassEntity entity3 = new ResourceClassEntity(UUID.randomUUID().toString(), "test3");
        ResourceClassEntity entity4 = new ResourceClassEntity(UUID.randomUUID().toString(), "test4");

        //act
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity3);
        entities.add(entity4);

        //assert
        when(repository.findAll()).thenReturn(entities);
        assertThat(classUnderTest.findAll()).isEqualTo(entities);
    }

    @Test
    void findByUuidTest() {

        //prepare
        List <ResourceClassEntity> entities = new ArrayList<ResourceClassEntity>();
        ResourceClassEntity entity1 = new ResourceClassEntity("Uuid1", "test1");
        ResourceClassEntity entity2 = new ResourceClassEntity("Uuid2", "test2");


        //act
        entities.add(entity1);
        entities.add(entity2);

        //assert
        when(repository.findByUuid("Uuid2")).thenReturn(Arrays.asList(entities.get(1)));
        assertThat(classUnderTest.findByUuid("Uuid2")).isEqualTo(entities.get(1));

    }

}
