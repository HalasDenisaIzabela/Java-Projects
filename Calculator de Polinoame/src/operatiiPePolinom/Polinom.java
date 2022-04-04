package operatiiPePolinom;

import java.util.*;

public class Polinom implements Comparator<Monom> {
    private List<Monom> polinom = new ArrayList<>();

    public Polinom() {
    }

    public Polinom(List<Monom> polinom) {
        this.polinom = polinom;
    }

    public Polinom(Polinom that) {
        List<Monom> pol = new ArrayList<>();
        for (Monom m : that.polinom) {
            pol.add(new Monom(m));
        }
        this.setPolinom(pol);
    }

    public List<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(List<Monom> polinom) {
        this.polinom = polinom;
    }

    public void adaugareMonom(Monom m) {
        this.polinom.add(m);
    }

    public Polinom invPol() {
        for (Monom m : this.getPolinom()) {
            m.setCoeficient(-m.getCoeficient());
        }
        return this;
    }

    @Override
    public String toString() {
        if (this.polinom.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (Monom m : this.polinom) {
            sb.append(m.toString());
            sb.append(" + ");
        }
        Operatii o = new Operatii();
        o.sortare(this);
        if(this.polinom.get(polinom.size()-1).getGrad() == 0)
        {
            if (this.polinom.get(polinom.size()-1).getCoeficient().intValue() == 0)
                return sb.substring(0, sb.toString().length() - 12);
            return sb.substring(0, sb.toString().length() - 6);
        }
        if(this.polinom.get(polinom.size()-1).getGrad() == 1)
            return sb.substring(0, sb.toString().length() - 5);
        return sb.substring(0, sb.toString().length() - 3);
    }

    @Override
    public int compare(Monom o1, Monom o2) {
        return o2.getGrad() - o1.getGrad();
    }
}
