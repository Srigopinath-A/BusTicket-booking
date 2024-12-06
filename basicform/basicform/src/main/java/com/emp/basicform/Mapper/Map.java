package com.emp.basicform.Mapper;

import com.emp.basicform.Details.details;

import com.emp.basicform.GetSet.detailsGetSet;

public class Map {
	
	public static detailsGetSet mapToDetailsGetSet(details details) {
		return new detailsGetSet(
				details.getId(),
				details.getSeat(),
				details.getPname(),
				details.getBname()
				
				);
	}
	
	public static details mapToDetails(detailsGetSet detailsGetSet) {
		return new details(
				detailsGetSet.getId(),
				detailsGetSet.getSeat(),
				detailsGetSet.getPname(),
				detailsGetSet.getBname()
				);			
	}
}
