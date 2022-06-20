public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String input = "10#11#12";
        System.out.println(Solution.freqAlphabets(input));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(SampleSolution.freqAlphabets(input));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}