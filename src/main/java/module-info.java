module com.example.printer_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;



    opens com.example.printer_management_system to javafx.fxml;
    exports com.example.printer_management_system;
    exports com.example.printer_management_system.pms_classes.controllers;
    exports com.example.printer_management_system.pms_classes;
    opens com.example.printer_management_system.pms_classes.controllers to javafx.fxml;
}