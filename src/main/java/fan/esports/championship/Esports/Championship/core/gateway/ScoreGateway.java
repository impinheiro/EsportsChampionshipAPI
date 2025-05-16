package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.domain.TeamScore;

import java.util.List;
import java.util.Optional;

public interface ScoreGateway {

    PlayerScore createPlayerScore(PlayerScore playerScore);
    Optional<PlayerScore> findPlayerScoreById(String id);
    List<PlayerScore> findAllPlayerScores();
    PlayerScore updatePlayerScore(String id, PlayerScore playerScore);
    void deletePlayerScore(String id);
    TeamScore createTeamScore(TeamScore teamScore);
    Optional<TeamScore> findTeamScoreById(String id);
    List<TeamScore> findAllTeamScores();
    TeamScore updateTeamScore(String id, TeamScore teamScore);
    void deleteTeamScore(String id);
}
