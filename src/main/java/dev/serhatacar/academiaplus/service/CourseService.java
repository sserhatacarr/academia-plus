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
}
