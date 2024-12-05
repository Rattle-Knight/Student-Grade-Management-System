package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.repository.GradeRepository;

/**
 * this class handles post mapping and dependency injections for the database.
 */
@RestController
public class GradeController {
  private final GradeRepository gradeRepository;

  /**
   * this is the public constructor for GradeController, the gradeRepository object (bean) is
   * initialised by Spring and injected to the GradeController.
   *
   * @param gradeRepository initialised by spring for the dependency injection.
   */
  public GradeController(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  /**
   * this method responds to the POST command and maps the values onto a Grade Object.
   *
   * @param params this is bound to the body of the web request and will take in values
   * @return the saved grade object
   */
  @PostMapping(value = "/grades/addGrade")
  public ResponseEntity<Grade> addGrade(@RequestBody Map<String, String> params) {
    // Find the student by using student_id
    // Find the module by using the module_code
    // Create a Grade object and set all values
    // Save the Grade object.
    // Return the saved Grade object.
    return null;
  }
}
