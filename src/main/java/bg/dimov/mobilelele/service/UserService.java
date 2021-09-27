package bg.dimov.mobilelele.service;

import bg.dimov.mobilelele.models.service.UserServiceModel;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean login(UserServiceModel userServiceModel);
}
