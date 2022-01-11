package br.com.tresdaniel.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tresdaniel.data.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u from User u WHERE u.userName =:userName")
	User findByUserName(@Param("userName") String userName);

}
