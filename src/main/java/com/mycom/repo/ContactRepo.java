package com.mycom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycom.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

	
	@Query("from Contact as c where c.user.id=:userId" )
	public List<Contact> findContactsByUser(@Param("userId") int userId);
	
	
}
