public class CanMove_CannotStore extends Object {  

private boolean canMove = true;  

private boolean canHold= false;  

private boolean isRoom = false;  

private boolean isbuilding = false;  

private String type ="CM_NS";  

private boolean isLost=false; 

private boolean isObj =true;
  

public void setLost(boolean lost) 

{ 

    isLost = lost; 

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

  

  

 