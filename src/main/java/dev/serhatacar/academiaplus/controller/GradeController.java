package dev.serhatacar.academiaplus.controller;

import dev.serhatacar.academiaplus.dto.GradeRequest;
import dev.serhatacar.academiaplus.dto.GradeResponse;
import dev.serhatacar.academiaplus.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serhat Acar
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/grades")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    public GradeResponse saveGrade(GradeRequest gradeRequest) {
        return gradeService.saveGrade(gradeRequest);
    }

    @GetMapping("/{id}")
    public GradeResponse getGradeById(Long id) {
        return gradeService.getGradeById(id);
    }

    @GetMapping
    public List<GradeResponse> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @PutMapping("/{id}")
    public GradeResponse updateGrade(Long id, GradeRequest gradeRequest) {
        return gradeService.updateGrade(id, gradeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(Long id) {
        gradeService.deleteGrade(id);
    }

}