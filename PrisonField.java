public class PrisonField extends Field {

   
    private boolean isVisit;


   

        this.isVisit = isVisit;
        String fieldType = isVisit ? "visit" : "goto";

        this.setTitle(Translate.t("board.field.prison." + fieldType + ".title"));
        this.setDescription(Translate.t("board.field.prison." + fieldType + ".description"));
        this.setSubText(Translate.t("board.field.prison." + fieldType + ".subDescription"));

        this.setBackgroundColor(Color.BLACK);
        this.setForegroundColor(Color.WHITE);
    }


   
    @Override
    protected GUI_Jail createGUIFIeld()
    {
        return new GUI_Jail();
    }


    @Override
    public GUI_Jail getGuiField()
    {
        return (GUI_Jail) this.guiField;
    }


    public boolean isVisit()
    {
        return this.isVisit;
    }


    @Override
    public void runAction(Game game) {
        if (! this.isVisit) {
            Player player = game.getPlayers().getCurrentPlayer();

            if (player.getPrisonCard() == 0) {
                game.getGui().showMessage(Translate.t("board.field.prison.action"));
                game.movePlayer(player, Translate.t("board.field.prison.visit.title"));

                player.addBalance(-2);
                game.getGui().showMessage(Translate.t("board.field.prison.pay"));
            } else {
                game.getGui().showMessage(Translate.t("board.field.prison.action"));
                game.movePlayer(player, Translate.t("board.field.prison.visit.title"));
                game.getGui().showMessage(Translate.t("board.field.prison.free.card"));

                player.removePrisonCard(1);
                game.getGui().showMessage(Translate.t("board.field.prison.free.card.num") + player.getPrisonCard() + Translate.t("board.field.prison.free.card.num2"));
            }
        }
    }
}
