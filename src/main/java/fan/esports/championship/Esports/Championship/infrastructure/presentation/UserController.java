package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.usecases.user.CreateUserCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.DeleteUserCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.FindUserByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.GetUsersCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.UserNotFoundException;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final CreateUserCase createUserCase;
    private final GetUsersCase getUsersCase;
    private final UserDtoMapper  userDtoMapper;
    private final DeleteUserCase deleteUserCase;
    private final FindUserByIdCase findUserByIdCase;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDto){
        User user  = userDtoMapper.toDomain(userDto);
        Map<String, Object> response = new HashMap<>();
        createUserCase.execute(user);
        response.put("Created User", userDtoMapper.toDto(user));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("findAll")
    public ResponseEntity<?> findAllUsers(){
        Map<String,Object> response = new HashMap<>();
        List<User> users = new ArrayList<User>();
        users = getUsersCase.execute();
        if(users.isEmpty()){
            response.put("Users list: ", "Users list is empty");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        response.put("Users list: ", users.stream().map(userDtoMapper::toDto).collect(Collectors.toList()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        Map<String,Object> response = new HashMap<>();
        deleteUserCase.execute(id);
        response.put("User ID", id+" was deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String id){
        User user = findUserByIdCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("User: ", userDtoMapper.toDto(user));
        return ResponseEntity.ok(response);
    }

}
