package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.user.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfigurationUser {

    @Bean
    public CreateUserCase createUser(UserGateway userGateway){
        return new CreateUserCaseImpl(userGateway);
    }
    @Bean
    public GetUsersCase getUsers(UserGateway userGateway){
        return new GetUsersCaseImpl(userGateway);
    }
    @Bean
    public DeleteUserCase deleteUser(UserGateway userGateway, AuthenticatedUserCase authenticatedUserCase){
        return new DeleteUserCaseImpl(userGateway, authenticatedUserCase);
    }
    @Bean
    public FindUserByIdCase findUserById(UserGateway userGateway){
        return new FindUserByIdCaseImpl(userGateway);
    }
    @Bean
    public FindUserByNicknameCase findUserByNickname(UserGateway userGateway){
        return new FindUserByNicknameCaseImpl(userGateway);
    }
    @Bean
    public LoginUserCase loginUser(UserGateway userGateway){
        return new LoginUserCaseImpl(userGateway);
    }
    @Bean
    public AuthenticatedUserCase authenticatedUserCase(UserGateway userGateway){
        return new AuthenticatedUserCaseImpl(userGateway);
    }
    @Bean
    public UpdateUserCase updateUser(UserGateway userGateway){
        return new UpdateUserCaseImpl(userGateway);
    }
    @Bean
    public PromoteUserCase promoteUser(UserGateway userGateway){
        return new PromoteUserCaseImpl(userGateway);
    }
}
