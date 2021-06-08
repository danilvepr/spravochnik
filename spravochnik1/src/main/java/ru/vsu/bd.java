//package ru.vsu;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import ru.vsu.model.abonent;
//
//import java.sql.*;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//
//@Component
//public class bd implements spravochnic {
//    Connection connection;
//    public bd(@Value("${bd.url}") String url,
//              @Value("${bd.user}") String user,
//              @Value("${bd.password}") String password) throws SQLException {
//        connection = DriverManager.getConnection(url, user, password);
//    }
//    public void add(abonent chelovec) {
//        try {
//            PreparedStatement vstavka = connection.prepareStatement("INSERT INTO abonent(surname,name,telefon1,telefon2,telefon3) VALUES(?,?,?,?,?)");
//            vstavka.setString(1, chelovec.gsurname());
//            vstavka.setString(2, chelovec.gname());
//            vstavka.setString(3, chelovec.gtelefon1());
//            vstavka.setString(4, chelovec.gtelefon2());
//            vstavka.setString(5, chelovec.gtelefon3());
//            vstavka.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//    public void delete(int id) {
//        try {
//            PreparedStatement delet = connection.prepareStatement("DELETE FROM abonent WHERE id = ?");
//            delet.setLong(1, id);
//            delet.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//    public void edit(int id, abonent chelovec) {
//        try {
//            PreparedStatement izmen = connection.prepareStatement("UPDATE abonent "+"SET "+"surname = ?,"+"name = ?,"+"telefon1 = ?,"+"telefon2 = ?,"+"telefon3 = ?"+"WHERE id = ?");
//            izmen.setString(1, chelovec.gsurname());
//            izmen.setString(2, chelovec.gname());
//            izmen.setString(3, chelovec.gtelefon1());
//            izmen.setString(4, chelovec.gtelefon2());
//            izmen.setString(5, chelovec.gtelefon3());
//            izmen.setLong(6, id);
//            izmen.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//    public abonent chel(int id) {
//        try {
//            abonent chelovec = null;
//            PreparedStatement zapis = connection.prepareStatement("SELECT * FROM abonent WHERE id = ?");
//            zapis.setLong(1, id);
//            ResultSet rs = zapis.executeQuery();
//            while (rs.next()) {
//                String surname = rs.getString("surname");
//                String name = rs.getString("name");
//                String telefon1 = rs.getString("telefon1");
//                String telefon2 = rs.getString("telefon2");
//                String telefon3 = rs.getString("telefon3");
//                chelovec = new abonent(id, surname, name, telefon1, telefon2, telefon3);
//            }
//            return chelovec;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//    public List<abonent> poisk(String isk) {
//        List<abonent> chelovec = abonen();
//        List<abonent> poisk = new ArrayList<>();
//        for (abonent stroka : chelovec) {
//            boolean surname = stroka.gsurname().toLowerCase().contains(isk.toLowerCase());
//            boolean name = stroka.gname().toLowerCase().contains(isk.toLowerCase());
//            boolean telefon1 = stroka.gtelefon1().toLowerCase().contains(isk.toLowerCase());
//            boolean telefon2 = stroka.gtelefon2().toLowerCase().contains(isk.toLowerCase());
//            boolean telefon3 = stroka.gtelefon3().toLowerCase().contains(isk.toLowerCase());
//            if (surname||name||telefon1||telefon2||telefon3) {
//                poisk.add(stroka);
//            }
//        }
//        return poisk;
//    }
//    public List<abonent> abonen() {
//        try {
//            List<abonent> abon = new ArrayList<>();
//            Statement pol = connection.createStatement();
//            ResultSet rs = pol.executeQuery("SELECT * FROM abonent");
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String surname = rs.getString("surname");
//                String name = rs.getString("name");
//                String telefon1 = rs.getString("telefon1");
//                String telefon2 = rs.getString("telefon2");
//                String telefon3 = rs.getString("telefon3");
//                abon.add(new abonent(id,surname,name,telefon1,telefon2,telefon3));
//            }
//            Collections.sort(abon);
//            return abon;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//}