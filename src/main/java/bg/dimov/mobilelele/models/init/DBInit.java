package bg.dimov.mobilelele.models.init;

import bg.dimov.mobilelele.models.entity.Brand;
import bg.dimov.mobilelele.models.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public DBInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Brand brand = new Brand();
        brand.setName("Ford");
        brand.setCreated(Instant.now());
        brandRepository.save(brand);
    }
}
