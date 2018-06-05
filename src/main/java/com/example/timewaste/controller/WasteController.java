package com.example.timewaste.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.timewaste.model.Waste;
import com.example.timewaste.service.WasteService;

@Controller
@RequestMapping("/waste")
public class WasteController {

	@Autowired
	private WasteService wasteService;
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public ModelAndView registration(Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("wasteList",wasteService.findAll() );
		modelAndView.setViewName("WasteList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView payrollGet( @ModelAttribute("waste") Waste waste,Model model) {
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("waste", new Waste());
		modelAndView.setViewName("WasteForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView payrollAdd(@Valid  @ModelAttribute("waste") Waste waste, BindingResult bindingResult) {
			ModelAndView modelAndView = new ModelAndView();
			if(waste.getId()!=0){
				modelAndView.addObject("Message", "holiday has been Updated successfully");
			}
			wasteService.saveWaste(waste);
			modelAndView.setViewName("redirect:/waste/get");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView payrollUpdate(@PathVariable("id") int id,Model model) {
			ModelAndView modelAndView = new ModelAndView("WasteForm");
			Waste waste=wasteService.findById(id);
			modelAndView.addObject("waste",waste);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		Waste waste =wasteService.findById(id);
		if(waste ==null){
			modelAndView.addObject("Message", "waste not found");
		}
		wasteService.deleteById(id);
	  return new ModelAndView("redirect:/waste/get");
	 }
}
