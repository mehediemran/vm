package vehicle.modeling;

/**
 * User: Atiqur Rahman
 * Date: 6/15/12 9:27 PM
 */
public class Utils {
    public static boolean isEmpty(String data) {
        return data == null || data.length() == 0;
    }
    public static boolean isNotEmpty(String data) {
        return !isEmpty(data);
    }
}
