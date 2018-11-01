package techma.service.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import techma.domain.users.User;
import techma.repository.repositoryUser.RepositoryUser;

public class UserService {
	@Autowired
	RepositoryUser repositoryUser;
	
	public List<User> findAll() {
		return repositoryUser.findAll();
	}
	//public User findOne(String name) {
		//return repositoryUser.getById(name);
	//}  
	public User create(User user) {
	    return repositoryUser.save(user);
    }

	public User update(User user) {
	    return repositoryUser.save(user);
    }

    public void delete(String name) {
    	repositoryUser.deleteById(name);
	    }
		
	}

