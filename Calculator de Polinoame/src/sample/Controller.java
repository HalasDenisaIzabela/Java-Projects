package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import operatiiPePolinom.*;

public class Controller {

    public Button adunare;
    public Button scadere;
    public Button inmultire;
    public Button impartire;
    public Button derivare;
    public Button integrare;

    public TextField t1;
    public TextField t2;
    public TextField tRez;

    public void apasButonAdunare(javafx.event.ActionEvent actionEvent) {

        tRez.clear();
        RegexClass r = new RegexClass();
        Operatii o = new Operatii();
        Polinom pRez = new Polinom();
        Polinom p1 = r.stringInPolinom(t1.getText());
        Polinom p2 = r.stringInPolinom(t2.getText());
        pRez = o.sumPol(p1,p2);
        if(pRez == null)
            tRez.setText("0");
        tRez.setText(pRez.toString());
    }

    public void apasButonScadere(ActionEvent actionEvent) {
        tRez.clear();
        RegexClass r = new RegexClass();
        Operatii o = new Operatii();
        Polinom pRez = new Polinom();
        Polinom p1 = r.stringInPolinom(t1.getText());
        Polinom p2 = r.stringInPolinom(t2.getText());
        pRez = o.difPol(p1,p2);
        if(pRez == null)
            tRez.setText("0");
        tRez.setText(pRez.toString());
    }

    public void apasButonInmultire(ActionEvent actionEvent) {
        tRez.clear();
        RegexClass r = new RegexClass();
        Operatii o = new Operatii();
        Polinom pRez = new Polinom();
        Polinom p1 = r.stringInPolinom(t1.getText());
        Polinom p2 = r.stringInPolinom(t2.getText());
        pRez = o.inmutirelPol(p1,p2);
        tRez.setText(pRez.toString());
    }

    public void apasButonImpartire(ActionEvent actionEvent) {
        tRez.clear();
        RegexClass r = new RegexClass();
        Operatii o = new Operatii();
        String pRez;
        Polinom p1 = r.stringInPolinom(t1.getText());
        Polinom p2 = r.stringInPolinom(t2.getText());
        pRez = o.impartirePol(p1,p2);
        tRez.setText(pRez.toString());
    }

    public void apasButonDerivare(ActionEvent actionEvent) {
        tRez.clear();
        RegexClass r = new RegexClass();
        Operatii o = new Operatii();
        Polinom pRez = new Polinom();
        Polinom p = r.stringInPolinom(t1.getText());
        pRez = o.derivarePol(p);
        tRez.setText(pRez.toString());
    }

    public void apasButonIntegrare(ActionEvent actionEvent) {
        tRez.clear();
        RegexClass r = new RegexClass();
        Operatii o = new Operatii();
        Polinom pRez = new Polinom();
        Polinom p = new Polinom(r.stringInPolinom(t1.getText()));
        pRez = o.integrarePol(p);
        tRez.setText(pRez.toString());
    }
}
