package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.domain.MatchResults;
import fan.esports.championship.Esports.Championship.core.domain.Team;

import java.time.LocalDateTime;
import java.util.List;

public record TeamMatchDTO (String id,
                            String name,
                            List<TeamDTO> participants,
                            LocalDateTime createdAt,
                            LocalDateTime updatedAt,
                            MatchResults matchResults){
}
