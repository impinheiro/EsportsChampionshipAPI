package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;

import java.util.List;

public interface FindPlayerScoresCase {
    List<PlayerScore> execute();
}
