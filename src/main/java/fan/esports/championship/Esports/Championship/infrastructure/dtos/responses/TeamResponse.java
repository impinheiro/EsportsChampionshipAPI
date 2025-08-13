package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamMember;

import java.util.List;

public record TeamResponse(String id, String name, List<TeamMember> members)  {
}
