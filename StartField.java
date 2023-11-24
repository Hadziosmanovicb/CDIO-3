public class StartField extends Field {


    public StartField()
    {
        super(
                Translate.t("board.field.start.title"),
                Translate.t("board.field.start.description"),
                Translate.t("board.field.start.subDescription"),
                Color.GREEN,
                Color.BLACK
        );
    }


    @Override
    protected GUI_Start createGUIFIeld()
    {
        return new GUI_Start();
    }


    @Override
    public GUI_Start getGuiField()
    {
        return (GUI_Start) this.guiField;
    }

    @Override
    public void runAction(Game game) {

    }
}
