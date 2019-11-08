import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class PassageOperations{
  File file;
  int totalWordCount;

  public PassageOperations(File file_) {
    file = file_;
    totalWordCount = 0;
  }
  public int GetTotalWordCount() throws FileNotFoundException {
    Scanner sc = new Scanner(file);
    while (sc.hasNext()){
      totalWordCount++;
    }
    return totalWordCount;
  }

/*
 * Scan the input file and check for each word. This will keep track of the total
 * word count for this particular file. We will also check to see if this word
 * is in our map. If it is in our map, we add 1 more to the occurrence, otherwise,
 * we add it into the map with occurrence of 1. We then use an ArrayList to
 * sort the values from the map in descending order, and from there, pick out the
 * first 10 values from the values ArrayList. Then we match the values, if they
 * match, we add it to our final return topTenWords.
 */
  public ArrayList<String> TopTenWords() throws FileNotFoundException {
    Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
    Scanner sc = new Scanner(file);
    while (sc.hasNext()) {
      String next = sc.next().toLowerCase();
      totalWordCount++;
        if (!wordCounts.containsKey(next)) {
            wordCounts.put(next, 1);
        } else {
            wordCounts.put(next, wordCounts.get(next) + 1);
        }
    }
    System.out.println("Total word count is: " + totalWordCount);
    ArrayList<Integer> values = new ArrayList<Integer>();
    ArrayList<String> topTenWords = new ArrayList<String>();
    values.addAll(wordCounts.values());
    Collections.sort(values, Collections.reverseOrder());
    int last_i = -1;
    for (Integer i : values.subList(0,9)){
      if (last_i == i){
        continue;
      }
      last_i = i;
      for (String s : wordCounts.keySet()){
        if (wordCounts.get(s) == i){
          topTenWords.add(s);
        }
      }
    }
    return topTenWords;
  }

/*
 * Scan the input file and read each line. In this case, our nextLine() call is a paragraph. So we first split it by periods as we are looking for the last sentence
 * in which the most common word occurs in. Then we will loop through the split paragraph
 * and check to see if the most common word is somewhere inside the sentence using the
 * indexOf string method. If it is, we will set our finalSentence to it. It will loop
 * through all the sentences in the file, and the last occurrence will by recorded like
 * this.
 */
  public String LastSentenceWithMostCommonWord(String mostCommon) throws FileNotFoundException{
    Scanner sc = new Scanner(file);
    String finalSentence = "";
    while (sc.hasNextLine()){
      String para = sc.nextLine();
      String[] paraSentences = para.split("\\.");
      for (int i = 0; i < paraSentences.length; i++){
        if (paraSentences[i].indexOf(mostCommon) != -1){
          finalSentence = paraSentences[i];
        }
      }
    }
  return finalSentence;
  }
}