package testeOperatiiMonoame;

import operatiiPePolinom.Monom;
import operatiiPePolinom.Operatii;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpartireTest {

    @Test
    void impartire() {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);
        Monom m3 = new Monom(2., 2);
        Monom m4 = new Monom(1., 0);
        Monom m5 = new Monom(7., 0);

        Operatii o = new Operatii();

        assertEquals("1.5x^0", o.impartire(m1, m3).toString());
        assertEquals("0.6x^1", o.impartire(m1, m2).toString());
        assertNotEquals("0.14x^0", o.impartire(m4, m5).toString());
    }
}