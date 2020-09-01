import java.util.*;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String[] splitedFirstWordList = firstWordList.split(",");
        String[] splitedSecondWordList = secondWordList.split(",");
        List<String> foundCommonWordsList = findCommonWords(splitedFirstWordList, splitedSecondWordList);
        return null;
    }

    private static List<String> findCommonWords(String[] splitedFirstWordList, String[] splitedSecondWordList) {
        List<String> foundCommonWordsList = new ArrayList<>();
        Set<String> noRepeatedWords = new HashSet<>(Arrays.asList(splitedFirstWordList));
        Arrays.stream(splitedSecondWordList).forEach(word -> {
            if (!noRepeatedWords.add(word)) {
                foundCommonWordsList.add(word);
            }
        });
        return foundCommonWordsList;
    }
}
