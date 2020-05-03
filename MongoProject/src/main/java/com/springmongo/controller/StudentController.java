package com.springmongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmongo.exception.ResourceNotFoundException;
import com.springmongo.model.Student;
import com.springmongo.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@GetMapping(value = "/all")
    public List<Student> getAllEmployees() {
        return studentRepository.findAll();
    }
	
	@GetMapping(value = "/all/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id")Long Id) throws ResourceNotFoundException{
		Student student = studentRepository.findById(Id)
						.orElseThrow(()-> new ResourceNotFoundException("this student Id not found: "+Id));
		return ResponseEntity.ok().body(student);
						

	}
	
	@PostMapping(value = "/create")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.insert(student);
		
	}
	
	@PutMapping(value = "/create/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id")Long sid, @Valid @RequestBody Student student) throws ResourceNotFoundException{
		Student stud = studentRepository.findById(sid)
						.orElseThrow(()->new ResourceNotFoundException("this student Id is not found: "+sid));
		stud.setId(student.getId());
		stud.setName(student.getName());
		stud.setGrade(student.getGrade());
		stud.setAge(student.getAge());
		final Student studDetails = studentRepository.save(stud);
		return ResponseEntity.ok().body(studDetails);
		
	}
    @DeleteMapping("/student/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id")Long id) throws ResourceNotFoundException{
		Student student = studentRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("this student Id is not found: "+id));
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
    	response.put("deleted", Boolean.TRUE);
		return response;
    	
    }
}
