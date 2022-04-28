package paintshop;

public class Working_App {

    public static Website ws;

    public static void main(String[] args) {
        ws = new Website();
        String[] usernames = new String[]{"asamc", "wilbe", "saimo", "matho"};
        String[] passwords = new String[]{"apple", "banana", "canteloupe", "durian"};
        System.out.println();
    }

    public static void createProj(String titleIn, String[] tagsIn, String descIn, int pmIn) {
        System.out.println("<Website>   Requesting new project creation");
        project pendProj = new project(titleIn, tagsIn, descIn, pmIn);
        if (ws.ReqEntInDB(pendProj) == 0) {
            System.out.println("<Website>   Project created successfully.");
        } else {
            System.out.println("<Website>   Error - Project could not be created.");
        }
        System.out.println("");
    }

    public static void submitFeedback(int index, String f) {
        project p = ws.giveFeedback(index, f);
        if (p != null) {
            System.out.println("<Website>   Feedback !" + f + "! submitted.");
        } else {
            System.out.println("<Website>   Project does not exist.");
        }
        System.out.println("");
    }

    public static void deleteProj(String titleIn, String[] tagsIn, String descIn, int pmIn) {
        System.out.println("<Website>   Requesting new project deletion");
        project pendProj = new project(titleIn, tagsIn, descIn, pmIn);
        if (ws.ReqEntInDB(pendProj) == 0) {
            System.out.println("<Website>   Project created deleted.");
        } else {
            System.out.println("<Website>   Error - Project could not be deleted.");
        }
        System.out.println("");
    }

    public static void adminDeleteProject(int index, String reason) {
        project p = ws.deleteEntry(index, reason);  //Returns the deleted project in successful
        if (p != null) {
            System.out.println("<Website>   Project deleted.");
        } else {
            System.out.println("<Website>   Project does not exist.");
        }
        System.out.println("");
    }
}
