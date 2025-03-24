package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.domain.UserInfo;
import fan.esports.championship.Esports.Championship.core.enums.UserRole;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.config.JWTUserData;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.MissingPermissionException;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserInfoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserRepository;
import fan.esports.championship.Esports.Championship.infrastructure.token.TokenService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserRepositoryGateway implements UserGateway, UserDetailsService {

    private final UserRepository userRepository;
    private final UserEntityMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserInfoMapper userInfoMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper mapper, PasswordEncoder passwordEncoder, @Lazy AuthenticationManager authenticationManager, TokenService tokenService, UserInfoMapper userInfoMapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        String password = userEntity.getPassword();
        userEntity.setPassword(passwordEncoder.encode(password));
        UserEntity newUser = userRepository.save(userEntity);
        return mapper.toDomain(newUser);
    }

    @Override
    public User update(User user, String id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();

        return userEntityList.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        UserEntity userToDelete = userRepository.findById(id).orElse(null);
        userRepository.delete(userToDelete);
    }

    @Override
    public Optional<User> findById(String id) {
        UserEntity userFound = userRepository.findById(id).orElse(null);
        if (userFound != null) {
            return Optional.of(mapper.toDomain(userFound));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        UserEntity userFound = userRepository.findByNickname(nickname).orElse(null);
        if (userFound != null) {
            return Optional.of(mapper.toDomain(userFound));
        }
        return Optional.empty();
    }

    @Override
    public UserInfo getAuthenticatedUser() {
        JWTUserData userData= (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfoMapper.toUserInfo(userData);
    }

    @Override
    public boolean exists(String id) {
        return userRepository.findAll().stream().anyMatch(user -> user.getId().equals(id));
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return userRepository.findAll().stream().anyMatch(user -> user.getNickname().equals(nickname));
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(userAndPass);
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return tokenService.generateToken(user);
    }

    @Override
    public boolean isValid(String email, String password) {
        boolean existingEmail = userRepository.findAll().stream().anyMatch(user -> user.getEmail().equals(email));
        if (existingEmail == true) {
            String validPassword = userRepository.findAll().stream()
                    .filter(u -> u.getEmail().equals(email))
                    .findFirst().get().getPassword();
            return passwordEncoder.matches(password, validPassword);
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha invalido"));
    }
}
