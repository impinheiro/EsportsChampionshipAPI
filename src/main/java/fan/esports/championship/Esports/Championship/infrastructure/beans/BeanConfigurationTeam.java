package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;
import fan.esports.championship.Esports.Championship.core.usecases.team.GetAllTeamsCase;
import fan.esports.championship.Esports.Championship.core.usecases.team.GetAllTeamsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationTeam {

    @Bean
    public GetAllTeamsCase getAllTeamsCase(TeamGateway teamGateway) {
        return new GetAllTeamsImpl(teamGateway);
    }
}
