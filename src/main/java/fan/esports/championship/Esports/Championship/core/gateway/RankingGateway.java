package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;

import java.util.List;

public interface RankingGateway {

    PlayerRanking createPlayerRanking(PlayerRanking playerRanking);
    PlayerRanking findPlayerRankingById(String id);
    List<PlayerRanking> findAllPlayerRankings();
    PlayerRanking updatePlayerRanking(String id, PlayerRanking playerRanking);
    void deletePlayerRanking(String id);
    TeamRanking createTeamRanking(TeamRanking teamRanking);
    TeamRanking findTeamRankingById(String id);
    List<TeamRanking> findAllTeamRankings();
    TeamRanking updateTeamRanking(String id, TeamRanking teamRanking);
    void deleteTeamRanking(String id);
}
