package com.example.linewebhookjava.controller;

import com.example.linewebhookjava.entity.datasource1.ProjectItems;
import com.example.linewebhookjava.entity.datasource1.Projects;
import com.example.linewebhookjava.service.MyNewService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/first/")
public class TestController {

    @Autowired
    protected MyNewService myNewService;

    @GetMapping("/saveProject")
    public ResponseEntity<Object> saveProject() {
        return ResponseEntity.ok(myNewService.saveProject());
    }

    @GetMapping("/saveProject2")
    public ResponseEntity<Projects> saveProject(@RequestParam(required = false) String project) {
        return ResponseEntity.ok(myNewService.saveMainEntity(project));
    }

    @GetMapping("/getAllProject")
    public List<Projects> getAllProject() {
        return myNewService.getAllProject();
    }

    @GetMapping("/getByProjectId/{projectId}")
    public Projects getAllProject(@PathVariable Long projectId) {
        return myNewService.getByProjectId(projectId);
    }

    @GetMapping("/findItemUpdatesByProjectId/{projectId}")
    public List<ProjectItems> findItemUpdatesByProjectId(@PathVariable Long projectId) {
        return myNewService.findItemUpdatesByProjectId(projectId);
    }

    @PostMapping("/updateProject")
    public ResponseEntity<Projects> updateProject(@RequestBody Projects project) {
        return ResponseEntity.ok(myNewService.updateProject(project));
    }

    @DeleteMapping("/deleteProject/{projectId}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long projectId) {
        Projects project = myNewService.getByProjectId(projectId);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        myNewService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    public static class MyResponse {
        public HttpStatus status;
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        public Date currentTime;
    }

    public static class MyResponseShort {
        public HttpStatus status;
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> hello(@RequestParam(required = false) String format) {
        if ("short".equals(format)) {
            return ResponseEntity.ok(
                new MyResponseShort() {{
                    status = HttpStatus.OK;
                }}
            );
        }

        if ("full".equals(format)) {
            return ResponseEntity.ok(
                new MyResponse() {{
                    status = HttpStatus.OK;
                    currentTime = new Date();
                }}
            );
        }

        return ResponseEntity.badRequest().body("Bad request");
    }

    @GetMapping("/bye")
    public String bye() {
        return "Goodbye";
    }
}
