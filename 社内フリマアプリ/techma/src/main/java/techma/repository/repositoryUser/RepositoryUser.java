package techma.repository.repositoryUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import techma.domain.items.Item;
import techma.domain.users.User;

public interface RepositoryUser extends JpaRepository<User, String> {
	
	 @Query("SELECT x FROM User x")
	    List<User> findAllUser();
	 
	 @Query("select x from User x where x.username = :username")
	 User findByUsername(@Param("username") String username);
	 
}
