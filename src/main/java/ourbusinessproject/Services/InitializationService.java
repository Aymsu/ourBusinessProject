package ourbusinessproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ourbusinessproject.Models.Enterprise;
import ourbusinessproject.Models.Project;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InitializationService {

    private EnterpriseProjectService enterpriseProjectService;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    public InitializationService() {
        enterprise1 = new Enterprise("E1", "Desc E1 Veeeeeerrryyyyy Loooong", "ContactE1", "contact@e1.com");
        enterprise2 = new Enterprise("E2", "Desc E2 Veeeeeerrryyyyy Loooong", "ContactE2", "contact@e2.com");
    }

    public EnterpriseProjectService getEnterpriseProjectService() {
        return enterpriseProjectService;
    }

    @Autowired
    public void setEnterpriseProjectService(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    public void setEnterprise1(Enterprise enterprise1) {
        this.enterprise1 = enterprise1;
    }

    public void setEnterprise2(Enterprise enterprise2) {
        this.enterprise2 = enterprise2;
    }

    public Project getProject1E1() {
        return new Project("projet1", "Projet1 desc", getEnterprise1());
    }

    public Project getProject1E2() {
        return new Project("projet1", "Projet1 desc", getEnterprise2());
    }

    public Project getProject2E1() {
        return new Project("projet2", "Projet2 desc", getEnterprise1());
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }

    public void initProjects() {
        enterpriseProjectService.save(enterprise1);
        enterpriseProjectService.save(enterprise2);
        enterpriseProjectService.save(getProject1E1());
        enterpriseProjectService.save(getProject1E2());
        enterpriseProjectService.save(getProject2E1());
    }
}
