package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.usecases.user.CreateUserCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.DeleteUserCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.GetUsersCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final CreateUserCase createUserCase;
    private final GetUsersCase getUsersCase;
    private final UserDtoMapper  userDtoMapper;
    private final DeleteUserCase deleteUserCase;

    @PostMapping("create")
    public UserDTO createUser(@RequestBody UserDTO userDto){
        User user  = userDtoMapper.toDomain(userDto);
        createUserCase.execute(user);
        return userDtoMapper.toDto(user);

    }
    @GetMapping("findAll")
    public List<UserDTO> findAllUsers(){
        List<User> users = new ArrayList<User>();
        users = getUsersCase.execute();
        return users.stream().map(userDtoMapper::toDto).collect(Collectors.toList());
    }
    @DeleteMapping
    public void deleteUser(@PathVariable String id){
        deleteUserCase.execute(id);
    }
}
