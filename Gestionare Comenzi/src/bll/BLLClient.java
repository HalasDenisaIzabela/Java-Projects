package bll;

import dao.DAOClient;
import model.Client;

import java.util.List;

public class BLLClient extends BLLClasaAbstracta<Client> {
    private final DAOClient clientDAO;

    public BLLClient() {
        super(new DAOClient());
        clientDAO = (DAOClient) dao;
    }
}
