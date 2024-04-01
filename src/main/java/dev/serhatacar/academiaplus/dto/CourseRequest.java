package dev.serhatacar.academiaplus.dto;

import java.util.Set;

/**
 * @author Serhat Acar
 */

public record CourseRequest(
        Long id,
        String courseName,
        String description,
        Set<Long> studentIds

) {
}
