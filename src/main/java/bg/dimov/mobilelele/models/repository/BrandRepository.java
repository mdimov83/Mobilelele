package bg.dimov.mobilelele.models.repository;

import bg.dimov.mobilelele.models.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
