//Created by Asa Mcdaniel
//Edited by William Bell
package uc1_implementation;

/**
 *
 * @author SunOfAGambolier
 */
public class Website {
    Database db;
    public Website(){
        db = new Database();
    }
    
    public project deleteEntry(int index, String reason) {			//remove a project from db, returns deleted project
    	project p = db.getEntry(index);
    	
    	if (p != null) {
    		String f = "Project deleted. Reason for deletion: " + reason + ".";
    		p.addFeedback(f);
    		
    		db.removeEntry(index);
    		
    		return p;
    	}
    	else
    		return null;
    }
    
    public int ReqEntInDB(project projIn){
        int ret = db.addEntry(projIn);
        db.status--;                                                            //Sends a token to end the waiting status of the Database
        return ret;                                             //Returns 0 if entry was successfully submitted, 1 if title was already taken
    }
}
