package com.edu.registation.controller;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edu.registation.controller.EducationController;
import com.edu.registation.model.Course;
import com.edu.registation.model.Student;
import com.edu.registation.service.CourseService;
import com.edu.registation.service.StudentService;
/**
 * @author Bala
 *
 */
public class EducationControllerTest {
	private final static Logger LOG = LoggerFactory.getLogger(EducationController.class);

	@Mock
	private StudentService studentServiceMock;
	@Mock
	private CourseService courseServiceMock;

	@InjectMocks
	private EducationController studentCourseRegistrationController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setStudentId(1l);
		studentCourseRegistrationController.addStudent(student);
	}

	@Test
	public void testRemoveStudent() {
		Long studentId = 1l;
		studentCourseRegistrationController.removeStudent(studentId);
	}

	@Test
	public void testAddCourse() {
		Course course = new Course();
		course.setCourseId(1l);
		LOG.info("Course  ::Course Name {}", course.getCourseName());
		studentCourseRegistrationController.addCourse(course);
	}

	@Test
	public void testRemoveCourse() {
		Long courseId = 1l;
		studentCourseRegistrationController.removeCourse(courseId);
	}

	@Test
	public void testEnrollStudentToCourse() {
		Long courseId = 1l;
		Set<Student> students = Collections.emptySet();
		studentCourseRegistrationController.enrollStudentToCourse(courseId, students);
	}

	@Test
	public void testGetStudentsByCourseName() {
		String courseName = "DevOps";
		studentCourseRegistrationController.getStudentsByCourseName(courseName);
	}

}
