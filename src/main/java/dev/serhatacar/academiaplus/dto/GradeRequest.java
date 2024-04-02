package dev.serhatacar.academiaplus.dto;

/**
 * @author Serhat Acar
 */

public record GradeRequest(
        Double value,
        Long courseId,
        Long studentId
) {
}
