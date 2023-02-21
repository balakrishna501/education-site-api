package com.edu.registation.service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.edu.registation.dao.repository.CourseRepository;
import com.edu.registation.exception.EducationIllegalStateException;
import com.edu.registation.model.Course;
import com.edu.registation.model.Student;
import com.edu.registation.service.CourseService;
/**
 * @author Bala
 *
 */
public class CourseServiceTest {

	@Mock
	private CourseRepository courseRepositoryMock;

	@InjectMocks
	private CourseService courseService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddCourse() {
		Course course = new Course();
		course.setCourseId(2l);
		Mockito.when(courseRepositoryMock.save(Mockito.any(Course.class))).thenReturn(course);
		Long courseId = courseService.addCourse(course);
		Assert.assertEquals(2, courseId.longValue());
	}

	@Test
	public void testRemoveCourse() {
		Long courseId = 1l;
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName("Spring");
		Mockito.when(courseRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(course));
		courseService.removeCourse(courseId);
	}
	
	@Test(expected=EducationIllegalStateException.class)
	public void testRemoveCourseWithEmptyCourse() {
		Long courseId = 1l;
		Mockito.when(courseRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		courseService.removeCourse(courseId);
	}

	@Test
	public void testRegisterStudentToCourse() {
		Long courseId = 1l;
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName("Spring");
		course.setStudents(Collections.emptySet());
		Mockito.when(courseRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(course));
		Set<Student> students = Collections.emptySet();
		courseService.registerStudentToCourse(courseId, students);

	}
	
	@Test(expected=EducationIllegalStateException.class)
	public void testRegisterStudentToCoursEmptyCourse() {
		Long courseId = 1l;
		Mockito.when(courseRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		Set<Student> students = Collections.emptySet();
		courseService.registerStudentToCourse(courseId, students);

	}

	@Test
	public void testGetCourseByCourseName() {
		String courseName = "DevOps";
		courseService.getCourseByCourseName(courseName);
	}

}
