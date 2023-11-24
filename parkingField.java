public class ParkingField extends Field {

   
    public ParkingField()
    {
        super(
                Translate.t("board.field.parking.title"),
                Translate.t("board.field.parking.description"),
                Translate.t("board.field.parking.subDescription"),
                Color.BLACK,
                Color.WHITE
        );
    }


   
    @Override
    protected GUI_Street createGUIFIeld()
    {
        return new GUI_Street();
    }


   
    @Override
    public GUI_Street getGuiField()
    {
        return (GUI_Street) this.guiField;
    }

    @Override
    public void runAction(Game game) {

    }
}
