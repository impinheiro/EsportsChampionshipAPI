package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;

import java.time.LocalDateTime;
import java.util.List;

public record Championship(String id,
                           String createdBy,
                           String name,
                           String gameName,
                           ChampionshipType type,
                           Integer capacity,
                           double subscriptionValue,
                           ChampionshipFormat format,
                           String rules,
                           LocalDateTime startDate,
                           LocalDateTime endDate,
                           String location,
                           String  coverImage,
                           String logoImage,
                           String awardDescription,
                           List<String> registrationsId,
                           List<String> matchesId,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
}
