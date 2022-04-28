/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uc1_implementation;

/**
 *
 * @author SunOfAGambolier
 * @editor Mathew H
 */
public class UC4_Implementation {

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
        
        //Enter project that does not exist
        System.out.println("The user requests to delete a project with the name Fourth.");
        deleteProj("Fourth", fillerTags, "description", 0);
        
        //Enter project that does exist
        System.out.println("The user requests to delete a project with the name First.");
        deleteProj("First", fillerTags, "description", 0);
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
}
