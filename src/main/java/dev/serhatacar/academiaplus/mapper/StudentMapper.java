package dev.serhatacar.academiaplus.mapper;

import dev.serhatacar.academiaplus.dto.StudentRequest;
import dev.serhatacar.academiaplus.dto.StudentResponse;
import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.entity.Student;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */

public class StudentMapper {

    public static StudentResponse toStudentResponse(Student student) {
        if (student.getCourses()!=null) {
            Set<Long> courseIds = student.getCourses().stream()
                    .map(Course::getId)
                    .collect(Collectors.toSet());

            return new StudentResponse(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getStudentNumber(),
                    student.getClassInfo(),
                    courseIds
            );
        }

        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getStudentNumber(),
                student.getClassInfo(),
                null
        );
    }

    public static Student toStudent(StudentRequest studentRequest) {
        return new Student(
                null,
                studentRequest.firstName(),
                studentRequest.lastName(),
                studentRequest.studentNumber(),
                studentRequest.classInfo(),
                null
        );
    }

}
