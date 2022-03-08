package org.example;

import java.util.List;

public interface TeacherController {
    List<StudentDto> getAllCourseWithStudents(Long courseId);
}
