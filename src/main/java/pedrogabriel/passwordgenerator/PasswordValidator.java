package pedrogabriel.passwordgenerator;

import java.util.regex.*;

public class PasswordValidator {
    private String regex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
    Pattern p;
    Matcher m;
	
	
	public boolean validatePassword(String password) {
		p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        m = p.matcher(password);
        
        return m.matches();
	}
}
