/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GlobalPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 *
 * @author Mohab
 */
public class Global {
    

    public static String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public static void sql_write(String query) {
        try {
            String connectionString = "jdbc:sqlserver://DESKTOP-GMJ1OFI;Database=coworking_space;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";
            try (Connection connection = DriverManager.getConnection(connectionString)) {
                PreparedStatement st = connection.prepareStatement(query);
                st.executeUpdate();

                st.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static ResultSet sql_read(String query) {
        String connectionString = "jdbc:sqlserver://DESKTOP-GMJ1OFI;Database=coworking_space;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int current_room_id;
}
