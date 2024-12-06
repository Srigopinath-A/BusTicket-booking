package com.emp.basicform.Controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.basicform.GetSet.detailsGetSet;
import com.emp.basicform.Service.DService;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/booking")
@CrossOrigin("*")
public class DController {
	
	private  DService Ser;
	
	@Autowired
	public DController(DService Ser) {
		this.Ser=Ser;
	}
	
	@PostMapping
	public ResponseEntity<detailsGetSet> EnterDetails(@RequestBody detailsGetSet detailsGetSete){
		
		detailsGetSet savedetails = Ser.EnterDetails(detailsGetSete);
		return new ResponseEntity<>(savedetails, HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<detailsGetSet> FetchDetails(@PathVariable("id") int id){
		detailsGetSet fetch= Ser.FetchDetail(id);
		return new ResponseEntity<>(fetch,HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity< List<detailsGetSet> > Fetchall(){
		List<detailsGetSet> fetchall = Ser.Fetchall();
		return new ResponseEntity<>(fetchall,HttpStatus.OK);
	}

	@PutMapping("{id}") // put method is must 
	public ResponseEntity<detailsGetSet> UpdateById(@PathVariable("id") int id, @RequestBody detailsGetSet updateDetails) {
	    detailsGetSet updatedDetail = Ser.UpdateById(id, updateDetails); 
	    return new ResponseEntity<>(updatedDetail, HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteById(@PathVariable int id){
		Ser.DeleteById(id);
		return new ResponseEntity<>("Details has been deleted ",HttpStatus.NO_CONTENT);
		
	}
	
}
