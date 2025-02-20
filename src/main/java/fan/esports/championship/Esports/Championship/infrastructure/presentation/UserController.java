package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.usecases.user.CreateUserCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final CreateUserCase createUserCase;
    private final UserDtoMapper  userDtoMapper;

    public UserController(CreateUserCase createUserCase, UserDtoMapper userDtoMapper) {
        this.createUserCase = createUserCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDto){
        return null;
    }
}
