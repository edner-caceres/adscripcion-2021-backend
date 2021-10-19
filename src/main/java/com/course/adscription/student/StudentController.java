package com.course.adscription.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){

        return _studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        _studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{email}")
    public void deleteStudent(@PathVariable("email") String email){
        _studentService.deleteStudentByEmail(email);
    }

    /*@PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        _studentService.updateStudent(studentId, name, email);
    }*/

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        _studentService.updateStudent(student);
    }
}
