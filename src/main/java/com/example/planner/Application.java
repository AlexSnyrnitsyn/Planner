package com.example.planner;

import com.example.planner.model.Project;
import com.example.planner.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class Application {

//    @Autowired
//    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void abc(){
//        Project project = projectRepository.findById(1L).get();
//        System.out.println(project);
//    }

}
