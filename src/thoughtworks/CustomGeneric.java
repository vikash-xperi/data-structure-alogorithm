package thoughtworks;

import java.math.BigDecimal;
import java.util.Comparator;

public class CustomGeneric implements Comparator<Number> {
    @Override
    public int compare(Number a, Number b){
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
}
