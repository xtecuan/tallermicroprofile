package sv.org.devfest;

//import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//import org.eclipse.microprofile.auth.LoginConfig;
//@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("/")
//@DeclareRoles({"mysimplerole", "USER"})
public class ApplicationConfig extends Application {

}
