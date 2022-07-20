package com.example.demo.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Scripts;


public interface ScriptsService {
	 Scripts addNewScripts(Scripts scripts);
	 
	    List<Scripts> listScripts();
	   
	    Scripts updateScripts(Scripts scripts,Long id);
	    String deleteScripts(Long id);
	    Scripts getScripts(String version);


}
