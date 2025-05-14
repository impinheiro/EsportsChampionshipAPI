package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import fan.esports.championship.Esports.Championship.core.domain.MatchResults;

import java.util.List;

public record TeamMatchData(String id,
                            String name,
                            List<TeamData> participants,
                            MatchResults matchResults) {
}
