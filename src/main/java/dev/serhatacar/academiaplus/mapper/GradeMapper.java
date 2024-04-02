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
                grade.getCourse().getId(),
                grade.getStudent().getId()
        );
    }

    public static Grade toGrade(GradeRequest gradeRequest) {
        return new Grade(
                null,
                gradeRequest.value(),
                null,
                null
        );
    }
}
