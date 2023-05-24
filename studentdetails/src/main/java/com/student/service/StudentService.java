package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Repository.StudentRepository;
import com.student.entity.Student;

@Service
public class StudentService {

	@Autowired
	 private StudentRepository stRepo;
	
	public Student createStudent(Student st)
	{
		return stRepo.save(st);
	}
	
	public Student updateStudent(Student st)
	{
		Student dbST= stRepo.findById(st.getId()).get();
		dbST.setId(st.getId());
		dbST.setName(st.getName());
		dbST.setEmail(st.getEmail());
		dbST.setPhone(st.getPhone());
		dbST.setAddr(st.getAddr());
		
		return stRepo.save(dbST);
		
	}
	
	public String deleteStudent(long id)
	{
		stRepo.deleteById(id);
		return "Student record deleted sucessfully.";
	}
	
	public List<Student> getAllStudents()
	{
		return stRepo.findAll();
	}
	
	public Student getStudentById(long id)
	{
		return stRepo.findById(id).get();
	}
}
