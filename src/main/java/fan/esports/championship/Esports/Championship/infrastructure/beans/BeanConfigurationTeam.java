package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.team.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationTeam {

    @Bean
    public GetAllTeamsCase getAllTeamsCase(TeamGateway teamGateway) {
        return new GetAllTeamsImpl(teamGateway);
    }

    @Bean
    public CreateTeamCase createTeamCase(TeamGateway teamGateway, UserGateway userGateway) {
        return new CreateTeamCaseImpl(teamGateway, userGateway);
    }
    @Bean
    public UpdateTeamCase updateTeamCase(TeamGateway teamGateway) {
        return new UpdateTeamCaseImpl(teamGateway);
    }
    @Bean
    public DeleteTeamCase deleteTeamCase(TeamGateway teamGateway) {
        return new DeleteTeamCaseImpl(teamGateway);
    }
    @Bean
    public GetTeamById getTeamById(TeamGateway teamGateway) {
        return new GetTeamByIdImpl(teamGateway);
    }
    @Bean
    public FindTeamScheduledMatches findTeamScheduledMatches(RegistrationGateway registrationGateway, MatchGateway matchGateway) {
        return new FindTeamScheduledMatchesImpl(registrationGateway,matchGateway);
    }
}
