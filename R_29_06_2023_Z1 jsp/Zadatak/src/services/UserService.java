package services;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserService {
	
	public List<User> users = new ArrayList<>();
	
	private static UserService instance = null;
	
	public static UserService getInstance() {
		if(instance == null)
			instance = new UserService();
		return instance;
	}
	
	private UserService() {
		super();
		users.add(new User("Slavko", "Muzdeka", "slavko", "2000-02-11"));
	}

}
