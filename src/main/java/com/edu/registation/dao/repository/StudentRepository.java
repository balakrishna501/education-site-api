package com.edu.registation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.registation.model.Student;
/**
 * @author Bala
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
