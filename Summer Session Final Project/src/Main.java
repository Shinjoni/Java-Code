//This is the main Method  

import java.util.ArrayList;     
import java.util.Scanner;        
import java.io.BufferedWriter;    
import java.io.File;    
import java.io.FileWriter;    
import java.io.IOException;    
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
 

public class Main {       

    public static void main(String[] args) {       
        ArrayList <Object> ObjectList = new ArrayList <Object>();     
        int choiceentry;     //This was initialized to show the choices the user has  
        Scanner scanner = new Scanner(System.in);       
        do {       
            System.out.println("Enter one of the following commands:");       
            System.out.println("1 - Create Building");       
            System.out.println("2 - Create Room");       
            System.out.println("3 - Create Object");       
            System.out.println("4 - Move Object");       
            System.out.println("5 - Erase Object");       
            System.out.println("6 - Location of One Object");       
            System.out.println("7 - Save current map to a file (Write Program)");       
            System.out.println("8 - Exit Program");
            System.out.println("9 - Read into an older file (Read Program and Prints)"); 
             
            
            choiceentry = scanner.nextInt();       

            boolean create = true;     // This was set as true in order to establish an exit to the program and also continually ask users for information  

            switch (choiceentry)       
            {       
            case 1:        
                // create a building       
                System.out.println("Enter name of building");       
                String buildName = scanner.next();    
                Building Build = new Building();  //Builds the building Object  

                if(CheckDups(ObjectList,buildName)==false) //Duplicate check 
                { 
                Build.setName(buildName); // name is set  
                } 

                else 
                { 
                    System.out.println("This program does not allow duplicate name entries. Please try again"); 
                    break; 
                } 

                System.out.println("Enter the street name of the building");  
                String buildLoc = scanner.next();  
                Build.setLocation(buildLoc);  
                  
                ObjectList.add(Build);    // Object is added to the Array  
                System.out.println("The building is a: " + buildName); //prints out what the user created        
   
                break;       

            case 2:        
                // create a room        
                System.out.println("Enter a building room name: ");       
                scanner.nextLine();       
                String roomName = scanner.next();    
                buildingRoom buildRoom = new buildingRoom(); 

                if(CheckDups(ObjectList,roomName)==false)  
                { 
                buildRoom.setName(roomName); 
                } 
                else 
                { 
                    System.out.println("This program does not allow duplicate name entries. Please try again"); 
                    break; 
                } 

                //Second verse, same as the 1st but with buildingRoom being made  

                System.out.println("Enter building room location: ");       
                scanner.nextLine();       
                String roomLoc = scanner.next();       

                if(CheckLoc(ObjectList,roomLoc) == true && CheckLoc2(ObjectList,roomLoc)==false) 
                { 
                ObjectList.add(buildRoom); //Adds the object after both Name and Location are created 
                buildRoom.setLocation(roomLoc); //Set the room name 
                System.out.println("The " + roomName + " is here: " + roomLoc);     //prints what the user made 
                } 

                else 
                { 
                	System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                } 
                  
                break;       

            case 3:        
                //Second case statement to define the logic behind the objects  
                System.out.println("Please choose between the following: \n 1. Person \n 2. Clothing \n 3. CanStore_CannotMove \n 4. CanMove_CanStore \n 5. CanMove_CannotStore \n 6. CannotMove_CannotStore");      
   
                Scanner userInput2 = new Scanner(System.in);          
                int choiceentry2 = userInput2.nextInt();          
                boolean create2 = true;  

                switch (choiceentry2)          
                //Same logic as the first choice-entry and create1  
                {      
                case 1: //Person      
                    do {        
                        System.out.println("Enter name of the Person");       
                        scanner.nextLine();       
                        String name = scanner.next();       
                        Person human = new Person(); 

                        if(CheckDups(ObjectList,name)==false)  
                        { 
                        human.setName(name);       
                        } 
                        else 
                        { 
                            System.out.println("This program does not allow duplicate name entries. Please try again"); 
                        } 

                        System.out.println("Enter location of the Person");       
                        scanner.nextLine();       
                        String location = scanner.next(); 
                        if(CheckLoc(ObjectList,location) == true) 

                        { 
                        human.setLocation(location);  
                        ObjectList.add(human);  
                        System.out.println("The " + name + " is here: " + location);       
                        } 

                        else 

                        { 
                            System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                        } 

                        //Same process as in case One, build the Human, set the name, Set the location and then add it to the Array List  

                        break;  

                    }while(create2 == false);        
  
                    break;        

                case 2: // Clothing       
                    do {         
                        System.out.println("Enter name of object");        
                        scanner.nextLine();        
                        String name = scanner.next();       
                        Clothing AAO= new Clothing(); 
                
                        if(CheckDups(ObjectList,name)==false)  
                        { 
                        AAO.setName(name);        
                        } 

                        else 
                        { 
                            System.out.println("This program does not allow duplicate name entries. Please try again"); 
                        } 

                        System.out.println("Enter location of object");        
                        scanner.nextLine();      
                        String location = scanner.next();        
                        
                        if(CheckLoc(ObjectList,location) == true) 
                        { 
                            AAO.setLocation(location); 
                            ObjectList.add(AAO);  
                            System.out.println("The " + name + " is here: " + location);        
                        } 
                        
                        else 
                        { 
                            System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                        } 
                        //Same process as in case One, build the Clothing, set the name, Set the location and then add it to the Array List  
                  
                    }while(create2 == false);       
                    break;       

                case 3: // CSCM    Can Store Cannot Move  

                    do {         
                        System.out.println("Enter name of object");        
                        scanner.nextLine();        
                        String name = scanner.next();        
                        CanStore_CannotMove CSCM = new CanStore_CannotMove(); 

                        if(CheckDups(ObjectList,name)==false)  
                        { 
                        CSCM.setName(name); 
                        } 

                        else 
                        { 
                            System.out.println("This program does not allow duplicate name entries. Please try again"); 
                        } 

                        System.out.println("Enter location of object");        
                        scanner.nextLine();        
                        String location = scanner.next();     

                        if(CheckLoc(ObjectList,location) == true) 
                        { 
                        CSCM.setLocation(location);      
                        ObjectList.add(CSCM);  
                        System.out.println("The " + name + " is here: " + location);        
                        } 

                        else 
                        { 
                            System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                        } 

                        //Same process as in case One, build the Item, set the name, Set the location and then add it to the Array List  

                         

                    }while(create2 == false);      
                    break;      
   
                case 4: //CMCS    Can Move Cannot Store  

                    do {        
                        System.out.println("Enter name of object");       
                        scanner.nextLine();       
                        String name = scanner.next();       
                        CanMove_CanStore hold = new CanMove_CanStore(); 

                        if(CheckDups(ObjectList,name)==false)  
                        { 
                        hold.setName(name);      
                        } 

                        else 
                        { 
                            System.out.println("This program does not allow duplicate name entries. Please try again"); 
                        } 
   
                        System.out.println("Enter location of object");       
                        scanner.nextLine();       
                        String location = scanner.next();       

                        if(CheckLoc(ObjectList,location) == true) 
                        { 
                        hold.setLocation(location); 
                        ObjectList.add(hold);  
                        System.out.println("The " + name + " is here: " + location); 
                        } 

                        else 
                        { 
                            System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                        } 

                        //Same     process as in case One, build the Item, set the name, Set the location and then add it to the Array List  

                    }while(create == false);      
                    break;      

                case 5: //CMNS    Can Move Not Store  

                    do {        
                        System.out.println("Enter name of object");       
                        scanner.nextLine();       
                        String name = scanner.next();       
                        CanMove_CannotStore denied = new CanMove_CannotStore(); 

                        if(CheckDups(ObjectList,name)==false)  
                        { 
                        denied.setName(name);      
                        } 

                        else 
                        { 
                            System.out.println("This program does not allow duplicate name entries. Please try again"); 
                        } 
   
                        System.out.println("Enter location of object");       
                        scanner.nextLine();       
                        String location = scanner.next();       

                        if(CheckLoc(ObjectList,location) == true) 
                        { 
                        denied.setLocation(location);  
                        ObjectList.add(denied);  
                        System.out.println("The " + name + " is here: " + location); 
                        } 

                        else 
                        { 
                            System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                        } 

                        //Same process as in case One, build the Item, set the name, Set the location and then add it to the Array List  

                    }while(create == false);      
                    break;      

                case 6: //NMNS Can not move or store 

                	do {        
                        System.out.println("Enter name of object");       
                        scanner.nextLine();       
                        String name = scanner.next();       
                        CannotMove_CannotStore nothin = new  CannotMove_CannotStore(); 

                        if(CheckDups(ObjectList,name)==false)  
                        { 
                        nothin.setName(name);      
                        } 

                        else 
                        { 
                            System.out.println("This program does not allow duplicate name entries. Please try again"); 
                        } 

                        System.out.println("Enter location of object");       
                        scanner.nextLine();       
                        String location = scanner.next(); 

                        if(CheckLoc(ObjectList,location) == true) 
                        { 
                        nothin.setLocation(location);  
                        ObjectList.add(nothin);  
                        System.out.println("The " + name + " is here: " + location); 
                        } 

                        else 
                        { 
                            System.out.println("The location that was set does not exist or cannot store that item. Pleaes try again"); 
                        } 

                        //Same process as in case One, build the Item, set the name, Set the location and then add it to the Array List  

                               

                    }while(create == false);      
                    break;        

                }      

                break; // break out of the nested switch statement  

            case 4:        

                // move object  
                do {        
                    System.out.println("Enter name of the original object");       
                    scanner.nextLine();       
                    String origin = scanner.next();       
                    System.out.println("Enter destination of the object");       
                    scanner.nextLine();       
                    String destination = scanner.next();       
   
                    System.out.println(Move(ObjectList,origin,destination));       

                }while(create == false);      
                break;       

            case 5:       
                //erase object     
                System.out.println("Enter name of the object that you want erased");       
                scanner.nextLine();       
                String erase = scanner.next();       
                Erase(ObjectList,erase);  

                break;       

            case 6:       
                //location of one object       

                do    
                {    
                    System.out.println("Enter name of the object you want to learn the location of");       
                    scanner.nextLine();       
                    String itmName = scanner.next();    
                    System.out.println(findLocation(ObjectList, itmName));    
                }    

                while(create == false);    
                break;       

            case 7:       
                
            	Write(ObjectList);
            	System.out.println("Saving Program");
                break;       

            case 8:       
           	
                create = false;   

                break;    

            case 9:  
            	Reader(ObjectList);
            	System.out.println("File read sucessfully");

            default:       

            }          

        } while (choiceentry != 8);       
         System.out.println("Good Bye");
    }       

