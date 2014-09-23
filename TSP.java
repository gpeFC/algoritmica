import java.util.Arrays;

public class TSP {
    /** retorna una solucion factible para el problema del viajero con un
     *  los pesos especificados en weights y ciudad inicial s */
    public int[] greedyTSP(int[][] weights, int s) {
        int n = weights.length;
        int[] solution = new int[n];
        solution[0] = s;
        int current = s;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        visited[s] = true;
        for (int i = 1; i < n; i++) {
            // buscamos el vecino mas cercano que no haya sido visitado
            int min = 0;
            int minWeight = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int next = weights[current][j];
                if (next < minWeight && next > 0 && !visited[j]) {
                    min = j;
                    minWeight = weights[current][j];
                }
            }
            solution[i] = min;
            visited[min] = true;
        }
        return solution;
    }


    public static void main(String[] args) {
        int[][] g = {{0,  150, 21, 43},
                     {150, 0,  40, 5}, 
                     {21, 40, 0,  6}, 
                     {43, 5,  6,  0}};
        TSP tsp = new TSP();
        int[] solution = tsp.greedyTSP(g, 0);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println("");
    }
}
