package com.parimi.studentservices.mapper;


import com.parimi.studentservices.model.Course;
import com.parimi.studentservices.model.StudentRegisteredCourse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCourseMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new StudentRegisteredCourse(new Course(rs.getString("course_id"), rs.getString("course_name"),"",
                rs.getDate("start_date"), rs.getDate("end_date")),
                rs.getString("student_name"));
    }
}
