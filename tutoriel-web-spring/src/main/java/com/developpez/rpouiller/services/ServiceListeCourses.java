package com.developpez.rpouiller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developpez.rpouiller.bean.Course;
import com.developpez.rpouiller.dao.IListeCoursesDAO;

@Service
public class ServiceListeCourses implements IServiceListeCourses {

	@Autowired
	private IListeCoursesDAO dao;
	
	@Transactional(readOnly=true)
	public List<Course> rechercherCourses() {
		return dao.rechercherCourses();
	}
	
	@Transactional
	public void creerCourse(final String pLibelle, final Integer pQuantite) {
		final Course lCourse = new Course();
		lCourse.setLibelle(pLibelle);
		lCourse.setQuantite(pQuantite);

		dao.creerCourse(lCourse);
	}
	
	@Transactional
	public void supprimerCourse(final Integer pIdCourse) {
		final Course lCourse = new Course();
		lCourse.setId(pIdCourse);

		dao.supprimerCourse(lCourse);
	}

	@Transactional
	public void modifierCourses(final List<Course> pListeCourses) {
		for (final Course lCourse : pListeCourses) {
			dao.modifierCourse(lCourse);
		}
	}
}