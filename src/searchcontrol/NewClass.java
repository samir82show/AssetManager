package searchcontrol;

import javax.security.auth.login.LoginException;
import util.ActiveDirectoryAuthentication;

public class NewClass {

    public static void main(String[] args) {
        ActiveDirectoryAuthentication authentication = new ActiveDirectoryAuthentication("mydomain.com");
        try {
            boolean authResult = authentication.authenticate("user", "password");
            System.out.print("Auth: " + authResult);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }

    }
}
