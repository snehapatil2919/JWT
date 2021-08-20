package com.elearning.cojoin.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.elearning.cojoin.Model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

      public Users findByEmail(String email);
      
      public Users findByEmailAndPassword(String email,String password);
}
