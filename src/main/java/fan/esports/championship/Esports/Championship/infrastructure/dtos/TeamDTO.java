package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import java.util.ArrayList;
import java.util.List;

public record TeamDTO(String id, String name, List<String> membersId) {
    public TeamDTO{
        if(membersId == null){
            membersId = new ArrayList<>();
        }
    }
}
