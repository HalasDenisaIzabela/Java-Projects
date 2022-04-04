package bll;

import dao.DAOClasaAbstracta;
import dao.DAOComanda;
import model.Client;
import model.Comanda;
import model.Produs;

import java.util.List;

public class BLLComanda extends BLLClasaAbstracta<Comanda> {

    public BLLComanda() {
        super(new DAOComanda());
    }
}
