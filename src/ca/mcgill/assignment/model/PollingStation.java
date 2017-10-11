/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.util.*;

// line 102 "../../../../EMSmodel.ump"
public class PollingStation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PollingStation Attributes
  private String address;

  //PollingStation Associations
  private List<Poll> polls;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PollingStation()
  {
    address = null;
    polls = new ArrayList<Poll>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public Poll getPoll(int index)
  {
    Poll aPoll = polls.get(index);
    return aPoll;
  }

  public List<Poll> getPolls()
  {
    List<Poll> newPolls = Collections.unmodifiableList(polls);
    return newPolls;
  }

  public int numberOfPolls()
  {
    int number = polls.size();
    return number;
  }

  public boolean hasPolls()
  {
    boolean has = polls.size() > 0;
    return has;
  }

  public int indexOfPoll(Poll aPoll)
  {
    int index = polls.indexOf(aPoll);
    return index;
  }

  public static int minimumNumberOfPolls()
  {
    return 0;
  }

  public Poll addPoll()
  {
    return new Poll(this);
  }

  public boolean addPoll(Poll aPoll)
  {
    boolean wasAdded = false;
    if (polls.contains(aPoll)) { return false; }
    PollingStation existingPollingStation = aPoll.getPollingStation();
    boolean isNewPollingStation = existingPollingStation != null && !this.equals(existingPollingStation);
    if (isNewPollingStation)
    {
      aPoll.setPollingStation(this);
    }
    else
    {
      polls.add(aPoll);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePoll(Poll aPoll)
  {
    boolean wasRemoved = false;
    //Unable to remove aPoll, as it must always have a pollingStation
    if (!this.equals(aPoll.getPollingStation()))
    {
      polls.remove(aPoll);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPollAt(Poll aPoll, int index)
  {  
    boolean wasAdded = false;
    if(addPoll(aPoll))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPolls()) { index = numberOfPolls() - 1; }
      polls.remove(aPoll);
      polls.add(index, aPoll);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePollAt(Poll aPoll, int index)
  {
    boolean wasAdded = false;
    if(polls.contains(aPoll))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPolls()) { index = numberOfPolls() - 1; }
      polls.remove(aPoll);
      polls.add(index, aPoll);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPollAt(aPoll, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (polls.size() > 0)
    {
      Poll aPoll = polls.get(polls.size() - 1);
      aPoll.delete();
      polls.remove(aPoll);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "]";
  }
}