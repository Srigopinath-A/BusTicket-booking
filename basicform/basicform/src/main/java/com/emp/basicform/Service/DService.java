package com.emp.basicform.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.basicform.Details.details;
import com.emp.basicform.Exception.ResourceNotFound;
import com.emp.basicform.GetSet.detailsGetSet;
import com.emp.basicform.Mapper.Map;
import com.emp.basicform.Repo.Repo;



@org.springframework.stereotype.Service
public class DService {
	
	
	private Repo repo;
	
	@Autowired
	public DService(Repo repo) {
		this.repo = repo;
	}
	
	public detailsGetSet EnterDetails(detailsGetSet detailsGetSet){
		details details =  Map.mapToDetails(detailsGetSet);
		details EnterDetails = repo.save(details);
		return Map.mapToDetailsGetSet(EnterDetails);
		
	}
	
	// findbyid is a optional class so we need to have expection to been thrown 
	public detailsGetSet FetchDetail(int id) {
		details detail = repo.findById(id).orElseThrow(() -> new ResourceNotFound ("Its not found/exist" + id));
		return Map.mapToDetailsGetSet(detail);
	}
	
	public List<detailsGetSet> Fetchall(){
		List<details> Fetchall = repo.findAll();
		//instead of this
		//return List.of();
		// we going to use stream api to list the stream of data and map it to the map function using map.
		return Fetchall.stream().map(detail -> Map.mapToDetailsGetSet(detail)).collect(Collectors.toList()); // Use Collectors.toList()

	}
	
	public detailsGetSet UpdateById(int id, detailsGetSet UpdateById) {
		details detail = repo.findById(id).orElseThrow(() -> new ResourceNotFound("value is not found"+ id));
		
		detail.setSeat(UpdateById.getSeat());
		detail.setPname(UpdateById.getPname());
		detail.setBname(UpdateById.getBname());
	
		details update = repo.save(detail);
		return Map.mapToDetailsGetSet(update);
	}
	
	public void DeleteById(int id) { // in this deleteby id dont return anything so it is said to been an void method.
		details detail = repo.findById(id).orElseThrow(() -> new ResourceNotFound("value is not found" + id));
		repo.deleteById(id);
	}
}
