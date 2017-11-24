package ourbusinessproject.Models;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.config.EnableEntityLinks;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date creationDate;

    @NotNull
    @ManyToOne
    private Enterprise enterprise;

    @NotNull
    @ManyToOne
    private Project project;

    public Partnership(Long l) {
        this();
        this.id = l;
    }

    public Partnership() {
        creationDate = new Date();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Project getProject() {
        return project;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
