package bll;

import dao.DAOProdus;
import model.Produs;
import java.util.List;

public class BLLProdus extends BLLClasaAbstracta<Produs> {
    public BLLProdus() {
        super(new DAOProdus());
    }
}
