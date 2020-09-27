package com.seu.ums_v1.Repository;

import com.seu.ums_v1.Entity.School;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface SchoolRepository extends CrudRepository<School, Integer> {

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Transactional
    @Query(value = "update school set campus_id = null where id = ?;",nativeQuery = true)
    void deleteCampusById(int id);

//    @Query(value = "Select id,name FROM school where id = ?;",nativeQuery = true)
//    public Object findSchoolById(int id);
}
