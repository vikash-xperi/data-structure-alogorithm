package revisionback.array;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    static class Pair {
        private int r;
        private int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static enum Box {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH, NULL
    }

    private static boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int tmp = Integer.parseInt(String.valueOf(board[i][j]));
                List<Pair> stringList = new ArrayList<>();
                if (map.containsKey(tmp)) {
                    stringList = map.get(tmp);
                }
                stringList.add(new Pair(i, j));
                map.put(tmp, stringList);
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (map.containsKey(i)) {
                List<Pair> pairs = map.get(i);
                for (int j = 0; j < pairs.size(); j++) {
                    for (int k = j + 1; k < pairs.size(); k++) {
                        if ((pairs.get(j).r == pairs.get(k).r) || (pairs.get(j).c == pairs.get(k).c)
                                || (whichBox(pairs.get(j).r, pairs.get(j).c) == whichBox(pairs.get(k).r, pairs.get(k).c))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static Box whichBox(int r, int c) {
        if (r >= 0 && r <= 2) {
            if (c >= 0 && c <= 2) {
                return Box.FIRST;
            } else if (c >= 3 && c <= 5) {
                return Box.SECOND;
            } else if (c >= 6 && c <= 8) {
                return Box.THIRD;
            }
        } else if (r >= 3 && r <= 5) {
            if (c >= 0 && c <= 2) {
                return Box.FOURTH;
            } else if (c >= 3 && c <= 5) {
                return Box.FIFTH;
            } else if (c >= 6 && c <= 8) {
                return Box.SIXTH;
            }
        } else {
            if (c >= 0 && c <= 2) {
                return Box.SEVENTH;
            } else if (c >= 3 && c <= 5) {
                return Box.EIGHTH;
            } else if (c >= 6 && c <= 8) {
                return Box.NINTH;
            }
        }
        return Box.NULL;
    }
}
