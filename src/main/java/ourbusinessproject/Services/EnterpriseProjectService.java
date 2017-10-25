package ourbusinessproject.Services;

import org.springframework.stereotype.Service;
import ourbusinessproject.Models.Enterprise;
import ourbusinessproject.Models.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public EnterpriseProjectService() {

    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Project project) {
        if(project.getEnterprise() != null) {
            entityManager.persist(project.getEnterprise());
            project.getEnterprise().addProject(project);
        }
        entityManager.persist(project);
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }

    public List<Project> findAllProjects() {
        Query query = entityManager.createQuery("SELECT p FROM Project p ORDER BY p.title");
        return query.getResultList();
    }

}
