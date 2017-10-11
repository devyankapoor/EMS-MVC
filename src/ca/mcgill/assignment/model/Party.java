/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.util.*;

// line 69 "../../../../EMSmodel.ump"
public class Party
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Party Attributes
  private String nameOfParty;

  //Party Associations
  private List<Candidate> candidates;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Party()
  {
    nameOfParty = null;
    candidates = new ArrayList<Candidate>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNameOfParty(String aNameOfParty)
  {
    boolean wasSet = false;
    nameOfParty = aNameOfParty;
    wasSet = true;
    return wasSet;
  }

  public String getNameOfParty()
  {
    return nameOfParty;
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

  public static int minimumNumberOfCandidates()
  {
    return 0;
  }

  public boolean addCandidate(Candidate aCandidate)
  {
    boolean wasAdded = false;
    if (candidates.contains(aCandidate)) { return false; }
    Party existingParty = aCandidate.getParty();
    if (existingParty == null)
    {
      aCandidate.setParty(this);
    }
    else if (!this.equals(existingParty))
    {
      existingParty.removeCandidate(aCandidate);
      addCandidate(aCandidate);
    }
    else
    {
      candidates.add(aCandidate);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCandidate(Candidate aCandidate)
  {
    boolean wasRemoved = false;
    if (candidates.contains(aCandidate))
    {
      candidates.remove(aCandidate);
      aCandidate.setParty(null);
      wasRemoved = true;
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

  public void delete()
  {
    while( !candidates.isEmpty() )
    {
      candidates.get(0).setParty(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nameOfParty" + ":" + getNameOfParty()+ "]";
  }
}