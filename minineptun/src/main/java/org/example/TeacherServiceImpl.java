package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherServiceImpl implements TeacherService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public final int TIRED_COURSE_LIMIT = 10;
    public final int TIRED_STUDENT_LIMIT = 10;

    private final Long teacher_id;

    public TeacherServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, Long teacher_id) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacher_id = teacher_id;
    }

    @Override
    public List<StudentDto> getMyStudents() {
        List<CourseDto> courseListByTeacher = courseRepository.findByTeacher(teacher_id);
        return studentRepository.findByCourseId(
                courseListByTeacher.stream()
                        .map(CourseDto::getId)
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean shouldBeTired() {
        return courseRepository.getElementCount(teacher_id) > TIRED_COURSE_LIMIT || getMyStudents().size() > TIRED_STUDENT_LIMIT;
    }
}
