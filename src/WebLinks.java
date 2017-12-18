import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashi on 12/16/17.
 */
public class WebLinks {
   private static Map<String,List<String>> webLinks = new LinkedHashMap<>();

   public void addLink(String hashLink,String actualLink){
      List<String> links = new ArrayList<>();
      if(webLinks.containsKey(hashLink)){
         System.out.println("yes");
          links = webLinks.get(hashLink);
      }
      links.add(actualLink);
      webLinks.put(hashLink,links);
   }

   public void printList(){
      System.out.println("went in print");
      for (String name: webLinks.keySet()){
        // if(!(name.contains("facebook") || name.contains("google")))
         System.out.println(name + " " + webLinks.get(name) );
        // System.out.println( );
      }
   }

   public void writeToFile(){
      try {
         BufferedWriter bufferedWriter =  new BufferedWriter(new FileWriter("test.txt"));
         StringBuilder sb = new StringBuilder();
         for (String name: webLinks.keySet()){
            List<String> list = webLinks.get(name);
            for (int i = 0; i < list.size(); i++) {
               sb.append(list.get(i));
               sb.append("\n");
            }
            System.out.println("sb is "+sb.toString());
         }
         bufferedWriter.write(sb.toString());
         bufferedWriter.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}
