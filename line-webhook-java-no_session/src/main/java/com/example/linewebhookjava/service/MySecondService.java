package com.example.linewebhookjava.service;

import com.example.linewebhookjava.entity.datasource2.ProjectItems2;
import com.example.linewebhookjava.entity.datasource2.Projects2;
import com.example.linewebhookjava.repository.datasource2.Projects2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MySecondService {

    @Autowired
    protected Projects2Repository projectsRepository;

    public Projects2 saveProject() {
        Projects2 newProject = new Projects2();
        newProject.setProjectName("New Project");
        return projectsRepository.save(newProject);
    }

    @Transactional
    public Projects2 saveMainEntity(String project) {
        Projects2 newProject = new Projects2(project);

        ProjectItems2 newProjectItem = new ProjectItems2();
        newProjectItem.setProjectItemNameTest(project + " Item " + 1);

        ProjectItems2 newProjectItem2 = new ProjectItems2();
        newProjectItem2.setProjectItemNameTest(project + " Item " + 2);

        newProject.addItem(newProjectItem);
        newProject.addItem(newProjectItem2);
        return projectsRepository.save(newProject);
    }

    public List<Projects2> getAllProject() {
        return projectsRepository.findAll();
    }

    public Projects2 getByProjectId(Long projectId) {
        return projectsRepository.findById(projectId).orElse(null);
    }

//    public List<ProjectItems2> findItemUpdatesByProjectId(Long id) {
//        return projectsRepository.findItemUpdatesByProjectId(id);
//    }

    @Transactional
    public Projects2 updateProject(Projects2 project) {
        return projectsRepository.save(project);
    }

    @Transactional
    public void deleteProject(Long projectId) {
        Projects2 project = getByProjectId(projectId);
        if (project == null) {
            return;
        }
        projectsRepository.delete(project);
    }

    public static String getGoodbye() {
        return "Goodbye";
    }
}
