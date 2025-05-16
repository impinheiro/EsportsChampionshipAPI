package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;

import java.util.List;
import java.util.Optional;

public interface RankingGateway {

    PlayerRanking createPlayerRanking(PlayerRanking playerRanking);
    Optional<PlayerRanking> findPlayerRankingById(String id);
    List<PlayerRanking> findAllPlayerRankings();
    PlayerRanking updatePlayerRanking(String id, PlayerRanking playerRanking);
    void deletePlayerRanking(String id);
    TeamRanking createTeamRanking(TeamRanking teamRanking);
    Optional<TeamRanking> findTeamRankingById(String id);
    List<TeamRanking> findAllTeamRankings();
    TeamRanking updateTeamRanking(String id, TeamRanking teamRanking);
    void deleteTeamRanking(String id);
}
