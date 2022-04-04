package model;

public class Comanda {
    public int id;
    public int idClient;
    public int idProdus;
    public int cantitateProdus;

    public Comanda() {
    }

    public Comanda(int id, int idClient, int idProdus, int cantitate) {
        this.id = id;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.cantitateProdus = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idProdus=" + idProdus +
                ", cantitate=" + cantitateProdus +
                '}'+ "\n";
    }
}
