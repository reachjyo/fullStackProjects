package com.parimi.studentservices.repository;

import com.parimi.studentservices.mapper.StudentCourseMapper;
import com.parimi.studentservices.model.Course;
import com.parimi.studentservices.model.StudentRegisteredCourse;
import com.parimi.studentservices.util.QueryReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.sql.DataSource;

@Repository
public class DbRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentRegisteredCourse> getCourses(String studentId){
        String sql ="select rc.course_id, crs.course_name, \n" +
                    "concat(std.first_name, std.last_name) as student_name, \n" +
                    "rc.start_date, rc.end_date \n" +
                    "from registered_courses rc \n" +
                    "Join student std on rc.student_id = std.student_id  \n" +
                    "Join courses crs on rc.course_id = crs.course_id  \n" +
                    "Where rc.student_id = :studentId ";

        Map<String, Object> params = new HashMap<>();
        params.put("studentId", studentId);


        List<StudentRegisteredCourse> result = namedParameterJdbcTemplate.query(
                                                sql , //QueryReader.GET_STUDENT_REGISTERED_COURSES,
                                                params, new StudentCourseMapper());
        return result;
    }
}
