/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.io.Serializable;
import java.util.*;

// line 17 "../../../../EMSPersistence.ump"
// line 34 "../../../../EMSmodel.ump"
public class ElectionBody implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionBody Attributes
  private String nameOfBody;

  //ElectionBody Associations
  private List<Position> positions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ElectionBody()
  {
    nameOfBody = null;
    positions = new ArrayList<Position>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNameOfBody(String aNameOfBody)
  {
    boolean wasSet = false;
    // line 37 "../../../../EMSmodel.ump"
    if (aNameOfBody == null || aNameOfBody.trim().length() == 0) {
     	throw new RuntimeException("Election Body cannot be empty.");  }
    nameOfBody = aNameOfBody;
    wasSet = true;
    return wasSet;
  }

  public String getNameOfBody()
  {
    return nameOfBody;
  }

  public Position getPosition(int index)
  {
    Position aPosition = positions.get(index);
    return aPosition;
  }

  public List<Position> getPositions()
  {
    List<Position> newPositions = Collections.unmodifiableList(positions);
    return newPositions;
  }

  public int numberOfPositions()
  {
    int number = positions.size();
    return number;
  }

  public boolean hasPositions()
  {
    boolean has = positions.size() > 0;
    return has;
  }

  public int indexOfPosition(Position aPosition)
  {
    int index = positions.indexOf(aPosition);
    return index;
  }

  public static int minimumNumberOfPositions()
  {
    return 0;
  }

  public Position addPosition()
  {
    return new Position(this);
  }

  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    if (positions.contains(aPosition)) { return false; }
    ElectionBody existingElectionBody = aPosition.getElectionBody();
    boolean isNewElectionBody = existingElectionBody != null && !this.equals(existingElectionBody);
    if (isNewElectionBody)
    {
      aPosition.setElectionBody(this);
    }
    else
    {
      positions.add(aPosition);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePosition(Position aPosition)
  {
    boolean wasRemoved = false;
    //Unable to remove aPosition, as it must always have a electionBody
    if (!this.equals(aPosition.getElectionBody()))
    {
      positions.remove(aPosition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPositionAt(Position aPosition, int index)
  {  
    boolean wasAdded = false;
    if(addPosition(aPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPositions()) { index = numberOfPositions() - 1; }
      positions.remove(aPosition);
      positions.add(index, aPosition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePositionAt(Position aPosition, int index)
  {
    boolean wasAdded = false;
    if(positions.contains(aPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPositions()) { index = numberOfPositions() - 1; }
      positions.remove(aPosition);
      positions.add(index, aPosition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPositionAt(aPosition, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (positions.size() > 0)
    {
      Position aPosition = positions.get(positions.size() - 1);
      aPosition.delete();
      positions.remove(aPosition);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "nameOfBody" + ":" + getNameOfBody()+ "]";
  }
}