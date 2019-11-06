package com.baylor.se.controller;

import com.baylor.se.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baylor.se.service.StudentService;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path="/students", produces="application/json")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> studentList =  studentService.getStudents();
        return ResponseEntity.ok().body(studentList);
    }

    @GetMapping(path="/students/{id:[0-9][0-9]*}", produces="application/json")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping(path="/students/",consumes = "application/json", produces="application/json")
    @ResponseBody
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        Student registeredStudent = studentService.registerStudent(student);
        return ResponseEntity.ok().body(registeredStudent);
    }

    @PutMapping(path="/students/", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping(path="/students/delete/{id:[0-9][0-9]*}", produces="application/json")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body(true);
    }

}
