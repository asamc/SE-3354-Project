//Created by Asa Mcdaniel
//Edited by William Bell, Mathew Hoang, Sai Motukuri
package paintshop;

public class Website {
    Database db;
    public Website(){
        db = new Database();
    }
    
    public int ReqEntInDB(project projIn){
        int ret = db.addEntry(projIn);
        db.status--;                                                            //Sends a token to end the waiting status of the Database
        return ret;                                             //Returns 0 if entry was successfully submitted, 1 if title was already taken
    }

    public project giveFeedback(int index, String f) {				//adds the feedback string to the projects record of feedback
        project p = db.getEntry(index);

        if (p != null) {
            p.addFeedback(f);

            return p;
        }
        else
            return null;
    }
    
    public project deleteEntry(int index, String reason) {			//delete a project from db, returns deleted project
    	project p = db.getEntry(index);
    	
    	if (p != null) {
    		String f = "Project deleted. Reason for deletion: " + reason + ".";
    		p.addFeedback(f);
    		
    		db.removeEntry(p);
    		
    		return p;
    	}
    	else
    		return null;
    }
    
    public int RemoveEntInDB(project projIn){                       //
        int ret = db.removeEntry(projIn);                                       //Sends a token to end the waiting status of the Database
        db.status--;                                            //Returns 0 if the entry was successfully deleted, 1 if the title was not found
        return ret;
    }
    
    public project getProject(String title){
        return db.getEntry(title);
    }
}
