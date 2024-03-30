package dev.serhatacar.academiaplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.serhatacar.academiaplus.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
