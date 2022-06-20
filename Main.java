public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[][] input = new int[2][2];
        input[0] = new int[]{1,3};
        input[1] = new int[]{2,3};
        System.out.println(Solution.findJudge(3, input));
        long endTime = System.nanoTime();
        long startSolutionTime = System.nanoTime();
        System.out.println(Solution.findJudge(3, input));
        long endSolutionTime = System.nanoTime();

        System.out.println("My time:       " + (endTime - startTime)/1000000 + " ms");
        System.out.println("Solution time: " + (endSolutionTime - startSolutionTime)/1000000 + " ms");
    }
}