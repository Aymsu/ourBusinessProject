package ourbusinessproject.Repositories;

import com.sun.istack.internal.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ourbusinessproject.Models.Partnership;

@RepositoryRestResource(exported = false)
public interface PartnershipRepository extends PagingAndSortingRepository<Partnership, Long> {

    Page<Partnership> findAll(Pageable pageable);

    Page<Partnership> findByEnterpriseNameAndProjectTitle(String name, String title, Pageable pageable);

    Page<Partnership> findByEnterpriseName(String name, Pageable pageable);

    Page<Partnership> findByProjectTitle(String title, Pageable pageable);
}
