package fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.teams;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.TeamScoreEntity;

public class TeamScoreEntityMapper {
    private TeamEntityMapper teamEntityMapper;

    public TeamScoreEntity toEntity(TeamScore teamScore) {
        return new TeamScoreEntity(
                teamScore.id(),
                teamEntityMapper.toEntity(teamScore.team()),
                teamScore.score()
        );
    }

    public TeamScore toDomain(TeamScoreEntity teamScoreEntity) {
        return new TeamScore(
                teamScoreEntity.getId(),
                teamEntityMapper.toDomain(teamScoreEntity.getTeam()),
                teamScoreEntity.getScore()
        );
    }
}
