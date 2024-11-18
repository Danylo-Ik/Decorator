package ua.edu.ucu.apps.decorator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.cloud.vision.v1.ProductSearchResults.Result;

import lombok.SneakyThrows;

public class DBConnection {

    private static DBConnection dbconnection;
    private Connection connection;
    
    @SneakyThrows
    private DBConnection() {
        this.connection = DriverManager.getConnection("/Users/danyilikonnikov/Desktop/Coding/Labs/SEM_3/Lab_10/lab10/src/main/resources/cache.db");
    }

    @SneakyThrows
    public String getDocument(String gcsPath) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM documents WHERE gcsPath = ?");
        statement.setString(1, gcsPath);
        ResultSet result = statement.executeQuery();
        return result.getString("parsed");
    }

    static DBConnection getInstance() {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }

    @SneakyThrows
    public void createDocument(String gcsPath, String parse) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO DOCUMENT (path, parsed) VALUES (?, ?)");
        statement.setString(1, gcsPath);
        statement.setString(2, parse);
        statement.executeUpdate();
        statement.close();
    }
}
