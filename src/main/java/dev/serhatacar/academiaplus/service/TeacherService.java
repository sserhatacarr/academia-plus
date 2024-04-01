package dev.serhatacar.academiaplus.service;

import dev.serhatacar.academiaplus.dto.TeacherRequest;
import dev.serhatacar.academiaplus.dto.TeacherResponse;
import dev.serhatacar.academiaplus.entity.Teacher;
import dev.serhatacar.academiaplus.mapper.TeacherMapper;
import dev.serhatacar.academiaplus.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherResponse saveTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.save(TeacherMapper.toTeacher(teacherRequest));
        return TeacherMapper.toTeacherResponse(teacher);
    }

    public TeacherResponse getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::toTeacherResponse)
                .orElseThrow(() -> new RuntimeException("Teacher not found."));
    }

    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(TeacherMapper::toTeacherResponse)
                .collect(Collectors.toList());
    }

    public TeacherResponse updateTeacherById(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found."));
        teacher.setFirstName(teacherRequest.firstName());
        teacher.setLastName(teacherRequest.lastName());
        return TeacherMapper.toTeacherResponse(teacherRepository.save(teacher));
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}
