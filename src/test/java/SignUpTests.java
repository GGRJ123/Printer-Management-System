import com.example.printer_management_system.pms_classes.Login;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpTests {
    //2.1
    @Test
    void unusedLoginDetails() throws IOException {
        Login login = new Login();
        assertTrue(login.register("test@dtcc.edu","Apple123$"));
    }
    //2.3
    @Test
    void verifyDuplicateEmail() throws IOException{
        Login login = new Login();
        assertFalse(login.register("ggarcia8@dtcc.edu","Apple123$"));
    }
}
