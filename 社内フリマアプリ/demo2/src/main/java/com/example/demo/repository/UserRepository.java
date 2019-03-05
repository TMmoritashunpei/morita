package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("SELECT x FROM User x ORDER BY x.username")
	List<User> findAllUserOrderByName();
	
	@Query("SELECT x FROM User x ORDER BY x.username")
    Page<User> findAllUserOrderByName(Pageable pageable);
	
	@Query("select x from User x where x.username = :username")
	User findByUsername(@Param("username") String username);
	
	@Query("select x from User x where x.username = :id")
	User findByUserId(@Param("id") Integer id);
}
