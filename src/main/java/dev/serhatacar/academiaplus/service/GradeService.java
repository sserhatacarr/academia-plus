package dev.serhatacar.academiaplus.service;

import dev.serhatacar.academiaplus.dto.GradeRequest;
import dev.serhatacar.academiaplus.dto.GradeResponse;
import dev.serhatacar.academiaplus.entity.Grade;
import dev.serhatacar.academiaplus.mapper.GradeMapper;
import dev.serhatacar.academiaplus.repository.GradeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class GradeService {
private final GradeRepository gradeRepository;


    public GradeResponse saveGrade(GradeRequest gradeRequest) {
        Grade grade = GradeMapper.toGrade(gradeRequest);
        return GradeMapper.toGradeResponse(gradeRepository.save(grade));
    }

    public GradeResponse getGradeById(Long id) {
        return gradeRepository.findById(id)
                .map(GradeMapper::toGradeResponse)
                .orElseThrow(() -> new EntityNotFoundException("Grade not found with id: " + id));
    }

    public List<GradeResponse> getAllGrades() {
        return gradeRepository.findAll()
                .stream()
                .map(GradeMapper::toGradeResponse)
                .collect(Collectors.toList());
    }

    public GradeResponse updateGrade(Long id, GradeRequest gradeRequest) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade not found with id: " + id));
        grade.setValue(gradeRequest.value());
        return GradeMapper.toGradeResponse(gradeRepository.save(grade));
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
