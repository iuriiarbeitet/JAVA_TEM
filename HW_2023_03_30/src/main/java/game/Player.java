package game;

public class Player {

    private League league;
    private String name;
    private String surname;
    private double point;

    public Player(League league, String name, String surname, double point) {
        this.league = league;
        this.name = name;
        this.surname = surname;
        this.point = point;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Player{" + "league: " + league +
                " , name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
