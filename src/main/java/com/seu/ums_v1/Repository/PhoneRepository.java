package com.seu.ums_v1.Repository;

import com.seu.ums_v1.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone,Integer> {

    @Query(value = "SELECT * from phone  where phone_no=?1",nativeQuery = true)
    public Optional<Phone> findByPhone_no(String phone_no);
}