    public static String Move(ArrayList<Object> ListofObjects,String itemName, String newLocation){         

        //This method will move one object to another location  

                int j = -1,d = -1,i,h;  // j and d are -1 in case they are not found in the list   

                for(i=0;  i < ListofObjects.size(); i++)  //Search through the ObjectList Array List  
                {         
                    if( ListofObjects.get(i).getName().contentEquals(itemName)) //If the item is in the String  
                    {   
                        j=i;        //set the value oh j to i in order to manipulate it  

                    if (ListofObjects.get(j).getMove() == false)  //if the itemName can't move exit  
                        {   
                            return itemName + " cannot move. Please try again.";         
                        }   
                    }           
                }         

                if (j==-1)  
                {         
                    return itemName + " is not in the list. Please try again.";       //If the item name is not in the list, exit  
                }         

                for(h=0;  h < ListofObjects.size(); h++)   //Loop through the list a second time for newLocation  
                {         
                    if( ListofObjects.get(h).getName().contentEquals(newLocation)) //Once location is found  
                    {   
                        d=h;                                             //Set the variable of new location  
                        if (ListofObjects.get(d).getStore() == false)  //If the newLocation cannot store  
                        {   
                            return  newLocation + " cannot hold this item. Please try again.";  
                        }   
                        if (ListofObjects.get(j).getName() == ListofObjects.get(d).getName())  //If the newLocation is the same as the Current Item  
                        {   
                             return "You cannot move an object inside of itself. Please try again.";   
                        }      
                    }   
                }  
                if (d==-1) //If the item was not found in the list  
                {         
                    return newLocation + " is not in the list";         
                }         
                ListofObjects.get(j).setLocation(ListofObjects.get(d).getName());     //After all is said and done the Object can move  
                ListofObjects.get(j).setLost(false);//Anytime a location is set isLost will be considered false. This is to make the Lost bool at Erase is changed especially after it is moved  
   
                return itemName + " has moved to " + newLocation;        
            }         

