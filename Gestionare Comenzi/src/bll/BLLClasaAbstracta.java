package bll;

import dao.DAOClasaAbstracta;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class BLLClasaAbstracta<T> {

    protected final DAOClasaAbstracta<T> dao;

    public BLLClasaAbstracta(DAOClasaAbstracta<T> dao) {
        this.dao = dao;
    }


    public List<T> gasesteTot() {
        return dao.gasesteTot();
    }

    public T gasesteDupaID(int id) {
        return dao.gasesteDupaID(id).orElseThrow(NoSuchElementException::new);
    }

    public T adauga(T t) throws IllegalAccessException {
        return dao.adauga(t);
    }

    public T modifica(T t) throws IllegalAccessException {
        return dao.modifica(t);
    }

    public boolean sterge(int id) {
        return dao.sterge(id);
    }

}
