package ourbusinessproject.Resources;

import org.springframework.hateoas.ResourceSupport;
import ourbusinessproject.Models.Enterprise;
import ourbusinessproject.Models.Project;

import java.util.Date;

public class PartnershipResource extends ResourceSupport {
    private Date creationDate;
    private Enterprise enterprise;
    private Project project;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
