public class Game {

    private Board board;
    private GUI gui;

    private Die die;
    private ChanceDeck chanceDeck;
    private Players players;


    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());

        this.die = new Die();
        this.chanceDeck = new ChanceDeck();
        this.players = new Players();
    }


    public GUI getGui()
    {
        return this.gui;
    }


    public Board getBoard()
    {
        return this.board;
    }


    public Players getPlayers()
    {
        return this.players;
    }


    public ChanceDeck getChanceDeck()
    {
        return this.chanceDeck;
    }


    public Field[] getFields()
    {
        return this.board.getFields();
    }


    public void movePlayer(Player player, int fieldsToMove)
    {
        Field oldField = this.board.getPlayerField(player);

        this.board.movePlayer(player, fieldsToMove);

        if (this.hasPlayerPassedStart(player, oldField)) {
            player.addBalance(2);
            this.gui.showMessage(player.getName() + Translate.t("kast.rollDie3"));
        }
    }


    public void movePlayer(Player player, String fieldName)
    {
        Field oldField = this.board.getPlayerField(player);

        Field moveToField = this.board.getFieldByTitle(fieldName);
        this.board.movePlayer(player, moveToField);

        if (! (oldField instanceof PrisonField) && !(moveToField instanceof PrisonField)) {
            if (this.hasPlayerPassedStart(player, oldField)) {
                player.addBalance(2);
                this.gui.showMessage(player.getName() + Translate.t("kast.rollDie3"));
            }
        }
    }


  
   


    private void createPlayers(int numberOfPlayers)
    {
        ArrayList<String> types = new ArrayList<>(Arrays.asList(Player.Type.valuesToString()));

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));
            String type = this.gui.getUserSelection(Translate.t("type.whatplayer"), types.toArray(new String[] {}));

            types.remove(type);

            Player player = new Player(name, this.getStartAmount(numberOfPlayers));
            player.setType(Player.Type.toEnum(type));

            this.gui.addPlayer(player.getGuiPlayer());
            this.board.addPlayer(player);
            this.players.addPlayer(player);
        }
    }


    private int getStartAmount(int numberOfPlayers)
    {
        switch (numberOfPlayers) {
            case 2: return 20;
            case 3: return 18;
            case 4: return 16;
            default: return 20;
        }
    }


   
    private void youngestPlayerStarts(int countplayers){

        String playerNumberString = "";

        switch (countplayers) {

            case 2:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players.get(0).getName(), "2. " + this.players.get(1).getName());
                break;

            case 3:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players.get(0).getName(), "2. " + this.players.get(1).getName(), "3. " + this.players.get(2).getName());
            
