CREATE TABLE courses (
	course_name varchar(50) ,
	course_id varchar(8) primary key,
	description varchar(200),
	start_date date,
	end_date date,
	last_modified_date TIMESTAMP default current_timestamp
);

create table student (
    student_id varchar(16) primary key,
    first_name varchar(50),
    last_name varchar(50),
    email_id varchar(100),
    address varchar(100),
    date_of_birth date,
    last_modified_date TIMESTAMP default current_timestamp
);

create table registered_courses (
  id serial primary key,
  student_id varchar(16),
  course_id varchar(8),
  start_date date,
  end_date date,
  grade varchar(1),
  status varchar(8), -- Status being ENROLLED, COMPLETED, WITHDRAWN
  notes varchar(200),
  last_modified_date timestamp default current_timestamp
);
