package com.eventapp.eventity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements Servicelogin {
	
	@Autowired
	LoginDAO loginDao;
	EventDAO eventDao;

	@Override
    public String createUser(Login log) {
        return loginDao.insertUserRecord(log);
    }

    // Get a user by ID
//    @Override
//    public Optional<Login> getUserById(int id) {
//        return loginDao.getUserById(id);
//    }
    
    @Override
    public Login getUserById(int id) {
        return loginDao.getUserById(id);
    }

    // Get a user by email
    @Override
    public Login getUserByEmail(String email) {
        return loginDao.getUserByEmail(email);
    }

    // Get all users
    @Override
    public List<Login> getAllUsers() {
        return loginDao.getAllUsers();
    }
    
    @Override
    public List<Login> getUserByRole(String role){
    	return loginDao.findByRole(role);
    }
    // Update a user by ID
//    @Override
//    public Login updateUser(int id, Login user) {
//        Optional<Login> exists = loginDao.getUserById(id);
//        if (exists.isPresent()) {
//            Login log = exists.get();
//            log.setStatus(user.getStatus());
//            return loginDao.updateUserData(log);
//        }
//        return null;
//    }
    
    @Override
    public Login updateUser(int id, String status) {
        Login user = loginDao.getUserById(id);
        if (user != null) {
            user.setStatus(status);
            return loginDao.updateUserData(user);
        }
        return null;
    }

    // Delete a user by ID
    @Override
    public void deleteUser(int id) {
        loginDao.deleteRecord(id);
    }
   
    public String updateRoleData(Login log)
    {
    	return loginDao.updateUserRoleData(log);
    }
    
    public boolean validateUser(String email, String password, String role) {
        Login user = loginDao.findUserByCredentials(email, password, role);
//        return user != null;
        if (user != null && "Active".equalsIgnoreCase(user.getStatus())) {
            return true;
        } else {
            return false;
        }
    }
	
}
