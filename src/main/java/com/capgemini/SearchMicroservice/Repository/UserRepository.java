package com.capgemini.SearchMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.SearchMicroservice.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	//Return the User of given username
	public User findByUsername(String username);

}
