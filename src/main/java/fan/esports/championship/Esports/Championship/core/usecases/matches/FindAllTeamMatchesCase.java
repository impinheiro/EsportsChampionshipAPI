package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;

import java.util.List;

public interface FindAllTeamMatchesCase {
    List<TeamMatch> execute();
}
