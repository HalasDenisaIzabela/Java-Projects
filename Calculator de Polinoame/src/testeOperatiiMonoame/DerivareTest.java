package testeOperatiiMonoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DerivareTest {

    @Test
    void der() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);
        Monom m3 = new Monom(2., 0);

        Operatii o = new Operatii();

        assertEquals("6.0x^1", o.der(m1).toString());
        assertEquals("5.0x^0", o.der(m2).toString());
        assertNotEquals("1.0x^0", o.der(m3).toString());
    }
}