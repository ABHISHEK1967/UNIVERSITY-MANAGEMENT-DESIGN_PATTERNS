package edu.dalhousie.database;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseConnectivityTest {

    private static DatabaseConnectivity databaseConnection;

    @BeforeAll
    @Test
    public static void initialize() {
        databaseConnection = DatabaseConnectivity.getInstance();
    }

    @Test
    @DisplayName("Test database connectivity")
    @Order(1)
    public void getDatabaseConnection() {
        Assertions.assertDoesNotThrow(() -> databaseConnection.getDatabaseConnection(),
                "Failed to establish a connection with the database.");
    }

    @Test
    @DisplayName("Clear database connection")
    @Order(2)
    public void clearDatabaseConnection() {
        Assertions.assertDoesNotThrow(() -> databaseConnection.clearDatabaseConnection(),
                "Failed to clear the database connection.");
    }
}
