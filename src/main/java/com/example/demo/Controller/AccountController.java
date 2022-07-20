package com.example.demo.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.AccountService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class AccountController {
	@Autowired
	 private AccountService accountService;
	@Autowired
	private UserRepository userRepo;


	    public AccountController(AccountService accountService) {
	        this.accountService = accountService;
	    }

	    @GetMapping(path = "/users")
	   // @PostAuthorize("hasAuthority('ADMIN')")
	    public List<User> Users(){ return accountService.listUser();}

	    @PostMapping("/addUser")
	   //@PostAuthorize("hasAuthority('ADMIN')")
	    public User saveUser(@RequestBody User User){
	        return userRepo.save(User);
	    }

	    @GetMapping("/findUserById/{id}")
	    public User findUserById(@PathVariable Long id){
	        return accountService.getUserById(id);
	    }

	    @PutMapping("/updateUser/{id}")
	    public User updateUser(@RequestBody User use,@PathVariable("id") Long id){
			System.out.println(id);
			User user = userRepo.findById(id).orElse(null);
			user.setFirstName(use.getFirstName());
			user.setEquipe(use.getEquipe());
			user.setEmail(use.getEmail());
			user.setPoste(use.getPoste());
			user.setLastName(use.getLastName());
			System.out.println(use.getEquipe());
			userRepo.save(user);
			return user;
	    }

	    @DeleteMapping("/deleteUser/{id}")
	    public String deleteUser(@PathVariable Long id){
	        return accountService.deleteUser(id);
	    }

	    @GetMapping("/findUserByFirstName/{firstname}")
	    public User findUserByFirstName(@PathVariable String firstname){
	        return accountService.getUserByFirstName(firstname);
	    }



	  

	    @GetMapping(path = "/profile")
	    public User profile(Principal principal){
	        return accountService.loadUserByUsername(principal.getName());
	    }
	    
	 

}
