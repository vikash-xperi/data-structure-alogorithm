package revisionback.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Tenable2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=Afghanistan");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(responseStream));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        String response = content.toString();
        System.out.println(response);
        if (response == null || response.equals("")) {

        }
        String[] split = response.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("callingCodes")) {
                System.out.println(split[i]);
                String[] split1 = split[i].split(":");
                char[] chars = split1[1].toCharArray();
                boolean first = false;
                for (int j = chars.length - 1; j >= 0; j--) {
                    if (chars[j] >= 48 && chars[j] <= 57) {
                        sb.append(chars[j]);
                    }
                    if (first) break;;
                    if (chars[i] == 34) {
                        first = true;
                    }
                }
            } else {

            }
        }
        System.out.println(sb.toString());

    }
}
