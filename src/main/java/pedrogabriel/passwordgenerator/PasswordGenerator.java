package pedrogabriel.passwordgenerator;

public class PasswordGenerator {
	private String password;
	private int maxSizePassword;
	Alphabet alphabet;
	
	public PasswordGenerator(int maxSizePassword) {
		this.maxSizePassword = maxSizePassword;
	}
	
	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		this.password = password;
		return password;
	}
	
	public String generatePassword() {
		String passwordBuilder;
		boolean isTruePassword = false;
		int random;
		PasswordValidator pwValidator = new PasswordValidator();

		do {
			passwordBuilder = "";
			for (int i = 0; i < maxSizePassword; i++) {
				random =  (int) (Math.random() * 4);
				switch (random) {
				case 0:
					passwordBuilder += alphabet.LOWERCASE_LETTERS.charAt((int) (Math.random() * alphabet.LOWERCASE_LETTERS.length()));
					break;
				case 1:
					passwordBuilder += alphabet.UPPERCASE_LETTERS.charAt((int) (Math.random() * alphabet.UPPERCASE_LETTERS.length()));
					break;
				case 2:
					passwordBuilder += alphabet.NUMBERS.charAt((int) (Math.random() * alphabet.NUMBERS.length()));	
					break;
				case 3:
					passwordBuilder += alphabet.SYMBOLS.charAt((int) (Math.random() * alphabet.SYMBOLS.length()));
					break;
				}
			}
			isTruePassword = pwValidator.validatePassword(passwordBuilder);
		} while (!isTruePassword);
		return passwordBuilder;
	}
}
