package dao;

import conexiune.ConexiuneMYSQL;

import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class DAOClasaAbstracta<T> {

    public static final String SELECTARE_TOT = "SELECT * FROM `%tabel%`;";
    public static final String SELECTARE_DUPA_CAMP = "SELECT * FROM `%tabel%` WHERE `%camp%` = ?;";
    public static final String INSERARE_NOU = "INSERT INTO `%tabel%` (%campuri%) VALUES (%valori_camp%);";
    public static final String MODIFICARE_DUPA_CAMP = "UPDATE `%tabel%` SET %campuri% WHERE %camp% = ?;";
    public static final String STERGERE_DUPA_CAMP = "DELETE FROM `%tabel%` WHERE `%camp%` = ?;";

    protected static final Logger LOGGER = Logger.getLogger(DAOClasaAbstracta.class.getName());

    private final ObjectGenerator<T> objectGenerator;
    protected final Class<T> type;

    public DAOClasaAbstracta(Class<T> type) {
        this.type = type;
        objectGenerator = new ObjectGenerator<>(type);
    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    public List<T> gasesteTot() {
        String query = SELECTARE_TOT.replace("%tabel%", type.getSimpleName());

        ResultSet resultSet = null;
        try (Connection connection = ConexiuneMYSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            resultSet = preparedStatement.executeQuery();

            return objectGenerator.createObjectsByResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                ConexiuneMYSQL.close(resultSet);
            }
        }

        return Collections.emptyList();
    }

    public Optional<T> gasesteDupaID(int id) {
        String query = SELECTARE_DUPA_CAMP
                .replace("%tabel%", type.getSimpleName())
                .replace("%camp%", "id");

        ResultSet resultSet = null;
        try (Connection connection = ConexiuneMYSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            return Optional.of(objectGenerator.createObjectByResultSet(resultSet));
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getSimpleName() + "DAO:gasesteDupaID " + e.getMessage());
        } finally {
            if (resultSet != null) {
                ConexiuneMYSQL.close(resultSet);
            }
        }

        return Optional.empty();
    }


    private String campuriInStringuri(T t) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : type.getDeclaredFields())
            if (!field.getName().equals("id"))
            {
                stringBuilder.append(field.getName()).append(", ");
            }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    private String valoriCampInStrig(T t) throws IllegalAccessException {
        StringBuilder valori = new StringBuilder();
        for (Field field : type.getDeclaredFields())
            if (!field.getName().equals("id"))
            {

                field.setAccessible(true);
                //valori.append("'").append(field.get(t)).append("', ");
                valori.append(field.getName()).append(" = '").append(field.get(t)).append("', ");
            }
        return valori.substring(0, valori.length() - 2);
    }
    private String valoriCampInStrig1(T t) throws IllegalAccessException {
        StringBuilder valori = new StringBuilder();
        for (Field field : type.getDeclaredFields())
            if (!field.getName().equals("id"))
            {

                field.setAccessible(true);
                //valori.append("'").append(field.get(t)).append("', ");
                valori.append("'").append(field.get(t)).append("', ");
            }
        return valori.substring(0, valori.length() - 2);
    }

    private String valoriCampInStrig(T t, String fieldName) throws IllegalAccessException {
        StringBuilder valori = new StringBuilder();
        for (Field field : type.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                return String.valueOf(field.get(t));
            }
        }
        return "";
    }

    private String campuriSiValoriInString(T t, String... ignoredFields) {
        return Arrays.stream(type.getDeclaredFields()).filter(field -> Arrays.stream(ignoredFields).noneMatch(ignoredField -> ignoredField.equalsIgnoreCase(field.getName()))).map(field -> {
            try {
                field.setAccessible(true);
                return field.getName() + " = '" + field.get(t) + "'";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        }).collect(Collectors.joining(", "));
    }

    public T adauga(T t) throws IllegalAccessException {
        String query = INSERARE_NOU
                .replace("%tabel%", type.getSimpleName())
                .replace("%campuri%", campuriInStringuri(t))
                .replace("%valori_camp%", valoriCampInStrig1(t));

        System.out.println(query);
        try (Connection connection = ConexiuneMYSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    public T modifica(T t) throws IllegalAccessException {
        String query = MODIFICARE_DUPA_CAMP.replace("%tabel%", type.getSimpleName())
                .replace("%campuri%", valoriCampInStrig(t))
                .replace("%camp%", "id");
        System.out.println(query);

        try (Connection connection = ConexiuneMYSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, Integer.parseInt(valoriCampInStrig(t, "id")));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }

    public boolean sterge(int id) {
        String query = STERGERE_DUPA_CAMP
                .replace("%tabel%", type.getSimpleName())
                .replace("%camp%", "id");

        try (Connection connection = ConexiuneMYSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

