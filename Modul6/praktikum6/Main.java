package praktikum6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        TableView<Mahasiswa> tabel = new TableView<>();

        TableColumn<Mahasiswa, String> kolomNim = new TableColumn<>("NIM");
        kolomNim.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> kolomNama = new TableColumn<>("Nama");
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tabel.getColumns().add(kolomNim);
        tabel.getColumns().add(kolomNama);

        tabel.setItems(getDataMahasiswa());

        VBox vbox = new VBox(tabel);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Praktikum 6 - Tabel Mahasiswa");
        primaryStage.show();
    }

    private ObservableList<Mahasiswa> getDataMahasiswa() {
        ObservableList<Mahasiswa> list = FXCollections.observableArrayList();
        
        list.add(new Mahasiswa(1, "Acel", "123879"));
        list.add(new Mahasiswa(2, "Tata", "123030"));
        list.add(new Mahasiswa(3, "Amel", "124123"));
        list.add(new Mahasiswa(4, "Dhea", "1241234"));
        list.add(new Mahasiswa(5, "Dinda", "201001"));
        list.add(new Mahasiswa(6, "Nadya", "201002"));
        list.add(new Mahasiswa(7, "Lisa", "201003"));
        list.add(new Mahasiswa(8, "Manda", "201004"));
        list.add(new Mahasiswa(9, "Reni", "201005"));
        list.add(new Mahasiswa(10, "Dewi", "201006"));

        return list;
    }
}