    public static void Erase(ArrayList<Object> ListofObjects, String itemName)    
    {    
        int h,i,j = -1;         
        /*    
         * Search for the item in the list    
         * Informs the user that it had objects there and where it was last seen.    
         * Informs the user that other objects have been moved out.  
         * Removes the item from the list completely    
         */   

//This method is not static because it will print out multiple statements depending on the location of the item  

        for(i=0;  i < ListofObjects.size(); i++) //Search through the Array List       
        {         
            if( ListofObjects.get(i).getName().contentEquals(itemName))  //Once the object is found       
            {    
                j=i;  
                for(h=0;  h < ListofObjects.size(); h++)   //Loop through the list a second time for things in itemName that belonged to this location  
                {         
                    if( ListofObjects.get(j).getName().contentEquals(ListofObjects.get(h).getLocation())) //Once location of other items is similar to the name of items in the list  
              {   

                System.out.println("Keep in mind that:" + ListofObjects.get(h).getName() + " has lost its location and was last seen in :" + itemName );  
                ListofObjects.get(h).setLost(true); // This will make the object at h false  
            }   
        }  
                ListofObjects.remove(j);  //Remove the object   
                System.out.println(itemName + " has been removed sucessfully");  
            }    
        }  

        if(j== -1) //if j didn't change  
        {  
            System.out.println(itemName + " is not in the list");         
        }         
        }         

