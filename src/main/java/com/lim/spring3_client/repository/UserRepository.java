package com.lim.spring3_client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lim.spring3_client.entity.User;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByName(String name);

	User findById(long id);
}
