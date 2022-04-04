package testeOperatiiPolinoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import operatiiPePolinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinoameEgaleTest {

    @Test
    void polEgale() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);

        Monom m3 = new Monom(3., 2);
        Monom m4 = new Monom(5., 1);

        Monom m5 = new Monom(2., 7);

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom p3 = new Polinom();

        p1.adaugareMonom(m1);
        p1.adaugareMonom(m2);

        p2.adaugareMonom(m3);
        p2.adaugareMonom(m4);

        p3.adaugareMonom(m5);

        Operatii o = new Operatii();

        assertEquals("true", o.polEgale(p1, p2).toString());
        assertEquals("false", o.polEgale(p2, p3).toString());
        assertNotEquals("true", o.polEgale(p3, p1).toString());
    }
}