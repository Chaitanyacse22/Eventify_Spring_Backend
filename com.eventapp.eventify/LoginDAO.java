package com.eventapp.eventity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	
	@Autowired
	LoginRepository loginRepo;
	 
//	public List<Login> getAllUsers()
//	{
//		return loginRepo.findAll();
//	}
//	
//	public String insertUserRecord(Login logObj)
//	{
//		 loginRepo.save(logObj);
//		 
//		 return "Record Inserted in the DB Successfully";
//	}
//	
	public String updateUserRoleData(Login logObj)
	{
		 loginRepo.save(logObj);
		 
		 return "Record Updated in the DB Successfully";
	}
//	
//	public Login getUserByID(Long id)
//	{
//		return loginRepo.findById(id).orElse(null);
//	}
//	
//	public Login getUserByEmail(String email)
//	{
//		return loginRepo.findByEmail(email).orElse(null);
//	}
//	
//	public String deleteRecord(Long Id)
//	{
//		 loginRepo.deleteById(Id);
//		 
//		 return "Given record is deleted successfully";
//	}
	
	public List<Login> getAllUsers() {
        return loginRepo.findAll();
    }

    // Method to insert a new user record
    public String insertUserRecord(Login logObj) {
        loginRepo.save(logObj);
        return "Record Inserted in the DB Successfully";
    }

    // Method to update an existing user record
    public Login updateUserData(Login logObj) {
        return loginRepo.save(logObj);
//        return "Record Updated in the DB Successfully";
    }

    // Method to get a user by ID
//    public Optional<Login> getUserById(int id) {
//        return loginRepo.findById(id);
//    }
    
    public List<Login> findByRole(String role){
    	return loginRepo.findByRole(role);
    };
    
    public Login getUserById(int id) {
        return loginRepo.findById(id).orElse(null);
    }

    // Method to get a user by email
    public Login getUserByEmail(String email) {
        return loginRepo.findByEmail(email);
    }
    
    public Login findUserByCredentials(String email, String password, String role) {
        return loginRepo.findByEmailAndPasswordAndRole(email, password, role);
    }

    // Method to delete a user by ID
    public String deleteRecord(int Id) {
        loginRepo.deleteById(Id);
        return "Given record is deleted successfully";
    }
    

}
