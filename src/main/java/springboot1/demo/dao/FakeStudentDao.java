package springboot1.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import springboot1.demo.entity.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier ("FakeDao")
public class FakeStudentDao implements StudentDao {
    @Autowired


    private static Map<Integer, Student> students;

    static {
      students=new HashMap<Integer, Student>(){
          {
              put(1,new Student(1,"tudor","mate"));
              put(2,new Student(2,"matei","computer science"));
          }
      };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentbyId(int id){
        return this.students.get(id);
    }

    @Override
    public void deleteStudentbyId(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student studentToUpdate = students.get(student.getId());

        studentToUpdate.setName(student.getName());
        studentToUpdate.setCourse(student.getCourse());
        students.put(student.getId(),studentToUpdate);
    }

    @Override
    public void insertStudent(Student student) {

        students.put(student.getId(),student);
    }
}
