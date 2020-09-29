package com.seu.ums_v1.Repository;


import com.seu.ums_v1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

    @Query(value = "SELECT * from user where lecturer_id=?", nativeQuery = true)
    User findUserByLecturerId(int id);
    @Query(value = "SELECT * from user where student_id=?", nativeQuery = true)
    User findUserByStudentId(int id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "delete from user_role where user_id=?",nativeQuery = true)
    int deleteUser_roleById(int id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "delete from user where id=?",nativeQuery = true)
    int deleteUserById(int id);
}
