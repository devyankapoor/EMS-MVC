/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.assignment.model;
import java.io.Serializable;
import java.util.*;

// line 4 "../../../../EMSPersistence.ump"
// line 4 "../../../../EMSmodel.ump"
public class EMS implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static EMS theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EMS Associations
  private List<Election> elections;
  private List<ElectionBody> electionBodies;
  private List<Person> persons;
  private List<PollingStation> pollingStations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private EMS()
  {
    elections = new ArrayList<Election>();
    electionBodies = new ArrayList<ElectionBody>();
    persons = new ArrayList<Person>();
    pollingStations = new ArrayList<PollingStation>();
  }

  public static EMS getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new EMS();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Election getElection(int index)
  {
    Election aElection = elections.get(index);
    return aElection;
  }

  public List<Election> getElections()
  {
    List<Election> newElections = Collections.unmodifiableList(elections);
    return newElections;
  }

  public int numberOfElections()
  {
    int number = elections.size();
    return number;
  }

  public boolean hasElections()
  {
    boolean has = elections.size() > 0;
    return has;
  }

  public int indexOfElection(Election aElection)
  {
    int index = elections.indexOf(aElection);
    return index;
  }

  public ElectionBody getElectionBody(int index)
  {
    ElectionBody aElectionBody = electionBodies.get(index);
    return aElectionBody;
  }

  public List<ElectionBody> getElectionBodies()
  {
    List<ElectionBody> newElectionBodies = Collections.unmodifiableList(electionBodies);
    return newElectionBodies;
  }

  public int numberOfElectionBodies()
  {
    int number = electionBodies.size();
    return number;
  }

  public boolean hasElectionBodies()
  {
    boolean has = electionBodies.size() > 0;
    return has;
  }

  public int indexOfElectionBody(ElectionBody aElectionBody)
  {
    int index = electionBodies.indexOf(aElectionBody);
    return index;
  }

  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

  public List<Person> getPersons()
  {
    List<Person> newPersons = Collections.unmodifiableList(persons);
    return newPersons;
  }

  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
  }

  public PollingStation getPollingStation(int index)
  {
    PollingStation aPollingStation = pollingStations.get(index);
    return aPollingStation;
  }

  public List<PollingStation> getPollingStations()
  {
    List<PollingStation> newPollingStations = Collections.unmodifiableList(pollingStations);
    return newPollingStations;
  }

  public int numberOfPollingStations()
  {
    int number = pollingStations.size();
    return number;
  }

  public boolean hasPollingStations()
  {
    boolean has = pollingStations.size() > 0;
    return has;
  }

  public int indexOfPollingStation(PollingStation aPollingStation)
  {
    int index = pollingStations.indexOf(aPollingStation);
    return index;
  }

  public static int minimumNumberOfElections()
  {
    return 0;
  }

  public boolean addElection(Election aElection)
  {
    boolean wasAdded = false;
    if (elections.contains(aElection)) { return false; }
    elections.add(aElection);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeElection(Election aElection)
  {
    boolean wasRemoved = false;
    if (elections.contains(aElection))
    {
      elections.remove(aElection);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addElectionAt(Election aElection, int index)
  {  
    boolean wasAdded = false;
    if(addElection(aElection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElections()) { index = numberOfElections() - 1; }
      elections.remove(aElection);
      elections.add(index, aElection);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveElectionAt(Election aElection, int index)
  {
    boolean wasAdded = false;
    if(elections.contains(aElection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElections()) { index = numberOfElections() - 1; }
      elections.remove(aElection);
      elections.add(index, aElection);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addElectionAt(aElection, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfElectionBodies()
  {
    return 0;
  }

  public boolean addElectionBody(ElectionBody aElectionBody)
  {
    boolean wasAdded = false;
    if (electionBodies.contains(aElectionBody)) { return false; }
    electionBodies.add(aElectionBody);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeElectionBody(ElectionBody aElectionBody)
  {
    boolean wasRemoved = false;
    if (electionBodies.contains(aElectionBody))
    {
      electionBodies.remove(aElectionBody);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addElectionBodyAt(ElectionBody aElectionBody, int index)
  {  
    boolean wasAdded = false;
    if(addElectionBody(aElectionBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElectionBodies()) { index = numberOfElectionBodies() - 1; }
      electionBodies.remove(aElectionBody);
      electionBodies.add(index, aElectionBody);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveElectionBodyAt(ElectionBody aElectionBody, int index)
  {
    boolean wasAdded = false;
    if(electionBodies.contains(aElectionBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElectionBodies()) { index = numberOfElectionBodies() - 1; }
      electionBodies.remove(aElectionBody);
      electionBodies.add(index, aElectionBody);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addElectionBodyAt(aElectionBody, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPersons()
  {
    return 0;
  }

  public boolean addPerson(Person aPerson)
  {
    boolean wasAdded = false;
    if (persons.contains(aPerson)) { return false; }
    persons.add(aPerson);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePerson(Person aPerson)
  {
    boolean wasRemoved = false;
    if (persons.contains(aPerson))
    {
      persons.remove(aPerson);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPersonAt(Person aPerson, int index)
  {  
    boolean wasAdded = false;
    if(addPerson(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePersonAt(Person aPerson, int index)
  {
    boolean wasAdded = false;
    if(persons.contains(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonAt(aPerson, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPollingStations()
  {
    return 0;
  }

  public boolean addPollingStation(PollingStation aPollingStation)
  {
    boolean wasAdded = false;
    if (pollingStations.contains(aPollingStation)) { return false; }
    pollingStations.add(aPollingStation);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePollingStation(PollingStation aPollingStation)
  {
    boolean wasRemoved = false;
    if (pollingStations.contains(aPollingStation))
    {
      pollingStations.remove(aPollingStation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPollingStationAt(PollingStation aPollingStation, int index)
  {  
    boolean wasAdded = false;
    if(addPollingStation(aPollingStation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPollingStations()) { index = numberOfPollingStations() - 1; }
      pollingStations.remove(aPollingStation);
      pollingStations.add(index, aPollingStation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePollingStationAt(PollingStation aPollingStation, int index)
  {
    boolean wasAdded = false;
    if(pollingStations.contains(aPollingStation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPollingStations()) { index = numberOfPollingStations() - 1; }
      pollingStations.remove(aPollingStation);
      pollingStations.add(index, aPollingStation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPollingStationAt(aPollingStation, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    elections.clear();
    electionBodies.clear();
    persons.clear();
    pollingStations.clear();
  }

}