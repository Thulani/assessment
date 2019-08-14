package za.co.investec.thulani.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class FileUtil {

    /**
     * Reads given resource file as a string.
     *
     * @param fileName the path to the resource file
     * @return the file's contents or null if the file could not be opened
     */
    public static String getResourceFileAsString(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream is = classLoader.getResourceAsStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }
}
