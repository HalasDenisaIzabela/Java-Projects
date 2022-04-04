package operatiiPePolinom;

public class MainOperatii {
    public static void main(String[] args) {
        Monom m1 = new Monom(3., 2);
        Monom m2 = new Monom(5., 1);
        Monom m5 = new Monom(4., 1);



        Monom m3 = new Monom(2., 1);
        Monom m4 = new Monom(1., 0);
        Monom m6 = new Monom(4., 1);


        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1.adaugareMonom(m1);
        p1.adaugareMonom(m2);
        //p1.adaugareMonom(m5);


        p2.adaugareMonom(m3);
        p2.adaugareMonom(m4);
        //p2.adaugareMonom(m6);


        Operatii o = new Operatii();

        System.out.println("p1:  " + p1);
        System.out.println("p2:  " + p2);
        //System.out.println(o.gradPol(p1));
        //System.out.println("Adunare:  " + o.sumPol(p1, p2));
        //System.out.println("Scadere:  " + o.difPol(p1, p2));
        //System.out.println("Inmultire:  " + o.inmutirelPol(p1, p2));
        //System.out.println("Derivare:  " + o.derivarePol(p1));
        //System.out.println("Integrare:  " + o.integrarePol(p2));
        System.out.println("Impartire:   " + o.impartirePol(p1, p2));
        //System.out.println(o.impartire(m1, m3));


    }
}
