package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.usecases.rankings.team.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/team-ranking")
public class TeamRankingController {

    private final CreateTeamRankingCase createTeamRankingCase;
    private final FindTeamRankingByIdCase findTeamRankingByIdCase;
    private final FindAllTeamRankingsCase findAllTeamRankingsCase;
    private final UpdateTeamRankingCase updateTeamRankingCase;
    private final DeleteTeamRankingCase deleteTeamRankingCase;

    public TeamRankingController(CreateTeamRankingCase createTeamRankingCase, FindTeamRankingByIdCase findTeamRankingByIdCase, FindAllTeamRankingsCase findAllTeamRankingsCase, UpdateTeamRankingCase updateTeamRankingCase, DeleteTeamRankingCase deleteTeamRankingCase) {
        this.createTeamRankingCase = createTeamRankingCase;
        this.findTeamRankingByIdCase = findTeamRankingByIdCase;
        this.findAllTeamRankingsCase = findAllTeamRankingsCase;
        this.updateTeamRankingCase = updateTeamRankingCase;
        this.deleteTeamRankingCase = deleteTeamRankingCase;
    }
}
