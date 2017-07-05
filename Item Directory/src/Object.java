public class Object {   

 

private String name = "";  //Name of the object (building, room,) for the user

private String type = "";

private boolean canMove=false;   // A switch that determines if the object can move   

private String Location = "";  // The location if object. This is defined by the name of the string   

private boolean canHold=false;   // A switch that determines if the object can store items  

private boolean isbuilding=false;// A switch that says this is a building  

private boolean isRoom=false;    // A switch that says that this is a room. 

private boolean isLost=false; 

private boolean isObj=false;

public void setName(String ObjectName)   

{   

name=ObjectName;   

}   

public String getName() //Object name get method   

{   

return name;    

}   

public void setLost(boolean lost) 

{ 

    isLost=lost; 

} 

   

  

public void setLocation (String ObjectLocation)   

{   

Location= ObjectLocation;    

}   

public String getLocation()    

{   

return Location;   

}   

  

public boolean getRoom() 

{ 

    return isRoom; 

}   

  

public boolean getBuild() 

{ 

    return isbuilding; 

}   

   

  

public boolean getMove() {   

return canMove;   

}   

public boolean getStore() {    

return canHold;   

}   

public boolean isLost() 

{ 

    return isLost; 

} 
public boolean getObj()
{
	return isObj;
}

public String retTyp()
{
	return type;
}
} 