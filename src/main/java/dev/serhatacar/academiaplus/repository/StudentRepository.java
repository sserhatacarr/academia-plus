package dev.serhatacar.academiaplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.serhatacar.academiaplus.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
