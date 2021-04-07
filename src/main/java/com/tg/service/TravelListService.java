package com.tg.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.entity.TravelList;

@Service
public class TravelListService {
	private List<TravelList> travelList = new ArrayList<>(Arrays.asList(

            new TravelList("tp001", "Nandhi Hills", "A Majestic View above the Clouds"),
            new TravelList("tp002", "Brihadeeswarar Temple", "It is one of the largest South Indian temples and an exemplary example of a fully realized Tamil architecture."),
            new TravelList("tp003", "Kodaikanal", "Princess of Hill stations")

    ));
	
	public List<TravelList> getAllTravelLists() {
		return travelList;
	}
	
	public TravelList getSingleTravel(String id) {
		return travelList.stream().filter(travel -> travel.getId().equals(id)).findFirst().get();
	}
	
	public String addTravel(TravelList travellist) {
		travelList.add(travellist);
		return "Travel Added Successfully ! ";
	}
	
	public String updateTravel(TravelList travellist, String id) {
		int counter = 0;
		for(TravelList tl1 : travelList) {
			if(tl1.getId().equals(id)) {
				travelList.set(counter, travellist);
			}
			counter++;
		}
		return "Travel Updated Successfully ! " + id;
	}
	
	public String deleteTravel(String id) {
		travelList.removeIf(travellist -> travellist.getId().equals(id));
		return "Travel Deleted Successfully ! " + id;
	}
	
}
