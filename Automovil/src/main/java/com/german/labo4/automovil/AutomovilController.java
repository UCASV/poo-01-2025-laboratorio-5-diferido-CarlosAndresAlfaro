package com.german.labo4.automovil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AutomovilController implements Initializable {

    @FXML private TilePane cardsPane;
    @FXML private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Automovil ejemplo = new Automovil(
                "Toyota",
                "Corolla",
                "2020",
                "https://www.kia.com/content/dam/kwcms/gt/en/images/discover-kia/voice-search/parts-80-1.jpg"
        );
        cardsPane.getChildren().add(createCard(ejemplo));

        addButton.setOnAction(e -> openAddDialog());
    }

    private void openAddDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("add-automovil-dialog.fxml")
            );
            VBox root = loader.load();

            AddAutomovilDialogController dialogCtrl = loader.getController();
            dialogCtrl.setOnAdd(auto -> cardsPane.getChildren().add(createCard(auto)));

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Agregar Automóvil");
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private VBox createCard(Automovil auto) {
        VBox card = new VBox(10);
        card.setPrefWidth(180);
        card.setAlignment(Pos.TOP_LEFT);
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-border-color: lightgray; " +
                        "-fx-border-width: 1; " +
                        "-fx-border-radius: 5; " +
                        "-fx-background-radius: 5; " +
                        "-fx-background-color: white;"
        );

        ImageView iv = new ImageView();
        iv.setFitWidth(200);
        iv.setFitHeight(150);
        iv.setPreserveRatio(true);
        if (auto.getImageURL() != null && !auto.getImageURL().isBlank()) {
            iv.setImage(new Image(auto.getImageURL(), true));
        }

        Label marcaLabel = new Label("Marca: " + auto.getMarca());
        Label modeloLabel = new Label("Modelo: " + auto.getModelo());
        Label anioLabel = new Label("Año: " + auto.getAnio());
        Label descripcion = new Label("Descripción: " + auto.getDescripcion());
        descripcion.setWrapText(true);
        descripcion.setMaxWidth(card.getPrefWidth() - 20);

        card.getChildren().addAll(iv, marcaLabel, modeloLabel, anioLabel, descripcion);
        return card;
    }

    @FXML private TableView<Automovil> tablaAutomoviles;

    @FXML
    public void initialize() {
        AutoDAO dao = new AutoDAO();
        List<Automovil> lista = dao.obtenerTodosLosAutomoviles();
        tablaAutomoviles.getItems().setAll(lista);
    }

}
