import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String[] input = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(Solution.reorderLogFiles(input)));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(Arrays.toString(SampleSolution.reorderLogFiles(input)));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}