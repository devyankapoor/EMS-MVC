/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.io.Serializable;
import java.util.*;

// line 38 "../../../../EMSPersistence.ump"
// line 44 "../../../../EMSmodel.ump"
public class Position implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private String nameOfPosition;

  //Position Associations
  private ElectionBody electionBody;
  private List<Candidate> candidates;
  private List<Area> areas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(ElectionBody aElectionBody)
  {
    nameOfPosition = null;
    boolean didAddElectionBody = setElectionBody(aElectionBody);
    if (!didAddElectionBody)
    {
      throw new RuntimeException("Unable to create position due to electionBody");
    }
    candidates = new ArrayList<Candidate>();
    areas = new ArrayList<Area>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNameOfPosition(String aNameOfPosition)
  {
    boolean wasSet = false;
    // line 47 "../../../../EMSmodel.ump"
    if (aNameOfPosition == null || aNameOfPosition.trim().length() == 0) {
     	throw new RuntimeException("Name of Position cannot be empty.");}
    nameOfPosition = aNameOfPosition;
    wasSet = true;
    return wasSet;
  }

  public String getNameOfPosition()
  {
    return nameOfPosition;
  }

  public ElectionBody getElectionBody()
  {
    return electionBody;
  }

  public Candidate getCandidate(int index)
  {
    Candidate aCandidate = candidates.get(index);
    return aCandidate;
  }

  public List<Candidate> getCandidates()
  {
    List<Candidate> newCandidates = Collections.unmodifiableList(candidates);
    return newCandidates;
  }

  public int numberOfCandidates()
  {
    int number = candidates.size();
    return number;
  }

  public boolean hasCandidates()
  {
    boolean has = candidates.size() > 0;
    return has;
  }

  public int indexOfCandidate(Candidate aCandidate)
  {
    int index = candidates.indexOf(aCandidate);
    return index;
  }

  public Area getArea(int index)
  {
    Area aArea = areas.get(index);
    return aArea;
  }

  public List<Area> getAreas()
  {
    List<Area> newAreas = Collections.unmodifiableList(areas);
    return newAreas;
  }

  public int numberOfAreas()
  {
    int number = areas.size();
    return number;
  }

  public boolean hasAreas()
  {
    boolean has = areas.size() > 0;
    return has;
  }

  public int indexOfArea(Area aArea)
  {
    int index = areas.indexOf(aArea);
    return index;
  }

  public boolean setElectionBody(ElectionBody aElectionBody)
  {
    boolean wasSet = false;
    if (aElectionBody == null)
    {
      return wasSet;
    }

    ElectionBody existingElectionBody = electionBody;
    electionBody = aElectionBody;
    if (existingElectionBody != null && !existingElectionBody.equals(aElectionBody))
    {
      existingElectionBody.removePosition(this);
    }
    electionBody.addPosition(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfCandidates()
  {
    return 0;
  }

  public boolean addCandidate(Candidate aCandidate)
  {
    boolean wasAdded = false;
    if (candidates.contains(aCandidate)) { return false; }
    candidates.add(aCandidate);
    if (aCandidate.indexOfPosition(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCandidate.addPosition(this);
      if (!wasAdded)
      {
        candidates.remove(aCandidate);
      }
    }
    return wasAdded;
  }

  public boolean removeCandidate(Candidate aCandidate)
  {
    boolean wasRemoved = false;
    if (!candidates.contains(aCandidate))
    {
      return wasRemoved;
    }

    int oldIndex = candidates.indexOf(aCandidate);
    candidates.remove(oldIndex);
    if (aCandidate.indexOfPosition(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCandidate.removePosition(this);
      if (!wasRemoved)
      {
        candidates.add(oldIndex,aCandidate);
      }
    }
    return wasRemoved;
  }

  public boolean addCandidateAt(Candidate aCandidate, int index)
  {  
    boolean wasAdded = false;
    if(addCandidate(aCandidate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCandidates()) { index = numberOfCandidates() - 1; }
      candidates.remove(aCandidate);
      candidates.add(index, aCandidate);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCandidateAt(Candidate aCandidate, int index)
  {
    boolean wasAdded = false;
    if(candidates.contains(aCandidate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCandidates()) { index = numberOfCandidates() - 1; }
      candidates.remove(aCandidate);
      candidates.add(index, aCandidate);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCandidateAt(aCandidate, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAreas()
  {
    return 0;
  }

  public boolean addArea(Area aArea)
  {
    boolean wasAdded = false;
    if (areas.contains(aArea)) { return false; }
    areas.add(aArea);
    if (aArea.indexOfPosition(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aArea.addPosition(this);
      if (!wasAdded)
      {
        areas.remove(aArea);
      }
    }
    return wasAdded;
  }

  public boolean removeArea(Area aArea)
  {
    boolean wasRemoved = false;
    if (!areas.contains(aArea))
    {
      return wasRemoved;
    }

    int oldIndex = areas.indexOf(aArea);
    areas.remove(oldIndex);
    if (aArea.indexOfPosition(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aArea.removePosition(this);
      if (!wasRemoved)
      {
        areas.add(oldIndex,aArea);
      }
    }
    return wasRemoved;
  }

  public boolean addAreaAt(Area aArea, int index)
  {  
    boolean wasAdded = false;
    if(addArea(aArea))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAreas()) { index = numberOfAreas() - 1; }
      areas.remove(aArea);
      areas.add(index, aArea);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAreaAt(Area aArea, int index)
  {
    boolean wasAdded = false;
    if(areas.contains(aArea))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAreas()) { index = numberOfAreas() - 1; }
      areas.remove(aArea);
      areas.add(index, aArea);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAreaAt(aArea, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ElectionBody placeholderElectionBody = electionBody;
    this.electionBody = null;
    placeholderElectionBody.removePosition(this);
    ArrayList<Candidate> copyOfCandidates = new ArrayList<Candidate>(candidates);
    candidates.clear();
    for(Candidate aCandidate : copyOfCandidates)
    {
      if (aCandidate.numberOfPositions() <= Candidate.minimumNumberOfPositions())
      {
        aCandidate.delete();
      }
      else
      {
        aCandidate.removePosition(this);
      }
    }
    ArrayList<Area> copyOfAreas = new ArrayList<Area>(areas);
    areas.clear();
    for(Area aArea : copyOfAreas)
    {
      aArea.removePosition(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nameOfPosition" + ":" + getNameOfPosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "electionBody = "+(getElectionBody()!=null?Integer.toHexString(System.identityHashCode(getElectionBody())):"null");
  }
}