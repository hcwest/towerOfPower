import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String,Item>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public void setItem(String name, Item item)
    {
        items.put(name,item);
    }

    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return "You are on " + description +".\n" + getItemsString() + ".\n" ;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return description + ".\n"  + getExitString() + ".\n" + getItemsString();
    }
    

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public String getItemsString()
    {
        String returnString = "You see these items: ";
        Set<String> keys = items.keySet();

        if(keys.size() == 0)
        {
            return "There are no items in the room :(";
        }
        else
        {
            int count = 0;
            for(String name : keys) {
                count++;
                returnString += name;
                if(count < keys.size())
                {
                    returnString += ", ";
                }
            }
        }

        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public Item getItem(String name) 
    {
        return items.get(name);
    }

    public void changeDescription(String newDescription)
    {
        description = newDescription;
    }

    public void unlock(Command command)
    {
        System.out.println("Unlock what?");

    }

    public void grab(Command command, HashMap<String,Item> bag)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Grab what?");
            return;
        }
        String thing = command.getSecondWord();
        Item item = getItem(thing);
        if (item == null)
        {
            System.out.println("I couldn't find what you're talking about...");
            return;
        }
        else
        {
            bag.put(thing,item);
            items.remove(thing);
            System.out.println("Putting " + thing + " in your bag..." + item.getItemDescription());
            System.out.println("What do you want to do now?");
        }
    }

    public boolean unlock(Command command, HashMap<String,Item> bag)
    {
        //if you have a key in your bag, then continue
        
        
        if (bag.get("key") != null)
        {
            System.out.println("You use the key you picked up to open the door...");
            //if you opened the door, then move into 15A
            return true;
        }else
        {
            System.out.println("How can you unlock a door without a key, dummy?");
            return false;
            
        }
    }

}

