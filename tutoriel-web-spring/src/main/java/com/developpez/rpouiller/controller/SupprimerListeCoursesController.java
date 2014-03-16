package com.developpez.rpouiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.developpez.rpouiller.bean.Course;
import com.developpez.rpouiller.services.IServiceListeCourses;

@Controller
public class SupprimerListeCoursesController {

	@Autowired
	private IServiceListeCourses service;
	
	@RequestMapping(value="/afficherSuppressionListeCourses", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Course> lListeCourses = service.rechercherCourses();
		pModel.addAttribute("listeCourses", lListeCourses);
		return "suppression";
	}
	
	@RequestMapping(value="/supprimerSuppressionListeCourses", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value="idCourse") final Integer pIdCourse, final ModelMap pModel) {

		service.supprimerCourse(pIdCourse);;
		return afficher(pModel);
	}
}