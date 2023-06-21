package sweeper;

public class Flag {
    private Matrix flagMap;
    private int totalFlagged;
    private int totalClosed;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        totalFlagged = 0;
        totalClosed = Ranges.getSquare();

    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }



    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

    private void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
        totalFlagged++;
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlagged--;
    }
    public int getTotalFlagged() {
        return totalFlagged;
    }

    public int getTotalClosed() {
        return totalClosed;
    }
    void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGGED:
                setClosedToBox(coord);
                break;
            case CLOSED:
                setFlaggedToBox(coord);
                break;
        }
    }

     void setFlaggedToLastClosedBoxes() {
        for (Coord coord: Ranges.getAllCoords()) {
            if (Box.CLOSED == flagMap.get(coord)){
                setFlaggedToBox(coord);
            }
        }
    }

     void setBombedToBox(Coord bombedCoord) {
        flagMap.set(bombedCoord,Box.BOMBED);
    }

    void setOpenedToClosedBox(Coord coord) {
        if(Box.CLOSED == flagMap.get(coord)) {
            flagMap.set(coord, Box.OPENED);
        }
    }

     void setNoBombToFlaggedBox(Coord coord) {
        if(Box.FLAGGED == flagMap.get(coord)) {
            flagMap.set(coord, Box.NOBOMB);
        }
    }

     int getCountOfFlaggedBoxesAround(Coord coord) {
        int count = 0;
        for(Coord around: Ranges.getCoordsAround(coord)){
            if (flagMap.get(around) == Box.FLAGGED) {
                count++;
            }
        }
         return count;
    }
}
