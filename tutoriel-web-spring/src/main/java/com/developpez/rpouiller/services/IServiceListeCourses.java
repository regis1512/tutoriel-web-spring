package com.developpez.rpouiller.services;

import java.util.List;

import com.developpez.rpouiller.bean.Course;

public interface IServiceListeCourses {
	List<Course> rechercherCourses();
	void creerCourse(final String pLibelle, final Integer pQuantite);
	void supprimerCourse(final Integer pIdCourse);
	void modifierCourses(final List<Course> pListeCourses);
}