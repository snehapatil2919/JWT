package com.elearning.cojoin.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.elearning.cojoin.Dao.UsersDao;
import com.elearning.cojoin.Model.Users;
import com.elearning.cojoin.config.JwtTokenUtil;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	UsersDao usersDao;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersDao.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(), new ArrayList<>());
	}
	
	
	public Users saveData(Users user) {
		Users u = usersDao.save(user);
		u.setToken(JwtTokenUtil.generateToken(user.getEmail()));
		return u;
	}
	
	
  public Users authenticateUser(Users user) {
	   Users u =  usersDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
	  u.setToken(JwtTokenUtil.generateToken(user.getEmail()));
	  return u;
  }
	
	
}
