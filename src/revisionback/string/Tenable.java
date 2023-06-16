package revisionback.string;

import java.util.*;

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] split1 = o1.split("/");
        String[] split2 = o2.split("/");
        if (split1.length == 1 && split2.length == 1) {
            return Integer.parseInt(o1) < Integer.parseInt(o2) ? -1 : 1;
        }
        if (split1.length < split2.length)
            return -1;
        else if (split1.length > split2.length)
            return 1;
        else {
            for (int i = 0; i < split1.length; i++) {
                if (Integer.parseInt(split1[i]) <= Integer.parseInt(split2[i]))
                    return -1;
                else
                    return 1;
            }
        }
        return 0;
    }
}

public class Tenable {
    public static void main(String[] args) {

        String[] requests = {"https://api.example.com/resource6/resource21/",
                "https://api.example.com/resource951/id60/resource115/",
                "https://api.example.com/resource535/id52/id57/id53/"};
        System.out.println(getResourceList(Arrays.asList(requests)));
    }

    public static List<String> getResourceList(List<String> requests) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String request : requests) {
            String[] split = request.split("/");
            StringBuilder str = new StringBuilder();
            for (String s : split) {
                if (s.startsWith("resource")) {
                    if (str.toString().equals("")) {
                        str = new StringBuilder(s.substring(8));
                    } else {
                        str.append("/").append(s.substring(8));
                    }
                }
            }
            list.add(str.toString());
        }
        Collections.sort(list, new MyComparator());
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split("/");
            if (split.length > 1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < split.length; j++) {
                    if (sb.toString().equals("")) {
                        sb = new StringBuilder("resource" + split[j]);
                    } else {
                        sb.append("/").append("resource" + split[j]);
                    }
                }
                ans.add(sb.toString());
            } else {
                ans.add("resource" + list.get(i));
            }
        }
        return ans;
    }
}
