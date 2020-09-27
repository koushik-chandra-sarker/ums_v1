package com.seu.ums_v1.Repository;

import com.seu.ums_v1.Entity.Lecturer;
import com.seu.ums_v1.Entity.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LecturerRepository extends CrudRepository<Lecturer, Long> {


    @Query(value = "select school_id from lecturer where id=?",nativeQuery = true)
    public int findSchoolByLId(int id);
}
