package ourbusinessproject.Services;

import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ourbusinessproject.Models.Partnership;
import ourbusinessproject.Repositories.PartnershipRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PartnershipRepository partnershipRepository;

    public PartnershipService() {
    }

    public Partnership save(Partnership partnership) {
        entityManager.persist(partnership);
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        return entityManager.find(Partnership.class, id);
    }

    public void remove(Partnership partnership) {
        entityManager.remove(entityManager.contains(partnership) ? partnership : entityManager.merge(partnership));
    }

    public Page<Partnership> getPartnershipPage(String projectTitle, String enterpriseName, Pageable pageable) {
        Page<Partnership> partnerships;
        if (projectTitle == null && enterpriseName == null) {
            partnerships = partnershipRepository.findAll(pageable);
            System.out.println("all");
        } else if (projectTitle == null) {
            partnerships = partnershipRepository.findByEnterpriseName(enterpriseName, pageable);
            System.out.println("enterprise");
        } else if (enterpriseName == null) {
            partnerships = partnershipRepository.findByProjectTitle(projectTitle, pageable);
            System.out.println("project");
        } else {
            partnerships = partnershipRepository.findByEnterpriseNameAndProjectTitle(enterpriseName, projectTitle, pageable);
            System.out.println("both");
        }
        return partnerships;
    }
}
