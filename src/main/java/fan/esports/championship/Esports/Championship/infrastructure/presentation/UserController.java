package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping
    public User createUser(@RequestBody UserEntity userEntity){
        return null;
    }
}
