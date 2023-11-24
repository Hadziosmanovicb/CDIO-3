public class ChanceDeck {

    private ChanceCard[] cards;

    private int numberOfDrawnCards;
    public ChanceDeck()
    {
        this.cards = ChanceDeck.defaultChanceCards.clone();
        this.shuffle();
    }
    public ChanceCard draw()
    {
        if (this.isEmpty()) {
            this.shuffle();
        }

        return this.cards[this.numberOfDrawnCards++];
    }
        Random rand = new Random();

        int max = this.cards.length;
        for (int i = 0; i < max; i++) {
            int slot = rand.nextInt(max);

            ChanceCard temp = this.cards[slot];
            this.cards[slot] = this.cards[i];
            this.cards[i] = temp;
        }

        this.numberOfDrawnCards = 0;
    }


   
    public boolean isEmpty()
    {
        return this.numberOfDrawnCards >= this.cards.length;
    }


    static private ChanceCard[] defaultChanceCards = new ChanceCard[] {
   
        new ChanceCard(
            Translate.t("chance.description.to_start"),
            (game) -> game.movePlayer(game.getPlayers().getCurrentPlayer(), Translate.t("board.field.start.title"))
        ),
        new ChanceCard(
            Translate.t("chance.description.move_5_fields"),
            (game) -> {
                String fieldAnswer = game.getGui().getUserSelection(Translate.t("chance.description.move_5_fields.question"), "1", "2", "3", "4", "5");
                int numberOfFields = Integer.parseInt(fieldAnswer);

                Player player = game.getPlayers().getCurrentPlayer();

                game.movePlayer(player, numberOfFields);
                game.getBoard().getPlayerField(player).runAction(game);
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_orange"),
            ChanceCard.fieldTypeAction(Color.ORANGE)
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_orange_green"),
            ChanceCard.fieldTypeAction(Color.ORANGE, Color.GREEN)
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_lightblue"),
            ChanceCard.fieldTypeAction(Color.CYAN)
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_pink_darkblue"),
            ChanceCard.fieldTypeAction(Color.PINK, Color.BLUE)
        ),


        new ChanceCard(
            Translate.t("chance.description.move_to_red"),
            ChanceCard.fieldTypeAction(Color.RED)
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_lightblue_red"),
            ChanceCard.fieldTypeAction(Color.CYAN, Color.RED)
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_brown_yellow"),
            ChanceCard.fieldTypeAction(Color.GRAY, Color.YELLOW)
        ),
        new ChanceCard(
            Translate.t("chance.description.field_or_card"),
            (game) -> {
                String answer = game.getGui().getUserButtonPressed(
                    Translate.t("chance.description.field_or_card.question"),
                    Translate.t("chance.description.field_or_card.move"),
                    Translate.t("chance.description.field_or_card.card")
                );

                if (answer.equals(Translate.t("chance.description.field_or_card.move"))) {
                    Player player = game.getPlayers().getCurrentPlayer();

                    game.movePlayer(player, 1);
                    game.getBoard().getPlayerField(player).runAction(game);
                } else {
                    game.getChanceDeck().draw().play(game);
                }
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.slik"),
            (game) -> game.getPlayers().getCurrentPlayer().addBalance(-2)
        ),
        new ChanceCard(
            Translate.t("chance.description.prison"),
            (game) ->game.getPlayers().getCurrentPlayer().addPrisonCard(1)
        ),
        new ChanceCard(
            Translate.t("chance.description.strandpromenaden"),
            (game) -> {
                Player player = game.getPlayers().getCurrentPlayer();

                game.movePlayer(player, Translate.t("board.field.strandpromenaden.description"));
                game.getBoard().getPlayerField(player).runAction(game);
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.birthday"),
            (game) -> {
                Players players = game.getPlayers();
                for (Player player : players) {
                    player.addBalance(-1);
                    players.getCurrentPlayer().addBalance(1);
                }
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.homework"),
            (game) -> game.getPlayers().getCurrentPlayer().addBalance(2)
        ),
        new ChanceCard(
            Translate.t("chance.description.skaterparken"),
            (game) -> game.movePlayer(game.getPlayers().getCurrentPlayer(), Translate.t("board.field.skaterparken.description"))
        ),
    };

}
