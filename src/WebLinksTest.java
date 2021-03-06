import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by ashi on 12/17/17.
 */
public class WebLinksTest extends TestCase {

    @Test
    public void testAssertFile(){

        try {
            assertEquals("The files differ!",
                    FileUtils.readFileToString(new File("output.txt"),"utf-8"),
            FileUtils.readFileToString(new File("test.txt"), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testAssertFile2(){

        try {
            assertEquals("The files differ!",
                    FileUtils.readFileToString(new File("output2.txt"),"utf-8"),
                    FileUtils.readFileToString(new File("test2.txt"), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}