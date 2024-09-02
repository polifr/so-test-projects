package com.example.linewebhookjava.repository.datasource2;

import com.example.linewebhookjava.entity.datasource2.Projects2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Projects2Repository extends JpaRepository<Projects2, Long>, JpaSpecificationExecutor<Projects2> {

//    @Query("SELECT m.itemUpdates FROM Projects2 m WHERE m.id = :id")
//    List<ProjectItems2> findItemUpdatesByProjectId(@Param("id") Long id);

}