package fan.esports.championship.Esports.Championship.infrastructure.mappers.championships;

import fan.esports.championship.Esports.Championship.core.domain.*;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchInfo;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.Participant;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.ChampionshipCreationDto;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.ChampionshipInfo;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.ChampionshipResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class ChampionshipDtoMapper {

    private final RegistrationGateway registrationGateway;
    private final UserGateway userGateway;
    private final MatchGateway matchGateway;
    private final TeamGateway teamGateway;

    public ChampionshipDtoMapper(RegistrationGateway registrationGateway, UserGateway userGateway, MatchGateway matchGateway, TeamGateway teamGateway) {
        this.registrationGateway = registrationGateway;
        this.userGateway = userGateway;
        this.matchGateway = matchGateway;
        this.teamGateway = teamGateway;
    }

    public Championship toDomain(ChampionshipDTO dto) {
        return new Championship(
                dto.id(),
                dto.createdBy(),
                dto.name(),
                dto.gameName(),
                dto.type(),
                dto.capacity(),
                dto.subscriptionValue(),
                dto.format(),
                dto.rules(),
                dto.startDate(),
                dto.endDate(),
                dto.location(),
                dto.coverImage(),
                dto.logoImage(),
                dto.awardDescription(),
                dto.rankingId(),
                dto.registrationsId(),
                dto.matchesId(),
                dto.createdAt(),
                dto.updatedAt()
        );
    }

    public ChampionshipDTO toDto(Championship championship) {
        List<String> acceptedRegistrations = new ArrayList<>();
        for(String registrationId : championship.registrationsId()){
            Registration registration = registrationGateway.findById(registrationId).orElse(null);
            if(registration.status().equals(RegistrationStatus.ACCEPTED)){
                acceptedRegistrations.add(registrationId);
            }
        }
        return new ChampionshipDTO(
                championship.id(),
                championship.createdBy(),
                championship.name(),
                championship.gameName(),
                championship.type(),
                championship.capacity(),
                championship.subscriptionValue(),
                championship.format(),
                championship.rules(),
                championship.startDate(),
                championship.endDate(),
                championship.location(),
                championship.coverImage(),
                championship.logoImage(),
                championship.awardDescription(),
                championship.rankingId(),
                acceptedRegistrations,
                championship.matchesId(),
                championship.createdAt(),
                championship.updatedAt()
        );
    }

    public ChampionshipResponse toResponse(Championship championship) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        List<Registration> registrations = championship.registrationsId().stream()
                .map(registrationGateway::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(reg -> reg.status().equals(RegistrationStatus.ACCEPTED))
                .collect(Collectors.toList());

        Map<String, String> registrationsMap = registrations
                .stream()
                .collect(Collectors.toMap(Registration::id, Registration::ownerId)
                );

        List<Participant> participants = new ArrayList<>();

        if(championship.type().equals(ChampionshipType.INDIVIDUAL)) {
            participants = registrationsMap.entrySet().stream()
                    .map(entry -> {
                        String registrationId = entry.getKey();
                        String ownerId = entry.getValue();
                        User user = userGateway.findById(ownerId).orElse(null);
                        if (user == null) return null;
                        return new Participant(registrationId, user.name());
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }else {
            participants = registrationsMap.entrySet().stream()
                    .map(entry -> {
                        String registrationId = entry.getKey();
                        String ownerId = entry.getValue();
                        Team team = teamGateway.findTeamById(ownerId);
                        return new Participant(registrationId, team.name());
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        List<Match> championshipMatches = championship.matchesId()
                .stream()
                .map(matchGateway::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()
                );

        List<MatchInfo> abstractedMatches = championshipMatches
                .stream()
                .map(match -> new MatchInfo(match.id(), match.name()))
                .collect(Collectors.toList()
                );

        return new ChampionshipResponse(
                championship.id(),
                championship.name(),
                championship.gameName().getGameName(),
                championship.type(),
                championship.capacity(),
                championship.subscriptionValue(),
                championship.format(),
                championship.rules(),
                championship.startDate().format(formatter),
                championship.endDate().format(formatter),
                championship.location(),
                championship.coverImage(),
                championship.logoImage(),
                championship.awardDescription(),
                championship.rankingId(),
                participants,
                abstractedMatches
        );
    }

    public Championship toDomain(ChampionshipCreationDto championship) {
        return new Championship(
                null,
                null,
                championship.name(),
                championship.gameName(),
                championship.type(),
                championship.capacity(),
                championship.subscriptionValue(),
                championship.format(),
                championship.rules(),
                championship.startDate(),
                championship.endDate(),
                championship.location(),
                championship.coverImage(),
                championship.logoImage(),
                championship.awardDescription(),
                null,
                null,
                null,
                null,
                null
        );
    }

    public ChampionshipInfo toInfo(Championship dto) {
        Integer availableVacancies = calculateVacancies(dto);
        return new ChampionshipInfo(
                dto.name(),
                dto.gameName(),
                dto.type(),
                dto.format(),
                dto.rules(),
                dto.awardDescription(),
                dto.capacity(),
                availableVacancies
                );
    }

    public Integer calculateVacancies(Championship championshipDTO) {
        Integer vacancies = championshipDTO.capacity();
        long acceptedRegistrations = championshipDTO.registrationsId()
                .stream()
                .map(registrationGateway::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(registration -> registration.status().equals(RegistrationStatus.ACCEPTED))
                .count();
        Integer acceptedCount = (int) acceptedRegistrations;
        return vacancies - acceptedCount;
    }


}
