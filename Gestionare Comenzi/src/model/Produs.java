package model;

public class Produs {
    public int id;
    public String nume;
    public String categorie;
    public double pret;
    public int cantitateProdus;

    public Produs() {
    }

    public Produs(int id, String nume, String categorie, double pret, int cantitateProdus) {
        this.id = id;
        this.nume = nume;
        this.categorie = categorie;
        this.pret = pret;
        this.cantitateProdus = cantitateProdus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", categorie='" + categorie + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitateProdus +
                '}';
    }
}
