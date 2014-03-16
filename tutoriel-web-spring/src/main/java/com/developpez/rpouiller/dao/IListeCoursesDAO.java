package com.developpez.rpouiller.dao;

import java.util.List;

import com.developpez.rpouiller.bean.Course;

public interface IListeCoursesDAO {
	List<Course> rechercherCourses();
	void creerCourse(final Course pCourse);
	void supprimerCourse(final Course pCourse);
	void modifierCourse(final Course pCourse);
}