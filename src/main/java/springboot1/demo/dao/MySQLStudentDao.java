package springboot1.demo.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import springboot1.demo.entity.Student;

import java.util.Collection;

@Repository
@Qualifier("MySql")
public class MySQLStudentDao implements StudentDao {
    @Override
    public Collection<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentbyId(int id) {
        return null;
    }

    @Override
    public void deleteStudentbyId(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
