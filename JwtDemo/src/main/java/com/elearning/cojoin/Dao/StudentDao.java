package com.elearning.cojoin.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.elearning.cojoin.Model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

}
