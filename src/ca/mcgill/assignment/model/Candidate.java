/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.util.*;

// line 61 "../../../../EMSmodel.ump"
public class Candidate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidate Attributes
  private boolean isIncumbent;
  private boolean isReelected;

  //Candidate Associations
  private Person person;
  private List<Position> positions;
  private Party party;
  private List<Votes> votes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Candidate(boolean aIsIncumbent, boolean aIsReelected, Person aPerson, Position... allPositions)
  {
    isIncumbent = aIsIncumbent;
    isReelected = aIsReelected;
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create candidate due to person");
    }
    positions = new ArrayList<Position>();
    boolean didAddPositions = setPositions(allPositions);
    if (!didAddPositions)
    {
      throw new RuntimeException("Unable to create Candidate, must have at least 1 positions");
    }
    votes = new ArrayList<Votes>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsIncumbent(boolean aIsIncumbent)
  {
    boolean wasSet = false;
    isIncumbent = aIsIncumbent;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsReelected(boolean aIsReelected)
  {
    boolean wasSet = false;
    isReelected = aIsReelected;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsIncumbent()
  {
    return isIncumbent;
  }

  public boolean getIsReelected()
  {
    return isReelected;
  }

  public boolean isIsIncumbent()
  {
    return isIncumbent;
  }

  public boolean isIsReelected()
  {
    return isReelected;
  }

  public Person getPerson()
  {
    return person;
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

  public Party getParty()
  {
    return party;
  }

  public boolean hasParty()
  {
    boolean has = party != null;
    return has;
  }

  public Votes getVote(int index)
  {
    Votes aVote = votes.get(index);
    return aVote;
  }

  public List<Votes> getVotes()
  {
    List<Votes> newVotes = Collections.unmodifiableList(votes);
    return newVotes;
  }

  public int numberOfVotes()
  {
    int number = votes.size();
    return number;
  }

  public boolean hasVotes()
  {
    boolean has = votes.size() > 0;
    return has;
  }

  public int indexOfVote(Votes aVote)
  {
    int index = votes.indexOf(aVote);
    return index;
  }

  public boolean setPerson(Person aNewPerson)
  {
    boolean wasSet = false;
    if (aNewPerson == null)
    {
      //Unable to setPerson to null, as candidate must always be associated to a person
      return wasSet;
    }
    
    Candidate existingCandidate = aNewPerson.getCandidate();
    if (existingCandidate != null && !equals(existingCandidate))
    {
      //Unable to setPerson, the current person already has a candidate, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Person anOldPerson = person;
    person = aNewPerson;
    person.setCandidate(this);

    if (anOldPerson != null)
    {
      anOldPerson.setCandidate(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean isNumberOfPositionsValid()
  {
    boolean isValid = numberOfPositions() >= minimumNumberOfPositions();
    return isValid;
  }

  public static int minimumNumberOfPositions()
  {
    return 1;
  }

  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    if (positions.contains(aPosition)) { return false; }
    positions.add(aPosition);
    if (aPosition.indexOfCandidate(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPosition.addCandidate(this);
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

    if (numberOfPositions() <= minimumNumberOfPositions())
    {
      return wasRemoved;
    }

    int oldIndex = positions.indexOf(aPosition);
    positions.remove(oldIndex);
    if (aPosition.indexOfCandidate(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPosition.removeCandidate(this);
      if (!wasRemoved)
      {
        positions.add(oldIndex,aPosition);
      }
    }
    return wasRemoved;
  }

  public boolean setPositions(Position... newPositions)
  {
    boolean wasSet = false;
    ArrayList<Position> verifiedPositions = new ArrayList<Position>();
    for (Position aPosition : newPositions)
    {
      if (verifiedPositions.contains(aPosition))
      {
        continue;
      }
      verifiedPositions.add(aPosition);
    }

    if (verifiedPositions.size() != newPositions.length || verifiedPositions.size() < minimumNumberOfPositions())
    {
      return wasSet;
    }

    ArrayList<Position> oldPositions = new ArrayList<Position>(positions);
    positions.clear();
    for (Position aNewPosition : verifiedPositions)
    {
      positions.add(aNewPosition);
      if (oldPositions.contains(aNewPosition))
      {
        oldPositions.remove(aNewPosition);
      }
      else
      {
        aNewPosition.addCandidate(this);
      }
    }

    for (Position anOldPosition : oldPositions)
    {
      anOldPosition.removeCandidate(this);
    }
    wasSet = true;
    return wasSet;
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

  public boolean setParty(Party aParty)
  {
    boolean wasSet = false;
    Party existingParty = party;
    party = aParty;
    if (existingParty != null && !existingParty.equals(aParty))
    {
      existingParty.removeCandidate(this);
    }
    if (aParty != null)
    {
      aParty.addCandidate(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfVotes()
  {
    return 0;
  }

  public Votes addVote(Poll aPoll)
  {
    return new Votes(this, aPoll);
  }

  public boolean addVote(Votes aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    Candidate existingCandidate = aVote.getCandidate();
    boolean isNewCandidate = existingCandidate != null && !this.equals(existingCandidate);
    if (isNewCandidate)
    {
      aVote.setCandidate(this);
    }
    else
    {
      votes.add(aVote);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVote(Votes aVote)
  {
    boolean wasRemoved = false;
    //Unable to remove aVote, as it must always have a candidate
    if (!this.equals(aVote.getCandidate()))
    {
      votes.remove(aVote);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVoteAt(Votes aVote, int index)
  {  
    boolean wasAdded = false;
    if(addVote(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoteAt(Votes aVote, int index)
  {
    boolean wasAdded = false;
    if(votes.contains(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoteAt(aVote, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Person existingPerson = person;
    person = null;
    if (existingPerson != null)
    {
      existingPerson.setCandidate(null);
    }
    ArrayList<Position> copyOfPositions = new ArrayList<Position>(positions);
    positions.clear();
    for(Position aPosition : copyOfPositions)
    {
      aPosition.removeCandidate(this);
    }
    if (party != null)
    {
      Party placeholderParty = party;
      this.party = null;
      placeholderParty.removeCandidate(this);
    }
    for(int i=votes.size(); i > 0; i--)
    {
      Votes aVote = votes.get(i - 1);
      aVote.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "isIncumbent" + ":" + getIsIncumbent()+ "," +
            "isReelected" + ":" + getIsReelected()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "party = "+(getParty()!=null?Integer.toHexString(System.identityHashCode(getParty())):"null");
  }
}