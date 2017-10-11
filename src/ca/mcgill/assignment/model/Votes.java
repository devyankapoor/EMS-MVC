/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;

// line 96 "../../../../EMSmodel.ump"
public class Votes
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Votes Associations
  private Candidate candidate;
  private Poll poll;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCandidate;
  private boolean canSetPoll;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Votes(Candidate aCandidate, Poll aPoll)
  {
    cachedHashCode = -1;
    canSetCandidate = true;
    canSetPoll = true;
    boolean didAddCandidate = setCandidate(aCandidate);
    if (!didAddCandidate)
    {
      throw new RuntimeException("Unable to create vote due to candidate");
    }
    boolean didAddPoll = setPoll(aPoll);
    if (!didAddPoll)
    {
      throw new RuntimeException("Unable to create vote due to poll");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Candidate getCandidate()
  {
    return candidate;
  }

  public Poll getPoll()
  {
    return poll;
  }

  public boolean setCandidate(Candidate aCandidate)
  {
    boolean wasSet = false;
    if (!canSetCandidate) { return false; }
    if (aCandidate == null)
    {
      return wasSet;
    }

    Candidate existingCandidate = candidate;
    candidate = aCandidate;
    if (existingCandidate != null && !existingCandidate.equals(aCandidate))
    {
      existingCandidate.removeVote(this);
    }
    if (!candidate.addVote(this))
    {
      candidate = existingCandidate;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setPoll(Poll aPoll)
  {
    boolean wasSet = false;
    if (!canSetPoll) { return false; }
    if (aPoll == null)
    {
      return wasSet;
    }

    Poll existingPoll = poll;
    poll = aPoll;
    if (existingPoll != null && !existingPoll.equals(aPoll))
    {
      existingPoll.removeVote(this);
    }
    if (!poll.addVote(this))
    {
      poll = existingPoll;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Votes compareTo = (Votes)obj;
  
    if (candidate == null && compareTo.candidate != null)
    {
      return false;
    }
    else if (candidate != null && !candidate.equals(compareTo.candidate))
    {
      return false;
    }

    if (poll == null && compareTo.poll != null)
    {
      return false;
    }
    else if (poll != null && !poll.equals(compareTo.poll))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (candidate != null)
    {
      cachedHashCode = cachedHashCode * 23 + candidate.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (poll != null)
    {
      cachedHashCode = cachedHashCode * 23 + poll.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCandidate = false;
    canSetPoll = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Candidate placeholderCandidate = candidate;
    this.candidate = null;
    placeholderCandidate.removeVote(this);
    Poll placeholderPoll = poll;
    this.poll = null;
    placeholderPoll.removeVote(this);
  }

}