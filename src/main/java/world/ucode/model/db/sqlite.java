package world.ucode.Model.db;

import world.ucode.Model.pets.Pet;
import java.util.ArrayList;
import java.sql.*;


public class sqlite extends DataBase {
    Connection con;
    Statement stmt;

    public sqlite() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Pets.db");
        createTablePets();
    }

    public void createTablePets() throws SQLException {
        stmt = con.createStatement();
        stmt.execute("CREATE  TABLE IF NOT EXISTS 'Pets'(   id         INTEGER  PRIMARY KEY, " +
                                                           "name        TEXT, "   +
                                                           "health      REAL, "   +
                                                           "thirst      REAL,"    +
                                                           "cleanliness REAL, "   +
                                                           "hunger      REAL, "   +
                                                           "happiness   REAL, "   +
                                                           "typeGame    INTEGER, "+
                                                           "typePet     INTEGER);");
    }


    @Override
    public void addPet(Pet pet) {
        try {
            PreparedStatement stmtPrepare = con.prepareStatement("INSERT INTO Pets(name, health, thirst, cleanliness, hunger, happiness, typeGame, typePet)VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmtPrepare.setString(1, pet.getName());
            stmtPrepare.setDouble(2, pet.getHealth());
            stmtPrepare.setDouble(3, pet.getThirst());
            stmtPrepare.setDouble(4, pet.getCleanliness());
            stmtPrepare.setDouble(5, pet.getHunger());
            stmtPrepare.setDouble(6, pet.getHappiness());
            stmtPrepare.setInt(7, pet.getTypeGame());
            stmtPrepare.setInt(8, pet.getType());

            stmtPrepare.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void savePet(Pet pet) {
        try {
            PreparedStatement stmtPrepare = con.prepareStatement("UPDATE Pets SET health = ?, thirst = ?,cleanliness = ?, hunger = ?, happiness = ? WHERE name = ?");
            stmtPrepare.setDouble(1, pet.getHealth());
            stmtPrepare.setDouble(2, pet.getThirst());
            stmtPrepare.setDouble(3, pet.getCleanliness());
            stmtPrepare.setDouble(4, pet.getHunger());
            stmtPrepare.setDouble(5, pet.getHappiness());
            stmtPrepare.setString(6, pet.getName());
            stmtPrepare.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isExistsPet(String namePet) {
        try {
            PreparedStatement stmtPrepare = con.prepareStatement("SELECT id from Pets WHERE name = ? LIMIT 1");
            stmtPrepare.setString(1, namePet);
            ResultSet rs = stmtPrepare.executeQuery();

            if (rs.next()) {
                rs.close();
                return true;
            }
            rs.close();
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public ArrayList<Pet> getAllPet() {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        try {
            PreparedStatement stmtPrepare = con.prepareStatement("SELECT * FROM Pets");;
            ResultSet rs = stmtPrepare.executeQuery();;


//            while (rs.next()) {
//
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pets;
    }

    @Override
    public void deletePet(Pet pet) {

    }
}
