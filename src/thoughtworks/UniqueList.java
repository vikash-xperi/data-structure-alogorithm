package thoughtworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Vikash");
        list.add("Kumar");
        list.add("Vikash");
        list.add("Singh");
        list.add("Kumar");
        System.out.println(deDuplicate(list));
    }
    public static List<String> deDuplicate(List<String> duplicateList) {
        Set<String> set = new HashSet<>();
        set.addAll(duplicateList);
        return new ArrayList<>(set);
    }
}
