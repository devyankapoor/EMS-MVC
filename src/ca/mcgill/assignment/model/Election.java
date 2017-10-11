/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.io.Serializable;

// line 10 "../../../../EMSPersistence.ump"
// line 14 "../../../../EMSmodel.ump"
public class Election implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Election Attributes
  private String typeOfElection;
  private String electionDate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Election()
  {
    typeOfElection = null;
    electionDate = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTypeOfElection(String aTypeOfElection)
  {
    boolean wasSet = false;
    // line 18 "../../../../EMSmodel.ump"
    if (aTypeOfElection == null || aTypeOfElection.trim().length() == 0) {
     	throw new RuntimeException("Type of Election cannot be empty.");  }
    typeOfElection = aTypeOfElection;
    wasSet = true;
    return wasSet;
  }

  public boolean setElectionDate(String aElectionDate)
  {
    boolean wasSet = false;
    // line 22 "../../../../EMSmodel.ump"
    if (aElectionDate == null || aElectionDate.trim().length() == 0) {
     	throw new RuntimeException("ElectionDate cannot be empty."); }
    electionDate = aElectionDate;
    wasSet = true;
    return wasSet;
  }

  public String getTypeOfElection()
  {
    return typeOfElection;
  }

  public String getElectionDate()
  {
    return electionDate;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "typeOfElection" + ":" + getTypeOfElection()+ "," +
            "electionDate" + ":" + getElectionDate()+ "]";
  }
}