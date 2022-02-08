module com.example.dentist_clinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens model to javafx.base;
    opens com.example.dentist_clinic to javafx.base, javafx.fxml;
    exports com.example.dentist_clinic;
}