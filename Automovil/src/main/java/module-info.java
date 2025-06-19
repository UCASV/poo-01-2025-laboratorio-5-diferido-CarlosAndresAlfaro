module com.german.labo4.automovil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.german.labo4.automovil to javafx.fxml;
    exports com.german.labo4.automovil;
}

