/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.util.*;

// line 89 "../../../../EMSmodel.ump"
public class Poll
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextPollNumber = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int pollNumber;

  //Poll Associations
  private List<Voter> voters;
  private PollingStation pollingStation;
  private List<Votes> votes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Poll(PollingStation aPollingStation)
  {
    pollNumber = nextPollNumber++;
    voters = new ArrayList<Voter>();
    boolean didAddPollingStation = setPollingStation(aPollingStation);
    if (!didAddPollingStation)
    {
      throw new RuntimeException("Unable to create poll due to pollingStation");
    }
    votes = new ArrayList<Votes>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getPollNumber()
  {
    return pollNumber;
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

  public PollingStation getPollingStation()
  {
    return pollingStation;
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

  public static int minimumNumberOfVoters()
  {
    return 0;
  }

  public Voter addVoter(boolean aIsEligible, Person aPerson, Area aArea)
  {
    return new Voter(aIsEligible, aPerson, aArea, this);
  }

  public boolean addVoter(Voter aVoter)
  {
    boolean wasAdded = false;
    if (voters.contains(aVoter)) { return false; }
    Poll existingPoll = aVoter.getPoll();
    boolean isNewPoll = existingPoll != null && !this.equals(existingPoll);
    if (isNewPoll)
    {
      aVoter.setPoll(this);
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
    //Unable to remove aVoter, as it must always have a poll
    if (!this.equals(aVoter.getPoll()))
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

  public boolean setPollingStation(PollingStation aPollingStation)
  {
    boolean wasSet = false;
    if (aPollingStation == null)
    {
      return wasSet;
    }

    PollingStation existingPollingStation = pollingStation;
    pollingStation = aPollingStation;
    if (existingPollingStation != null && !existingPollingStation.equals(aPollingStation))
    {
      existingPollingStation.removePoll(this);
    }
    pollingStation.addPoll(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfVotes()
  {
    return 0;
  }

  public Votes addVote(Candidate aCandidate)
  {
    return new Votes(aCandidate, this);
  }

  public boolean addVote(Votes aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    Poll existingPoll = aVote.getPoll();
    boolean isNewPoll = existingPoll != null && !this.equals(existingPoll);
    if (isNewPoll)
    {
      aVote.setPoll(this);
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
    //Unable to remove aVote, as it must always have a poll
    if (!this.equals(aVote.getPoll()))
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
    for(int i=voters.size(); i > 0; i--)
    {
      Voter aVoter = voters.get(i - 1);
      aVoter.delete();
    }
    PollingStation placeholderPollingStation = pollingStation;
    this.pollingStation = null;
    placeholderPollingStation.removePoll(this);
    for(int i=votes.size(); i > 0; i--)
    {
      Votes aVote = votes.get(i - 1);
      aVote.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "pollNumber" + ":" + getPollNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pollingStation = "+(getPollingStation()!=null?Integer.toHexString(System.identityHashCode(getPollingStation())):"null");
  }
}