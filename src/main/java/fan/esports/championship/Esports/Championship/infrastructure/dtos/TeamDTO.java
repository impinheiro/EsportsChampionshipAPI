package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import java.util.ArrayList;
import java.util.List;

public record TeamDTO(String id, String name, List<UserDTO> members) {
    public TeamDTO{
        if(members == null){
            members = new ArrayList<>();
        }
    }
}
