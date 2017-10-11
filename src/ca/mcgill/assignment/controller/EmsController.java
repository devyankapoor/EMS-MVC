package ca.mcgill.assignment.controller;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ca.mcgill.assignment.model.EMS;
import ca.mcgill.assignment.model.Election;
import ca.mcgill.assignment.model.ElectionBody;
import ca.mcgill.assignment.model.Position;
import ca.mcgill.assignment.persistence.PersistenceEMS;
 
public class EmsController {
	

 
                public EmsController()
                {
 
                }
 
 
 
                public static void createElection(String type, String edate, String pos, String body) throws InvalidInputException,RuntimeException,NullPointerException
                {
                                /**
                                * @author Devyan
                                * Instantiating singleton object of class EMS. Class EMS is declared singleton in model itself.e2 is the object
                                * reloaded from the persistence file and added to the current ems object. Thus, breaking the singleton pattern in
                                 * this context.
                                */
                				
                               EMS ems= EMS.getInstance();
                             
                                EMS e2= (EMS) PersistenceEMS.deserialize();
                               
                              
                                /**
                                  * Merging data into current instance with persistence file
                                  */
                                if(e2!=null)
                                {
                                for(Election elec: e2.getElections())
                                {                            
                                                 
                                                 ems.addElection(elec);
                                }
                               
                                for(ElectionBody eb: e2.getElectionBodies())
                                {
                                                ems.addElectionBody(eb);
                                }
                                }
 
//                                /**
//                                * @author Devyan
//                                * Converting date from java.util to java.sql
//                                */
                            //    java.sql.Date sqlDate = new java.sql.Date(edate.getTime());
                               
                               
                                /**
                                * Election Data
                                */
                                Election elec= new Election();
                                elec.setTypeOfElection(type);
                                elec.setElectionDate(edate);
                               
                                /**
                                * Election Body Data
                                */
                                ElectionBody eb=new ElectionBody();
                                eb.setNameOfBody(body);
                                Position ps=new Position(eb);
                                ps.setNameOfPosition(pos);
                                eb.addPosition(ps);
                                ems.addElectionBody(eb);
                                ems.addElection(elec);
                                
                                PersistenceEMS.serialize(ems);
                                ems.delete();
                               // System.out.println(ems.getElection(0).getTypeOfElection());
 
                }
 
                public static void updateElection(String type, Date edate, String pos, String body) throws InvalidInputException,RuntimeException
                {
                                EMS e2= (EMS) PersistenceEMS.deserialize();
                                System.out.println(e2.getElectionBody(0).getNameOfBody());
                               
                }
               
                public static EMS loadData()
                {
                                /**
                                * @author Devyan
                                * Instantiating singleton object of class EMS. Class EMS is declared singleton in model itself.e2 is the object
                                * reloaded from the persistence file and added to the current ems object. Thus, breaking the singleton pattern in
                                 * this context.
                                */
                                EMS e2= (EMS) PersistenceEMS.deserialize();
                                if(e2!=null)
                                return e2;
                                return null;
                }
               
                
                public static void updateElection(int rownum,String TypeOfElection,String EDate,String ElecPos,String ElecBody)  throws InvalidInputException,RuntimeException
                {
                	EMS e2= (EMS) PersistenceEMS.deserialize();
                    
                    EMS ems = EMS.getInstance();
                    ems.delete(); 
                    /**
                     * Merging data into current instance with persistence file
                     */
                     if(e2!=null)
                     {
                                    
                                     for(Election elec: e2.getElections())
                                     {                             

                                                     ems.addElection(elec);
                                     }

                                    
                                     for(ElectionBody eb: e2.getElectionBodies())
                                     {
                                                     ems.addElectionBody(eb);
                                     }
                     }
                     
                     Election e1=  ems.getElections().get(rownum);
                     ems.removeElection(e1);
                     ElectionBody eb1= ems.getElectionBodies().get(rownum);
                     ems.removeElectionBody(eb1);
                 	
                     Election elec= new Election();
                     elec.setTypeOfElection(TypeOfElection);
                     elec.setElectionDate(EDate);
                    
                     /**
                     * Election Body Data
                     */
                     ElectionBody eb=new ElectionBody();
                     eb.setNameOfBody(ElecBody);
                     Position ps=new Position(eb);
                     ps.setNameOfPosition(ElecPos);
                     eb.addPosition(ps);
                     ems.addElectionBody(eb);
                     ems.addElection(elec);
                    
                     PersistenceEMS.serialize(ems);
                     ems.delete();

                }
                
                public static void deleteElection(int rownum) 
                {                             
                                EMS e2= (EMS) PersistenceEMS.deserialize();
                                
                               EMS ems = EMS.getInstance();
                               ems.delete(); 
                               /**
                                * Merging data into current instance with persistence file
                                */
                                if(e2!=null)
                                {
                                               
                                                for(Election elec: e2.getElections())
                                                {                             
 
                                                                ems.addElection(elec);
                                                }
 
                                               
                                                for(ElectionBody eb: e2.getElectionBodies())
                                                {
                                                                ems.addElectionBody(eb);
                                                }
                                }
                                
                                
                              
                                /*
                                * @author Devyan
                                * Converting date from java.util to java.sql
                                */
                             //   java.sql.Date sqlDate;
                             //   SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
                             //   java.util.Date date;
						//		try {
							//		date = sdf1.parse(edate);
								//	 sqlDate = new java.sql.Date(date.getTime());
								
                                /**
                                * Matching data to delete
                                
*/ 
//                                while(ems.getElections().iterator().hasNext())
//                                {
//                               
//                                	System.out.println("I am here");
//                                Election e1= ems.getElections().iterator().next();
//                                	System.out.println(e1.getTypeOfElection());
//                                                if(e1.getElectionDate().equals(edate) &&
//                                                                                e1.getTypeOfElection().equals(type))
//                                                {
// 
//                                                                while(ems.getElectionBodies().iterator().hasNext())
//                                                                {
//                                                                	ElectionBody eb= ems.getElectionBodies().iterator().next();
//                                                                                if(eb.getNameOfBody().equals(body))
//                                                                                {
//                                                                                                while(eb.getPositions().iterator().hasNext())
//                                                                                                {
//                                                                                                	Position p1= eb.getPositions().iterator().next();
//                                                                                                                if(p1.getNameOfPosition().equals(pos))
//                                                                                                                {
//                                                                                                                                ems.removeElection(e1);
//                                                                                                                                ems.removeElectionBody(eb);
//                                                                                                                                break;
//                                                                                                                }
//                                                                                                }
//                                                                                               
//                                                                                }
//                                                                                break;
//                                                                }
//                                                               
//                                                }
//                                                break;
//                                  }
                                
                              Election e1=  ems.getElections().get(rownum);
                              ems.removeElection(e1);
                              ElectionBody eb1= ems.getElectionBodies().get(rownum);
                 
                            ems.removeElectionBody(eb1);
                                int size = ems.getElectionBodies().size();
                                int i = 0;
                                while(i<size)
                                {
                                	                               	
                                    System.out.println(ems.getElectionBody(i).getNameOfBody()+" "+size);
                                	i++;
                                }
                                PersistenceEMS.serialize(ems);
                                ems.delete();

 
                }
 

}