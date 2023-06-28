package app.beans;

import java.io.Serializable;

import java.util.HashMap;
import java.util.logging.Logger;

import app.dto.User;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private boolean isLoggedIn = false;
	private static HashMap<String, User> users = new HashMap<>();

	Logger loger = Logger.getLogger("MyLogger");

	public boolean login(String username) {
		loger.info("ETF LOGIN" + users.get(username));
		loger.info("ETF LOGIN" + users.toString());
		if ((user = users.get(username)) != null) {
			isLoggedIn = true;
			return true;
		}
		return false;
	}

	public boolean register(String username) {
		if (!users.containsKey(username)) {
			users.put(username, new User(username));
			loger.info("ETF REGISTER" + users.toString());
			return true;
		}
		return false;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void logout() {
		user = new User();
		isLoggedIn = false;
	}

	public User getUser() {
		return user;
	}

	public boolean isUsernameAllowed(String username) {
		return !users.containsKey(username);
	}

	public void add(User user) {
		users.put(user.getUsername(), user);
	}
}
