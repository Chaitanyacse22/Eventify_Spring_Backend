package com.eventapp.eventity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;;

@CrossOrigin (origins="http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class LoginController {
	
	public LoginController(){}
	
 
	@Autowired
	LoginService serve;
	LoginDAO loginDao;
	
	//Login Validation and Roles Management Endpoints.
	
//	@PostMapping("/user/insert")
//	public ResponseEntity<String> createUser(@RequestBody Login user) {
//        String createdUser = serve.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
	@PostMapping("/user/insert")
	public ResponseEntity<String> createUser(@RequestBody Login user) {
	    // Assuming the "serve.createUser()" method is correctly handling the user insertion logic
	    String createdUser = serve.createUser(user);
	    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	
//	@GetMapping("/user/{id}")
//    public ResponseEntity<Login> getUserById(@PathVariable int id) {
//        Optional<Login> user = serve.getUserById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
	
	@GetMapping("/user/hello/{email}")
    public ResponseEntity<Login> getUserByEmail(@PathVariable String email) {
        Login user = serve.getUserByEmail(email);
        return (user==null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(user, HttpStatus.OK) ;
    }
	
	@GetMapping("/user/{id}")
    public ResponseEntity<Login> getUserById(@PathVariable int id) {
        Login user = serve.getUserById(id);
        return (user==null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(user, HttpStatus.OK) ;
    }
	
	@GetMapping("/user")
    public ResponseEntity<List<Login>> getAllUsers() {
        List<Login> users = serve.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@PutMapping("/updateUser/{status}")
    public String updateUser(@RequestBody Login log, @PathVariable String status) {
        return serve.updateRoleData(log);
//        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
//	@PutMapping("/updateUser/{id}")
//    public ResponseEntity<Login> updateUser(@PathVariable int id, @RequestBody Login user) {
//        Login updatedUser = serve.updateUser(id, user);
//        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
	
	@GetMapping("/user/role/{role}")
    public ResponseEntity<List<Login>> getUserByRole(@PathVariable String role) {
        List<Login> user = serve.getUserByRole(role);
        return (user==null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(user, HttpStatus.OK) ;
    }

	
	@PutMapping("/updateUser/{id}/status")
    public ResponseEntity<Login> updateUser(@PathVariable int id, @RequestBody Map<String, String> status) {
		
		String userStatus = status.get("status");
        Login updatedUser = serve.updateUser(id, userStatus);

        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        serve.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	//Event controller methods Endpoints.
	
	@Autowired
	EventDAO evenDao;
	
	@GetMapping("/getEvents")
	public List<Event>getEvents(){
		return evenDao.getAllEvents();
	}
	@PostMapping("/insertEvent")
	public String insertEvent(@RequestBody Event evenObj) {
			return evenDao.insertEventRecord(evenObj);
	}
	@PutMapping("/updateEvent")
	public String updateEvent(@RequestBody Event evenObj) {
		return evenDao.updateEventData(evenObj);
	}
	@DeleteMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable Long id) {
		return evenDao.deleteEventRecord(id);
	}
	
	//Login controller methods Endpoints for login Validation.
	
	@PostMapping("/login")
    public int login(@RequestBody LoginDTO loginRequest) {
        boolean isValidUser = serve.validateUser(
            loginRequest.getEmail(),
            loginRequest.getPassword(),
            loginRequest.getRole()
        );
        return isValidUser ? 1 : 0;
    }
	
	
//	@GetMapping("/getAllUsers")
//	public List<Login> getAllUser()
//	{
//		return logDao.getAllUsers();
//	}
//	
//	@PostMapping("/insertUserRecord")
//	public String insertUserRecord(@RequestBody Login logObj)
//	{
//		return logDao.insertUserRecord(logObj);
//	}
//	
//	@PutMapping("/updateUserData")
//	public String updateUser(@RequestBody Login logObj)
//	{
//		return loginDao.updateUser(logObj);
//	}
////	
//	@DeleteMapping("/deleteRecord/{id}")
//	public String deleteRecord(@PathVariable Long id)
//	{
//		return logDao.deleteRecord(id);
//	}

}
