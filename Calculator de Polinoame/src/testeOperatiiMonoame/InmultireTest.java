package testeOperatiiMonoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InmultireTest {

    @Test
    void inm() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);
        Monom m3 = new Monom(2., 2);
        Monom m4 = new Monom(1., 0);
        Monom m5 = new Monom(7., 0);

        Operatii o = new Operatii();

        assertEquals("6.0x^4", o.inm(m1, m3).toString());
        assertEquals("15.0x^3", o.inm(m1, m2).toString());
        assertNotEquals("1.0x^0", o.inm(m4, m5).toString());
    }
}