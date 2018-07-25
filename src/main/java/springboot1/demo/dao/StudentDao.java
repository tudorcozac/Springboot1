package springboot1.demo.dao;

import springboot1.demo.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentbyId(int id);

    void deleteStudentbyId(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
