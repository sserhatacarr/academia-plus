package dev.serhatacar.academiaplus.service;

import dev.serhatacar.academiaplus.dto.GradeRequest;
import dev.serhatacar.academiaplus.dto.GradeResponse;
import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.entity.Grade;
import dev.serhatacar.academiaplus.entity.Student;
import dev.serhatacar.academiaplus.mapper.GradeMapper;
import dev.serhatacar.academiaplus.repository.CourseRepository;
import dev.serhatacar.academiaplus.repository.GradeRepository;
import dev.serhatacar.academiaplus.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public List<GradeResponse> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(GradeMapper::toGradeResponse)
                .toList();
    }

    public GradeResponse getGradeById(Long id) {
        return gradeRepository.findById(id)
                .map(GradeMapper::toGradeResponse)
                .orElseThrow(() -> new RuntimeException("Grade not found."));
    }

    public GradeResponse saveGrade(GradeRequest gradeRequest) {
        Course course = courseRepository.findById(gradeRequest.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Student student = studentRepository.findById(gradeRequest.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Grade grade = GradeMapper.toGrade(gradeRequest);
        grade.setCourse(course);
        grade.setStudent(student);
        Grade savedGrade = gradeRepository.save(grade);
        return GradeMapper.toGradeResponse(savedGrade);
    }

    public GradeResponse updateGradeById(Long id, GradeRequest gradeRequest) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found."));
        grade.setValue(gradeRequest.value());
        return GradeMapper.toGradeResponse(gradeRepository.save(grade));
    }

    public void deleteGradeById(Long id) {
        gradeRepository.deleteById(id);
    }
}
