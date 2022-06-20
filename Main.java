public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] input = new int[]{1,3};
        System.out.println(Solution.buildArray(input, 3));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(Solution.buildArray(input, 3));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}