package sweeper;

import javax.swing.*;

class Flag {
    private Matrix flagMap;
    private int countOfClosesBoxes;

    void start () {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosesBoxes = Ranges.getSize().x * Ranges.getSize().y;

    }

    Box get (Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        countOfClosesBoxes --;
    }
    void toggleFlagedToBox (Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGED: setClosedToBox (coord); break;
            case CLOSED: setFlagedToBox (coord); break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
    }

    private void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
    }

    int getCountOfClosesBoxes() {
        return countOfClosesBoxes;

    }

    void setBombedToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    void setOpenedToClosedBombBox(Coord coord) {
        if (flagMap.get (coord) == Box.CLOSED)
            flagMap.set (coord, Box.OPENED);

    }
    void setNobombToFFlagedSafeBox(Coord coord) {
        if (flagMap.get(coord) == Box.FLAGED)
            flagMap.set(coord, Box.NOBOMB);
    }

    int getCountOfFlagedBoxesAround (Coord coord) {
        int count = 0;
        for (Coord around : Ranges.getCoordsAround(coord))
            if (flagMap.get(around) == Box.FLAGED)
                count ++;
        return count;

    }
}
