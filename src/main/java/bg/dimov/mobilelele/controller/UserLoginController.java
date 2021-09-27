package bg.dimov.mobilelele.controller;

import bg.dimov.mobilelele.models.entity.Dto.UserLoginDto;
import bg.dimov.mobilelele.models.service.UserServiceModel;
import bg.dimov.mobilelele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserLoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }
    @PostMapping("/users/login")
    public String login(UserLoginDto userLoginDto){


        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setUsername(userServiceModel.getUsername());
        userServiceModel.setRawPassword(userLoginDto.getPassword());
        boolean loginSuccsessful = userService.login(userServiceModel);
        LOGGER.info("User try to login. User with name {} tried to login. Success = {}?", userLoginDto.getUsername(), loginSuccsessful);
        return "redirect:/users/login";
    }
}
