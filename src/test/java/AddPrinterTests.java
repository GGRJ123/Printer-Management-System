import com.example.printer_management_system.pms_classes.AdminAccount;
import com.example.printer_management_system.pms_classes.Login;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddPrinterTests {

    //barcode and serialNum exists (printer exists)
    //3.1
    @Test
    void barcodeAndSerialNumExist() throws IOException {
        //both the serial number and barcode already exist
        String testPrinter[] = {
                "4357","DESIGNJET 500","INK PRINTER",
                "A231","SG3AF61004","HP","INSTRUCTION",
                "ENVIRONMENTAL TECHNOLOGY","STANTON","ACTIVE"};
        AdminAccount adminAccount = new AdminAccount();
        assertFalse(adminAccount.add_printer(testPrinter[0], testPrinter[1], testPrinter[2],
                testPrinter[3],testPrinter[4],testPrinter[5],
                testPrinter[6],testPrinter[7],testPrinter[8],testPrinter[9]));
    }
    //bar code doesnt exist but serial number does
    //3.2
    @Test
    void serialNumExistsBarcodeDoesNot() throws IOException {
        String testPrinter[] = {
                "435777777","DESIGNJET 500","INK PRINTER",
                "A231","SG3AF61004","HP","INSTRUCTION",
                "ENVIRONMENTAL TECHNOLOGY","STANTON","ACTIVE"};
        AdminAccount adminAccount = new AdminAccount();
        assertFalse(adminAccount.add_printer(testPrinter[0], testPrinter[1], testPrinter[2],
                testPrinter[3],testPrinter[4],testPrinter[5],
                testPrinter[6],testPrinter[7],testPrinter[8],testPrinter[9]));
    }
    //barcode exists, serial number doesnt
    //3.3
    @Test
    void barcodeExistsSerialNumDoesNot() throws IOException {
        String testPrinter[] = {
                "4357","DESIGNJET 500","INK PRINTER",
                "A231","incorrectSerial","HP","INSTRUCTION",
                "ENVIRONMENTAL TECHNOLOGY","STANTON","ACTIVE"};
        AdminAccount adminAccount = new AdminAccount();
        assertFalse(adminAccount.add_printer(testPrinter[0], testPrinter[1], testPrinter[2],
                testPrinter[3],testPrinter[4],testPrinter[5],
                testPrinter[6],testPrinter[7],testPrinter[8],testPrinter[9]));
    }
    //Serial Number and barcode dont exist
    //3.4
    @Test
    void serialNumAndBarcodeDoNotExist() throws IOException {
        String testPrinter[] = {
                "4357458","DESIGNJET 500","INK PRINTER",
                "A231","RandomSerial","HP","INSTRUCTION",
                "ENVIRONMENTAL TECHNOLOGY","STANTON","ACTIVE"};
        AdminAccount adminAccount = new AdminAccount();
        assertTrue(adminAccount.add_printer(testPrinter[0], testPrinter[1], testPrinter[2],
                testPrinter[3],testPrinter[4],testPrinter[5],
                testPrinter[6],testPrinter[7],testPrinter[8],testPrinter[9]));
    }
    //is admin

    //not admin

    //can test different combinations of these such as being an admin and the bar code not existing
}
