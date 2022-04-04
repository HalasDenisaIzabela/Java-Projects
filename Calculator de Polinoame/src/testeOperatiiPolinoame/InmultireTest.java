package testeOperatiiPolinoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import operatiiPePolinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InmultireTest {

    @Test
    void inmutirelPol() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);

        Monom m3 = new Monom(2., 2);
        Monom m4 = new Monom(1., 0);

        Monom m5 = new Monom(2., 0);

        Monom m6 = new Monom(1., 3);

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom p3 = new Polinom();
        Polinom p4 = new Polinom();

        p1.adaugareMonom(m1);
        p1.adaugareMonom(m2);

        p2.adaugareMonom(m3);
        p2.adaugareMonom(m4);

        p3.adaugareMonom(m5);

        p4.adaugareMonom(m6);

        Operatii o = new Operatii();

        assertEquals("6.0x^4 + 10.0x^3 + 3.0x^2 + 5.0x", o.inmutirelPol(p1, p2).toString());
        assertEquals("2.0x^3", o.inmutirelPol(p3, p4).toString());
        assertNotEquals("4.0x^2 + 2.5", o.inmutirelPol(p2, p3).toString());
    }
}