package dev.serhatacar.academiaplus.dto;


/**
 * @author Serhat Acar
 */

public record CourseRequest(
        String courseName,
        String description,
        Long teacherId
) {
}
