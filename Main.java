public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Solution.findLHS(new int[]{1,3,2,2,5,2,3,7}));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(SampleSolution.findLHS(new int[]{1,3,2,2,5,2,3,7}));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}