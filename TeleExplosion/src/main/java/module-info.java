module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens org.teleexplosion to javafx.fxml;
    exports org.teleexplosion;
    exports org.teleexplosion.controlers;
    opens org.teleexplosion.controlers to javafx.fxml;
}
