package group3.finalproj.account;

class Password {
	private String encryptedPass;
	//private String encryptionKey; //TODO - Determine how this shall be used
	protected int loginAttempts;
	private int maxAttempts = 3;
	
	protected Password(String password) {
		encryptPass(password); 
		loginAttempts = 0;
	}
	
	//TODO - Implementation
	private void encryptPass(String password) {
		encryptedPass = password;
	}
	
	//TODO - Implementation
	private String decryptPass() {
		return encryptedPass;
	}
	
	protected boolean matchPass(String password) {
		if (password.compareTo(decryptPass()) == 0 && loginAttempts < maxAttempts) {
			loginAttempts = 0;
			return true;
		}else {
			loginAttempts++;
			return false;
		}
	}
}
