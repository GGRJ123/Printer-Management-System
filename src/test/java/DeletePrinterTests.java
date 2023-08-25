import com.example.printer_management_system.pms_classes.AdminAccount;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletePrinterTests {

    //is admin

    //is not admin

    //bar code exists
    //4.1
    @Test
    void barcodeExist() throws IOException {
        AdminAccount adminAccount = new AdminAccount();
        assertTrue(adminAccount.delete_printer("4357"));
    }
    //bar code does not exist
    //4.2
    @Test
    void barcodeDoesNotExist() throws IOException {
        AdminAccount adminAccount = new AdminAccount();
        assertFalse(adminAccount.delete_printer("435743245"));
    }
}
