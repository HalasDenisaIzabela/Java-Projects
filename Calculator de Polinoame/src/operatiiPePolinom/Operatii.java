package operatiiPePolinom;

import java.util.Collections;

public class Operatii {

    public Polinom sortare(Polinom p) {
        Collections.sort(p.getPolinom(), new Polinom());
        return p;
    }

    public Monom sum(Monom m1, Monom m2) {
        Double sum = 0.;
        Monom mSum = new Monom(0., m1.getGrad());
        if (m1.getGrad() == m2.getGrad()) {
            sum = m1.getCoeficient() + m2.getCoeficient();
            mSum.setCoeficient(sum);
            return mSum;
        } else {
            return new Monom();
        }
    }

    public Monom inm(Monom m1, Monom m2) {
        Double coef = 1.;
        Integer gr = 0;
        coef = m1.getCoeficient() * m2.getCoeficient();
        gr = m1.getGrad() + m2.getGrad();
        Monom mInm = new Monom(coef, gr);
        return mInm;
    }

    public Monom der(Monom m) {
        Double coef = 1.;
        Integer gr = 0;
        if (m.getGrad() > 0) {
            coef = m.getCoeficient() * m.getGrad();
            gr = m.getGrad() - 1;
            Monom mDer = new Monom(coef, gr);
            return mDer;
        } else if (m.getGrad() == 0) {
            coef = 0.;
            Monom mDer = new Monom(0., gr);
            return mDer;
        } else System.out.println("Nu se mai poate deriva");
        return null;
    }

    public Monom integr(Monom m) {
        Double coef = 1.;
        Integer gr = 0;

        coef = m.getCoeficient() / (m.getGrad() + 1);
        gr = m.getGrad() + 1;
        Monom mIntegr = new Monom(coef, gr);
        return mIntegr;
    }

    public Integer gradPol(Polinom p) {
        Integer gr;
        if (p == null)
            return 0;
        if (p.getPolinom().isEmpty())
            return 0;
        sortare(p);
        gr = p.getPolinom().get(0).getGrad();
        return gr;
    }

    public Monom monomDominant(Polinom p) {
        Monom m = new Monom();
        sortare(p);
        Integer gr = gradPol(p);
        for (Monom mon : p.getPolinom()) {
            if (mon.getGrad() == gr) {
                m.setGrad(gr);
                m.setCoeficient(mon.getCoeficient());
            }
        }
        return m;
    }

    public Monom impartire(Monom m1, Monom m2) {
        Monom m = new Monom();
        m.setGrad(m1.getGrad() - m2.getGrad());
        m.setCoeficient(m1.getCoeficient() / m2.getCoeficient());
        return m;
    }

    public Boolean polEgale(Polinom p1, Polinom p2) {
        Integer cnt = 0;
        for (Monom m1 : p1.getPolinom()) {
            for (Monom m2 : p2.getPolinom()) {
                if ((m1.getCoeficient().intValue() == m2.getCoeficient().intValue() && m1.getGrad() == m2.getGrad()))
                    cnt++;
            }
        }
        if (cnt == p1.getPolinom().size() && p1.getPolinom().size() == p2.getPolinom().size())
            return true;
        return false;
    }

    public Polinom sumPol(Polinom p1, Polinom p2) {
        Polinom pSum = new Polinom();
        Polinom p2Invp2 = new Polinom(p2);
        p2Invp2.invPol();
        if (polEgale(new Polinom(p1), new Polinom(p2Invp2))) {
            pSum = null;
            return pSum;
        }
        pSum.getPolinom().addAll(new Polinom(p1).getPolinom());
        pSum.getPolinom().addAll(new Polinom(p2).getPolinom());
        sortare(pSum);
        for (int i = 0; i < pSum.getPolinom().size() - 1; i++) {
            for (int j = i + 1; j < pSum.getPolinom().size(); j++) {
                if (pSum.getPolinom().get(i).getGrad() == pSum.getPolinom().get(j).getGrad()) {
                    pSum.getPolinom().get(i).setCoeficient(pSum.getPolinom().get(i).getCoeficient() +
                            pSum.getPolinom().get(j).getCoeficient());
                    pSum.getPolinom().remove(j);

                }

                if (pSum.getPolinom().get(i).getCoeficient() == 0) {
                    pSum.getPolinom().remove(i);
                    j--;
                    if (i != 0)
                        i--;
                }
            }
        }
        sortare(pSum);
        return pSum;
    }

    public Polinom difPol(Polinom p1, Polinom p2) {
        Polinom pDif = new Polinom();
        if (polEgale(new Polinom(p1), new Polinom(p2))) {
            pDif = null;
            return pDif;
        } else {
            Polinom p2Invp2 = new Polinom(p2);
            p2Invp2.invPol();
            pDif.getPolinom().addAll(new Polinom(p1).getPolinom());
            pDif.getPolinom().addAll(new Polinom(p2Invp2).getPolinom());
            sortare(pDif);
            for (int i = 0; i < pDif.getPolinom().size() - 1; i++) {
                for (int j = i + 1; j < pDif.getPolinom().size(); j++) {
                    if (pDif.getPolinom().get(i).getGrad() == pDif.getPolinom().get(j).getGrad()) {
                        pDif.getPolinom().get(i).setCoeficient(pDif.getPolinom().get(i).getCoeficient() +
                                pDif.getPolinom().get(j).getCoeficient());
                        pDif.getPolinom().remove(j);
                    }
                    if (pDif.getPolinom().get(i).getCoeficient() == 0) {
                        pDif.getPolinom().remove(i);
                        j--;
                        if (i != 0)
                            i--;
                    }
                }
            }
            sortare(pDif);
            return pDif;
        }
    }

    public Polinom inmutirelPol(Polinom p1, Polinom p2) {
        Polinom pInm = new Polinom();
        for (Monom m1 : p1.getPolinom()) {
            for (Monom m2 : p2.getPolinom()) {
                pInm.adaugareMonom(inm(m1, m2));
            }
        }
        Polinom p0 = new Polinom();
        Polinom pFinal = new Polinom();
        pFinal = sumPol(new Polinom(pInm), p0);

        return pFinal;
    }

    public String impartirePol(Polinom p1, Polinom p2) {
        if (gradPol(p2) == 0) {
            System.out.println("Nu se poate imparti cu 0");
            return null;
        } else {
            Polinom q = new Polinom();
            Polinom r = new Polinom(p1);
            while (gradPol(r) >= gradPol(p2) && gradPol(r) > 0) {
                Polinom t = new Polinom();
                t.adaugareMonom(impartire(monomDominant(r), monomDominant(p2)));
                q = sumPol(t, new Polinom(q));
                Polinom pInm = new Polinom(inmutirelPol(p2, t));
                r = difPol(r, pInm);
            }
            if (r != null)
                return "Catul este:    " + q.toString() + "    Restul este:    " + r.toString();
            else
                return "Catul este:    " + q.toString();

        }

    }

    public Polinom derivarePol(Polinom p) {
        Polinom pDer = new Polinom();
        for (Monom m : p.getPolinom()) {
            pDer.adaugareMonom(der(m));
        }
        sortare(pDer);
        return pDer;
    }

    public Polinom integrarePol(Polinom p) {
        Polinom pIntegr = new Polinom();
        for (Monom m : p.getPolinom()) {
            pIntegr.adaugareMonom(integr(m));
        }
        sortare(pIntegr);
        return pIntegr;
    }

}
