//Created by Asa Mcdaniel
package paintshop;

public class Working_Demo {

    public static Website ws;
 
    public static void main(String[] args) {
        ws = new Website();
        
        //put filler in database
        String[] fillerTags = new String[]{"data"};
        project first = new project("First", fillerTags, "description", 0);
        project second = new project("Second", fillerTags, "description", 0);
        project third = new project("Third", fillerTags, "description", 0);
        
        ws.ReqEntInDB(first);
        ws.ReqEntInDB(second);
        ws.ReqEntInDB(third);
        
        System.out.println("The database currently contains projects with the titles " + first.getTitle() + ", " + second.getTitle() + ", " + third.getTitle() + "." );
        System.out.println("");
        
        //////////////////////////////////////////////////////////  UC1 ///////////////////////////////////////////////////////////////////////////////////////////////
        
        //Enter project with free title
        System.out.println("The user requests to create a project with the name Fourth.");
        createProj("Fourth", fillerTags, "description", 0);
        
        //Enter project with taken title
        System.out.println("The user requests to create a project with the name First.");
        createProj("First", fillerTags, "description", 0);
        
        //////////////////////////////////////////////////////////  UC2 ///////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("The database currently contains projects with the titles " + first.getTitle() + ", " + second.getTitle() + "." );
        System.out.println("");
        
        String f = "Project way not be suitable for all audiences.";
        submitFeedback(0, f);
        
        submitFeedback(3, f);
        
        String r = "Inappropriate";

        adminDeleteProject(3, r);
        
        //////////////////////////////////////////////////////////  UC3 ///////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("The user requests to edit a project with the name Second.");
        project selected = ws.getProject("Second");
        System.out.println("The selected project currently contains : " + selected.projData);
        System.out.println("The user would like to add \"Hello\" to the selected project.");
        selected.editData("Hello");
        System.out.println("The selected project currently contains : " + selected.projData);
        
        //////////////////////////////////////////////////////////  UC4 ///////////////////////////////////////////////////////////////////////////////////////////////
    
        //Enter project that does not exist
        System.out.println("The user requests to delete a project with the name Fourth.");
        deleteProj("Fourth", fillerTags, "description", 0);
        
        //Enter project that does exist
        System.out.println("The user requests to delete a project with the name First.");
        deleteProj("First", fillerTags, "description", 0);
    
    }    
    
    public static void createProj(String titleIn, String[] tagsIn, String descIn, int pmIn){
        System.out.println("<Website>   Requesting new project creation");
        project pendProj = new project(titleIn, tagsIn, descIn, pmIn);
        if(ws.ReqEntInDB(pendProj) == 0){
            System.out.println("<Website>   Project created successfully.");
        } else {
            System.out.println("<Website>   Error - Project could not be created.");
        }
        System.out.println("");
    }
    
    public static void submitFeedback(int index, String f){
    	project p = ws.giveFeedback(index, f);
        if(p != null){
            System.out.println("<Website>   Feedback !"+f+"! submitted.");
        } else {
            System.out.println("<Website>   Project does not exist.");
        }
        System.out.println("");
    }
    
    public static void deleteProj(String titleIn, String[] tagsIn, String descIn, int pmIn){
        System.out.println("<Website>   Requesting new project deletion");
        project pendProj = new project(titleIn, tagsIn, descIn, pmIn);
        if(ws.ReqEntInDB(pendProj) == 0){
            System.out.println("<Website>   Project created deleted.");
        } else {
            System.out.println("<Website>   Error - Project could not be deleted.");
        }
        System.out.println("");
    }
    
    public static void adminDeleteProject(int index, String reason) {
    	project p = ws.deleteEntry(index, reason);  //Returns the deleted project in successful
        if(p != null){
            System.out.println("<Website>   Project deleted.");
        } else {
            System.out.println("<Website>   Project does not exist.");
        }
        System.out.println("");
    }
}
