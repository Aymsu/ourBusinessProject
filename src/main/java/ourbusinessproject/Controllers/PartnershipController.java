package ourbusinessproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ourbusinessproject.Assemblers.PartnershipResourceAssembler;
import ourbusinessproject.Models.Enterprise;
import ourbusinessproject.Models.Partnership;
import ourbusinessproject.Models.Project;
import ourbusinessproject.Repositories.PartnershipRepository;
import ourbusinessproject.Resources.PartnershipResource;
import ourbusinessproject.Services.EnterpriseProjectService;
import ourbusinessproject.Services.PartnershipService;

@RepositoryRestController
@RequestMapping(path = "/api/v1/partnerships", produces = "application/hal+json")
public class PartnershipController extends ResourceSupport {

    private EnterpriseProjectService enterpriseProjectService;
    private PartnershipService partnershipService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PagedResourcesAssembler<Partnership> assembler;

    public PartnershipController(
            EnterpriseProjectService enterpriseProjectService,
            PartnershipService partnershipService
    ) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    @PostMapping(value = "")
    @ResponseBody
    public Partnership addPartnership(@RequestParam(name = "project_id") long projectId,
                                      @RequestParam(name = "enterprise_id") long enterpriseId) {
        Project project = enterpriseProjectService.findProjectById(projectId);
        Enterprise enterprise = enterpriseProjectService.findEnterpriseById(enterpriseId);
        Partnership partnership = new Partnership();
        partnership.setEnterprise(enterprise);
        partnership.setProject(project);
        partnershipService.save(partnership);
        return partnership;
    }

    @DeleteMapping(value = "{id}")
    public void removePartnership(@PathVariable("id") long id) {
        partnershipService.remove(partnershipService.findPartnershipById(id));
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public HttpEntity<PagedResources<PartnershipResource>> searchPartnerShips(
            @RequestParam(value = "project_title", required = false) String projectTitle,
            @RequestParam(value = "enterprise_name", required = false) String enterpriseName,
            Pageable pageable,
            PartnershipResourceAssembler partnershipResourceAssembler
    ) {
        System.out.println("Controller method");
        System.out.println(projectTitle);
        System.out.println(enterpriseName);
        Page<Partnership> partnerships;
        partnerships = partnershipService.getPartnershipPage(projectTitle, enterpriseName, pageable);
        PagedResources<PartnershipResource> p = assembler.toResource(partnerships, partnershipResourceAssembler);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

}
