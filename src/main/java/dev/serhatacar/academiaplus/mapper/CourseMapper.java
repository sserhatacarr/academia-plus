package dev.serhatacar.academiaplus.mapper;

import dev.serhatacar.academiaplus.dto.CourseRequest;
import dev.serhatacar.academiaplus.dto.CourseResponse;
import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.entity.Student;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */

public class CourseMapper {

    public static CourseResponse toCourseResponse(Course course) {

        Set<Long> studentIds = course.getStudents() != null ? course.getStudents().stream()
                .map(Student::getId)
                .collect(Collectors.toSet()) : null;

        return new CourseResponse(
                course.getId(),
                course.getCourseName(),
                course.getDescription(),
                course.getTeacher().getId(),
                studentIds
        );
    }

    public static Course toCourse(CourseRequest courseRequest) {
        return new Course(
                null,
                courseRequest.courseName(),
                courseRequest.description(),
               null,
                null
        );
    }
}
