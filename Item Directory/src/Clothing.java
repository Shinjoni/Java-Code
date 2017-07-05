public class Clothing extends Object {  

private boolean canMove = true;  

private boolean canHold = true;  

private boolean isRoom = false;  

private boolean isbuilding = false;  

private String type ="Clothing";  

private boolean isLost =false; 

private boolean isObj = true; 

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
public String retTyp()
{
	return type;
}
} 

//Set variable for type of clothing and if it can have pockets. Might be an if gate  

  

  

  

 