package springboot1.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import springboot1.demo.entity.Student;
import sun.rmi.rmic.iiop.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("MySql")
public class MySQLStudentDao implements StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }
    @Override
    public Collection<Student> getAllStudents() {

        List<Student> students = jdbcTemplate.query("select id,name,course from students", new StudentRowMapper() );
        return students;
    }

    @Override
    public Student getStudentbyId(int id) {

        Student student=jdbcTemplate.queryForObject("select id,name.course from students where id=?", new StudentRowMapper(), id);
        return student;
    }

    @Override
    public void deleteStudentbyId(int id) {
        jdbcTemplate.update("delete from students where id=?",id);
    }

    @Override
    public void updateStudent(Student student) {
        jdbcTemplate.update("update students set name =?, course=? where id=?",student.getName(),student.getCourse(),student.getId());

    }

    @Override
    public void insertStudent(Student student) {
        jdbcTemplate.update("insert into students values (?,?,?,)"
                ,student.getId(),student.getName(),student.getCourse()
                , Types.INTEGER,Types.VARCHAR,Types.VARCHAR);

    }


}