    public static String findLocation(ArrayList<Object> ListofObjects, String itemName)    
    {    
        // This will search through the list and print out that item's location  
        int i;  
        for(i=0;  i < ListofObjects.size(); i++)  //Search through the ObjectList <ArrayList>  
        {         
            if( ListofObjects.get(i).getName().contentEquals(itemName))   //If the position at index i is equal to the desired itemname  
            {    
                return "The location of " + itemName + " is " + ListofObjects.get(i).getLocation();            
            }    
        }           
            return itemName + " is not in the list. Please try again";      //If the search continues all the way but doesn't find the desired itemname have the user try again.  
    }    

    public static  boolean CheckDups(ArrayList<Object> ListofObjects, String name)    
    {    

        /* This will check through the entire ListofObjects for duplicate name entries.  
         * Search through the entire list... twice  
         * See if there is are any duplicate name entries  
         * If there are just return true  
         */  
        int i,h;         
        for(i=0;  i < ListofObjects.size(); i++)         
        {         
            if(ListofObjects.get(i).getName().contentEquals(name)) 
            { 
                return true; 
            }        
        }         
        return false;    
    } 

    public static boolean CheckLoc(ArrayList<Object> ListofObjects, String location) 
    { 
        /* This will check through the entire ListofObjects for bad locations, or items that cannot store.   
         * Search through the entire list and check if the name at ArrayPostion matches the location string 
         * If so print out the getStore Boolean 
         * See if there is are any duplicate name entries  
         * If there are just return true  
         */  

        int i,h;         
        for(i=0;  i < ListofObjects.size(); i++)         
        {         

            if(ListofObjects.get(i).getName().contentEquals(location)) 
                    { 
                return ListofObjects.get(i).getStore(); 
                    }                            

        }         
        return false;    
    } 

