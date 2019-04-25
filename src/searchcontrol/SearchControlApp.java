package searchcontrol;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import util.Helper;

public class SearchControlApp {

    public static void main(String[] args) {
        Helper helper = new Helper();
        Hashtable<String, String> env = helper.ldapConnect("ldap://mv3wcddc01prv.smrc.sidra.org:389/DC=smrc,DC=sidra,DC=org",
                "simple", "CN=Samir Awad,OU=Tower D,OU=Mall,OU=Hospital Building,OU=Users,OU=Healthcare,OU=SMRC Business Units,DC=smrc,DC=sidra,DC=org",
                "shadOw!123");

        DirContext context = null;
        try {
            context = new InitialDirContext(env);
        } catch (AuthenticationNotSupportedException ex) {
            System.out.println("The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            System.out.println("incorrect password or username");
        } catch (NamingException ex) {
            System.out.println("error when trying to create the context");
        }

        SearchControls searchControls = new SearchControls();
        Attributes attributes = new BasicAttributes();
//        attributes.put(new BasicAttribute("sn", "aWad"));
        String filter = "(&(sn=*)(employeeNumber=21349))";
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        try {
            NamingEnumeration<SearchResult> answer = context.search("OU=SMRC Business Units",
                    filter, searchControls);
            while (answer.hasMoreElements()) {
                SearchResult searchResult = answer.next();
                System.out.println(searchResult.getAttributes().get("manager"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(SearchControlApp.class.getName()).log(Level.SEVERE, null, ex);
        }     
        System.out.println("aaa ssss".replace(" ", "_"));

    }

}
