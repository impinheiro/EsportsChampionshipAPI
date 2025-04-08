package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionShipEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipRepository;
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
        newChampionship.setCreatedAt(LocalDateTime.now());
        newChampionship.setUpdatedAt(LocalDateTime.now());
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
}
