package dev.serhatacar.academiaplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.serhatacar.academiaplus.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
