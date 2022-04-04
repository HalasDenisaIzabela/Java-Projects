package testeOperatiiMonoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegrareTest {

    @Test
    void integr() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);
        Monom m3 = new Monom(1., 3);

        Operatii o = new Operatii();

        assertEquals("1.0x^3", o.integr(m1).toString());
        assertEquals("2.5x^2", o.integr(m2).toString());
        assertNotEquals("0.2x^4", o.integr(m3).toString());
    }
}