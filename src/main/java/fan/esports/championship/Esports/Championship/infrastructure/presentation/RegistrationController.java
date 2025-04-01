package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.CreateRegistrationCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.DeleteRegistrationCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.GetRegistrationByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.UpdateRegistrationCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RegistrationDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationDtoMapper registrationDtoMapper;
    private final CreateRegistrationCase createRegistrationCase;
    private final UpdateRegistrationCase updateRegistrationCase;
    private final GetRegistrationByIdCase getRegistrationByIdCase;
    private final DeleteRegistrationCase deleteRegistrationCase;

    public RegistrationController(RegistrationDtoMapper registrationDtoMapper, CreateRegistrationCase createRegistrationCase, UpdateRegistrationCase updateRegistrationCase, GetRegistrationByIdCase getRegistrationByIdCase, DeleteRegistrationCase deleteRegistrationCase) {
        this.registrationDtoMapper = registrationDtoMapper;
        this.createRegistrationCase = createRegistrationCase;
        this.updateRegistrationCase = updateRegistrationCase;
        this.getRegistrationByIdCase = getRegistrationByIdCase;
        this.deleteRegistrationCase = deleteRegistrationCase;
    }

    @GetMapping("/getById")
    public ResponseEntity<?> findById(String id) {
        Map<String, Object> response = new HashMap<>();
        Registration registration = getRegistrationByIdCase.execute(id);
        response.put("Registration ID: ", registration.id());
        response.put("Registration owner: ", "Email: "+registration.user().email()+" Nickname: "+registration.user().nickname());
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
}
