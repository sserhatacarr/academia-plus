package dev.serhatacar.academiaplus.service;

import dev.serhatacar.academiaplus.dto.CourseRequest;
import dev.serhatacar.academiaplus.dto.CourseResponse;
import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.mapper.CourseMapper;
import dev.serhatacar.academiaplus.repository.CourseRepository;
import dev.serhatacar.academiaplus.repository.StudentRepository;
import dev.serhatacar.academiaplus.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public CourseResponse saveCourse(CourseRequest courseRequest) {
        Course course = CourseMapper.toCourse(courseRequest);
        course.setTeacher(teacherRepository.findById(courseRequest.teacherId()).orElseThrow());
        courseRepository.save(course);


        return CourseMapper.toCourseResponse(course);
    }

    public CourseResponse getCourseById(Long id) {
        return courseRepository.findById((id))
                .map(CourseMapper::toCourseResponse)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseMapper::toCourseResponse)
                .toList();
    }

    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setCourseName(courseRequest.courseName());
        course.setDescription(courseRequest.description());
        course.setTeacher(teacherRepository.findById(courseRequest.teacherId()).orElseThrow());
        courseRepository.save(course);
        return CourseMapper.toCourseResponse(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
