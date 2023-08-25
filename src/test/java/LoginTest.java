import com.example.printer_management_system.pms_classes.Login;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest {

    //1.1
    @Test
    void verifyCorrectLogin() throws IOException {
        Login login = new Login();
        assertTrue(login.verifyLogin("ggarcia8@dtcc.edu","Apple123$"));
    }

    //1.2
    @Test
    void incorrectLoginPassword() throws IOException {
        Login login = new Login();
        assertFalse(login.verifyLogin("ggarcia8@dtcc.edu","password1"));
    }

    //1.3
    @Test
    void incorrectLoginUsername() throws IOException {
        Login login = new Login();
        assertFalse(login.verifyLogin("ggarcia8@dtcc.eduuu","Apple123$"));
    }


}
