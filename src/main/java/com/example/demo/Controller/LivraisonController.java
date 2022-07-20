package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import com.example.demo.Entity.Livraison;
import com.example.demo.Entity.Scripts;
import com.example.demo.Entity.TestQA;
import com.example.demo.Repository.Historique;
import com.example.demo.Repository.LivraisonRepository;
import com.example.demo.Repository.ScriptsRepository;
import com.example.demo.Repository.TestQARepository;
import com.example.demo.Services.LivraisonService;

import com.example.demo.payload.request.sortItemsHistorique;
import com.example.demo.payload.request.sortItemsLivraison;
import com.example.demo.payload.request.sortItemsScript;
import com.example.demo.payload.request.sortItemsTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Livraison")
public class LivraisonController {
	@Autowired
	 private LivraisonService livraisonService;
	@Autowired
	private LivraisonRepository livraisonRepo;
	@Autowired
	private Historique historique;
	@Autowired
	private TestQARepository testQARepository;


	@Autowired
	private ScriptsRepository scriptsRepository;


	    public LivraisonController(LivraisonService livraisonService) {
	        this.livraisonService = livraisonService;
	    }

	    @GetMapping(path = "/Livraison")
	    public List<Livraison> Livraison(){

			List<Livraison> list=new ArrayList<>();
			list= livraisonService.listLivraison();;
			Collections.sort(list, new sortItemsLivraison());

			return list;
		}


	@GetMapping(path = "/Livraisontest")
	public List<TestQA> Livraisontest(){


		List<TestQA> list=new ArrayList<>();
		list=testQARepository.findAll();
		Collections.sort(list, new sortItemsTest());

		return list;


		}
	@GetMapping(path = "/LivraisonH")
	public List<com.example.demo.Entity.Historique> LivraisonH(){



		List<com.example.demo.Entity.Historique> list=new ArrayList<>();
		list=historique.findAll();
		Collections.sort(list, new sortItemsHistorique());

		return list;
	}

	@GetMapping(path = "/Livraisonscript")
	public List<Scripts> Livraisonscript(){

		List<Scripts> list=new ArrayList<>();
		list=scriptsRepository.findAll();
		Collections.sort(list, new sortItemsScript());

		return list;
	}

	@GetMapping(path = "/LivraisonByBloc")
	public List<Livraison> LivraisonByBloc(){
		List<Livraison> List=new ArrayList<>();

			for (Livraison x : livraisonService.listLivraison())
			{					//System.out.println(x.getBloc());

				if(x.getBloc().equals("B"))
				{
					List.add(x);
					System.out.println(x.getBloc());
				}
			}


			return List;
		}
	@PostMapping("/addLivraisonfini")
	public Scripts savefini(@RequestBody Scripts scripts){
		System.out.println(scripts.getEtat());
		Scripts script=new Scripts(scripts.getVersion(),scripts.getDate_livraison(),scripts.getEtat(),"",false,new Date());
			return scriptsRepository.save(script);

	}

	@PutMapping("/updateLivraisonfini/{id}")
	public Scripts updatefini(@RequestBody String etat, @PathVariable("id") Long id){


		Scripts liv = scriptsRepository.findById(id).orElse(null);
        TestQA test=new TestQA(liv.getVersion(),liv.getDate_livraison(),liv.getEtat(),liv.getBloc(),liv.getTested(),new Date());
		liv.setEtat(etat);
		scriptsRepository.save(liv);
		testQARepository.save(test);
		return  liv;
	}

		@PostMapping("/addLivraisonTest")
	public TestQA saveTes(@RequestBody TestQA testQA){
		System.out.println(testQA.getEtat());
		return testQARepository.save(testQA);

	}

	@PutMapping("/updateTest/{id}")
	public TestQA updateTest(@RequestBody String etat,@PathVariable("id") Long id){

		System.out.println(id);
		System.out.println(etat);
		TestQA liv = testQARepository.findById(id).orElse(null);
		Livraison test=new Livraison(liv.getVersion(),liv.getDate_livraison(),liv.getEtat(),liv.getBloc(),liv.getTested(),liv.getGenerated());


		liv.setEtat(etat);
		liv.setBloc("C");

		testQARepository.save(liv);
		livraisonRepo.save(test);
		return  liv;
	}





	@PostMapping("/addLivraison")
	public Livraison saveScripts(@RequestBody Livraison livraison){
		System.out.println(livraison.getEtat());
		return livraisonRepo.save(livraison);

	}
	   
	    @PutMapping("/updateLivraison/{id}")
	    public Livraison updateScripts(@RequestBody String etat,@PathVariable("id") Long id){

			System.out.println(id);
			System.out.println(etat);
			Livraison liv = livraisonRepo.findById(id).orElse(null);


 			liv.setEtat(etat);
			 liv.setBloc("D");

			com.example.demo.Entity.Historique test=new com.example.demo.Entity.Historique(liv.getVersion(),liv.getDate_livraison(),liv.getEtat(),liv.getBloc(),liv.getTested(),liv.getGenerated());

			historique.save(test);
			livraisonRepo.save(liv);

			return  liv;
	    }

	    @DeleteMapping("/deleteLivraison/{id}")
	    public String deleteLivraison(@PathVariable Long id){
	        return livraisonService.deleteLivraison(id);
	    }

}
