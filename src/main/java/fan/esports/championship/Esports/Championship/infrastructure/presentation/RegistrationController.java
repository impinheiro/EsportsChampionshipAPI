package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.CreateRegistrationCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.GetRegistrationByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.UpdateRegistrationCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final CreateRegistrationCase createRegistrationCase;
    private  final UpdateRegistrationCase updateRegistrationCase;
    private final GetRegistrationByIdCase getRegistrationByIdCase;

    public RegistrationController(CreateRegistrationCase createRegistrationCase, UpdateRegistrationCase updateRegistrationCase, GetRegistrationByIdCase getRegistrationByIdCase) {
        this.createRegistrationCase = createRegistrationCase;
        this.updateRegistrationCase = updateRegistrationCase;
        this.getRegistrationByIdCase = getRegistrationByIdCase;
    }

    @GetMapping("/getById")
    public Registration findById(String id) {
        getRegistrationByIdCase.execute(id);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("create")
    public Registration create(@RequestBody Registration registration) {
        createRegistrationCase.execute(registration);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PutMapping("/update/{id}")
    public Registration update(@PathVariable String id,@RequestBody Registration registration) {
        updateRegistrationCase.execute(id, registration);
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
