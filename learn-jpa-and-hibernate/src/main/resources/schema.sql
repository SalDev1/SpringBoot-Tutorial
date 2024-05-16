
-- id , name , author
-- always defining a primary key.


CREATE TABLE COURSE
(
  id bigint not null,
  name varchar(255) not null,
  author varchar(255),
  primary key (id)
);

-- Insert some data into the course.
-- We are inserting values into the table using Spring JDBC.
--INSERT INTO COURSE(id,name,author)
--VALUES(1,'Piyush','AWS Course')