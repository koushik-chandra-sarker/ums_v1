package com.seu.ums_v1.Repository;

import com.seu.ums_v1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
