public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Solution.minMaxGame(new int[]{1,3,5,2,4,8,2,2}));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(SampleSolution.minMaxGame(new int[]{1,3,5,2,4,8,2,2}));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}