package com.example.linewebhookjava.entity.datasource2;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Projects2 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    //    @ElementCollection
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "project_items", joinColumns = @JoinColumn(name = "project_id"))
    private List<ProjectItems2> itemUpdates;

    public Projects2() {
        this.itemUpdates = new ArrayList<>();
    }

    public Projects2(String projectName) {
        this.projectName = projectName;
        this.itemUpdates = new ArrayList<>();
    }

    public void addItem(ProjectItems2 item) {
        this.itemUpdates.add(item);
    }
}
