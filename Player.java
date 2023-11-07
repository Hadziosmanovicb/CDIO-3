public class Player {
    private String name;
    private int money;
    private int position;
    private boolean isBankrupt;
    private Token token;

    public Player(String name, Token token) {
        this.name = name;
        this.money = 20; // Startpenge (kan justeres afhængigt af antal spillere)
        this.position = 0; // Startposition (START)
        this.isBankrupt = false;
        this.token = token;
    }

    // Implementer getter- og setter-metoder efter behov
    // Implementer en metode til at flytte spillerens position baseret på terningekast
}
