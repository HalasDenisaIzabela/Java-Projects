package testeOperatiiMonoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import operatiiPePolinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumaTest {

    @Test
    void sum() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);
        Monom m3 = new Monom(2., 2);
        Monom m4 = new Monom(1., 0);
        Monom m5 = new Monom(7., 0);

        Operatii o = new Operatii();

        assertEquals("5.0x^2", o.sum(m1, m3).toString());
        assertEquals("nullx^null", o.sum(m1, m2).toString());
        assertNotEquals("5.0x^0", o.sum(m4, m5).toString());
    }
}