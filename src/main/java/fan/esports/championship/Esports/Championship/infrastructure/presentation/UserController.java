package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.usecases.user.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.UserRequestDTO;
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
    private final FindUserByNicknameCase findUserByNicknameCase;
    private final LoginUserCase loginUserCase;
    private final UpdateUserCase updateUserCase;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDto){
        User user  = userDtoMapper.toDomain(userDto);
        Map<String, Object> response = new HashMap<>();
        createUserCase.execute(user);
        response.put("Created User", userDtoMapper.toResponseDto(userDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserRequestDTO userData){
        Map<String, Object> response = new HashMap<>();
        String token = loginUserCase.execute(userData.email(), userData.password());
        response.put("Login", "User logged in successfully");
        response.put("User:", userData.email());
        response.put("token", token);
        return ResponseEntity.ok(response);
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
    @GetMapping("/getByNickname/{nickname}")
    public ResponseEntity<Map<String, Object>> getUserByNickname(@PathVariable String nickname){
        Map<String,Object> response = new HashMap<>();
        User user = findUserByNicknameCase.execute(nickname);
        response.put("User: ", userDtoMapper.toDto(user));
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO userDto){
        Map<String,Object> response = new HashMap<>();
        User user = userDtoMapper.toDomain(userDto);
        updateUserCase.execute(user, id);
        response.put("Updated User", userDtoMapper.toDto(user));
        return ResponseEntity.ok(response);
    }


}
