import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ashi on 12/16/17.
 */
public class Driver {

    public static void main(String[] args) {
        WebLinks webLinks = new WebLinks();

        try {
           FileInputStream fstream = new FileInputStream("src/test2.html");
       BufferedReader infile = new BufferedReader(new InputStreamReader(
                   fstream));
         String data = new String();

      //  This pattern will identify the anchor tag "<a href=\"http://www.knowyourcandidate.net/web/ministers/list/1\">List Of Ministers</a>";
        String pattern = "<a href=(\"((http://)(.*?))/(.*)\")>";


        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);


            String firstline = infile.readLine(); //obtain the first line of the file, we will test each link against this
           // System.out.println("first line " + firstline);
            while ((data = infile.readLine()) != null) { // use if for reading just 1 line
                Matcher m = r.matcher(data);
                if(m.find()){
//                    System.out.println("Found "+m.group(3));
//                    System.out.println("Found "+m.group(1));
                    String val = m.group(1);
                    String link = val.replace("\"","");
                    if(m.group(2).equals(firstline))
                    webLinks.addLink(m.group(2), link); //only add links that match the first line
                }
            }


            webLinks.writeToFile(); //write the links to the file

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

