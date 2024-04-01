package dev.serhatacar.academiaplus.service;

import dev.serhatacar.academiaplus.dto.StudentRequest;
import dev.serhatacar.academiaplus.dto.StudentResponse;
import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.entity.Student;
import dev.serhatacar.academiaplus.mapper.StudentMapper;
import dev.serhatacar.academiaplus.repository.CourseRepository;
import dev.serhatacar.academiaplus.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toStudentResponse)
                .toList();
    }

    public StudentResponse getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::toStudentResponse)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = StudentMapper.toStudent(studentRequest);
        return getStudentResponse(studentRequest, student, courseRepository, studentRepository);
    }

    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstName(studentRequest.firstName());
        student.setLastName(studentRequest.lastName());
        student.setStudentNumber(studentRequest.studentNumber());
        student.setClassInfo(studentRequest.classInfo());
        return getStudentResponse(studentRequest, student, courseRepository, studentRepository);
    }

    private StudentResponse getStudentResponse(StudentRequest studentRequest, Student student, CourseRepository courseRepository, StudentRepository studentRepository) {

        if(studentRequest.courseIds() != null){
            Set<Course> courses = studentRequest.courseIds().stream()
                .map(courseRepository::findById)
                .map(optionalCourse -> optionalCourse.orElseThrow(() -> new RuntimeException("Course not found")))
                .collect(Collectors.toSet());
            student.setCourses(courses);
        }
        Student studentWithCourse = studentRepository.save(student);
        return StudentMapper.toStudentResponse(studentWithCourse);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}


