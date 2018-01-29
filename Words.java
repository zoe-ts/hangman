import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Words {

    public String Read(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("files/words.txt"));
            String line;
            ArrayList<String> allwords=new ArrayList<String>();
            while ((line=reader.readLine())!=null){
                String [] words=line.split(" ");
                for( String oneItem : words ) {
                    allwords.add(oneItem);
                }
            }
            int idx =new Random().nextInt(allwords.size());
            String chosen = allwords.get(idx).toString();
            return chosen;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

}
