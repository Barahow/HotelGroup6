import java.util.Scanner;

public class Login {

    // username and password
    private final String Username = "admin"; 
    private final String Password = "pass";
    
    /**
     * This method display login screen and check if the entered credentials are authentic.
     * @return true if login was successful
     */
    public boolean showLoginScreen() {

        // for user inputs
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nHotel group 6\n");
        System.out.print("\nEnter username :: ");
        String username = input.nextLine();
        System.out.print("Enter password :: ");
        String password = input.nextLine();
        
        // if username is correct
        if (username.equals(Username)) {

            // if password is correct
            if(password.equals(Password))
                return true;
            else
                System.out.println("\nPassword is incorrect!");
        }
        else
            System.out.println("\nUsername is incorrect!");
        
        // wait for enter key to be pressed
        System.out.print("Press enter key to continue...");
        input.nextLine();
        
        // if login was unsuccessful
        return false;
    }
    
}