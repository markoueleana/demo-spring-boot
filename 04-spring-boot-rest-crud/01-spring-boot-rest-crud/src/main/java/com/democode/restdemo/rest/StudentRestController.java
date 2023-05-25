package com.democode.restdemo.rest;

import com.democode.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //get all students
   private  List<Student> theStudents=new ArrayList<>();
   @PostConstruct
   public void loadData(){
       theStudents.add(new Student("Lucky","Grumpy"));
       theStudents.add(new Student("Saki","Paki"));
       theStudents.add(new Student("Lila","Tequila"));
       theStudents.add(new Student("Pali","Krepali"));

   }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
       if (theStudents.size()<= id || id<0 ){
    throw new StudentNotFoundException("Student with "+ id +" not found");
       }
        return theStudents.get(id);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
       StudentErrorResponse error= new StudentErrorResponse();
       error.setMessage(exc.getMessage());
       error.setErrorMessage(HttpStatus.NOT_FOUND.value());
       error.setTimeStamp(System.currentTimeMillis());
       return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error= new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setErrorMessage(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
