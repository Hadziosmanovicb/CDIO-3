public abstract class Field {

    
    private String title;

  
    private String description;

   
    private String subText;


  
    protected GUI_Field guiField;


    
    public Field()
    {
        this.guiField = this.createGUIFIeld();
    }


  
    
    public Field(String title)
    {
        this();
        this.setTitle(title);
    }


   
    public Field(String title, String description, String subText, Color backgroundColor, Color foregroundColor)
    {
        this(title);

        this.setDescription(description).setSubText(subText);
        this.setBackgroundColor(backgroundColor).setForegroundColor(foregroundColor);
    }


    public String getTitle()
    {
        return this.title;
    }
   
