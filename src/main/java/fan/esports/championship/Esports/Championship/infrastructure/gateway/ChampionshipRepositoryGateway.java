package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.infrastructure.config.JWTUserData;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionShipEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ChampionshipRepositoryGateway implements ChampionshipGateway {

    private final ChampionshipRepository championshipRepository;
    private final ChampionShipEntityMapper mapper;

    public ChampionshipRepositoryGateway(ChampionshipRepository championshipRepository, ChampionShipEntityMapper mapper) {
        this.championshipRepository = championshipRepository;
        this.mapper = mapper;
    }

    @Override
    public Championship create(Championship championship) {
        ChampionshipEntity newChampionship = mapper.toEntity(championship);
        JWTUserData userData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = userData.id().replaceAll("^\"|\"$", "");
        newChampionship.setCreatedBy(userId);
        newChampionship.setCreatedAt(LocalDateTime.now());
        newChampionship.setUpdatedAt(LocalDateTime.now());
        newChampionship.setRankingId(null);
        newChampionship.setRegistrationsId(new ArrayList<>());
        newChampionship.setMatchesId(new ArrayList<>());
        championshipRepository.save(newChampionship);
        return mapper.toDomain(newChampionship);
    }

    @Override
    public Championship update(String id, Championship championship){

        ChampionshipEntity championshipToUpdate = championshipRepository.findById(id).orElse(null);

        if (championshipToUpdate == null) {
            return null;
        }

        ChampionshipEntity updatedData = mapper.toEntity(championship);

        if (updatedData.getMatchesId() != null) {
            championshipToUpdate.setMatchesId(updatedData.getMatchesId());
        }

        if (updatedData.getRegistrationsId() != null) {
            championshipToUpdate.setRegistrationsId(updatedData.getRegistrationsId());
        }

        if (updatedData.getFormat() != null) {
            championshipToUpdate.setFormat(updatedData.getFormat());
        }

        if (updatedData.getType() != null) {
            championshipToUpdate.setType(updatedData.getType());
        }

        if (updatedData.getCapacity() != null) {
            championshipToUpdate.setCapacity(updatedData.getCapacity());
        }

        if (updatedData.getAwardDescription() != null) {
            championshipToUpdate.setAwardDescription(updatedData.getAwardDescription());
        }

        if (updatedData.getRules() != null) {
            championshipToUpdate.setRules(updatedData.getRules());
        }

        if (updatedData.getCoverImage() != null) {
            championshipToUpdate.setCoverImage(updatedData.getCoverImage());
        }

        if (updatedData.getName() != null) {
            championshipToUpdate.setName(updatedData.getName());
        }

        if (updatedData.getLogoImage() != null) {
            championshipToUpdate.setLogoImage(updatedData.getLogoImage());
        }

        championshipToUpdate.setUpdatedAt(LocalDateTime.now());

        championshipRepository.save(championshipToUpdate);

        return mapper.toDomain(championshipToUpdate);

    }

    @Override
    public void delete(String id) {
        ChampionshipEntity championshipToDelete = championshipRepository.findById(id).orElse(null);
        championshipRepository.delete(championshipToDelete);
    }

    @Override
    public Optional<Championship> findById(String id) {
        ChampionshipEntity championship = championshipRepository.findById(id).orElse(null);
        if(championship != null) {
            return Optional.of(
                    mapper.toDomain(championship)
            );
        }
        return Optional.empty();
    }

    @Override
    public List<Championship> findAll() {
        List<ChampionshipEntity> championships = championshipRepository.findAll();
        return championships
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Championship> findAvailableChampionships() {
        List<ChampionshipEntity> championships = championshipRepository.findAll()
                .stream()
                .filter(championshipEntity -> championshipEntity.getEndDate().isAfter(LocalDateTime.now()) ||
                        championshipEntity.getRegistrationsId().size()<championshipEntity.getCapacity())
                .collect(Collectors.toList());
        return championships.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Championship> findExpiredChampionships() {
        List<ChampionshipEntity> championships = championshipRepository.findAll()
                .stream()
                .filter(championshipEntity -> championshipEntity.getEndDate().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
        return championships.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Championship> findByGameName(String gameName) {
        List<ChampionshipEntity> championships = championshipRepository.findByGameName(gameName);
        return championships
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList()
                );
    }

    @Override
    public List<Championship> findByChampionshipType(String championshipType) {
        List<ChampionshipEntity> championships = championshipRepository.findByType(championshipType);
        return championships
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList()
                );
    }

    @Override
    public List<Championship> findByChampionshipFormat(String championshipFormat) {
        List<ChampionshipEntity> championships = championshipRepository.findByFormat(championshipFormat);
        return championships
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Championship subscribeMatch(String championshipId, String matchId) {
        ChampionshipEntity subscribedChampionship = championshipRepository.findById(championshipId).orElse(null);

        List<String> matchesIds = new ArrayList<>();

        if (subscribedChampionship != null) {
            matchesIds =  subscribedChampionship.getMatchesId();
            matchesIds.add(matchId);
            subscribedChampionship.setMatchesId(matchesIds);
            championshipRepository.save(subscribedChampionship);

            return mapper.toDomain(subscribedChampionship);
        }
        return null;
    }

    @Override
    public Championship subscribeRegistration(String championshipId, String registrationId) {

        ChampionshipEntity subscribedChampionship = championshipRepository.findById(championshipId).orElse(null);

        List<String> registrationIds = new ArrayList<>();
        registrationIds =  subscribedChampionship.getRegistrationsId();
        registrationIds.add(registrationId);
        subscribedChampionship.setRegistrationsId(registrationIds);
        championshipRepository.save(subscribedChampionship);

        return mapper.toDomain(subscribedChampionship);

    }

    @Override
    public void setRanking(String championshipId, String rankingId) {

        ChampionshipEntity championship = championshipRepository.findById(championshipId).orElse(null);

        championship.setRankingId(rankingId);

        championshipRepository.save(championship);
    }
}


