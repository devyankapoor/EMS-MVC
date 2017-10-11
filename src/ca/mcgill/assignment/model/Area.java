/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.util.*;

// line 83 "../../../../EMSmodel.ump"
public class Area
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Area Associations
  private List<Position> positions;
  private List<Voter> voters;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Area()
  {
    positions = new ArrayList<Position>();
    voters = new ArrayList<Voter>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public Voter getVoter(int index)
  {
    Voter aVoter = voters.get(index);
    return aVoter;
  }

  public List<Voter> getVoters()
  {
    List<Voter> newVoters = Collections.unmodifiableList(voters);
    return newVoters;
  }

  public int numberOfVoters()
  {
    int number = voters.size();
    return number;
  }

  public boolean hasVoters()
  {
    boolean has = voters.size() > 0;
    return has;
  }

  public int indexOfVoter(Voter aVoter)
  {
    int index = voters.indexOf(aVoter);
    return index;
  }

  public static int minimumNumberOfPositions()
  {
    return 0;
  }

  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    if (positions.contains(aPosition)) { return false; }
    positions.add(aPosition);
    if (aPosition.indexOfArea(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPosition.addArea(this);
      if (!wasAdded)
      {
        positions.remove(aPosition);
      }
    }
    return wasAdded;
  }

  public boolean removePosition(Position aPosition)
  {
    boolean wasRemoved = false;
    if (!positions.contains(aPosition))
    {
      return wasRemoved;
    }

    int oldIndex = positions.indexOf(aPosition);
    positions.remove(oldIndex);
    if (aPosition.indexOfArea(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPosition.removeArea(this);
      if (!wasRemoved)
      {
        positions.add(oldIndex,aPosition);
      }
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

  public static int minimumNumberOfVoters()
  {
    return 0;
  }

  public Voter addVoter(boolean aIsEligible, Person aPerson, Poll aPoll)
  {
    return new Voter(aIsEligible, aPerson, this, aPoll);
  }

  public boolean addVoter(Voter aVoter)
  {
    boolean wasAdded = false;
    if (voters.contains(aVoter)) { return false; }
    Area existingArea = aVoter.getArea();
    boolean isNewArea = existingArea != null && !this.equals(existingArea);
    if (isNewArea)
    {
      aVoter.setArea(this);
    }
    else
    {
      voters.add(aVoter);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVoter(Voter aVoter)
  {
    boolean wasRemoved = false;
    //Unable to remove aVoter, as it must always have a area
    if (!this.equals(aVoter.getArea()))
    {
      voters.remove(aVoter);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVoterAt(Voter aVoter, int index)
  {  
    boolean wasAdded = false;
    if(addVoter(aVoter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoters()) { index = numberOfVoters() - 1; }
      voters.remove(aVoter);
      voters.add(index, aVoter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoterAt(Voter aVoter, int index)
  {
    boolean wasAdded = false;
    if(voters.contains(aVoter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoters()) { index = numberOfVoters() - 1; }
      voters.remove(aVoter);
      voters.add(index, aVoter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoterAt(aVoter, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Position> copyOfPositions = new ArrayList<Position>(positions);
    positions.clear();
    for(Position aPosition : copyOfPositions)
    {
      aPosition.removeArea(this);
    }
    for(int i=voters.size(); i > 0; i--)
    {
      Voter aVoter = voters.get(i - 1);
      aVoter.delete();
    }
  }

}