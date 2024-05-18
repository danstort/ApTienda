/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField tfnserie;
    @FXML
    private TextField tfnombre;
    @FXML
    private TextField tffabricante;
    @FXML
    private TextField tfprecio;
    @FXML
    private Button bGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void guardarProducto(ActionEvent event) {

         if(tfnserie.getText().isEmpty()||tfnombre.getText().isEmpty()||tffabricante.getText().isEmpty()||tfprecio.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Nombre");
        lista.add("Dirección");
        lista.add("Teléfono");
        String salida = "";
        for(String datos: lista){
            salida = salida+datos+"\n";
        }
        alert.setHeaderText("Mensaje de error");
        alert.setContentText("Debe introducir los DATOS de cliente \n"+salida);
        alert.showAndWait();
        } else {
        Producto p = new Producto();
        p.setNserie(parseInt(tfnserie.getText()));
        p.setNombre(tfnombre.getText());
        p.setFabricante(tffabricante.getText());
        p.setPrecio(parseInt(tfprecio.getText()));

        ProductoDAO pDAO = new ProductoDAO();
        pDAO.insertar(p);
        
         Alert alert2 = new Alert (Alert.AlertType.INFORMATION);
            alert2.setTitle("INFORMACION");
            alert2.setHeaderText("Mensaje de informacion");
            alert2.setContentText("Se ha insertado correctamente");
            alert2.showAndWait();
        
         }
    }

}
