package dev.serhatacar.academiaplus.mapper;

import dev.serhatacar.academiaplus.dto.GradeRequest;
import dev.serhatacar.academiaplus.dto.GradeResponse;
import dev.serhatacar.academiaplus.entity.Grade;

/**
 * @author Serhat Acar
 */

public class GradeMapper {

    public static GradeResponse toGradeResponse(Grade grade) {
        return new GradeResponse(
                grade.getId(),
                grade.getValue(),
                grade.getCourse().getId(), // get the id of the course
                grade.getStudent().getId() // get the id of the student
        );
    }

    public static Grade toGrade(GradeRequest gradeRequest) {
        Grade grade = new Grade();
        grade.setValue(gradeRequest.value());
        // Course and Student should be set in the service layer
        return grade;
    }

}
