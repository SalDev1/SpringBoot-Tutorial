package com.sal.springboot.learnjpaandhibernate.jdbc;

import com.sal.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public class CourseJDBCRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
               insert into course(id,name,author)
               values(?,?,?)
            """;

//    public void insert() {
//
//        // update --> allows us to perform single SQL update operation
//        // such as insert, delete and update operation.
//        springJdbcTemplate.update(INSERT_QUERY);
//    }
      public void insert(Course course) {
          springJdbcTemplate.update(INSERT_QUERY,
                  course.getId(),course.getName(),course.getAuthor());
      }

      // Query for deleting a course from the course table using the id.
     private static String DELETE_QUERY =
              """
                 delete from course where course.id = ?
              """;
      public void delete(long id) {
          springJdbcTemplate.update(DELETE_QUERY,id);
      }

      // Selecting a unique course from the course table using the course id.
    private static String SELECT_QUERY =
            """
               select * from course 
               where id = ?
            """;
    public Course findById(long id) {
        // ResultSet --> Bean => Row Mappers , id is input in this

        // Printing out the course bean values.
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),id);
    }
}
