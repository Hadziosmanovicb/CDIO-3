public class ChanceField extends Field {

    
    public ChanceField()
    {
        super(
                Translate.t("board.field.chance.title"),
                Translate.t("board.field.chance.description"),
                Translate.t("board.field.chance.subDescription"),
                Color.BLACK,
                Color.WHITE
        );
    }


   
    @Override
    protected GUI_Chance createGUIFIeld()
    {
        return new GUI_Chance();
    }


  
    @Override
    public GUI_Chance getGuiField()
    {
        return (GUI_Chance) this.guiField;
    }


    @Override
    public void runAction(Game game)
    {
        game.getChanceDeck().draw().play(game);
    }

}
