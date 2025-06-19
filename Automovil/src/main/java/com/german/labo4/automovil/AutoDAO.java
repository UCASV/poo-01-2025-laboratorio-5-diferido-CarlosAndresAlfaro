import com.german.labo4.automovil.Automovil;
import com.german.labo4.automovil.BDConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {

    // Ya existente
    public void saveAutomovil(Automovil automovil) {
        String sql = "INSERT INTO Automovil (marca, modelo, anio, imagen_url) VALUES (?, ?, ?, ?)";

        try (Connection conn = BDConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, automovil.getMarca());
            stmt.setString(2, automovil.getModelo());
            stmt.setString(3, automovil.getAnio());
            stmt.setString(4, automovil.getImageURL());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Automovil> obtenerTodosLosAutomoviles() {
        List<Automovil> lista = new ArrayList<>();
        String sql = "SELECT * FROM Automovil";

        try (Connection conn = BDConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String anio = rs.getString("anio");
                String imagenUrl = rs.getString("imagen_url");

                Automovil auto = new Automovil(marca, modelo, anio, imagenUrl);
                lista.add(auto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
