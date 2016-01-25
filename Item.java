import java.util.ArrayList;
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
        
        
    }

    public String getItemName()
    {
        return name;
    }
    
    public String getItemDescription()
    {
        return description;
    }
    
    
    
}
