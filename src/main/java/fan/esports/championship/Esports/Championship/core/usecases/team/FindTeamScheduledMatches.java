package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Match;

import java.util.List;

public interface FindTeamScheduledMatches {
    List<Match> execute(String teamId);
}
