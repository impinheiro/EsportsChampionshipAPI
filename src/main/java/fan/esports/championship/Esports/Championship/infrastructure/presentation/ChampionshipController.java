package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/championship")
public class ChampionshipController {

    @PostMapping("create")
    public ChampionshipDTO create(@RequestBody ChampionshipDTO championshipDTO){
        return null;
    }
}
