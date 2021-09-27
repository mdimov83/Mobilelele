package bg.dimov.mobilelele.service.impl;

import bg.dimov.mobilelele.models.entity.User;
import bg.dimov.mobilelele.models.repository.UserRepository;
import bg.dimov.mobilelele.models.service.UserServiceModel;
import bg.dimov.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserServiceModel userServiceModel) {
        Optional<User> user = userRepository.findByUsername(userServiceModel.getUsername());
        if (user.isEmpty()){
            return false;
        }
        return passwordEncoder.matches(userServiceModel.getRawPassword(), user.get().getPassword());
    }
}
