package com.elearning.cojoin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.elearning.cojoin.Model.Student;
import com.elearning.cojoin.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping(path = "/saveStudentInfo")
	public ResponseEntity<Student> saveStudentInfo(@RequestBody Student student){
		Student saveStudentData = studentService.saveStudentData(student);
		return new ResponseEntity<Student>(saveStudentData, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getStudentInfo")
	public ResponseEntity<List<Student>> getStudentsInfo(){
		List<Student> getStudentData = studentService.getStudentData();
		return new ResponseEntity<List<Student>>(getStudentData, HttpStatus.FOUND);
	}
	
	@GetMapping(path = "/getStudentById")
	public ResponseEntity<Student> getStudentsById(@PathVariable("id") Long id){
		Student getStudentById = studentService.getStudentById(id);
		return new ResponseEntity<Student>(getStudentById, HttpStatus.FOUND);
	}
}
