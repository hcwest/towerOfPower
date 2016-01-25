
/**
 * Write a description of class SpecialLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialLevel extends Room
{
    

    /**
     * Constructor for objects of class SpecialLevel
     */
    public SpecialLevel(String description)
    {
        super(description);
    }

   public String getShortDescription()
    {
        if (getDescription().equals("Dusty Room")) {
            return "You are in a " + getDescription() +".\n" + getItemsString() + "\n" + ". pick a to exit back to level 15.";
        }
        else if (getDescription().equals("Treasure Room")) {
            String description = "";

            description += "You are in a " + getDescription() + ".\n";
            description += "There is a dragon here. OMG" + "\n";
    
            return description;
        }
        else 
        {
            return "I have no idea where you are";
        }
    }
}
