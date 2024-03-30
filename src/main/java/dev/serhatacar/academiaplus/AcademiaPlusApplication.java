package dev.serhatacar.academiaplus;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import dev.serhatacar.academiaplus.entity.Course;
import dev.serhatacar.academiaplus.entity.Grade;
import dev.serhatacar.academiaplus.entity.Student;
import dev.serhatacar.academiaplus.entity.Teacher;
import dev.serhatacar.academiaplus.repository.CourseRepository;
import dev.serhatacar.academiaplus.repository.GradeRepository;
import dev.serhatacar.academiaplus.repository.StudentRepository;
import dev.serhatacar.academiaplus.repository.TeacherRepository;

@SpringBootApplication
public class AcademiaPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaPlusApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(StudentRepository studentRepo, CourseRepository courseRepo,
			GradeRepository gradeRepo, TeacherRepository teacherRepo) {
		return args -> {
			Faker faker = new Faker();

			for (int i = 0; i < 10; i++) {
				Teacher teacher = new Teacher();
				teacher.setFirstName(faker.name().firstName());
				teacher.setLastName(faker.name().lastName());
				teacherRepo.save(teacher);
			}

			for (int i = 0; i < 10; i++) {
				Course course = new Course();
				course.setCourseName(faker.educator().course());
				course.setDescription(faker.lorem().sentence());
				course.setTeacher(teacherRepo.findById((long) faker.number().numberBetween(1, 10)).get());
				course.setStudents(new HashSet<>());
				courseRepo.save(course);
			}

			for (int i = 0; i < 10; i++) {
				Student student = new Student();
				student.setClassInfo(faker.educator().campus());
				student.setFirstName(faker.name().firstName());
				student.setLastName(faker.name().lastName());
				student.setStudentNumber(faker.numerify("##########"));
				student.setCourses(new HashSet<>());
				studentRepo.save(student);
			}

			for (int i = 0; i < 10; i++) {
				Grade grade = new Grade();
				grade.setValue(faker.number().randomDouble(2, 0, 100));
				grade.setCourse(courseRepo.findById((long) faker.number().numberBetween(1, 10)).get());
				grade.setStudent(studentRepo.findById((long) faker.number().numberBetween(1, 10)).get());
				gradeRepo.save(grade);

			}

			// Set<Student> students = new HashSet<>();
			// Set<Course> courses = new HashSet<>();

			// for (int i = 0; i < 10; i++) {
			// students.add(studentRepo.findById((long) faker.number().numberBetween(1,
			// 10)).get());
			// courses.add(courseRepo.findById((long) faker.number().numberBetween(1,
			// 10)).get());
			// }

			// for (Student student : students) {
			// for (Course course : courses) {
			// student.getCourses().add(course);
			// studentRepo.save(student);
			// }
			// }

		};
	}

}
