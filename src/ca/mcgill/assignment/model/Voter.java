/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;

// line 76 "../../../../EMSmodel.ump"
public class Voter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Voter Attributes
  private boolean isEligible;

  //Voter Associations
  private Person person;
  private Area area;
  private Poll poll;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Voter(boolean aIsEligible, Person aPerson, Area aArea, Poll aPoll)
  {
    isEligible = aIsEligible;
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create voter due to person");
    }
    boolean didAddArea = setArea(aArea);
    if (!didAddArea)
    {
      throw new RuntimeException("Unable to create voter due to area");
    }
    boolean didAddPoll = setPoll(aPoll);
    if (!didAddPoll)
    {
      throw new RuntimeException("Unable to create voter due to poll");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsEligible(boolean aIsEligible)
  {
    boolean wasSet = false;
    isEligible = aIsEligible;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsEligible()
  {
    return isEligible;
  }

  public boolean isIsEligible()
  {
    return isEligible;
  }

  public Person getPerson()
  {
    return person;
  }

  public Area getArea()
  {
    return area;
  }

  public Poll getPoll()
  {
    return poll;
  }

  public boolean setPerson(Person aNewPerson)
  {
    boolean wasSet = false;
    if (aNewPerson == null)
    {
      //Unable to setPerson to null, as voter must always be associated to a person
      return wasSet;
    }
    
    Voter existingVoter = aNewPerson.getVoter();
    if (existingVoter != null && !equals(existingVoter))
    {
      //Unable to setPerson, the current person already has a voter, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Person anOldPerson = person;
    person = aNewPerson;
    person.setVoter(this);

    if (anOldPerson != null)
    {
      anOldPerson.setVoter(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setArea(Area aArea)
  {
    boolean wasSet = false;
    if (aArea == null)
    {
      return wasSet;
    }

    Area existingArea = area;
    area = aArea;
    if (existingArea != null && !existingArea.equals(aArea))
    {
      existingArea.removeVoter(this);
    }
    area.addVoter(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setPoll(Poll aPoll)
  {
    boolean wasSet = false;
    if (aPoll == null)
    {
      return wasSet;
    }

    Poll existingPoll = poll;
    poll = aPoll;
    if (existingPoll != null && !existingPoll.equals(aPoll))
    {
      existingPoll.removeVoter(this);
    }
    poll.addVoter(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Person existingPerson = person;
    person = null;
    if (existingPerson != null)
    {
      existingPerson.setVoter(null);
    }
    Area placeholderArea = area;
    this.area = null;
    placeholderArea.removeVoter(this);
    Poll placeholderPoll = poll;
    this.poll = null;
    placeholderPoll.removeVoter(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "isEligible" + ":" + getIsEligible()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "area = "+(getArea()!=null?Integer.toHexString(System.identityHashCode(getArea())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "poll = "+(getPoll()!=null?Integer.toHexString(System.identityHashCode(getPoll())):"null");
  }
}