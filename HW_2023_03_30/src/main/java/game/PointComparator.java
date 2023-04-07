package game;

import java.util.Comparator;

public class PointComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getPoint() < o2.getPoint() ? 1 : -1;
    }
}
