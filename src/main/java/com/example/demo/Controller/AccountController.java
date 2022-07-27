package com.example.demo.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.Problem;
import com.example.demo.Repository.ProblemRepository;
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
	@Autowired
	private ProblemRepository problemRepository;

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
	    public User updateUser(@RequestBody Boolean use,@PathVariable("id") Long id){
			System.out.println(id);
			User user = userRepo.findById(id).orElse(null);
			if(use.equals(false))
			{user.setValid(true);}
			else
			{user.setValid(false);}
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


	@GetMapping(path = "/GetUserAndAdmin")
	// @PostAuthorize("hasAuthority('ADMIN')")
	public List<Integer> GetSizeUserAndADdmin(){
			List<User> users = userRepo.findByRoles("User");
		    List<User> admins = userRepo.findByRoles("Admin");
		   List<Integer> list=new ArrayList<>();
		   System.out.println(users.size());
		System.out.println(admins.size());

		list.add(users.size());
		list.add(admins.size());
		return  list;
		}

	@GetMapping("/GetAllProblem")
	public List<Problem> GetAlleEvent(){

		return problemRepository.findAll();

	}

			@PostMapping("/addproblem")
			public Problem saveproblem(@RequestBody Problem problem){

			 Problem problem1=new Problem(problem.getText(),problem.getObject(),problem.getUsernameuser(),problem.getVersion(),new Date());

			return problemRepository.save(problem1);


 	      }


		@GetMapping(path = "/profile")
	    public User profile(Principal principal){
	        return accountService.loadUserByUsername(principal.getName());
	    }
	    
	 

}
