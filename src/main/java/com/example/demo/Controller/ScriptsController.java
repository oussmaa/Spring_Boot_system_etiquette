package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Scripts;
import com.example.demo.Repository.ScriptsRepository;
import com.example.demo.Services.ScriptsService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ScriptsController {
	@Autowired
	 private ScriptsService scriptsService;
	@Autowired
	private ScriptsRepository scriptsRepo;


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
