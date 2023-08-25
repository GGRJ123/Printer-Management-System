import com.example.printer_management_system.pms_classes.BaseAccount;
import com.example.printer_management_system.pms_classes.CSVparser;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SearchPrinterTests {

    //barcode exists (printer exists)
    //5.1
    @Test
    void barcodeExist() throws IOException {
        BaseAccount baseAccount = new BaseAccount();
        CSVparser parse = new CSVparser();
        Deltech_printer_database db = new Deltech_printer_database(parse.getSinglePrinterData("2003000",parse.printers()));
        assertEquals(db.toString(),baseAccount.search_printer("2003000"));
    }

    //barcode doesnt exist
    //5.2
    @Test
    void barcodeDoesNotExist() throws IOException {
        BaseAccount baseAccount = new BaseAccount();
        CSVparser parse = new CSVparser();
        Deltech_printer_database db = new Deltech_printer_database(parse.getSinglePrinterData("20030",parse.printers()));
        assertEquals("No barcode found",baseAccount.search_printer("20030"));
    }

    //can test different cases for the filtering options
}
