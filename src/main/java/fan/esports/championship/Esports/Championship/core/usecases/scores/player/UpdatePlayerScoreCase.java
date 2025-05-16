package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;

public interface UpdatePlayerScoreCase {
    PlayerScore execute(String id, PlayerScore score);
}