    public static boolean CheckLoc2(ArrayList<Object> ListofObjects, String location) 
    { 
        /* This will check if the Object that it is moving into isn't an Object Room
         * True if the object moved to is a room, False if its a different object
         */  

        int i,h;         
        for(i=0;  i < ListofObjects.size(); i++)         
        {         

            if(ListofObjects.get(i).getName().contentEquals(location)) 
                    { 
                if(ListofObjects.get(i).getRoom()==true)
                	{
                	return true; 
                	}
                    }                            

        }         
        return false;    
    } 

        public static void Write(ArrayList<Object> ListofObjects) {    
            /* 
             * This is the part of the code that writes the new file or does the saving 
             * It works by sifting through the entire Array List 
             * Then it prints out the Location First and then the Building. 
             * Next it prints out all of the objects inside of that building 
             * Then it moves onto the next item in the array list. 
             * Buildings only have 2 tabs in front of them, then their objects inside 
             * BuildingRooms have 5 tabs in front of them, then their objects inside 
             * Objects have 7 tabs in front of them, then their objects inside 
             * At the end there is also a lost and found that gets printed out for Objects that got erased. 
             * There is a legend that gets printed to indicate what type of object is being printed 
             * This is created in this fashion in order for us to tell what is what when this file is being read into.
             * 
             *  It pains me to say that Linux is able to hold the /n command but Windows it not able to
             *  Therefore there are comments in the code regarding where the nextLine code is actually placed and where it is not placed
             */ 

            BufferedWriter bw = null;    
            try {    
                int i,j,h,l,f;
                
                //Specify the file name and path here    
                File file = new File("C:\\Users\\Davante\\Desktop\\file.txt");    

                if (!file.exists()) {     
                    file.createNewFile();    
                }    

                FileWriter fw = new FileWriter(file);    
                bw = new BufferedWriter(fw);
                bw.append("Item Location \t\t\t Item Name");
// Searches through the arraylist and prints out all of the Objects and their locations
                for(i=0; i < ListofObjects.size();i++)//Search the entire list
                {
                	if(ListofObjects.get(i).getBuild()==true)//If the Item is a Building
                	{
                		bw.newLine();
                		bw.append(ListofObjects.get(i).getLocation() +"\t\t\t " + ListofObjects.get(i).getName() + typeAdd(ListofObjects,ListofObjects.get(i).getName()) + " holds:" );// Prints the location of the building, Buildings are 3 tabs away from the location   
                		for(j=0; j<ListofObjects.size(); j++)
                		{
                			if(ListofObjects.get(i).getName().contentEquals(ListofObjects.get(j).getLocation()))//If the Location is located anywhere else in the arrayList
                			{
                				bw.append(" " + ListofObjects.get(j).getName() + "|");//Print out the Item
                			}
                			if(j == ListofObjects.size())
                			{
                				bw.append("nothing");
                			}
                			
                		}
                		
                	}
                	else if(ListofObjects.get(i).getRoom() == true)//If the Item is a buildingRoom
                	{
                		if(ListofObjects.get(i).isLost() == true)
                    	{
                			bw.newLine();
                    		bw.append(ListofObjects.get(i).getLocation() + "\t\t\t\t\t " + ListofObjects.get(i).getName()+ typeAdd(ListofObjects,ListofObjects.get(i).getName()) + ".l is lost, it was last seen inside:" + ListofObjects.get(i).getLocation() + ". " + ListofObjects.get(i).getName()+ " was also holding:");
                    	}
                		else
                		{
                			bw.newLine();
                			bw.append(ListofObjects.get(i).getLocation() + "\t\t\t\t\t " + ListofObjects.get(i).getName()+ typeAdd(ListofObjects,ListofObjects.get(i).getName()) + " holds:");// Building Rooms are 5 tabs away	
                		}
                		
                		for(h = 0; h < ListofObjects.size(); h++)
                		{
                			if(ListofObjects.get(i).getName().contentEquals(ListofObjects.get(h).getLocation()))//If the location is located anywhere else in the arrayList
                			{
                				bw.append(" " + ListofObjects.get(h).getName() + "|");//Print out the Item 
                			}
                			if(h == ListofObjects.size())
                			{
                				bw.append("nothing");
                			}
                		}
                	}
                	else if(ListofObjects.get(i).getObj() == true) // This is the Code to write the Objects and what they hold
                	{
                		if(ListofObjects.get(i).isLost() == true)
                    	{
                			bw.newLine();
                    		bw.append(ListofObjects.get(i).getLocation() + "\t\t\t\t\t\t\t " + ListofObjects.get(i).getName() + typeAdd(ListofObjects,ListofObjects.get(i).getName()) + ".l is lost, it was last seen inside:" + ListofObjects.get(i).getLocation() + ". " + ListofObjects.get(i).getName()+ " was also holding:");
                    	}
                		else
                		{
                		bw.newLine();
                		bw.append(ListofObjects.get(i).getLocation() + "\t\t\t\t\t\t\t " + ListofObjects.get(i).getName() + typeAdd(ListofObjects,ListofObjects.get(i).getName()) + " holds:"); // Objects are 7 tabs away
                		}
                		for(l = 0; l < ListofObjects.size(); l++) // check the entire list
                		{
                			if(ListofObjects.get(i).getName().contentEquals(ListofObjects.get(l).getLocation())) //once the Location of the Object is the same as another object, print that object in the list.
                			{
                				bw.append(" " + ListofObjects.get(l).getName() + "|"); // Print out the items that are inside of the original object
                			}
                			if(l == ListofObjects.size())
                			{
                				bw.append("nothing");
                			}
                		}
                	}
                }
                //This is the legend code. Also this was a pain to rewrite for windows.
                bw.newLine();
                bw.newLine();
                bw.newLine();
                bw.append("Legend");
                bw.newLine();
                bw.append(".b = building");
                bw.newLine();
                bw.append(".r = buildingRoom");
                bw.newLine();
                bw.append(".p = person");
                bw.newLine();
                bw.append(".c = clothing");
                bw.newLine();
                bw.append(".o = CanMove CanStore");
                bw.newLine();
                bw.append(".s = CanStore Cannot Move");
                bw.newLine();
                bw.append(".m = CanMove Not store");
                bw.newLine();
                bw.append(".z = NoMove NoStore");
                bw.newLine();
                bw.append(".l = item is lost");
                // legacy "I worked so hard to get this on debian code" bw.append("\n\n\n Legend: +" bw.newLine(); + "\n .b = building\n .r = buildingRoom\n .p = person\n .c = clothing\n .ms = CanMove CanStore\n .s = CanStore Cannot Move\n .m = CanMove Not store\n .s = CanStore CannotMove\n .z= NoMove NoStore\n .l = item is lost");

                System.out.println("File written Successfully");    
                bw.flush();    

            } catch (IOException ioe) {    

                ioe.printStackTrace();    

            }    

            finally    

            {    

                try{    

                    if(bw!=null)    

                        bw.close();    

                }catch(Exception e){    

                    System.out.println("Error in closing the Buffered Writer");    

                }    

            }    

        }    
        public static String typeAdd(ArrayList<Object> ListofObjects,String itemName)
        {
        	/*
        	 * This is the code that appends the legend at the end of each item
        	 * It works by using the typeAdd method with the name of the Object from the other methods
        	 * Method Ception?
        	 */
        	int i;
        	for (i=0; i<ListofObjects.size();i++)
        	{
        		if(ListofObjects.get(i).getName().contentEquals(itemName))
        		{
        			if(ListofObjects.get(i).getBuild() == true)
        			{
        				return ".b";
        			}
        			if(ListofObjects.get(i).getRoom() == true)
        			{
        				return ".r";
        			}
        			if(ListofObjects.get(i).retTyp() == "Person")//Person class
        			{
        				return ".p";
        			}
        			if(ListofObjects.get(i).retTyp() == "NM_NS") //Can't Move/Store
        			{
        				return ".z";
        			}
        			if(ListofObjects.get(i).retTyp() == "CS_NM")//Can Store Not Move
        			{
        				return ".s";
        			}
        			if(ListofObjects.get(i).retTyp() == "CM_NS")//Can Move not Store
        			{
        				return ".m";
        			}
        			if(ListofObjects.get(i).retTyp() == "CM_CS")//CanMove +Store
        			{
        				return ".o";
        			}
        			if(ListofObjects.get(i).retTyp() == "Clothing")
        			{
        				return ".c";
        			}
        		}
        	}
        	return "";
        }

