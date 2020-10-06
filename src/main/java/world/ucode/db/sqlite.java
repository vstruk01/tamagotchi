package world.ucode.db;

import world.ucode.pets.Pet;

import java.sql.*;

public class sqlite implements DataBase {
    Connection con;
    Statement stmt;


    public sqlite() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Pets.db");
        createTablePets();
    }

    public void createTablePets() throws SQLException {
        stmt = con.createStatement();
        stmt.execute("CREATE  TABLE IF NOT EXISTS 'Pets'(id         INTEGER  PRIMARY KEY, " +
                                                           "name        TEXT, " +
                                                           "health      REAL, " +
                                                           "thirst      REAL," +
                                                           "cleanliness REAL, " +
                                                           "hunger      REAL, " +
                                                           "happiness   REAL);");
        System.out.println("ok");
    }


    @Override
    public void addPet(Pet pet) {
        try {
            PreparedStatement stmtPrepare = con.prepareStatement("INSERT INTO Pets(name, health, thirst, cleanliness, hunger, happiness)VALUES (?, ?, ?, ?, ?, ?)");
            stmtPrepare.setString(1, pet.getName());
            stmtPrepare.setDouble(2, pet.getHealth());
            stmtPrepare.setDouble(3, pet.getThirst());
            stmtPrepare.setDouble(4, pet.getCleanliness());
            stmtPrepare.setDouble(5, pet.getHunger());
            stmtPrepare.setDouble(6, pet.getHappiness());
            stmtPrepare.executeUpdate();
            System.out.println("ok add Pet");
        } catch (SQLDataException e) {
            System.out.println(e.getMessage());
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    @Override
    public void savePet() {

    }

    @Override
    public String[] getCurrName() {
        return new String[0];
    }

    @Override
    public boolean isExistsPet(String namePet) {

    }

    @Override
    public Pet[] getAllPet() {
        return new Pet[0];
    }
}
