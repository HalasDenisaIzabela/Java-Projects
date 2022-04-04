package dao;

import conexiune.ConexiuneMYSQL;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class DAOClient extends DAOClasaAbstracta<Client>{
    public DAOClient() {
        super(Client.class);
    }

}
