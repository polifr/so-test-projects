package com.example.linewebhookjava.entity.datasource2;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ProjectItems2 {

    @Column(name = "project_item_name")
    private String projectItemNameTest;

}
