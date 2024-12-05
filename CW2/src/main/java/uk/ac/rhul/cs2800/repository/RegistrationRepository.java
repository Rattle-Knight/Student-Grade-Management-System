package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Registration;

/**
 * this interface acts as a Data Access object for Students.
 */
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
