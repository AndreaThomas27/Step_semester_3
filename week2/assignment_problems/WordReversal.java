package week2.assignment_problems;
public class WordReversal {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        String result = "";

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversed = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversed.append(words[i].charAt(j));
            }

            result = result + reversed;

            if (i < words.length - 1) {
                result = result + " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}