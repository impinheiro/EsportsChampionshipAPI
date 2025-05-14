package fan.esports.championship.Esports.Championship.core.usecases.promoters;


public interface ChangeRegistrationsStatusCase {

    void execute(String registrationId, String status);

}
