package fileslab;

import java.io.*;


public class Startup {
    public static void main(String[] args) throws IOException{
        ContactService srv = new ContactService();
        String filePath = "src/contactList";
        
        srv.getLinesInFile(filePath);
        
        String con1 = srv.findContactAndState(1, filePath);
        System.out.println(con1);
        
    }
    
}
        