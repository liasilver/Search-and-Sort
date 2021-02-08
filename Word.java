/**
 * The word object contains the methods for getting the word and its definition
 */
class Word {
    private String word;
    private String wordDef;

    /**
     * Constructor
     * @param word the word itself
     * @param wordDef the definition of the word
     */
    public Word (String word, String wordDef) {
        this.word = word;
        this.wordDef = wordDef;
    } //end Word constructor

    /**
     * Getter method for the word field.
     * @return the word
     */
    public String getWord() {
        return word;
    }//end getWord

    /**
     * Getter method for the getWordDef field.
     * @return definition of the word
     */
    public String getWordDef() {
        return wordDef;
    }//end getWordDef
} // end Home