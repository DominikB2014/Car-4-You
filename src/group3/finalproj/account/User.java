package group3.finalproj.account;

public class User {
	private String userName;
	private Password password;
	public boolean loginStatus;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = new Password(password);
		loginStatus = false;
	}
	
	public void changePass(String oldPass, String newPass) {
		if (verifyLogin(oldPass)) {
			password = new Password(newPass);
		}
	}
	
	private boolean verifyLogin(String password) {
		return this.password.matchPass(password);
	}
	
	public void login(String password) {
		loginStatus = this.password.matchPass(password);
	}
	
	public void logoff() {
		loginStatus = false;
	}
	
}
