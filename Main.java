import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("passage.txt");

    PassageOperations po = new PassageOperations(file);
    //System.out.println(po.GetTotalWordCount());
    ArrayList<String> topTen = new ArrayList<String>();
    topTen = po.TopTenWords();
    System.out.println(topTen);
    PassageOperations po2 = new PassageOperations(file);
    System.out.println(po2.LastSentenceWithMostCommonWord(topTen.get(0)));
  }
}