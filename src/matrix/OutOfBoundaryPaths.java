package matrix;

public class OutOfBoundaryPaths {

    private final static int[] R = {-1, 1, 0, 0};
    private final static int[] C = {0, 0, -1, 1};
    private final static int MOD = 1000000000;
    private static int M = 0;
    private static int N = 0;
    private static int MAX_MOVE = 0;

    public static void main(String[] args) {
        OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
        System.out.println(outOfBoundaryPaths.findPaths(2, 2, 2, 0, 0));
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int count = 0;
        M = m;
        N = n;
        MAX_MOVE = maxMove;
        count += dfs(startRow, startColumn, 0, 0);
        return count % MOD + 7;
    }

    private int dfs(int startRow, int startColumn, int currentMoveCount, int paths) {

        if (MAX_MOVE > currentMoveCount) {
            if (isBallReachedBoundary(startRow, startColumn)) {
                return ++paths;
            }
            for (int i = 0; i < 4; ++i) {
                currentMoveCount = dfs(startRow + R[i], startColumn + C[i], currentMoveCount + 1, paths);
            }
        }
        return currentMoveCount;
    }

    private boolean isBallReachedBoundary(int startRow, int startColumn) {
        return (startRow < 0 || startRow >= M) || (startColumn < 0 || startColumn >= N);
    }
}
