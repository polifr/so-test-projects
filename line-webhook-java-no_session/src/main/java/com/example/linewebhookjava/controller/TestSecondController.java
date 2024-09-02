package com.example.linewebhookjava.controller;

import com.example.linewebhookjava.entity.datasource2.ProjectItems2;
import com.example.linewebhookjava.entity.datasource2.Projects2;
import com.example.linewebhookjava.service.MySecondService;
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
@RequestMapping("/second/")
public class TestSecondController {

    @Autowired
    protected MySecondService mySecondService;

    @GetMapping("/saveProject")
    public ResponseEntity<Object> saveProject() {
        return ResponseEntity.ok(mySecondService.saveProject());
    }

    @GetMapping("/saveProject2")
    public ResponseEntity<Projects2> saveProject(@RequestParam(required = false) String project) {
        return ResponseEntity.ok(mySecondService.saveMainEntity(project));
    }

//    @GetMapping("/getAllProject")
//    public String getAllProject() {
//        return "test";
//    }
    @GetMapping("/getAllProject")
    public List<Projects2> getAllProject() {
        return mySecondService.getAllProject();
    }

    @GetMapping("/getByProjectId/{projectId}")
    public Projects2 getAllProject(@PathVariable Long projectId) {
        return mySecondService.getByProjectId(projectId);
    }

//    @GetMapping("/findItemUpdatesByProjectId/{projectId}")
//    public List<ProjectItems2> findItemUpdatesByProjectId(@PathVariable Long projectId) {
//        return mySecondService.findItemUpdatesByProjectId(projectId);
//    }

    @PostMapping("/updateProject")
    public ResponseEntity<Projects2> updateProject(@RequestBody Projects2 project) {
        return ResponseEntity.ok(mySecondService.updateProject(project));
    }

    @DeleteMapping("/deleteProject/{projectId}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long projectId) {
        Projects2 project = mySecondService.getByProjectId(projectId);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        mySecondService.deleteProject(projectId);
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
