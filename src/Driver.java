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
           FileInputStream fstream = new FileInputStream("/Users/ashi/git/WebCrawler/src/test.html");
       BufferedReader infile = new BufferedReader(new InputStreamReader(
                   fstream));
         String data = new String();

      //  String line = "<a href=\"http://www.knowyourcandidate.net/web/ministers/list/1\">List Of Ministers</a>";
        String pattern = "<a href=(\"((http://)(.*?))/(.*)\")>";
        String pattern2 = "(.*?)/";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
       // Matcher m = r.matcher(line);

        /*

         if (m.find()) {
            String val = m.group(0);
            System.out.println("Found value 0: " + val.replace("\"",""));
            System.out.println("Found value 1: " + m.group(1));
            System.out.println("Found value 2: " + m.group(2));
            System.out.println("Found value 3: " + m.group(3));
            System.out.println("Found value 4: " + m.group(4));


        } else {
            System.out.println("NO MATCH");
        }
         */
            String firstline = infile.readLine();
            System.out.println("first line " + firstline);
            while ((data = infile.readLine()) != null) { // use if for reading just 1 line
                Matcher m = r.matcher(data);
                if(m.find()){
//                    System.out.println("Found "+m.group(3));
//                    System.out.println("Found "+m.group(1));
                    String val = m.group(1);
                    String link = val.replace("\"","");
                    if(m.group(2).equals(firstline))
                    webLinks.addLink(m.group(2), link); //only add links that correspond to the first line
                }
            }

            //webLinks.printList();
            webLinks.writeToFile();
           // System.out.println(webLinks.returnCopyOfMap());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

