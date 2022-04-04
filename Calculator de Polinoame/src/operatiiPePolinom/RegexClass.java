package operatiiPePolinom;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexClass {
    public Polinom stringInPolinom(String s) {
        Pattern separatori = Pattern.compile("([+-]?[^-+]+)");
        Matcher m = separatori.matcher(s);
        Polinom p = new Polinom();
        while (m.find()) {
            String[] sFaraX = m.group(1).replaceAll("x", " ").split(" ");
            Monom mon = new Monom();
            for (String str : sFaraX) {
                System.out.println(str);
                if (str.contains("^")) {
                    str = str.replace("^", "");
                    mon.setGrad(Integer.parseInt(str));
                }
                else {
                    switch (str) {
                        case "" -> mon.setCoeficient(1.);
                        case "-" -> mon.setCoeficient(-1.);
                        case "+" -> mon.setCoeficient(Double.parseDouble(str + 1));
                        default -> mon.setCoeficient(Double.parseDouble(str));
                    }
                }
            }
            p.adaugareMonom(mon);
        }
        return p;
    }
}
