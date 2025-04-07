package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;

import java.util.List;

public interface FindAllMatchesCase {
    List<Match> execute();
}
