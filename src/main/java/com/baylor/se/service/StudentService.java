package com.baylor.se.service;

import com.baylor.se.data.StudentRepository;
import com.baylor.se.exception.NotFoundException;
import com.baylor.se.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student registerStudent(Student student){
        return studentRepository.save((Student) student);
    }

    public Student getStudent(Long id){
        Student student =   studentRepository.findById(id).orElseThrow(NotFoundException::new);
        return student;
    }

    public List<Student> getStudents(){
        return (List<Student>)studentRepository.findAll();
    }

    public Student updateStudent(Student student){ return studentRepository.save((Student) student);};

    public void deleteStudent(Long id){
        Student student =   studentRepository.findById(id).orElseThrow(NotFoundException::new);
        studentRepository.delete(student);
    }
}
