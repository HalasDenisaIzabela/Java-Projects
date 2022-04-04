package testeOperatiiPolinoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import operatiiPePolinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpartireTest {

    @Test
    void impartirePol() {
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

        assertEquals("Catul este:    1.5    Restul este:    5.0x^1 + -1.5", o.impartirePol(p1, p2).toString());
        assertEquals("Catul este:        Restul este:    2.0", o.impartirePol(p3, p4).toString());
        assertNotEquals("4.0x^2 + 2.0", o.impartirePol(p2, p4).toString());
    }
}