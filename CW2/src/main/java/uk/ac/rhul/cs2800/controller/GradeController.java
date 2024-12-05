package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * this class handles post mapping and dependency injections for the database.
 */
@RestController
public class GradeController {
  private final GradeRepository gradeRepository;
  private final StudentRepository studentRepository;
  private final ModuleRepository moduleRepository;

  /**
   * this is the public constructor for GradeController, the gradeRepository object (bean) is
   * initialised by Spring and injected to the GradeController.
   *
   * @param gradeRepository initialised by spring for the dependency injection.
   * @param studentRepository initialised by spring for the dependency injection.
   * @param moduleRepository initialised by spring for the dependency injection.
   */
  public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository,
      ModuleRepository moduleRepository) {
    this.gradeRepository = gradeRepository;
    this.studentRepository = studentRepository;
    this.moduleRepository = moduleRepository;
  }


  /**
   * this method responds to the POST command and maps the values onto a Grade Object.
   *
   * @param params this is bound to the body of the web request and will take in values
   * @return the saved grade object
   */
  @PostMapping(value = "/grades/addGrade")
  public ResponseEntity<Grade> addGrade(@RequestBody Map<String, String> params) {

    long id = Long.parseLong((params.get("student_id")));
    Student student = studentRepository.findById(id).orElseThrow();

    Module module =
        moduleRepository.findById(String.valueOf(params.get("module_code"))).orElseThrow();

    Grade grade = new Grade();
    grade.setStudent(student);
    grade.setModule(module);
    grade.setScore(Integer.valueOf(params.get("score")));

    grade = gradeRepository.save(grade);
    return ResponseEntity.ok(grade);
  }


}
