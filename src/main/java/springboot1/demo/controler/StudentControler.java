package springboot1.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboot1.demo.entity.Student;
import springboot1.demo.service.StudentService;

import java.util.Collection;
@RestController
@RequestMapping("/students")
public class StudentControler {
    @Autowired
    private StudentService studentService;



    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getStudentbyId(@PathVariable("id") int id){
        return studentService.getStudentbyId(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteStudentbyId(@PathVariable("id") int id){
        studentService.deleteStudentbyId(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE )
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}
