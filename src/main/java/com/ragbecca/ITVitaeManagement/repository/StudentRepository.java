package com.ragbecca.ITVitaeManagement.repository;

import com.ragbecca.ITVitaeManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
