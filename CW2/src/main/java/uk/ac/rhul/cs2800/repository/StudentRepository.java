package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Student;

/**
 * this interface acts as a Data Access object for Students.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

}
