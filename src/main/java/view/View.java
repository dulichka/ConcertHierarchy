package view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class displays messages on console.
 *
 * @author dulichka
 */

public class View {

    public static String SINGLE_INPUT = "single.input";
    public static String INPUT_STRING_DATA = "input.string.data";
    public static String WRONG_INPUT_TYPE = "input.wrong.data";
    public static String SORT_PARAMETER = "input.sort.parameter";
    public static String PICK_PARAMETER = "input.pick.parameter";
    public static String MESSAGES_BUNDLE_NAME = "messages";
    public static String CONCERTS_INFO = "concerts.info";
    public static String LOCATION_INPUT = "input.location";

    public static final ResourceBundle bundle;
    static {
         bundle =
                ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("en"));
    }

    public View(){

    }

    public void printMessage(String message){
        System.out.println(message);
    }

    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(SINGLE_INPUT),
                bundle.getString(message)));
    }
}
