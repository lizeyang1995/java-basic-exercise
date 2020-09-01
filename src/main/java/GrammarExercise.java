import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Collections.sort(foundCommonWordsList);
        return addSpacesBetweenCharacters(foundCommonWordsList);
    }

    private static List<String> addSpacesBetweenCharacters(List<String> foundCommonWordsList) {
        return foundCommonWordsList.stream().map(word -> word.replace("", " ").trim()).collect(Collectors.toList());
    }

    private static List<String> findCommonWords(String[] splitedFirstWordList, String[] splitedSecondWordList) {
        List<String> foundCommonWordsList = new ArrayList<>();
        Stream<String> processedFirstWordsList = processingWords(splitedFirstWordList);
        Stream<String> processedSecondWordsList = processingWords(splitedSecondWordList);
        Set<String> noRepeatedWords = new HashSet<>();
        processedFirstWordsList.forEach(noRepeatedWords::add);
        processedSecondWordsList.forEach(word -> {
            if (!noRepeatedWords.add(word)) {
                foundCommonWordsList.add(word);
            }
        });
        return foundCommonWordsList;
    }

    private static Stream<String> processingWords(String[] splitedWordList) {
        return Arrays.stream(splitedWordList).map(word -> {
            if (!word.matches("[a-zA-Z]+")) {
                throw new RuntimeException();
            }
            return word.toUpperCase();
        });
    }
}
