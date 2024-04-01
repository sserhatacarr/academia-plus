package dev.serhatacar.academiaplus.controller;

import dev.serhatacar.academiaplus.dto.TeacherRequest;
import dev.serhatacar.academiaplus.dto.TeacherResponse;
import dev.serhatacar.academiaplus.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    public TeacherResponse getTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.saveTeacher(teacherRequest);
    }

    @PutMapping("/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacherById(id, teacherRequest);
    }

    @DeleteMapping("/{id}")

    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }
}
