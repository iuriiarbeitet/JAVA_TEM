package sweeper;

public class Game {
    private final Bomb bomb;
    private final Flag flag;
    private GameState gameState;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        bomb.start();
        flag.start();
        gameState = GameState.PLAYED;
    }

    public Box getBox(Coord coord) {
        if (Box.OPENED == flag.get(coord)) {
            return bomb.get(coord);
        } else {
            return flag.get(coord);
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public void pressLeftButton(Coord coord) {

        if (isGameOver()) return;
        openBox(coord);
        checkWinner();
    }

    public void pressRightButton(Coord coord) {
        if (isGameOver()) return;
        flag.toggleFlaggedToBox(coord);

    }

    public int getTotalBombs() {
        return bomb.getTotalBombs();
    }

    public int getTotalFlagged() {
        return flag.getTotalFlagged();
    }

    private boolean isGameOver() {
        if (GameState.PLAYED != gameState) {
            start();
            return true;
        } else
            return false;
    }

    private void checkWinner() {
        if (GameState.PLAYED == gameState) {
            if (flag.getTotalClosed() == bomb.getTotalBombs()) {
                gameState = GameState.WINNER;
                flag.setFlaggedToLastClosedBoxes();
            }
        }
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED:
                setOpenedToClosedBoxesAroundNumber(coord);
                break;
            case FLAGGED:
                break;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO:
                        openBoxesAroundZero(coord);
                        break;
                    case BOMB:
                        openBombs(coord);
                        break;
                    default:
                        flag.setOpenedToBox(coord);
                        break;
                }
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Coord coord) {
        if (Box.BOMB != bomb.get(coord)) {
            if (bomb.get(coord).getNumber() == flag.getCountOfFlaggedBoxesAround(coord)) {
                for (Coord around : Ranges.getCoordsAround(coord)) {
                    if (flag.get(around) == Box.CLOSED) {
                        openBombs(around);
                    }
                }
            }
        }
    }

    private void openBombs(Coord bombedCoord) {
        flag.setBombedToBox(bombedCoord);

        for (Coord coord : Ranges.getAllCoords()) {
            if (bomb.get(coord) == Box.BOMB) {
                flag.setOpenedToClosedBox(coord);
            } else {
                flag.setNoBombToFlaggedBox(coord);
            }
        }
        gameState = GameState.BOMBED;
    }

    private void openBoxesAroundZero(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getCoordsAround(coord)) {
            openBox(around);
        }
    }

}
