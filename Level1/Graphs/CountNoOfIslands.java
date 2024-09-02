package Level1.Graphs;

public class CountNoOfIslands {
    public static void getNoOfIslands(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        getNoOfIslands(arr, i - 1, j, visited);
        getNoOfIslands(arr, i + 1, j, visited);
        getNoOfIslands(arr, i, j - 1, visited);
        getNoOfIslands(arr, i, j + 1, visited);
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        boolean[][] visited = new boolean[8][8];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    getNoOfIslands(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
