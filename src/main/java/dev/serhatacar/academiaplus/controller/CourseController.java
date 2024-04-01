package dev.serhatacar.academiaplus.controller;

import dev.serhatacar.academiaplus.dto.CourseRequest;
import dev.serhatacar.academiaplus.dto.CourseResponse;
import dev.serhatacar.academiaplus.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseResponse saveCourse (@RequestBody CourseRequest courseRequest) {
        return courseService.saveCourse(courseRequest);
    }
}
