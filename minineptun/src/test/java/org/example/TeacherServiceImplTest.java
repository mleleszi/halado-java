package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class TeacherServiceImplTest {


    @Test
    public void getMyStudents() {

        // given
        Long teacherId = 234L;
        List<CourseDto> findByTeacherResult = new ArrayList<>(
                Arrays.asList(
                        new CourseDto(1L, "demo course", new ArrayList<>())
                )
        );

        List<StudentDto> finrByCourseIdResult = new ArrayList<>(
                Arrays.asList(
                        new StudentDto(1L, "sanyi", "asd123"),
                        new StudentDto(2L, "peti", "asdad12"),
                        new StudentDto(3L, "adam", "212sad")
                )
        );


        StudentRepository studentRepository = mock(StudentRepository.class);
        CourseRepository courseRepository = mock(CourseRepository.class);
        TeacherServiceImpl teacherService  = new TeacherServiceImpl(studentRepository, courseRepository, teacherId);

        when(courseRepository.findByTeacher(teacherId)).thenReturn(findByTeacherResult);
        when(studentRepository.findByCourseId(anyList())).thenReturn(finrByCourseIdResult);

        // when
        List<StudentDto> myStudents = teacherService.getMyStudents();

        // then
        assertTrue(myStudents.size() == 3);
        verify(courseRepository, times(1)).findByTeacher(eq(teacherId));
        verify(studentRepository, times(1)).findByCourseId(anyList());
    }

    @Test
    public void shouldBeTired() {
        // given
        Long teacherId = 234L;
        StudentRepository studentRepository = mock(StudentRepository.class);
        CourseRepository courseRepository = mock(CourseRepository.class);

        TeacherServiceImpl teacherService  = new TeacherServiceImpl(studentRepository, courseRepository, teacherId);

        when(courseRepository.getElementCount(teacherId)).thenReturn(125);

        // when then
        assertTrue(teacherService.shouldBeTired());
    }

    @Test
    public void shouldBeTired_No() {
        // given
        Long teacherId = 234L;
        StudentRepository studentRepository = mock(StudentRepository.class);
        CourseRepository courseRepository = mock(CourseRepository.class);

        TeacherServiceImpl teacherService  = new TeacherServiceImpl(studentRepository, courseRepository, teacherId);

        when(courseRepository.getElementCount(teacherId)).thenReturn(1);

        // when then
        assertFalse(teacherService.shouldBeTired());
    }
}