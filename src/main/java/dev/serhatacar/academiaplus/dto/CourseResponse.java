package dev.serhatacar.academiaplus.dto;

import java.util.Set;

/**
 * @author Serhat Acar
 */

public record CourseResponse(
        Long id,
        String courseName,
        String description,
        Long teacherId,
        Set<Long> studentIds
) {
}