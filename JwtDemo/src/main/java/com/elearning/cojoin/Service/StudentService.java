package com.elearning.cojoin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.cojoin.Dao.StudentDao;
import com.elearning.cojoin.Model.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public Student saveStudentData(Student student) {
		Student saveStudent = studentDao.save(student);
		return saveStudent;
	}
	
	public List<Student> getStudentData() {
		List<Student> findAllStudents = studentDao.findAll();
		return findAllStudents;
	}
	
	public Student getStudentById(Long id) {
		Student findStudentById = studentDao.getById(id);
		return findStudentById;
	}
	
}
