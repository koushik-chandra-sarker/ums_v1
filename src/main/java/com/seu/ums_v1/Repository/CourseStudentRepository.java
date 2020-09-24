package com.seu.ums_v1.Repository;

import com.seu.ums_v1.Entity.Course_Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseStudentRepository extends CrudRepository<Course_Student, String> {

    @Query(value = "SELECT * from course_student  where student_id=?1",nativeQuery = true)
    public List<Course_Student> findAllByStudentId(int id);

    @Query(value = "SELECT * from course_student  where courses_ssn=?1",nativeQuery = true)
    public List<Course_Student> findAllByCoursesSsn(String ssn);

}
