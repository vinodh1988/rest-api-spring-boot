package com.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{


}
