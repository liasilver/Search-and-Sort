import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/*
* WordSort class puts all vocabulary in alphabetical order and searches for a desired word, outputting its definition
* */
class WordSort {
    boolean testing = false;

    /* Constructor
     * */
    public WordSort() throws Exception {
        readFile();
        alphaSort(readFile());
        searchWord(alphaSort(readFile()));
    }//end constructor

    /*
    * readFile method stores data from file as an array list of Word objects
    * @return array list
     * */
    public ArrayList<Word> readFile() throws Exception {
        File wordsFile = new File("words.csv");
        Scanner s = new Scanner(wordsFile);
        ArrayList<Word> words = new ArrayList<>();
        while (s.hasNextLine()) {
            String[] input = s.nextLine().toLowerCase().split(",");
            words.add(new Word(input[0], input[1]));
        }
        return words;
    }//end readFile

    /*
     * alphaSort method sorts an array list of Word objects into alphabetical order
     * @param words array list of Word objects
     * @return alphabetically sorted array list
     * */
    public ArrayList<Word> alphaSort(ArrayList<Word> words) {
        for (int i = 0; i < words.size(); i++) {
            int min = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).getWord().compareTo(words.get(min).getWord()) < 0) {
                    min = j;
                }
            }
            Word w = words.get(min);
            words.set(min, words.get(i));
            words.set(i, w);
        }
        if (testing) {
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i).getWord());
            }
        }
        return words;
    }//end alphaSort

    /*
     * searchWord method uses binary search to find a desired word and its definition in an array list of Words, and tell users if it is not there
     * @param words array list of Word objects
     * @return alphabetically sorted array list
     * */
    public void searchWord(ArrayList<Word> words) {
        Scanner s = new Scanner(System.in);
        System.out.println("What word would you like a definition for?");
        String userWord = s.nextLine().toLowerCase();

        int low = 0;
        int high = words.size() - 1;
        int mid;
        boolean b = false;
        String outWord = userWord.substring(0, 1).toUpperCase() + userWord.substring(1);

        while (low <= high) {
            mid = (low + high) / 2;
            if (words.get(mid).getWord().compareTo(userWord) < 0) {
                low = mid + 1;
            } else if (words.get(mid).getWord().compareTo(userWord) > 0) {
                high = mid - 1;
            } else {
                b = true;
                System.out.println(outWord + ": " + words.get(mid).getWordDef());
                break;
            }
        }
        if (!b) {
            System.out.println(outWord + " is not in Eminem's vocabulary.");
        }
    }//end of searchWord
}//end of WordSort