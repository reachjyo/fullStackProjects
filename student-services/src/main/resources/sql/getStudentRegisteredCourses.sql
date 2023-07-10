select rc.course_id, crs.course_name,
concat(std.first_name, std.last_name) as student_name,
rc.start_date, rc.end_date
from registered_courses rc
Join student std on rc.student_id = std.student_id
Join courses crs on rc.course_id = crs.course_id
Where rc.student_id = :studentId;