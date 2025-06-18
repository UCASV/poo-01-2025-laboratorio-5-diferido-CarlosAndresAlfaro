package com.german.labo4.automovil;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAutomovilDialogController {

    @FXML private TextField marcaField;
    @FXML private TextField modeloField;
    @FXML private TextField anioField;
    @FXML private TextField imageURLField;
    @FXML private Button addBtn;
    @FXML private Label errorLabel;

    private java.util.function.Consumer<Automovil> onAdd;

    public void setOnAdd(java.util.function.Consumer<Automovil> onAdd) {
        this.onAdd = onAdd;
    }

    @FXML
    private void initialize() {
        addBtn.setOnAction(e -> {
            String marca = marcaField.getText().trim();
            String modelo = modeloField.getText().trim();
            String anio = anioField.getText().trim();
            String imageUrl = imageURLField.getText().trim();
            if (marca.isEmpty() || modelo.isEmpty() || anio.isEmpty()) {
                errorLabel.setText("Todos los campos excepto URL son obligatorios.");
                return;
            }
            Automovil auto = new Automovil(marca, modelo, anio, imageUrl);
            if (onAdd != null) onAdd.accept(auto);
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
    }
}