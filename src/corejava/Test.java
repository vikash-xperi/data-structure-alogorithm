package corejava;


import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String FAILED_TO_PROCESS_API_REQUEST = "%sFailure";
        String requestType = "linearStationPolicyPublish";
        System.out.println(String.format(FAILED_TO_PROCESS_API_REQUEST, requestType));
    }
}
