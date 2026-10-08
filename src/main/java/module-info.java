module com.rojas.pruebajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.rojas.pruebajavafx to javafx.base; /// Tiene que llamarse javafx.base o no va a poder tener acceso
    opens com.rojas.pruebajavafx.modelos to javafx.base; /// Acceso a la carpeta modelos donde esta la clase Productos
    exports com.rojas.pruebajavafx;
}