package com.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tg.entity.TravelList;
import com.tg.service.TravelListService;

@RestController
public class TravelListController {
	@Autowired
	private TravelListService travelListService;
	
	@RequestMapping("/travel")
	public List<TravelList> all_lists() {
		return travelListService.getAllTravelLists();
	}
	
	@RequestMapping("/travel/{id}")
	public TravelList getSingleTravel(@PathVariable("id") String id) {
		return travelListService.getSingleTravel(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addTravel")
	public String addTravel(@RequestBody TravelList travellist) {
		return travelListService.addTravel(travellist);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/travel/{id}")
	public String updateTravel(@RequestBody TravelList travellist, @PathVariable("id") String id) {
		return travelListService.updateTravel(travellist, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/travel/{id}")
	public String deleteTravel(@PathVariable("id") String id) {
		return travelListService.deleteTravel(id);
	}
	
}
