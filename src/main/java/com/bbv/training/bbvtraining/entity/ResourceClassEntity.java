package com.bbv.training.bbvtraining.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource_class")
public class ResourceClassEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column (name="uuid", unique = true, nullable = false)
    private String uuid;

    @Column (name = "name")
    private String name;

    public ResourceClassEntity(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public ResourceClassEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
