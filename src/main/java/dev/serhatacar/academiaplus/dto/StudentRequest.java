package dev.serhatacar.academiaplus.dto;

import java.util.Set;

/**
 * @author Serhat Acar
 */

public record StudentRequest(
        String firstName,
        String lastName,
        String studentNumber,
        String classInfo,
        Set<Long> courseIds
) {
}