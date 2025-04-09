package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RegistrationDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamRegistrationDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.TeamRegistrationDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationDtoMapper registrationDtoMapper;
    private final TeamRegistrationDtoMapper teamRegistrationDtoMapper;
    private final CreateRegistrationCase createRegistrationCase;
    private final UpdateRegistrationCase updateRegistrationCase;
    private final GetRegistrationByIdCase getRegistrationByIdCase;
    private final DeleteRegistrationCase deleteRegistrationCase;
    private final CreateTeamRegistrationCase createTeamRegistrationCase;
    private final UpdateTeamRegistrationCase updateTeamRegistrationCase;
    private final FindTeamRegistrationByIdCase findTeamRegistrationByIdCase;
    private final DeleteTeamRegistrationCase deleteTeamRegistrationCase;
    private final FindAllRegistrationsCase findAllRegistrationsCase;

    public RegistrationController(RegistrationDtoMapper registrationDtoMapper, TeamRegistrationDtoMapper teamRegistrationDtoMapper, CreateRegistrationCase createRegistrationCase, UpdateRegistrationCase updateRegistrationCase, GetRegistrationByIdCase getRegistrationByIdCase, DeleteRegistrationCase deleteRegistrationCase, CreateTeamRegistrationCase createTeamRegistrationCase, UpdateTeamRegistrationCase updateTeamRegistrationCase, FindTeamRegistrationByIdCase findTeamRegistrationByIdCase, DeleteTeamRegistrationCase deleteTeamRegistrationCase, FindAllRegistrationsCase findAllRegistrationsCase) {
        this.registrationDtoMapper = registrationDtoMapper;
        this.teamRegistrationDtoMapper = teamRegistrationDtoMapper;
        this.createRegistrationCase = createRegistrationCase;
        this.updateRegistrationCase = updateRegistrationCase;
        this.getRegistrationByIdCase = getRegistrationByIdCase;
        this.deleteRegistrationCase = deleteRegistrationCase;
        this.createTeamRegistrationCase = createTeamRegistrationCase;
        this.updateTeamRegistrationCase = updateTeamRegistrationCase;
        this.findTeamRegistrationByIdCase = findTeamRegistrationByIdCase;
        this.deleteTeamRegistrationCase = deleteTeamRegistrationCase;
        this.findAllRegistrationsCase = findAllRegistrationsCase;
    }


    @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = findAllRegistrationsCase.execute();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        Registration registration = getRegistrationByIdCase.execute(id);
        response.put("Registration ID: ", registration.id());
        response.put("Registration owner: ", "[ Email: "+registration.user().email()+" ] "+ "[ Nickname: "+registration.user().nickname()+ " ]");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RegistrationDTO registrationDto) {
        Map<String, Object> response = new HashMap<>();
        Registration registration = registrationDtoMapper.toDomain(registrationDto);
        createRegistrationCase.execute(registration);
        response.put("Registration", registration);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody RegistrationDTO registrationDto) {
        Map<String, Object> response = new HashMap<>();
        Registration registration = registrationDtoMapper.toDomain(registrationDto);
        updateRegistrationCase.execute(id, registration);
        response.put("Success", "Your registration has been updated");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        deleteRegistrationCase.execute(id);
        response.put("Success", "Your registration has been withdrawn");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/teamregistration/findById/{id}")
    public ResponseEntity<?> findTeamRegistrationById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        TeamRegistration teamRegistration = findTeamRegistrationByIdCase.execute(id);
        response.put("Registration found: ", teamRegistrationDtoMapper.toDTO(teamRegistration));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/teamregistration/create")
    public ResponseEntity<?> createTeamRegistration(@RequestBody TeamRegistrationDTO teamRegistrationDTO) {
        Map<String, Object> response = new HashMap<>();
        TeamRegistration teamRegistration = teamRegistrationDtoMapper.toDomain(teamRegistrationDTO);
        createTeamRegistrationCase.execute(teamRegistration);
        response.put("Success", "You have been registered");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/teamregistration/update/{id}")
    public ResponseEntity<?> updateTeamRegistration(@PathVariable String id,@RequestBody TeamRegistrationDTO teamRegistrationDTO) {
        Map<String, Object> response = new HashMap<>();
        TeamRegistration updatedData = teamRegistrationDtoMapper.toDomain(teamRegistrationDTO);
        updateTeamRegistrationCase.execute(id, updatedData);
        response.put("Success", "The registration has been updated");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/teamregistration/delete/{id}")
    public ResponseEntity<?> deleteTeamRegistration(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        deleteTeamRegistrationCase.execute(id);
        response.put("Success", "Registration of ID: "+id+" has been deleted");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
