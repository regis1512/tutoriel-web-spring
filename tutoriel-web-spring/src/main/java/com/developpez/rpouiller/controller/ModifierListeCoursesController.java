package com.developpez.rpouiller.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developpez.rpouiller.bean.Course;
import com.developpez.rpouiller.services.IServiceListeCourses;

@Controller
public class ModifierListeCoursesController {

	@Autowired
	private IServiceListeCourses service;
	
	@RequestMapping(value="/afficherModificationListeCourses", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		if (pModel.get("modification") == null) {
			final List<Course> lListeCourses = service.rechercherCourses();
			final ModificationForm lModificationForm = new ModificationForm();
			final List<ModificationCourse> lListe = new LinkedList<ModificationCourse>();
			for (final Course lCourse : lListeCourses) {
				final ModificationCourse lModificationCourse = new ModificationCourse();
				lModificationCourse.setId(lCourse.getId());
				lModificationCourse.setLibelle(lCourse.getLibelle());
				lModificationCourse.setQuantite(lCourse.getQuantite().toString());
				lListe.add(lModificationCourse);
			}
			lModificationForm.setListeCourses(lListe);
			pModel.addAttribute("modification", lModificationForm);
		}
		return "modification";
	}
	
	@RequestMapping(value="/modifierModificationListeCourses", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value="modification") final ModificationForm pModification, 
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {
			final List<Course> lListeCourses = new LinkedList<Course>();
			for (final ModificationCourse lModificationCourse : pModification.getListeCourses()) {
				final Course lCourse = new Course();
				lCourse.setId(lModificationCourse.getId());
				final Integer lQuantite = Integer.valueOf(lModificationCourse.getQuantite());
				lCourse.setQuantite(lQuantite);
				lListeCourses.add(lCourse);
			}
			service.modifierCourses(lListeCourses);
		}
		
		return afficher(pModel);
	}
}