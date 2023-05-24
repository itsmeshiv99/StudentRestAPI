package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/student/api")

public class StudentController {

	@Autowired
	private StudentService stServ;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> students= stServ.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("{id}")
	public ResponseEntity <Student> getStudentById(@PathVariable("id") long id)
	{
		Student student= stServ.getStudentById(id);
		return new ResponseEntity <Student>(student,HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity <Student> createStudent(@RequestBody Student student)
	{
		Student createdStudent= stServ.createStudent(student);
		return new ResponseEntity <Student>(createdStudent,HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("{id}")
	public ResponseEntity <Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student )
	{
		Student updateStudent= stServ.updateStudent(student);
		return new ResponseEntity <Student>(updateStudent,HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("{id}")
	public ResponseEntity <String> deleteStudent(@PathVariable("id") long id)
	{
		String msg = stServ.deleteStudent(id);
		return new ResponseEntity <String>(msg ,HttpStatus.OK);
	}
	
	
	
}
