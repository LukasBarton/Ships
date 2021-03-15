class App {
    public static void main(String[] args) {
        Game game = new Game();

        {
            Ship ship = new Ship(4);
            ShipGeographic shipGeographic = new ShipGeographic();
            shipGeographic.orientation = ShipGeographic.Orientation.HORIZONTAL;
            shipGeographic.x = 1;
            shipGeographic.y = 4;
            shipGeographic.x = 3;
            shipGeographic.y = 9;
            shipGeographic.x = 2;
            shipGeographic.y = 6;
            shipGeographic.x = 6;
            shipGeographic.y = 4;

            ship.shipGeographic = shipGeographic;

            game.board.ships.add(ship);
        }

        game.playGame();
    }
}
