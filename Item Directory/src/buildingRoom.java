public class buildingRoom extends Object {   

   

private boolean canMove = false;  

private boolean canHold= true;  

private boolean isRoom = true;  

private boolean isbuilding = false;  

private boolean isLost =false; 

private boolean isObj = false;  

public void setLost(boolean lost) 

{ 

    isLost=lost; 

} 

  

//The methods below must be there in order to override the Object class and return the desired result. 

  

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
} 