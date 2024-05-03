package com.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.CountryStateDao;
import com.app.entity.City;
import com.app.entity.Country;
import com.app.entity.State;


@Controller
public class DropdownController {
	@RequestMapping("/")
	public String home() {
		System.out.println("This is home URL");
		return "index";
	}
	
	
	@RequestMapping("/getCountries")
    public String getCountry(@RequestParam("id") int id,@RequestParam("name") String name) 
	{
	
		try{
			CountryStateDao cdao= new CountryStateDao(null);
			Country c=new Country();
			List<Country> listCountry = cdao.getCountry();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
    }
	
	@RequestMapping("/getStates")
    public String getStates(@RequestParam("countryId") int countryId) 
	{
	
		try{
			CountryStateDao cdao= new CountryStateDao(null);
			Country c=new Country();
			List<State> listStates = cdao.getState(countryId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
    }
	
	@RequestMapping("/getCities")
    public String getCity(@RequestParam("stateId") int stateId) 
	{
	
		try{
			CountryStateDao cdao= new CountryStateDao(null);
			Country c=new Country();
			List<City> listCity = cdao.getCity(stateId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
    }
	
	

}
