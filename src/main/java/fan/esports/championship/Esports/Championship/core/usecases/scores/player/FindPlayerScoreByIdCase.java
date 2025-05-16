package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;

public interface FindPlayerScoreByIdCase {
    PlayerScore execute(String id);
}
