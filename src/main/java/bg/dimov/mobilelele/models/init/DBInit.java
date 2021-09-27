package bg.dimov.mobilelele.models.init;

import bg.dimov.mobilelele.models.entity.Brand;
import bg.dimov.mobilelele.models.entity.Model;
import bg.dimov.mobilelele.models.entity.User;
import bg.dimov.mobilelele.models.entity.enums.Category;
import bg.dimov.mobilelele.models.repository.BrandRepository;
import bg.dimov.mobilelele.models.repository.ModelRepository;
import bg.dimov.mobilelele.models.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository, ModelRepository modelRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeBrandAndModels();
        initializeUser();
    }

    private void initializeUser(){
        if (userRepository.count() == 0){
            User admin = new User();
            admin.setActive(true);
            admin.setUsername("admin");
            admin.setCreated(Instant.now());
            admin.setFirstName("Pesho");
            admin.setLastName("Peshov");
            admin.setPassword(passwordEncoder.encode("test"));

            userRepository.save(admin);
        }
    }
    private void initializeBrandAndModels(){
        if (brandRepository.count() == 0 && modelRepository.count() == 0){
            Brand brand = new Brand();
            brand.setName("Ford");
            brand.setCreated(Instant.now());
            Model fiesta = new Model();
            fiesta.setBrand(brand);
            fiesta.setCategory(Category.CAR);
            fiesta.setName("Fiesta");
            fiesta.setStartYear(1976);
            fiesta.setImageUrl("https://bg.auto-data.org/wp-content/uploads/2017/08/Ford-Fiesta-1976--0-768x576.jpg");
            fiesta.setCreated(Instant.now());
            brandRepository.save(brand);
            modelRepository.save(fiesta);
        }
    }
}
