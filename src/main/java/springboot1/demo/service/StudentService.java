package springboot1.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springboot1.demo.dao.StudentDao;
import springboot1.demo.entity.Student;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier ("MySql")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudentbyId(int id){
        return this.studentDao.getStudentbyId(id);
    }

    public void deleteStudentbyId(int id) {
        this.studentDao.deleteStudentbyId(id);
    }

    public void updateStudent(Student student) {
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }
}
