package controller;

import model.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // --- PELANGGAN ---
    @FXML private TextField txtNama, txtEmail, txtTelepon;
    @FXML private TableView<Pelanggan> tabelPelanggan;
    @FXML private TableColumn<Pelanggan, Integer> colID;
    @FXML private TableColumn<Pelanggan, String> colNama, colEmail, colTelepon;
    private ObservableList<Pelanggan> listPelanggan = FXCollections.observableArrayList();

    // --- BUKU ---
    @FXML private TextField txtJudul, txtPenulis, txtHarga, txtStok;
    @FXML private TableView<Buku> tabelBuku;
    @FXML private TableColumn<Buku, Integer> colBukuID, colHarga, colStok;
    @FXML private TableColumn<Buku, String> colJudul, colPenulis;
    private ObservableList<Buku> listBuku = FXCollections.observableArrayList();

    // --- PENJUALAN ---
    @FXML private TextField txtJualPelangganID, txtJualBukuID, txtJumlah, txtTanggal;
    @FXML private TableView<Penjualan> tabelPenjualan;
    @FXML private TableColumn<Penjualan, Integer> colJualID, colJualPelanggan, colJualBuku, colJumlah, colTotal;
    @FXML private TableColumn<Penjualan, String> colTanggal;
    private ObservableList<Penjualan> listPenjualan = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initPelanggan();
        initBuku();
        initPenjualan();
    }

    // --- INIT METHODS ---
    private void initPelanggan() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        loadPelanggan();
        
        tabelPelanggan.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtNama.setText(newVal.getNama());
                txtEmail.setText(newVal.getEmail());
                txtTelepon.setText(newVal.getTelepon());
            }
        });
    }

    private void initBuku() {
        colBukuID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        loadBuku();
        
        tabelBuku.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtJudul.setText(newVal.getJudul());
                txtPenulis.setText(newVal.getPenulis());
                txtHarga.setText(String.valueOf(newVal.getHarga()));
                txtStok.setText(String.valueOf(newVal.getStok()));
            }
        });
    }

    private void initPenjualan() {
        colJualID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colJualPelanggan.setCellValueFactory(new PropertyValueFactory<>("pelanggan_id"));
        colJualBuku.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        loadPenjualan();
    }

    // --- LOAD DATA ---
    private void loadPelanggan() {
        listPelanggan.clear();
        try (Connection conn = Database.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Pelanggan");
            while (rs.next()) listPelanggan.add(new Pelanggan(rs.getInt("id"), rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
            tabelPelanggan.setItems(listPelanggan);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void loadBuku() {
        listBuku.clear();
        try (Connection conn = Database.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Buku");
            while (rs.next()) listBuku.add(new Buku(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getInt("harga"), rs.getInt("stok")));
            tabelBuku.setItems(listBuku);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void loadPenjualan() {
        listPenjualan.clear();
        try (Connection conn = Database.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Penjualan");
            while (rs.next()) listPenjualan.add(new Penjualan(rs.getInt("id"), rs.getInt("jumlah"), rs.getInt("total_harga"), rs.getString("tanggal"), rs.getInt("pelanggan_id"), rs.getInt("buku_id")));
            tabelPenjualan.setItems(listPenjualan);
        } catch (Exception e) { e.printStackTrace(); }
    }

    // --- CRUD PELANGGAN ---
    @FXML private void addPelanggan() {
        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Pelanggan (nama, email, telepon) VALUES (?,?,?)");
            ps.setString(1, txtNama.getText()); ps.setString(2, txtEmail.getText()); ps.setString(3, txtTelepon.getText());
            ps.executeUpdate(); loadPelanggan(); clearPelanggan();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML private void editPelanggan() {
        Pelanggan s = tabelPelanggan.getSelectionModel().getSelectedItem();
        if (s == null) return;
        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE Pelanggan SET nama=?, email=?, telepon=? WHERE id=?");
            ps.setString(1, txtNama.getText()); ps.setString(2, txtEmail.getText()); ps.setString(3, txtTelepon.getText()); ps.setInt(4, s.getId());
            ps.executeUpdate(); loadPelanggan(); clearPelanggan();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML private void deletePelanggan() {
        Pelanggan s = tabelPelanggan.getSelectionModel().getSelectedItem();
        if (s != null) delete("Pelanggan", s.getId()); loadPelanggan();
    }

    // --- CRUD BUKU ---
    @FXML private void addBuku() {
        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?,?,?,?)");
            ps.setString(1, txtJudul.getText()); ps.setString(2, txtPenulis.getText());
            ps.setInt(3, Integer.parseInt(txtHarga.getText())); ps.setInt(4, Integer.parseInt(txtStok.getText()));
            ps.executeUpdate(); loadBuku(); clearBuku();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML private void editBuku() {
        Buku s = tabelBuku.getSelectionModel().getSelectedItem();
        if (s == null) return;
        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE Buku SET judul=?, penulis=?, harga=?, stok=? WHERE id=?");
            ps.setString(1, txtJudul.getText()); ps.setString(2, txtPenulis.getText());
            ps.setInt(3, Integer.parseInt(txtHarga.getText())); ps.setInt(4, Integer.parseInt(txtStok.getText())); ps.setInt(5, s.getId());
            ps.executeUpdate(); loadBuku(); clearBuku();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML private void deleteBuku() {
        Buku s = tabelBuku.getSelectionModel().getSelectedItem();
        if (s != null) delete("Buku", s.getId()); loadBuku();
    }

    // --- CRUD PENJUALAN ---
    @FXML private void addPenjualan() {
        try (Connection conn = Database.getConnection()) {
            // Ambil harga buku dulu buat hitung total
            PreparedStatement psHarga = conn.prepareStatement("SELECT harga FROM Buku WHERE id=?");
            psHarga.setInt(1, Integer.parseInt(txtJualBukuID.getText()));
            ResultSet rs = psHarga.executeQuery();
            int hargaSatuan = 0;
            if (rs.next()) hargaSatuan = rs.getInt("harga");

            int jumlah = Integer.parseInt(txtJumlah.getText());
            int total = hargaSatuan * jumlah;

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Penjualan (pelanggan_id, buku_id, jumlah, total_harga, tanggal) VALUES (?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(txtJualPelangganID.getText()));
            ps.setInt(2, Integer.parseInt(txtJualBukuID.getText()));
            ps.setInt(3, jumlah);
            ps.setInt(4, total);
            ps.setString(5, txtTanggal.getText());
            ps.executeUpdate(); loadPenjualan();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @FXML private void deletePenjualan() {
        Penjualan s = tabelPenjualan.getSelectionModel().getSelectedItem();
        if (s != null) delete("Penjualan", s.getId()); loadPenjualan();
    }

    // --- HELPER ---
    private void delete(String table, int id) {
        try (Connection conn = Database.getConnection()) {
            conn.createStatement().executeUpdate("DELETE FROM " + table + " WHERE id=" + id);
        } catch (Exception e) { e.printStackTrace(); }
    }
    private void clearPelanggan() { txtNama.clear(); txtEmail.clear(); txtTelepon.clear(); }
    private void clearBuku() { txtJudul.clear(); txtPenulis.clear(); txtHarga.clear(); txtStok.clear(); }
}