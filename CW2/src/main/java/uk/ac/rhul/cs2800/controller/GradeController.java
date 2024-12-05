package uk.ac.rhul.cs2800.controller;

import org.springframework.web.bind.annotation.RestController;
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


}
