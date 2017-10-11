package ca.mcgill.assignment.application;

import ca.mcgill.assignment.model.EMS;
import ca.mcgill.assignment.persistence.PersistenceEMS;
import ca.mcgill.assignment.view.EmsPage;


public class EmsApplication
{
	private static EMS btms;
	private static String filename = "data.ems";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// start UI
		PersistenceEMS.setFilename(filename);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmsPage();
            }
        });
        
	}

}
