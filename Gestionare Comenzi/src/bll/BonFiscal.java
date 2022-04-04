package bll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BonFiscal {
    public void scriereInFisier(String s, String continut)
    {
        try {
            File f = new File(s);
            FileWriter fileWriter = new FileWriter(s);
            fileWriter.write(continut);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Eroare!");
            e.printStackTrace();
        }
    }
}
