package ourbusinessproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ourbusinessproject.Models.Enterprise;
import ourbusinessproject.Models.Partnership;
import ourbusinessproject.Models.Project;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InitializationService {

    private EnterpriseProjectService enterpriseProjectService;

    @Autowired
    private PartnershipService partnershipService;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    private Project p1e1;
    private Project p2e1;
    private Project p1e2;

    private Partnership partnershipP1E1WithE2;
    private Partnership partnershipP1E2WithE1;
    private Partnership partnershipP2E1WithE2;


    public InitializationService() {
        enterprise1 = new Enterprise("E1", "Desc E1 Veeeeeerrryyyyy Loooong", "ContactE1", "contact@e1.com");
        enterprise2 = new Enterprise("E2", "Desc E2 Veeeeeerrryyyyy Loooong", "ContactE2", "contact@e2.com");

        p1e1 = new Project("projet1", "Projet1 desc", getEnterprise1());
        p1e2 = new Project("projet1", "Projet1 desc", getEnterprise2());
        p2e1 = new Project("projet2", "Projet2 desc", getEnterprise1());

        partnershipP1E1WithE2 = new Partnership();
        partnershipP1E1WithE2.setProject(this.getProject1E1());
        partnershipP1E1WithE2.setEnterprise(this.getEnterprise2());

        partnershipP1E2WithE1 = new Partnership();
        partnershipP1E2WithE1.setProject(this.getProject1E2());
        partnershipP1E2WithE1.setEnterprise(this.getEnterprise1());

        partnershipP2E1WithE2 = new Partnership();
        partnershipP2E1WithE2.setProject(this.getProject2E1());
        partnershipP2E1WithE2.setEnterprise(this.getEnterprise2());

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
        return p1e1;
    }

    public Project getProject1E2() {
        return p1e2;
    }

    public Project getProject2E1() {
        return p2e1;
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

    public void initPartnerships() {
        partnershipService.save(getPartnershipP1E1WithE2());
        partnershipService.save(getPartnershipP1E2WithE1());
        partnershipService.save(getPartnershipP2E1WithE2());
    }

    public Partnership getPartnershipP1E1WithE2() {

        return partnershipP1E1WithE2;
    }

    public Partnership getPartnershipP1E2WithE1() {
        return partnershipP1E2WithE1;
    }

    public Partnership getPartnershipP2E1WithE2() {
        return partnershipP2E1WithE2;
    }
}
