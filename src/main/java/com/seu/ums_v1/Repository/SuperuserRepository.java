package com.seu.ums_v1.Repository;


import com.seu.ums_v1.Entity.Superuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuperuserRepository extends JpaRepository<Superuser, Integer> {

   @Query(value = "select * from superuser where email=?", nativeQuery = true)
   Superuser findSuperuserByEmail(String email);
}
