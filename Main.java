public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] input = new int[]{1,2};
        System.out.println(Solution.maxProfit(input));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(Solution.maxProfit(input));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}