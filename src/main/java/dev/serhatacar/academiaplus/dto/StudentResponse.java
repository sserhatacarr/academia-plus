package dev.serhatacar.academiaplus.dto;

import java.util.Set;

/**
 * @author Serhat Acar
 */

public record StudentResponse(
        Long id,
        String firstName,
        String lastName,
        String studentNumber,
        String classInfo,
        Set<Long> courseIds
) {
}