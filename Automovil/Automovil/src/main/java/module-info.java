module com.german.labo4.automovil {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.german.labo4.automovil to javafx.fxml;
    exports com.german.labo4.automovil;
}