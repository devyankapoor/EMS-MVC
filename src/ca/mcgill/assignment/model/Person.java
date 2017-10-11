/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.io.Serializable;

// line 44 "../../../../EMSPersistence.ump"
// line 55 "../../../../EMSmodel.ump"
public class Person implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private String address;

  //Person Associations
  private Candidate candidate;
  private Voter voter;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person()
  {
    name = null;
    address = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public Candidate getCandidate()
  {
    return candidate;
  }

  public boolean hasCandidate()
  {
    boolean has = candidate != null;
    return has;
  }

  public Voter getVoter()
  {
    return voter;
  }

  public boolean hasVoter()
  {
    boolean has = voter != null;
    return has;
  }

  public boolean setCandidate(Candidate aNewCandidate)
  {
    boolean wasSet = false;
    if (candidate != null && !candidate.equals(aNewCandidate) && equals(candidate.getPerson()))
    {
      //Unable to setCandidate, as existing candidate would become an orphan
      return wasSet;
    }

    candidate = aNewCandidate;
    Person anOldPerson = aNewCandidate != null ? aNewCandidate.getPerson() : null;

    if (!this.equals(anOldPerson))
    {
      if (anOldPerson != null)
      {
        anOldPerson.candidate = null;
      }
      if (candidate != null)
      {
        candidate.setPerson(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setVoter(Voter aNewVoter)
  {
    boolean wasSet = false;
    if (voter != null && !voter.equals(aNewVoter) && equals(voter.getPerson()))
    {
      //Unable to setVoter, as existing voter would become an orphan
      return wasSet;
    }

    voter = aNewVoter;
    Person anOldPerson = aNewVoter != null ? aNewVoter.getPerson() : null;

    if (!this.equals(anOldPerson))
    {
      if (anOldPerson != null)
      {
        anOldPerson.voter = null;
      }
      if (voter != null)
      {
        voter.setPerson(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Candidate existingCandidate = candidate;
    candidate = null;
    if (existingCandidate != null)
    {
      existingCandidate.delete();
    }
    Voter existingVoter = voter;
    voter = null;
    if (existingVoter != null)
    {
      existingVoter.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "candidate = "+(getCandidate()!=null?Integer.toHexString(System.identityHashCode(getCandidate())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "voter = "+(getVoter()!=null?Integer.toHexString(System.identityHashCode(getVoter())):"null");
  }
}