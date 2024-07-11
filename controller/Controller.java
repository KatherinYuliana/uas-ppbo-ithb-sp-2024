package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Makanan;
import model.MenuResto;
import model.Minuman;

public class Controller {
    private static Controller instance;
    static DatabaseHandler conn = new DatabaseHandler();

    public Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public boolean addNewMenuResto(MenuResto menuResto) {
        conn.connect();
        String sqlMenuResto = "INSERT INTO menuresto VALUES (?, ?, ?)";

        try {
            PreparedStatement psMenuResto = conn.con.prepareStatement(sqlMenuResto);
            psMenuResto.setString(1, menuResto.getKode());
            psMenuResto.setString(2, menuResto.getNama());
            psMenuResto.setInt(3, menuResto.getHarga());

            // Execute the SQL statement
            int rowsAffected = psMenuResto.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect(); // Make sure to close the connection in the finally block
        }
    }

    public ArrayList<MenuResto> getAllMenuResto() {
        conn.connect();
        String query = "SELECT * FROM menuresto";
        ArrayList<MenuResto> menuResto = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                MenuResto menu = new MenuResto();
                menu.setKode(resultSet.getString("kode"));
                menu.setNama(resultSet.getString("nama"));
                menu.setHarga(resultSet.getInt("harga"));
                
                menuResto.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuResto;
    }

    public boolean addNewMakanan(Makanan makanan) {
        conn.connect();
        String sqlMakanan = "INSERT INTO makanan VALUES (?, ?, ?)";

        try {
            PreparedStatement psMakanan = conn.con.prepareStatement(sqlMakanan);
            psMakanan.setString(1, makanan.getKode());
            psMakanan.setBoolean(2, makanan.isContainsMeat());
            psMakanan.setInt(3, makanan.getUkuranPorsi());

            // Execute the SQL statement
            int rowsAffected = psMakanan.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect(); // Make sure to close the connection in the finally block
        }
    }


    public ArrayList<Makanan> getAllMakanan() {
        conn.connect();
        String query = "SELECT * FROM makanan";
        ArrayList<Makanan> makanan = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Makanan food = new Makanan("", "", 0, true, 0);
                food.setKode(resultSet.getString("kode"));
                food.setContainsMeat(resultSet.getBoolean("containsMeat"));
                food.setUkuranPorsi(resultSet.getInt("ukuranPorsi"));
                
                makanan.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return makanan;
    }

    public boolean addNewMinuman(Minuman minuman) {
        conn.connect();
        String sqlMenuResto = "INSERT INTO menuresto VALUES (?, ?, ?)";
        String sqlMinuman = "INSERT INTO minuman VALUES (?, ?)";

        try {
            PreparedStatement psMenuResto = conn.con.prepareStatement(sqlMenuResto);
            psMenuResto.setString(1, minuman.getKode());
            psMenuResto.setString(2, minuman.getNama());
            psMenuResto.setInt(3, minuman.getHarga());

            PreparedStatement psMakanan = conn.con.prepareStatement(sqlMinuman);
            psMakanan.setString(1, minuman.getKode());
            //psMakanan.setJ(2, minuman.getJenis());
            
            // Execute the SQL statement
            int rowsAffected = psMenuResto.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect(); // Make sure to close the connection in the finally block
        }
    }
}