        public static void Reader(ArrayList<Object> ListofObjects)
        { 
            { 
            	int i,j,k,l;
//            	int startN,endN,startL,endL;
                BufferedReader reader = null; 
                try { 
                    String sCurrentLine; 
                    reader = new BufferedReader(new FileReader("C:\\Users\\Davante\\Desktop\\file.txt")); 
                    while ((sCurrentLine = reader.readLine()) != null) { 
                    	//logic for the code goes here bub...
                   
                    	if(sCurrentLine.contentEquals(""))
                    	{
                    		continue;
                    	}
                    	//Find the building Location and building name, then set that as a variable in the code
                    	
                    	else if (sCurrentLine.contains(".b") && sCurrentLine.contains(":")) //If this line has a ".b" or a building in it
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if(sCurrentLine.substring(i).startsWith("\t") && endL==0)
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every building is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Realisitically, after the first tab this should stop
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String buildLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String buildName = sCurrentLine.substring((startN+1), endN);
                    		//Create a building variable and set the Location along with the Name
                    		Building Build = new Building();  //Builds the building Object
                    		Build.setLocation(buildLoc);  
                            Build.setName(buildName);
                            ListofObjects.add(Build);    // Object is added to the Array 
                    	}
                  
                    	else if (sCurrentLine.contains(".r") && sCurrentLine.contains(":")) //If this line has a ".r" so a building room
                    	{
                    		// ok in the interest of time, these objects were copied and pasted due to their similiarity. If I had more time I would have probably made this into a method and tested it 
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String RoomLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String RoomName = sCurrentLine.substring((startN+1), endN);
                    		System.out.println(RoomLoc + " " + RoomName);
                    		//Create a building variable and set the Location along with the Name
                    		buildingRoom Room = new buildingRoom();  //Builds the building Object
                    		Room.setLocation(RoomLoc);  
                            Room.setName(RoomName);
                            ListofObjects.add(Room);    // Object is added to the Array 
                    	}
                    	else if (sCurrentLine.contains(".p") && sCurrentLine.contains(":")) //If this line has a ".p" or a person in it
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String ObjLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String ObjName = sCurrentLine.substring((startN+1), endN);
                    		// For testing purposes: System.out.println(RoomLoc + " " + RoomName);
                    		Person human = new Person();  //Builds the building Object
                    		if (sCurrentLine.contains(".l"))
                            {
                            	human.setLost(true);
                            }
                    		human.setLocation(ObjLoc);  
                            human.setName(ObjName);
                            ListofObjects.add(human);    // Object is added to the Array 
                    	}
                    	else if (sCurrentLine.contains(".c") && sCurrentLine.contains(":")) //If this line has a ".c" or clothing in it
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String ObjLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String ObjName = sCurrentLine.substring((startN+1), endN);
                    		//Create a building variable and set the Location along with the Name
                    		Clothing clothes = new Clothing();  //Builds the building Object
                    		if (sCurrentLine.contains(".l"))
                            {
                            	clothes.setLost(true);
                            }
                    		clothes.setLocation(ObjLoc);  
                            clothes.setName(ObjName);
                            ListofObjects.add(clothes);    // Object is added to the Array 
                    	}
                    	else if (sCurrentLine.contains(".o") && sCurrentLine.contains(":")) //If this line has a ".o" or CanMove & CanStore
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String ObjLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String ObjName = sCurrentLine.substring((startN+1), endN);
                    		// For testing purposes: System.out.println(RoomLoc + " " + RoomName);
                    		//Create a building variable and set the Location along with the Name
                    		CanMove_CanStore cmcs = new CanMove_CanStore();  //Builds the building Object
                    		if (sCurrentLine.contains(".l"))
                            {
                            	cmcs.setLost(true);
                            }
                    		cmcs.setLocation(ObjLoc);  
                            cmcs.setName(ObjName);
                            ListofObjects.add(cmcs);    // Object is added to the Array 
                    	}
                    	else if (sCurrentLine.contains(".s") && sCurrentLine.contains(":")) //If this line has a ".s" or CanStore not Move
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String ObjLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String ObjName = sCurrentLine.substring((startN+1), endN);
                    		//Create a building variable and set the Location along with the Name
                    		CanStore_CannotMove csnm = new CanStore_CannotMove();  //Builds the building Object
                    		if (sCurrentLine.contains(".l"))
                            {
                            	csnm.setLost(true);
                            }
                    		csnm.setLocation(ObjLoc);  
                            csnm.setName(ObjName);
                            ListofObjects.add(csnm);    // Object is added to the Array 
                    	}
                    	else if (sCurrentLine.contains(".m") && sCurrentLine.contains(":")) //If this line has a ".m" or is only moveable in it
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String ObjLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String ObjName = sCurrentLine.substring((startN+1), endN);
                    		// For testing purposes: System.out.println(RoomLoc + " " + RoomName);
                    		//Create a building variable and set the Location along with the Name
                    		CanMove_CannotStore cmns = new CanMove_CannotStore();  //Builds the building Object
                    		if (sCurrentLine.contains(".l"))
                            {
                            	cmns.setLost(true);
                            }
                    		cmns.setLocation(ObjLoc);  
                            cmns.setName(ObjName);
                            ListofObjects.add(cmns);    // Object is added to the Array 
                    	}
                    	else if (sCurrentLine.contains(".z") && sCurrentLine.contains(":")) //If this line has a ".z" or a building in it
                    	{
                    		int startN=0,endN=0,startL=0,endL=0;
                    		for(i=0; i<sCurrentLine.length()-1; i++) // Search the entire string of this line
                    		{
                    			if( (endL ==0) && (sCurrentLine.substring(i).startsWith("\t") ))
                    				/*Starting from the beginning and ending with the last character before the tab.
                    				 * The start of every room has 5 tabs is just the location without any spaces
                    				 * There can be multiple spaces if there are a lot of things inside the building
                    				 * 
                    				 * Stops after the first tab
                    				 */
                    			{
                    				endL = i; //swap the value of end with i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith(" ") && endN == 0 ) 
                    				/* 
                    				 * if The current line has a space (all of them have a space before writing the name of the building, by design of course)
                    				 * Then that value at i will be one character away from the start of the string
                    				 * The && operator is there to avoid the problem when this line holds other items and there is a space there. 
                    				 */ 
                    			{
                    				startN = i;
                    			}
                    			if(sCurrentLine.substring(i).startsWith("."))
                    			/*
                    			 * This dot locator is put in place in order to find the .b. 
                    			 * For the reader the program already knows this is going to be a building
                    			 */
                    			{
                    				endN = i;
                    			}
                    		}
                    		String ObjLoc = sCurrentLine.substring(startL,endL); //buildLoc finally has the value of the location part of the string
                    		String ObjName = sCurrentLine.substring((startN+1), endN);
                    		// For testing purposes: System.out.println(RoomLoc + " " + RoomName);
                    		//Create a building variable and set the Location along with the Name
                    		CannotMove_CannotStore nmns = new CannotMove_CannotStore();  //Builds the building Object
                    		nmns.setLocation(ObjLoc);  
                            nmns.setName(ObjName);
                            if (sCurrentLine.contains(".l"))
                            {
                            	nmns.setLost(true);
                            }
                            ListofObjects.add(nmns);    // Object is added to the Array 
                    	}

                    	System.out.println(sCurrentLine);
                    	}
                         
                }     
          
                
            catch (IOException e) { 
                    e.printStackTrace(); 
                    System.out.print(e.getMessage()); 
                } finally { 
                    try { 
          
                        if (reader != null)reader.close(); 
                    } catch (IOException ex) { 
                        System.out.println(ex.getMessage()); 
                        ex.printStackTrace(); 
                    } 
                } 
            } 
        } 
         
    }   

 