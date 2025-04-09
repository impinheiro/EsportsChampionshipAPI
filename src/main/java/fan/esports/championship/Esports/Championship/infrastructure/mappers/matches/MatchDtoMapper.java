package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MatchDtoMapper {


    private final UserDtoMapper userMapper;

    public MatchDtoMapper(UserDtoMapper userMapper) {
        this.userMapper = userMapper;
    }


    public Match toDomain(MatchDTO matchesDTO){
        return new Match(
                matchesDTO.id(), matchesDTO.name(),
                matchesDTO.participants()
                        .stream()
                        .map(userMapper::toDomain)
                        .collect(Collectors.toList())
                , matchesDTO.createdAt(), matchesDTO.updatedAt(),
                matchesDTO.matchInfo()
        );
    }

    public MatchDTO toDTO(Match match){
        return new MatchDTO(
                match.id(), match.name(),
                match.participants()
                        .stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                match.createdAt(),
                match.updatedAt(),
                match.matchInfo()
        );
    }

}
