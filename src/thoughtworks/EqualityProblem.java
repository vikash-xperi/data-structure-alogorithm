package thoughtworks;

import java.util.Objects;

class Player {
    String name;
    int score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
public class EqualityProblem {
    public static void main(String[] args) {

    }

}
