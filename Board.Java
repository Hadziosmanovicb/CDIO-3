
public class Board {

   
    private Field[] fields;

    private HashMap<Player, Field> playerFieldMap = new HashMap<>();


  
    public Board()
    {
        this.fields = this.createFields();
    }


   
 
    public Field[] getFields()
    {
        return this.fields;
    }


   


        return null;
    }

   
   
    public BuildingField[] getFieldsByTypes(Color ...types)
    {
        ArrayList<BuildingField> fields = new ArrayList<>();

        for (BuildingField field : this.getBuildingFields()) {
            for (Color type : types) {
                if (field.getType() == type) {
                    fields.add(field);
                }
            }
        }

        return fields.toArray(new BuildingField[] {});
    }

    
    public BuildingField[] getBuildingFields()
    {
        ArrayList<BuildingField> fields = new ArrayList<>();

        for (Field field: this.fields) {
            if (field instanceof BuildingField) {
                fields.add((BuildingField) field);
            }
        }

        return fields.toArray(new BuildingField[] {});
    }

    
   
    public BuildingField[] getFieldsOwnedByPlayer(Player player)
    {
        ArrayList<BuildingField> fields = new ArrayList<>();

        for (BuildingField field: this.getBuildingFields()) {
            if (field.isOwnedByPlayer(player)) {
                fields.add(field);
            }
        }

        return fields.toArray(new BuildingField[] {});
    }


   
    public GUI_Field[] getGuiFields()
    {
        GUI_Field[] fields = new GUI_Field[this.fields.length];

        for (int i = 0; i < this.fields.length; i++) {
            fields[i] = this.fields[i].getGuiField();
        }

        return fields;
    }


  

    public boolean isFieldBefore(Field newField, Field oldField)
    {
        if (newField == oldField) {
            return false;
        }

        for (int i = 0; i < this.fields.length; i++) {
            if (this.fields[i] == newField) {
                return true;
            } else if (this.fields[i] == oldField) {
                return false;
            }
        }

        return false;
    }


    private Field[] createFields()
    {
        return new Field[] {
            new StartField() .setTitle("Start") .setSubText("") .setBackgroundColor(Color.White),
            new BuildingField(Translate.t("board.field.burgerbaren.description"), 1, Color.brown).setSubText("M1"),
            new BuildingField(Translate.t("board.field.pizzeriaet.description"), 1, Color.brown).setSubText("M1"),
            new ChanceField() .setTitle("Chance").setSubText("?"),
            new BuildingField(Translate.t("board.field.slikbutikken.description"), 1, Color.lightBlue).setSubText("M1"),
            new BuildingField(Translate.t("board.field.iskiosken.description"), 1, Color.lightBlue).setSubText("M1"),
            new PrisonField(true).setSubText("På besøg"),
            new BuildingField(Translate.t("board.field.museet.description"), 2, Color.pink).setSubText("M2"),
            new BuildingField(Translate.t("board.field.biblioteket.description"), 2, Color.pink).setSubText("M2"),
            new ChanceField() .setTitle("Chance").setSubText("?"),
            new BuildingField(Translate.t("board.field.skaterparken.description"), 2, Color.lightYellow).setSubText("M3"),
            new BuildingField(Translate.t("board.field.swimmingpoolen.description"), 2, Color.LightYellow).setSubText("M3"),
            new ParkingField() .setTitle("Parkering").setSubText("P"),
            new BuildingField(Translate.t("board.field.spillehallen.description"), 3, Color.red).setSubText("M3"),
            new BuildingField(Translate.t("board.field.biografen.description"), 3, Color.red).setSubText("M3"),
            new ChanceField() .setTitle("Chance").setSubText("?"),
            new BuildingField(Translate.t("board.field.legetøjsbutikken.description"), 3, Color.yellow).setSubText("M3"),
            new BuildingField(Translate.t("board.field.dyrehandlen.description"), 3, Color.yellow).setSubText("M3"),
            new PrisonField(false).setSubText("Fængsel"),
            new BuildingField(Translate.t("board.field.bowlinghallen.description"), 4, Color.green).setSubText("M4"),
            new BuildingField(Translate.t("board.field.zoo.description"), 4, Color.green).setSubText("M4"),
            new ChanceField() .setTitle("Chance").setSubText("?"),
            new BuildingField(Translate.t("board.field.vandlandet.description"), 5, Color.blue).setSubText("M5"),
            new BuildingField(Translate.t("board.field.strandpromenaden.description"), 5, Color.blue).setSubText("M5"),
        };
    }

}
