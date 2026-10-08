package com.rojas.pruebajavafx;

import com.rojas.pruebajavafx.modelos.Productos;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.layout.VBox; /// Importante para crear la ventana la cual se va a hacer la interfaz

import java.io.IOException;

public class HelloApplication extends Application {

    private ObservableList<Productos> Productos = FXCollections.observableArrayList(
            new Productos("Teclado", "alguna descripción", 1000L),
            new Productos("Mouse", "alguna descripción mouse", 500L),
            new Productos("CPU", "alguna Ryzen 5", 500000L),
            new Productos("Memoria RAM", "alguna RAM 64 GB", 400000L)
    );
    @Override
    public void start(Stage stage) throws IOException {
        TableView<Productos> tableView = new TableView<>(); /// Crear una tabla que va a mostrar los objetos de Productos
        TableColumn<Productos, String> nombreColumna = new TableColumn<>("Nombre Producto"); /// Define el valor a mostrar de la lista Productos
        TableColumn<Productos, String> descColumna = new TableColumn<>("Descripción Producto"); /// Define el valor a mostrar de la lista Productos
        TableColumn<Productos, Long> precioColumna = new TableColumn<>("Precio Producto"); /// Define el valor a mostrar de la lista Productos
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descColumna.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        precioColumna.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Productos, Void> borrarColumna = new TableColumn<>("Eliminar");
        borrarColumna.setCellFactory(celda -> new TableCell<>(){

            private final Button borrarBoton = new Button("Eliminar Celda");


            {
                borrarBoton.setOnAction(event  -> { /// Estamos creando un evento al presionar el boton
                    Productos productos = getTableView().getItems().get(getIndex());
                    tableView.getItems().remove(productos); /// mvc investigar y como conectarlo a una base de datos
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                } else {
                    setGraphic(borrarBoton);
                }
            }
        });
        tableView.getColumns().addAll(nombreColumna,descColumna,precioColumna,borrarColumna);
        tableView.setItems(this.Productos);
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 520, 340);
        stage.setTitle("Gestión De Productos");
        stage.setScene(scene);
        stage.show();
    }
}