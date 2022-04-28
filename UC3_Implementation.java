
package uc3_implementation;

public class UC3_Implementation {

    public static Website ws;
    
    public static void main(String[] args) {
        ws = new Website();
        
        //put filler in database
        String[] fillerTags = new String[]{"data"};
        Project first = new Project("First", fillerTags, "description", 0, "");
        Project second = new Project("Second", fillerTags, "description", 0, "");
        Project third = new Project("Third", fillerTags, "description", 0, "");
        
        int one = ws.ReqEntInDB(first);
        int two = ws.ReqEntInDB(second);
        int three = ws.ReqEntInDB(third);
        
        System.out.println("The database currently contains projects with the titles " + first.getTitle() + ", " + second.getTitle() + ", " + third.getTitle() + "." );
        System.out.println("");
        
        //Enter project with free title
        System.out.println("The user requests to edit a project with the name Second.");
        Project selected = ws.getProject("Second");
        System.out.println("The selected project currently contains : " + selected.projData);
        System.out.println("The user would like to add \"Hello\" to the selected project.");
        selected.editData("Hello");
        System.out.println("The selexted project currently contains : " + selected.projData);
        
    }
    
    public static void createProj(String titleIn, String[] tagsIn, String descIn, int pmIn){
        System.out.println("<Website>   Requesting new project creation");
        Project pendProj = new Project(titleIn, tagsIn, descIn, pmIn, "");
        if(ws.ReqEntInDB(pendProj) == 0){
            System.out.println("<Website>   Project created successfully.");
        } else {
            System.out.println("<Website>   Error - Project could not be created.");
        }
        System.out.println("");
    }
    
    
}
