package ourbusinessproject.Assemblers;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ourbusinessproject.Controllers.PartnershipController;
import ourbusinessproject.Models.Partnership;
import ourbusinessproject.Resources.PartnershipResource;

public class PartnershipResourceAssembler extends ResourceAssemblerSupport<Partnership, PartnershipResource> {

    public PartnershipResourceAssembler() {
        super(PartnershipController.class, PartnershipResource.class);
    }

    @Override
    public PartnershipResource toResource(Partnership partnership) {
        PartnershipResource partnershipResource = new PartnershipResource();
        partnershipResource.setProject(partnership.getProject());
        partnershipResource.setEnterprise(partnership.getEnterprise());
        partnershipResource.setCreationDate(partnership.getCreationDate());
        return partnershipResource;
    }


}
