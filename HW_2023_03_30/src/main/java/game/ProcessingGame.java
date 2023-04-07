package game;

import java.util.*;

public class ProcessingGame {
    private Comparator<Player> playerComparator = new PointComparator();
    private List<Player> leagueA = new ArrayList<>();
    private List<Player> leagueB = new ArrayList<>();
    private List<Player> leagueC = new ArrayList<>();
    private List<Player> leagueD = new ArrayList<>();

    private List<Player> leagueWinner = new ArrayList<>();


    public void startGame() {
        fillPlayersLeagues();
        processGameLeague(leagueA);
        processGameLeague(leagueB);
        processGameLeague(leagueC);
        processGameLeague(leagueD);

        Collections.sort(leagueA, playerComparator);
        Collections.sort(leagueB, playerComparator);
        Collections.sort(leagueC, playerComparator);
        Collections.sort(leagueD, playerComparator);

        leagueWinner.add(leagueA.get(0));
        leagueWinner.add(leagueB.get(0));
        leagueWinner.add(leagueC.get(0));
        leagueWinner.add(leagueD.get(0));
        processGameLeague(leagueWinner);
        Collections.sort(leagueWinner, playerComparator);

        printLeague();
    }

    private void fillPlayersLeagues() {
        fillPlayers(League.A, 0.0, leagueA);
        fillPlayers(League.B, 0.0, leagueB);
        fillPlayers(League.C, 0.0, leagueC);
        fillPlayers(League.D, 0.0, leagueD);
    }

    private List<Player> fillPlayers(League league, double points, List<Player> playerList) {
        for (int i = 1; i < 6; i++) {
            playerList.add(new Player(league, "PlayerNumber " + i, "PlayerSurname ", points));
        }
        return playerList;
    }

    private List<Player> processGameLeague(List<Player> playerList) {
        Random random = new Random();
        int playerI = 0;
        int playerJ = 0;

        for (int i = 0; i < playerList.size(); i++) {
            for (int j = i; j < playerList.size(); j++) {
                playerI = 0;
                playerJ = 0;
                if (i != j) {
                    playerI = random.nextInt(2);
                    playerJ = random.nextInt(2);
                    double p1 = playerList.get(i).getPoint();
                    double p2 = playerList.get(j).getPoint();

                    if (playerI == playerJ) {
                        p1 = p1 + 0.5;
                        playerList.get(i).setPoint(p1);
                        p2 = p2 + 0.5;
                        playerList.get(j).setPoint(p2);
                    } else if (playerI > playerJ) {
                        p1 = p1 + 1;
                        playerList.get(i).setPoint(p1);
                    } else {
                        p2 = p2 + 1;
                        playerList.get(j).setPoint(p2);
                    }
                }
            }
        }
        for (int i = 0; i < playerList.size(); i++) {
            for (int j = 0; j < playerList.size(); j++) {
                playerI = 0;
                playerJ = 0;
                if (i != j && playerList.get(i).getPoint() == playerList.get(j).getPoint()) {
                    playerI = random.nextInt(2);
                    playerJ = random.nextInt(2);
                    double p1 = playerList.get(i).getPoint();
                    double p2 = playerList.get(j).getPoint();

                    if (playerI == playerJ) {
                        p1 = p1 + 0.5;
                        playerList.get(i).setPoint(p1);
                        p2 = p2 + 0.5;
                        playerList.get(j).setPoint(p2);
                    } else if (playerI > playerJ) {
                        p1 = p1 + 1;
                        playerList.get(i).setPoint(p1);
                    } else {
                        p2 = p2 + 1;
                        playerList.get(j).setPoint(p2);
                    }
                    i = 0;
                    j = 0;
                }
            }
        }
        return playerList;
    }

    public void printLeague() {
        System.out.println("Result game from league A :");
        print(leagueA);
        System.out.println();
        System.out.println("Result game from league B :");
        print(leagueB);
        System.out.println();
        System.out.println("Result game from league C :");
        print(leagueC);
        System.out.println();
        System.out.println("Result game from league D :");
        print(leagueD);
        System.out.println();
        System.out.println("Winners between winners from leagues : ");
        print(leagueWinner);
    }

    private void print(List<Player> playerList) {
        int count = 0;
        for (int i = 0; i < playerList.size(); i++) {
            count++;
            System.out.println("Place " + count + " -> " + playerList.get(i));
        }
    }
}
