package testeOperatiiPolinoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import operatiiPePolinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class IntegrareTest {

    @Test
    void integrarePol() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);

        Monom m3 = new Monom(2., 2);
        Monom m4 = new Monom(1., 0);

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

        assertEquals("1.0x^3 + 2.5x^2", o.integrarePol(p1).toString());
        assertNotEquals("0.66x^3 + 1.0x", o.integrarePol(p2).toString());
        assertEquals("0.25x^8", o.integrarePol(p3).toString());
    }
}