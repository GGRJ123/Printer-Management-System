import com.example.printer_management_system.pms_classes.AdminAccount;
import com.example.printer_management_system.pms_classes.BaseAccount;
import com.example.printer_management_system.pms_classes.CSVparser;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdatePrinterTests {

    //barcode exists (printer exists)
    //6.1
    @Test
    void barcodeExist() throws IOException {
        BaseAccount baseAccount = new BaseAccount();
        CSVparser parse = new CSVparser();
        Deltech_printer_database db = new Deltech_printer_database(parse.getSinglePrinterData("1001609",parse.printers()));

        assertTrue(baseAccount.update_printer("1001609",
                db.getDescription(),
                db.getCategory(),
                db.getLocation(),
                db.getSerial_num(),
                db.getManufacturer(),
                db.getDivision(),
                db.getDepartment(),
                db.getCampus(),
                db.getStatus()));
    }
    //barcode doesnt exist
    //6.2
    @Test
    void barcodeDoesNotExist() throws IOException {
        BaseAccount baseAccount = new BaseAccount();
        CSVparser parse = new CSVparser();
        Deltech_printer_database db = new Deltech_printer_database(parse.getSinglePrinterData("1001609",parse.printers()));

        assertFalse(baseAccount.update_printer("1",
                db.getDescription(),
                db.getCategory(),
                db.getLocation(),
                db.getSerial_num(),
                db.getManufacturer(),
                db.getDivision(),
                db.getDepartment(),
                db.getCampus(),
                db.getStatus()));
    }
}
