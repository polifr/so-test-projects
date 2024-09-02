package com.example.linewebhookjava.service;

import com.example.linewebhookjava.entity.datasource1.ProjectItems;
import com.example.linewebhookjava.entity.datasource1.Projects;
import com.example.linewebhookjava.repository.datasource1.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyNewService {

    @Autowired
    protected ProjectsRepository projectsRepository;

    public Projects saveProject() {
        Projects newProject = new Projects();
        newProject.setProjectName("New Project");
        return projectsRepository.save(newProject);
    }

    @Transactional
    public Projects saveMainEntity(String project) {
        Projects newProject = new Projects(project);

        ProjectItems newProjectItem = new ProjectItems();
        newProjectItem.setProjectItemNameTest(project + " Item " + 1);

        ProjectItems newProjectItem2 = new ProjectItems();
        newProjectItem2.setProjectItemNameTest(project + " Item " + 2);

        newProject.addItem(newProjectItem);
        newProject.addItem(newProjectItem2);
        return projectsRepository.save(newProject);
    }

    public List<Projects> getAllProject() {
        return projectsRepository.findAll();
    }

    public Projects getByProjectId(Long projectId) {
        return projectsRepository.findById(projectId).orElse(null);
    }

    public List<ProjectItems> findItemUpdatesByProjectId(Long id) {
        return projectsRepository.findItemUpdatesByProjectId(id);
    }

    @Transactional
    public Projects updateProject(Projects project) {
        return projectsRepository.save(project);
    }

    @Transactional
    public void deleteProject(Long projectId) {
        Projects project = getByProjectId(projectId);
        if (project == null) {
            return;
        }
        projectsRepository.delete(project);
    }

    public static String getGoodbye() {
        return "Goodbye";
    }
}
