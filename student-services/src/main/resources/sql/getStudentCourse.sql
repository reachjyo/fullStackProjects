select rc.student_id,rc.course_id ,crs.course_name, rc.start_date,rc.end_date, rc.grade,rc.status  from registered_courses rc
Join student std on rc.student_id = std.student_id
Join courses crs on rc.course_id = crs.course_id
Where rc.student_id = :studentId; And rc.course_id=:courseId