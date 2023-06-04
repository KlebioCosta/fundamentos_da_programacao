package Ultilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat limitadorDecimal = new DecimalFormat();

    public static String doubleToString(Double valor) {
        return limitadorDecimal.format(valor);
    }


}
