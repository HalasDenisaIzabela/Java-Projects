package conexiune;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexiuneMYSQL {


        private static final Logger LOGGER = Logger.getLogger(ConexiuneMYSQL.class.getName());
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String DBURL = "jdbc:mysql://localhost:3306/tema3TPCompanie";
        private static final String USER = "root";
        private static final String PASS = "Izibibi1";

        private static ConexiuneMYSQL singleInstance = new ConexiuneMYSQL();

        private ConexiuneMYSQL() {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private Connection createConnection() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(DBURL, USER, PASS);
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
                e.printStackTrace();
            }
            return connection;
        }

        public static Connection getConnection() {
            return singleInstance.createConnection();
        }

        public static void close(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
                }
            }
        }

        public static void close(Statement statement) {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
                }
            }
        }

        public static void close(ResultSet resultSet) {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
                }
            }
        }
    }


