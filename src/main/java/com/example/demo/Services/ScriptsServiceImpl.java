package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Scripts;
import com.example.demo.Repository.ScriptsRepository;

@Service
@Transactional
public class ScriptsServiceImpl implements ScriptsService{
	private ScriptsRepository scriptsRepository;
	 

    public ScriptsServiceImpl(ScriptsRepository scriptsRepository) {
        this.scriptsRepository = scriptsRepository;
    }
   
    /**
     * Scripts Crud
     */
    @Override
    public Scripts addNewScripts(Scripts scripts) {
        return scriptsRepository.save(scripts);
    }

    @Override
    public List<Scripts> listScripts() { return scriptsRepository.findAll(); }

    public Scripts getUserById(Long id){
        return scriptsRepository.findById(id).orElse(null);
    }
    public Scripts getUserByVersion(String version){
        return scriptsRepository.findByVersion(version);
    }

    public Scripts updateScripts(Scripts scripts, Long id){
    Scripts Scripts = scriptsRepository.getById(id);
  
    Scripts.setVersion(scripts.getVersion());
     scripts.setDate_livraison(scripts.getDate_livraison());
    scripts.setEtat(scripts.getEtat());
    scriptsRepository.save(scripts);
    return scripts;
    }
    public String deleteScripts(Long id){
    	scriptsRepository.deleteById(id);
        return "Scripts removed  !! "+id;
    }
    @Override
   public Scripts getScripts(String version) {
    	return scriptsRepository.findByVersion(version);
    	
    }


}
