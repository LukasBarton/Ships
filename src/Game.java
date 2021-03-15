import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Game {
    Board board = new Board();

    void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!board.allShipsSank()) {
            System.out.println("Enter missile locations, x and y to 10.");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board.shoot(x, y);
        }
    }
}

class Board {
    Set<Ship> ships = new HashSet<>();

    boolean allShipsSank() {
        for (Ship ship : ships)
            if (!ship.isSank())
                return false;
        return true;
    }

    void shoot(int x, int y) {
        for (Ship ship : ships) {
            if (ship.shipGeographic.orientation == ShipGeographic.Orientation.HORIZONTAL) {
                if (y == ship.shipGeographic.y && ship.shipGeographic.x <= x && x <= ship.shipGeographic.x + ship.len) {
                    ship.missileAt(x - ship.shipGeographic.x);
                    return;
                }
            }
            if (ship.shipGeographic.orientation == ShipGeographic.Orientation.VERTICAL) {
                if (x == ship.shipGeographic.x && ship.shipGeographic.y <= y && y <= ship.shipGeographic.y + ship.len) {
                    ship.missileAt(ship.shipGeographic.y + y);
                    return;
                }
            }
        }
    }
}


class ShipGeographic {
    enum Orientation {
        HORIZONTAL, VERTICAL;
    }

    int x;
    int y;
    ShipGeographic.Orientation orientation;
}

class Ship {
    int len;

    Set<Integer> hit = new HashSet<>();

    ShipGeographic shipGeographic;

    Ship(int len) {
        this.len = len;
    }

    boolean isSank() {
        return hit.size() == len;
    }


    void missileAt(int offsetFromLen) {
        if (hit.add(offsetFromLen)) {
            System.out.println("hit");
            System.out.println(hit);
        }
    }
}

