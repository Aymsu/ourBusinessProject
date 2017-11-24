package ourbusinessproject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @Size(min = 10)
    private String description;

    @NotEmpty
    @NotNull
    private String contactName;

    @NotEmpty
    @NotNull
    @Email
    private String contactEmail;

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @JsonIgnore
    @OneToMany
    private List<Project> projects;

    public Enterprise() {
    }

    public Enterprise(String name, String description, String contactName, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if(this.projects == null) projects = new ArrayList<>();
        this.projects.add(project);
    }
}
