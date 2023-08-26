package beans;

import models.User;
import services.UserService;

public class UserBean {
	
	UserService userService = UserService.getInstance();
	
	public UserBean() {
		super();
	}
	
	public boolean registrationSucessfull(String username, String dateOfBirth) {
		if(isUsernameFree(username) && isOlderThan18(dateOfBirth)) {
			return true;
		}
		return false;
	}
	
	private boolean isUsernameFree(String username) {
		for(User u: userService.users) {
			if(u.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isOlderThan18(String dateOfBirth) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//		Integer currentYear = Integer.valueOf(dateFormat.format(new Date()));
		// TODO Provjeriti da li osoba ima 18 godina
		return true;
	}
	
	public void addUser(User user) {
		System.out.println("Registrovao se korisnik " + user);
		userService.users.add(user);
	}
	
	public User findUser(String username) {
		for(User u: userService.users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}

}
