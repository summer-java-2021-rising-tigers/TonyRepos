import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void main (String[] args) throws SQLException {
        DBclass db = new DBclass();
        db.getData();
    }

}

class DBclass {

    public void getData() throws SQLException {

        try {
            Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root", "");
            Statement queryManager = databaseConnection.createStatement();
            ResultSet collection = queryManager.executeQuery("SELECT CharacterName, Strength, Dexterity, \r\n"
                    + "Constitution, Intelligence, Wisdom, Charisma, ArmorClass, Initiative, Speed\r\n"
                    + "FROM characterinfo;");

            while(collection.next()) {
                String characterName = collection.getString("CharacterName");
                String strength = collection.getString("Strength");
                String dexterity = collection.getString("Dexterity");
                String constitution = collection.getString("Constitution");
                String intelligence = collection.getString("Intelligence");
                String wisdom = collection.getString("Wisdom");
                String charisma = collection.getString("Charisma");
                String armorClass = collection.getString("ArmorClass");
                String initiative = collection.getString("Initiative");
                String speed = collection.getString("Speed");

                System.out.println(characterName + " " + strength + " " + dexterity + " " + constitution +
                        " " + intelligence + " " + wisdom + " " + charisma + " " + armorClass + " " + initiative + " " + speed);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}