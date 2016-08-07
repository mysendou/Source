package StringUtils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheStringUtils {
    /**
     *  Check the string contains how many tag
     * @param string
     * @param tag
     * @return
     */
    private static int getTagCount(String string, String tag) {
        Pattern pattern = Pattern.compile(tag);
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
    
    /**
     * Get the tag position base on the number
     * @param string
     * @param mapString
     * @param num
     * @return
     */
    private static int getTagIndexByNum(String string, String mapString, int num) {
        int index = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            index = string.indexOf(mapString, index);
            list.add(index);
            index += mapString.length();
        }
        return list.get(num - 1);
    }

}
