package dev.serhatacar.academiaplus.mapper;

import dev.serhatacar.academiaplus.dto.TeacherRequest;
import dev.serhatacar.academiaplus.dto.TeacherResponse;
import dev.serhatacar.academiaplus.entity.Teacher;

/**
 * @author Serhat Acar
 */

public class TeacherMapper {
    public static TeacherResponse toTeacherResponse(Teacher teacher) {
        return new TeacherResponse(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName());
    }

    public static Teacher toTeacher(TeacherRequest teacherRequest) {
        return new Teacher(
                null,
                teacherRequest.firstName(),
                teacherRequest.lastName());
    }
}
