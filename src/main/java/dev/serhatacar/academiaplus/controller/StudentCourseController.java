package dev.serhatacar.academiaplus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.entity.Student;
import dev.serhatacar.academiaplus.repository.CourseRepository;
import dev.serhatacar.academiaplus.repository.StudentRepository;

@RestController

public class StudentCourseController {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentCourseController(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentRepo.findById(studentId).get();
        Course course = courseRepo.findById(courseId).get();
        student.getCourses().add(course);
        return studentRepo.save(student);
    }

    @PostMapping("/courses/{courseId}/students/{studentId}")
    public Course addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = courseRepo.findById(courseId).get();
        Student student = studentRepo.findById(studentId).get();
        course.getStudents().add(student);
        return courseRepo.save(course);
    }

    @PostMapping
    public Student saveStudentWithCourses(@RequestBody Student student) {
        return studentRepo.save(student);
    }

}