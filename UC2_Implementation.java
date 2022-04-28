//William Bell

package uc2_implementation;

public class UC2_Implementation {

    public static Website ws;
 
    public static void main(String[] args) {
        ws = new Website();
        
        //put filler in database
        String[] fillerTags = new String[]{"data"};
        project first = new project("First", fillerTags, "description", 0);
        project second = new project("Second", fillerTags, "description", 0);
        
        ws.ReqEntInDB(first);
        ws.ReqEntInDB(second);
        
        System.out.println("The database currently contains projects with the titles " + first.getTitle() + ", " + second.getTitle() + "." );
        System.out.println("");
        
        String f = "Project way not be suitable for all audiences.";
        submitFeedback(0, f);
        
        submitFeedback(3, f);
        
        String r = "Inappropriate";
        deleteProject(1, r);
        
        deleteProject(3, r);
        
        
        
    }    
    
    public static void submitFeedback(int index, String f){
    	project p = ws.giveFeedback(index, f);
        if(p != null){
            System.out.println("<Website>   Feedback submitted.");
        } else {
            System.out.println("<Website>   Project does not exist.");
        }
        System.out.println("");
    }
    
    public static void deleteProject(int index, String reason) {
    	project p = ws.deleteEntry(index, reason);
        if(p != null){
            System.out.println("<Website>   Project deleted.");
        } else {
            System.out.println("<Website>   Project does not exist.");
        }
        System.out.println("");
    }
    
}
