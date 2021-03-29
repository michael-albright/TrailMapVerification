package com.tts.trailMapVerification;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer
{	
	@Autowired
	private HikeDetailsRepository hikeDetailsRepository;

	@GetMapping("/")
	public String showForm(HikeDetailsForm hikeDetailsForm) {
		return "hikerForm";
	}

	@PostMapping("/")
	public String addNewHiker(HikeDetailsForm hiker, Model model)
	{
		hikeDetailsRepository.save(new HikeDetailsForm(hiker.getName(),
														hiker.getAmountOfPeople(),
														hiker.getNightsOnTrail(), 
														hiker.getStartedTrailAt()));
												
		model.addAttribute("Name", hiker.getName());
		model.addAttribute("Amount-Of-People", hiker.getAmountOfPeople());
		model.addAttribute("Nights-On-Trail", hiker.getNightsOnTrail());
		model.addAttribute("Started-Trail-At", hiker.getStartedTrailAt());
		
		return "trailMap";
	}
	
//	public String checkPersonInfo(@Valid HikeDetailsForm hikeDetailsForm, BindingResult bindingResult) {
//		
//		if (bindingResult.hasErrors()) {
//			return "hikerForm";
//		}
//
//		return "trailMap";
//	}
//	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/trailMap").setViewName("trailMap");
//	}

}
