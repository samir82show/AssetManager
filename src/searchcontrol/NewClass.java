package searchcontrol;

import javax.security.auth.login.LoginException;
import util.ActiveDirectoryAuthentication;

public class NewClass {

    public static void main(String[] args) {
        ActiveDirectoryAuthentication authentication = new ActiveDirectoryAuthentication("smrc.sidra.org");
        try {
            boolean authResult = authentication.authenticate("sawad2", "shadOw!123");
            System.out.print("Auth: " + authResult);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }

    }
}
