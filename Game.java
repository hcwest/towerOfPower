import java.util.ArrayList;
import java.util.HashMap;

/**
 *  This class is the main class of the "Tower of Power" application.
 * 

 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    public int counter;
    public HashMap<String, SpecialLevel> specialLevels;
    public HashMap<String,Room> rooms;
    public HashMap<String,Item> bag;
    private ParserWithFileInput parserWithFileInput;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {

        parser = new Parser();
        counter = 0;
        
        parserWithFileInput = new ParserWithFileInput();
        createRooms();
        play();
    }
    
    private void clear()
    {
        specialLevels = new HashMap<String, SpecialLevel>();
        bag = new HashMap<String,Item>();
        rooms = new HashMap<String,Room>();
    }
    
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        clear();
        
        Room level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12, level13, level14, level15, level16, level17, level18, level19, level20;
        SpecialLevel level15A, treasureRoom;
        // create the rooms
        level1 = new Room("Level 1 \nYou have entered the tower. Before you lies an item box. Grab these items. \nYou see four different stair cases. Pick the correct one (a, b, c, or d) or be cast back outside. \n"); rooms.put(level1.getDescription(), level1); 
        level2 = new Room("Level 2 \nYou walk up the staircase and enter the new room. This room has a foul stentch. You notice that the path to the next level is guarded by a huge 3 headed dog beast. \nHow do you distract it? \na)Sing it a lullaby. b)Rub it's belly. c)Throw something for it to fetch. d)Sneak quietly past it." ); rooms.put(level2.getDescription(), level2);
        level3 = new Room("Level 3 \nYou have escaped the beast! This new floor just has four colored levers in the middle of the room. \nWhich color do you choose to pull? \na)red. b)blue. c)green. d)yellow" ); rooms.put(level3.getDescription(), level3);
        level4 = new Room("Level 4 \nA ladder drops from the ceiling and you climb it to the next level. \nThis new room is very dark. You can barely see your hand in front of your face. \nYou hear a strange rumbling noise coming from the darkness. What do you do? \na)Walk towards the sound b)Ask 'Who's there?' c)Wave arms fantically while running towards sound d)'This is why people die in horror movies'" ); rooms.put(level4.getDescription(), level4);
        level5 = new Room("Level 5 \nWhen you ask 'Who's there?' you get no response. You walk toward that sound and notice it is a broken chain hanging from a doorway. \nSomeone must have broken through this previously locked door.... \nYou walk through the doorway and go up a ladder. This level looks like a library. \nYou notice a bookcase with an item on it. Looks like a sword hilt. Grab this item. \nYou see a few books on this same bookcase. You decide to pick one up. Which one catches your eye? \na)Dictionary b)Encyclopedia c)Harry Potter d)Objects First with Java" ); rooms.put(level5.getDescription(), level5);
        level6 = new Room("Level 6 \nYou pull on the book and it opens a bookcase door with stairs behind it. You walk up. \nBefore you now are four big beatufully crafted doors, all made from a unique material. \nYou admire the craftsmenship and decide to go through the most beautiful door. \nWhich door do you think is the most beautiful? \na)The bronze door. b)The iron door. c)The mahogany door. d)The glass door." ); rooms.put(level6.getDescription(), level6);
        level7 = new Room("Level 7 \nThe door leads you to a staircase. You climb it and walk into a dining room. \nYou see an armed guard sitting at a long table. He has four cups of wine before him. \nHe tells you that three out of four of the cups of wine contains poison. \nHe tells you to drink one of the cups. If you survive his test, he promises to lead you to the next level. \nWhich cup do you drink from? \na)That one. b)That one. c)That one. d)That one."  ); rooms.put(level7.getDescription(), level7);
        level8 = new Room("Level 8 \nYou survive the guard's test and he shows you the next floor. When you go inside, the guard laughs, steps outside of the door, and locks you inside. \nAs you realize his betrayal, you also notice a large grotesque ogre with a wooden club charging at you. \nYou have a split second to do something or the ogre will smash your skull in. What do you do? \na)Roll dodge to the left. b)Slide under his legs. c)Fist fight him. d)Get in the fetal position." ); rooms.put(level8.getDescription(), level8);
        level9 = new Room("Level 9 \nYour sliding manuvor confuses the orge. As he is looking a round, he becomes dizzy and falls over. \nYou easily walk into the next room unscathed. \nIn here you find another set of colored levers. This tower seems to have a lot of levers... \nWhich color do you pull? \na)red b)blue c)green d)yellow " ); rooms.put(level9.getDescription(), level9);
        level10 = new Room("Level 10 \nA secret doorway is opened and it leads you to a spiral stair case. \n You walk into a room with a reflective pool. You notice a black sword sheath mounted on a table. Grab this item. \nWhile destracted by the sheath, you don't notice that the pool is overflowing. \nIt becomes apparent that the room is flooding at a fast rate. \nAs the water rises above your head, what action do you take? \na)Start swimming b)Relax and float on the top of the water c)Hold your breath d)Cut your loses " ); rooms.put(level10.getDescription(), level10);
        level11 = new Room("Level 11 \nYou float to the ceiling and notice a hole in the ceiling and you float up through it. \nYou have arrived in a big room with a tiny chess table in the center. \nYou inspect it and notice that there was a gome in progress before the table was abandoned. \nYou decide to play the next move with the chess pieces closest to you. What move do you make? \na)Rook to B5 b)Bishop to E3 c)Queen to A1 d)Pawn to D8" ); rooms.put(level11.getDescription(), level11);
        level12 = new Room("Level 12 \nCheckmate! Your correct move seems to have activated a secret ladder. \nThis next level has a prison cell in it, and an old dirty prisoner resides in it. \nHe asks you to free him. If you do, he promises to take you to the next floor. What do you do? \na)Free him b)Ignore him c)Throw a rock at him d)'I can't trust a prisoner'" ); rooms.put(level12.getDescription(), level12);
        level13 = new Room("Level 13 \nYou hit the prisoner in the head with the rock and exclaim 'I can see the stairs right over there!' \nYou climb the stairs and enter a new level. A strange man appears before you and asks 'Where ya headed?' \nYou don't trust this man. Something is off about him. What do you say to him? \na)'Get lost creep' b)*lie* 'I'm going down' c)'Why do you care?' d)'I'm going all the way to the top!'" ); rooms.put(level13.getDescription(), level13);
        level14 = new Room("Level 14 \nThe man replies 'Well, if you're going up, just climb that ladder over there' His smirk makes you very suspisous. \nYou go up. You find a sleeping giant blocking the path. You have to wake him up to move him. \nHow do you wake him up? \na)Scream in his ear. b)Poke him with a sharp object. c)Play your flute. d)Bang on a noisy object" ); rooms.put(level14.getDescription(), level14);
        level15 = new Room("Level 15 \nThe flute wakes the giant, and he moves aside. "  + " There is a large wooden a bronze lock... \nYou can use your key be typing 'unlock' \nType 'pick a' to move on to skip the door"); rooms.put(level15.getDescription(), level15);
        level15A = new SpecialLevel("Dusty Room" + "/nYou meet a wise sage named Nikhil. He sees your bag with the sword pieces. \nHe asks 'May I inspect those objects?' \n'Wow, this is a very powerful sword. It could defeat any enemy. But you must unlock its power. The sword will talk to you when the time is right. \nType 'pick a' to go to the next level." ); specialLevels.put(level15A.getDescription(), level15A);
        level16 = new Room("Level 16 \nThis room has thousands of snakes everywhere. One slithers over your shoe. You are deathly afraid of snakes. \nWhat do you do? \na)Scream and run. b)Find rope and swing over the snake pits. c)Step carefully around the snakes. d)Trip and fall into the snakes" ); rooms.put(level16.getDescription(), level16);
        level17 = new Room("Level 17 \nYou escape succesfully to the next level. \nA wizard appears before you. He begins chanting a spell.  What do you do before he finishes his chant? \na)Push him down b)Throw a rock at him c)Hit him in the face d)Counter spell" ); rooms.put(level17.getDescription(), level17);
        level18 = new Room("Level 18 \nYour attemts stop the wizard chant and his spell is interupted. You flee to the next level. \nYou have yet another enemy to face. This time it is a large warrior with a large broad sword. \nHe lunges towords you and swings his blade. How do you counter? \na)Duck! b)Use the sheath to block his blow. c)Dodge and throw a punch. d)Jump over this swing" ); rooms.put(level18.getDescription(), level18);
        level19 = new Room("Level 19 \nHe swings and misses you. His blade gets stuck when he strikes the door post. You use this time to escape to the next floor. \nYou find a shining blade that is sharp to the touch. This is the final piece to your mysterious sword! Grab this item. \n You Hear a loud roar upstairs. What do you do? \na)Face the challenge head on b)Decide to leave c)Chicken out d)'Screw this I'm out'" ); rooms.put(level19.getDescription(), level19);
        level20 = new Room("Level 20 \nYOU HAVE REACHED THE FINAL BOSS \nYou stand before a powerful dragon. It seems to be guarding the final room. \nYou remember your powerful sword, and pull it from it's sheath. You then hear whispers as the blade glows bright. \nThe sword is speaking to you.... \n'To unlock my power, you must answer one question to prove you are worthy to wield me.' \n'..............' \n'...............' \n'What is the proper data type of this value: 'java'' \na)boolean b)int c)String d)double" ); rooms.put(level20.getDescription(), level20);
        treasureRoom = new SpecialLevel("Treasure Room \nYou raise your sword high as it summons its power. You lung at the dragon with great swiftness. \nYou plunge your blade right into the dragon's heart, and the sword unleashes its most powerful blow. \nYou obliterate the dragon and find that it was guarding a huge pile of treasures. \nCongrats! You're rich. You got the top in " + counter +" attempts. \nType 'quit' to end the game." ); specialLevels.put(treasureRoom.getDescription(), treasureRoom);

        // initialise room exits
        level1.setExit("d", level2);
        level2.setExit("a", level3);
        level3.setExit("c", level4);
        level4.setExit("b", level5);
        level5.setExit("d", level6);
        level6.setExit("c", level7);
        level7.setExit("b", level8);
        level8.setExit("b", level9);
        level9.setExit("a", level10);
        level10.setExit("b", level11);
        level11.setExit("c", level12);
        level12.setExit("c", level13);
        level13.setExit("d", level14);
        level14.setExit("c", level15);
        level15A.setExit("a", level15);
        level15.setExit("a", level16);
        level16.setExit("b", level17);
        level17.setExit("d", level18);
        level18.setExit("a", level19);
        level19.setExit("a", level20);
        level20.setExit("c", treasureRoom);

        Item handle, hilt, sheath, blade, key;
        handle = new Item("handle", "The handle of what was a sword at some point in time");
        hilt = new Item("hilt", "Looks like another piece of the sword. We should combine this hilt with the handle.");
        sheath = new Item("sheath", "Oh look, its a sheath! If only you could find a blade!");
        blade = new Item("blade", "There is a glowing blue blade in the center of the room...The final piece of the sword.");
        key = new Item("key", "This bronze key opens something...");

        level1.setItem(handle.getItemName(),handle);
        level1.setItem(key.getItemName(),key);
        level5.setItem(hilt.getItemName(),hilt);
        level10.setItem(sheath.getItemName(),sheath);
        level19.setItem(blade.getItemName(),blade);

        
        //outside.setExit("east", theater);
        //outside.setExit("south", lab);
        //outside.setExit("west", pub);

        //theater.setExit("west", outside);

        //pub.setExit("east", outside);

        //lab.setExit("north", outside);
        //lab.setExit("east", office);

        //office.setExit("west", lab);

        //currentRoom = outside;  // start game outside

        currentRoom = level1;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        
        
        
        System.out.println();
        System.out.println("   _  _  _");
        System.out.println("   |- - -|");
        System.out.println("   |-----|");
        System.out.println("    |---| ______   ___   __    __    ___  ____        ___   _____      ____    ___   __    __    ___  ____  ");
        System.out.println("    |-[]||      ||     ||  |  |  | /  [_ |  D  )    |     ||   __|    |  o  )|     ||  |  |  | /  [_ |  D  )");
        System.out.println("    |---||_|  |_||  O  ||  |  |  ||    _]|    /     |  O  ||  |_      |   _/ |  O  ||  |  |  ||    _]|    / ");
        System.out.println("    |---|  |  |  |     ||  `  '  ||   [_ |    \\     |     ||   _]     |  |   |     ||  `  '  ||   [_ |    \\ ");
        System.out.println("    |---|  |  |  |     | \\      / |     ||  .  \\    |     ||  |       |  |   |     | \\      / |     ||  .  \\");
        System.out.println("    |[]-|  |__|   \\___/   \\_/\\_/  |_____||__|\\_|     \\___/ |__|       |__|    \\___/   \\_/\\_/  |_____||__|\\_|");
        System.out.println("");
        System.out.println("Welcome to the Tower of Power!");
        System.out.println("Do you have what it takes to get to the top?");
        System.out.println("A unique challenge awaits you on each of the 20 levels.");
        System.out.println("If you fail a challenge, you will be cast back to the ground level and will have to start again");
        System.out.println("Can you reach the top in the least amount of attempts?");
        System.out.println("Grab items along your way and place them in your bag.");
        System.out.println("You may need them later...");
        
        System.out.println("");
        System.out.println("Type 'pick' and then a letter choice (a, b, c, or d) to perform an action.");
        System.out.println("Type 'grab' to pick up an item if you find one.");
        System.out.println("Type 'help' for assistence.");
        System.out.println("Type 'quit' to end your game.");
        System.out.println();
        System.out.println();
        System.out.println(currentRoom.getShortDescription());
        
     
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("pick")) {
            goRoom(command);
        }
        else if (commandWord.equals("bag")) {
            showBag(command);
        }
        else if (commandWord.equals("grab"))
        {
            currentRoom.grab(command, bag);
        }

        else if (commandWord.equals("unlock"))
        {
            SpecialLevel specialLevel = specialLevels.get("Dusty Room");
            if(currentRoom.unlock(command, bag))// currentRoom, specialLevel);
            {   
                currentRoom = specialLevel;
                System.out.println(currentRoom.getShortDescription());
            }
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Having trouble?");
        System.out.println("");
        System.out.println("");
        System.out.println("Your command words are:");
        System.out.println("pick - Type this first before choosing an action");
        System.out.println("a, b, c, d - Type after 'pick' to choose which action to take.");
        System.out.println("grab - Type this to put items in your bag.");
        System.out.println("bag - Type this to check the contents of your bag.");
        System.out.println("quit - It speaks for itself");
        //parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Pick what?");
            return;
        }

        String direction = command.getSecondWord();

        //if(!secondWord.equals("a") && !secondWord.equals("b") &&!secondWord.equals("c") &&!secondWord.equals("d"))
        //{
        //System.out.println("You did not pick a, b, c, or d. Wow...seriously? Your punishment...");

        //}

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        //if(currentRoom)
        //{
        //  System.out.println("test");
        //}

        if (nextRoom == null) {
            System.out.println("You have been cast back to Level 1");
            counter++;
            System.out.println("Attempts: " + counter);
            createRooms();

            System.out.println(currentRoom.getShortDescription());

        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());

            //if its the treasure room and if you don't have enough sword pieces, then get kicked out.
            if(currentRoom.getDescription().equals("Treasure Room"))
            {
                if(bag.get("handle") != null && bag.get("hilt") != null && bag.get("sheath") != null && bag.get("blade") != null)
                {
                    //you win
                    System.out.println("Your bag contains all of the pieces of the sword. The sword magically assembles itself!");
                    System.out.println("You pull the sword out of your bag and jab it through the dragon's heart!");
                    System.out.println("You beat the dragon!");

                }
                else
                {
                    System.out.println("You reach in your bag and you don't have a sword.");
                    System.out.println("Dragon eats you.");
                    System.out.println("You have been cast back to Level 1");
                    counter++;
                    System.out.println("Attempts: " + counter);
                    createRooms();

                    System.out.println(currentRoom.getShortDescription());

                }
            }
        }

    }

    private void showBag(Command command)
    {
        System.out.println("Showing what's in your bag...");
        int count = 0;
        for (String key: bag.keySet())
        {
            count++;
            System.out.print(bag.get(key).getItemName());
            if(count < bag.size())
            {
                System.out.print(", ");
            }
        }

        System.out.println("");
        System.out.println("You have " + count + " item(s) in your bag.");
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    public void playWithFileInput()
    {
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parserWithFileInput.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
}
