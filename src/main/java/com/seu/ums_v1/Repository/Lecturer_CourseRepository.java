package com.seu.ums_v1.Repository;
import com.seu.ums_v1.Entity.Lecturer_Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Lecturer_CourseRepository extends CrudRepository<Lecturer_Course, String> {

    @Query(value = "SELECT * from lecturer_course  where lecturer_id=?1",nativeQuery = true)
    public List<Lecturer_Course> findAllByLecturer(int id);

}
