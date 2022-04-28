//Created by Asa Mcdaniel
//Edited by William Bell

package uc2_implementation;

import java.util.ArrayList; // import the ArrayList class

public class project {

    public String title;   //Title of the project
    public String[] tags;  //Tags for the project
    public ArrayList<String> fb;    //List of given feedback 
    public String desc;    //Description of the project
    public int pm;         //Permissions for the project

    public project() { // Basic Constructor
        title = "";
        tags = new String[]{};
        fb = new ArrayList<>();
        desc = "";
        pm = 0;
    }

    public project(String titleIn, String[] tagsIn, String descIn, int pmIn) { //specified Constructor
        title = titleIn;
        tags = tagsIn;
        fb = new ArrayList<>();
        desc = descIn;
        pm = pmIn;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int addFeedback(String f) {		//adds feedback to fb
    	fb.add(f);
    	
    	return fb.indexOf(f);
    }
}
