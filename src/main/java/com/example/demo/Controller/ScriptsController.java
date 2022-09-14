package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.TestQA;
import com.example.demo.Repository.TestQARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Scripts;
import com.example.demo.Repository.ScriptsRepository;
import com.example.demo.Services.ScriptsService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/script")
public class ScriptsController {
	@Autowired
	 private ScriptsService scriptsService;
	@Autowired
	private ScriptsRepository scriptsRepo;

	@Autowired
	private TestQARepository testQARepository;


	@PutMapping("/updatetest/{id}")
	public TestQA updateTest(@RequestBody Date date, @PathVariable("id") Long id){
		TestQA test =testQARepository.findById(id).orElse(null);;
		test.setDatefinScript(date);
		testQARepository.save(test);
		return test;
	}
	@PutMapping("/updatescripts/{id}")
	public Scripts updateScripts(@RequestBody Date date, @PathVariable("id") Long id){
		Scripts scripts =scriptsRepo.findById(id).orElse(null);;
		 scripts.setDatefinScript(date);
		scriptsRepo.save(scripts);
		return scripts;
	}
	    public ScriptsController(ScriptsService scriptsService) {
	        this.scriptsService = scriptsService;
	    }

	    @GetMapping(path = "/scripts")
	    public List<Scripts> scripts(){ return scriptsService.listScripts();}

	    @PostMapping("/addScripts")
	    public Scripts saveScripts(@RequestBody Scripts scripts){
	        return scriptsRepo.save(scripts);
	    }

	   
	    @PutMapping("/updateScripts/{id}")
	    public Scripts updateScripts(@RequestBody Scripts scripts,@PathVariable Long id){
	        return scriptsService.updateScripts(scripts,id);
	    }

	    @DeleteMapping("/deleteScripts/{id}")
	    public String deleteScripts(@PathVariable Long id){
	        return scriptsService.deleteScripts(id);
	    }

}
