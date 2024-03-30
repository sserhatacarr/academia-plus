package dev.serhatacar.academiaplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.serhatacar.academiaplus.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
