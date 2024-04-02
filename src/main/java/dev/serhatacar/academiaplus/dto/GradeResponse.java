package dev.serhatacar.academiaplus.dto;

/**
 * @author Serhat Acar
 */

public record GradeResponse(
        Long id,
        Double value,
        Long courseId,
        Long studentId
) {
}
