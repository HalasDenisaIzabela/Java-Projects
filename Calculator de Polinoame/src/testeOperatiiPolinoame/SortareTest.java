package testeOperatiiPolinoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import operatiiPePolinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortareTest {

    @Test
    void sortare() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);

        Monom m3 = new Monom(2., 2);
        Monom m4 = new Monom(1., 0);

        Monom m5 = new Monom(2., 7);

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom p3 = new Polinom();

        p1.adaugareMonom(m4);
        p1.adaugareMonom(m1);
        p1.adaugareMonom(m2);

        p2.adaugareMonom(m3);
        p2.adaugareMonom(m5);
        p2.adaugareMonom(m4);

        p3.adaugareMonom(m4);
        p3.adaugareMonom(m2);
        p3.adaugareMonom(m5);

        Operatii o = new Operatii();

        assertEquals("3.0x^2 + 5.0x^1 + 1.0", o.sortare(p1).toString());
        assertEquals("2.0x^7 + 2.0x^2 + 1.0", o.sortare(p2).toString());
        assertNotEquals("2.0x^7 + 8.0x^1 + 1.0", o.sortare(p3).toString());
    }
}