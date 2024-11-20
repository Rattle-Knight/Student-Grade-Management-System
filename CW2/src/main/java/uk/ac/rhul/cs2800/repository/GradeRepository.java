package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Grade;

/**
 * this interface acts as a Data Access object for Grades.
 */
public interface GradeRepository extends CrudRepository<Grade, Long> {

}
