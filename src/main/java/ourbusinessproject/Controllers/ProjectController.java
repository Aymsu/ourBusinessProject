package ourbusinessproject.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ourbusinessproject.Models.Project;
import ourbusinessproject.Services.EnterpriseProjectService;

import java.util.List;

@RestController
public class ProjectController {

    private EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @RequestMapping(value = "/projectsWithEnterprises")
    public List<Project> findAllProjectsWithEnterprises() {
        return enterpriseProjectService.findAllProjects();
    }
}
