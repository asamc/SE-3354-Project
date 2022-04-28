//Created by Asa Mcdaniel
//Edited by William Bell, Mathew Hoang

package paintshop;

import java.util.ArrayList; // import the ArrayList class


public class Database {

    ArrayList<project> db;
    int status;

    public Database() {
        db = new ArrayList<>();                                                 // Create an ArrayList
        status = 0;
    }
    
    

    public int addEntry(project projIn) {                                       //Returns 0 if entry was successfully submitted, 1 if title was already taken
        status++;                                                               //add on a waiting token for confirmation of the report
        if (!(db.isEmpty())) {
            for (int i = 0; i < db.size(); i++) {
                if (projIn.getTitle().equals(db.get(i).getTitle())) {
                    return 1;                                                       //Another project already has that title
                }
            }
        }

        db.add(projIn);
        return 0;
    }
    
    public project getEntry(int index) {										//returns the project at index
    	if (index < db.size()) {
    		return db.get(index);
    	}
    	else
    		return null;
    }
    
    public int removeEntry(int index) {											//removes the project at index
    	if (index < db.size()) {
    		db.remove(index);
    		
    		return index;
    	}
    	else
    		return -1;
    }

}
