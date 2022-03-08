package org.example;

import java.util.List;

public interface CourseRepository {
    List<CourseDto> findByTeacher(Long id);

    int getElementCount(Long teacher_id);
}
