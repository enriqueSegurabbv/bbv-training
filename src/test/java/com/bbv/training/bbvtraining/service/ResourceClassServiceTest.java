package com.bbv.training.bbvtraining.service;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.repository.ResourceClassDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResourceClassServiceTest {

    @InjectMocks
    private ResourceClassService classUnderTest;

    @Mock
    private ResourceClassDataRepository repository;

    @Test
    void simpleFinById() {
        //Prepare
        when(repository.findById(1L)).thenReturn(Optional.of(new ResourceClassEntity(UUID.randomUUID().toString(), "test")));
        //act
        ResourceClassEntity entity = classUnderTest.findById(1L);
        //assert
        assertThat(entity.getName()).isEqualTo("test");
    }

    @Test
    void simpleFindAll() {
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
        when(repository.findAll()).thenReturn(entities);
//        verify(repository, times(1)).findAll();
        //assert
        assertThat(classUnderTest.findAll()).isEqualTo(entities);
    }

    @Test
    void simpleDeleteById() {
        //prepare
        List <ResourceClassEntity> entities = new ArrayList<ResourceClassEntity>();
        ResourceClassEntity entity = new ResourceClassEntity(UUID.randomUUID().toString(), "test1");
        entities.add(entity);

        //act
        repository.deleteById(1L);

        //assert
        assertThat(repository.findById(1L)).isEmpty();
    }

}
