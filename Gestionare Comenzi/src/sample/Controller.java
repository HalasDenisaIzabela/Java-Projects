package sample;

import bll.BLLClient;
import bll.BLLComanda;
import bll.BLLProdus;
import bll.BonFiscal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Client;
import model.Comanda;
import model.Produs;

public class Controller {

    public ListView<Produs> produse;
    public ListView<Comanda> comenzi;
    public ListView<Client> clienti;

    public TextField id;
    public TextField nume;
    public TextField email;
    public TextField adresa;
    public TextField varsta;

    public TextField idp;
    public TextField numep;
    public TextField categoriep;
    public TextField pretp;
    public TextField cantitatep;

    public TextField cantitateC;
    public TextField idC;
    public TextField idP;

    public ListView<Client> clComenzi;
    public ListView<Produs> prodComenzi;
    public Label cantitatePreaMare;

    private ObservableList<Comanda> comandaObservableList;
    private ObservableList<Produs> produsObservableList;
    private ObservableList<Client> clientObservableList;


    BLLClient bllClient = new BLLClient();
    BLLProdus bllProdus = new BLLProdus();
    BLLComanda bllComanda = new BLLComanda();
    BonFiscal bonFiscal = new BonFiscal();

    public void initialize() {
        actualizareClienti();
        actualizareComenzi();
        actualizareProduse();
        cantitatePreaMare.setVisible(false);
    }

    public void creareComanda() throws IllegalAccessException {
        Comanda comanda = new Comanda(1, Integer.parseInt(idC.getText()), Integer.parseInt(idP.getText()), Integer.parseInt(cantitateC.getText()));

        Produs produs = prodComenzi.getSelectionModel().getSelectedItem();
        if (produs.getCantitateProdus() >= Integer.parseInt(cantitateC.getText())) {
            bllComanda.adauga(comanda);
            actualizareComenzi();
            bonFiscal.scriereInFisier("BonFiscal.txt", comanda.toString());
            produs.setCantitateProdus(produs.getCantitateProdus() - Integer.parseInt(cantitateC.getText()));

            bllProdus.modifica(produs);
            actualizareProduse();
            cantitatePreaMare.setVisible(false);
        } else
            cantitatePreaMare.setVisible(true);

    }

    public void addClient() throws IllegalAccessException {
        Client newClient = new Client(Integer.parseInt(id.getText()),
                nume.getText(), adresa.getText(), email.getText(), Integer.parseInt(varsta.getText()));
        bllClient.adauga(newClient);
        actualizareClienti();
    }

    public void findClient() throws IllegalAccessException {
        Client client = bllClient.gasesteDupaID(Integer.parseInt(id.getText()));
        clientObservableList = FXCollections.observableArrayList();
        clientObservableList.add(client);
        clienti.setItems(clientObservableList);
    }

    public void deleteClient() throws IllegalAccessException {
        Client newClient = new Client(Integer.parseInt(id.getText()),
                nume.getText(), adresa.getText(), email.getText(), Integer.parseInt(varsta.getText()));
        bllClient.sterge(newClient.getId());
        actualizareClienti();
    }

    public void findProdus() throws IllegalAccessException {
        Produs produs = bllProdus.gasesteDupaID(Integer.parseInt(idp.getText()));
        produsObservableList = FXCollections.observableArrayList();
        produsObservableList.add(produs);
        produse.setItems(produsObservableList);
    }

    public void deleteProdus() throws IllegalAccessException {
        Produs newProdus = new Produs(Integer.parseInt(idp.getText()),
                numep.getText(), categoriep.getText(), Double.parseDouble(pretp.getText()), Integer.parseInt(cantitatep.getText()));
        bllProdus.sterge(newProdus.getId());
        actualizareProduse();
    }

    public void modificareClient() throws IllegalAccessException {
        Client newClient = new Client(Integer.parseInt(id.getText()),
                nume.getText(), adresa.getText(), email.getText(), Integer.parseInt(varsta.getText()));
        bllClient.modifica(newClient);
        actualizareClienti();
    }

    public void modificareProdus() throws IllegalAccessException {
        Produs newProdus = new Produs(Integer.parseInt(idp.getText()),
                numep.getText(), categoriep.getText(), Double.parseDouble(pretp.getText()), Integer.parseInt(cantitatep.getText()));
        bllProdus.modifica(newProdus);
        actualizareProduse();
    }

    public void selectClient() {
        Client client = clienti.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(client.getId()));
        email.setText(client.getEmail());
        adresa.setText(client.getAdresa());
        varsta.setText(String.valueOf(client.getVarsta()));
        nume.setText(client.getNume());
    }

    public void selectProdus() {
        Produs produs = produse.getSelectionModel().getSelectedItem();
        idp.setText(String.valueOf(produs.getId()));
        numep.setText(produs.getNume());
        categoriep.setText(produs.getCategorie());
        pretp.setText(String.valueOf(produs.getPret()));
        cantitatep.setText(String.valueOf(produs.getCantitateProdus()));
    }

    public void addProdus() throws IllegalAccessException {
        Produs newProdus = new Produs(Integer.parseInt(idp.getText()),
                numep.getText(), categoriep.getText(), Double.parseDouble(pretp.getText()), Integer.parseInt(cantitatep.getText()));
        bllProdus.adauga(newProdus);
        actualizareProduse();
    }

    public void actualizareClienti() {
        clientObservableList = FXCollections.observableArrayList();
        clientObservableList.addAll(bllClient.gasesteTot());
        clienti.setItems(clientObservableList);
        clComenzi.setItems(clientObservableList);
    }

    public void actualizareProduse() {
        produsObservableList = FXCollections.observableArrayList();
        produsObservableList.addAll(bllProdus.gasesteTot());
        produse.setItems(produsObservableList);
        prodComenzi.setItems(produsObservableList);


    }

    public void actualizareComenzi() {
        comandaObservableList = FXCollections.observableArrayList();
        comandaObservableList.addAll(bllComanda.gasesteTot());
        comenzi.setItems(comandaObservableList);
    }

    public void selectClientC() {
        Client client = clComenzi.getSelectionModel().getSelectedItem();
        idC.setText(String.valueOf(client.getId()));

    }

    public void selectProdusC() {
        Produs produs = prodComenzi.getSelectionModel().getSelectedItem();
        idP.setText(String.valueOf(produs.getId()));
    }
}
