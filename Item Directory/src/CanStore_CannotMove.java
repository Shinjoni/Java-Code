public class CanStore_CannotMove extends Object {  

private boolean canMove = false;  

private boolean canHold = true;  

private boolean isRoom = false;  

private boolean isbuilding = false;  

private String type ="CS_NM";  

private boolean isLost =false; 

private boolean isObj = true;
//The methods below must be there in order to override the Object class and return the desired result. 

public void setLost(boolean lost) 

{ 

    isLost=lost; 

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

  

  

 