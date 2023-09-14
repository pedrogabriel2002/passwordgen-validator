package pedrogabriel.passwordgenerator;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
    	PasswordValidator pwValidator = new PasswordValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dica: Para ter uma senha razoável é necessário ter 8 digitos ou mais");
        System.out.print("Qual o tamanho da senha que você deseja:");
        
       
        try {
        	int maxSizePassword = scanner.nextInt();
        	
            if (maxSizePassword < 8) {        	
            	System.err.println("É necessário uma senha de tamanho 8 ou mais!!!\n");
            	App.main(args);
            } else {
            PasswordGenerator pwGenerator = new PasswordGenerator(maxSizePassword);
            pwGenerator.setPassword(pwGenerator.generatePassword());
            
            System.out.println("Senha Gerada: " + pwGenerator.getPassword());
            System.out.println("Senha Válida? " + pwValidator.validatePassword(pwGenerator.getPassword()));
            }
		} catch (Exception e) {
			System.err.println("Erro: Somente números devem ser inseridos!\n");
			App.main(args);
		}
    }
}
