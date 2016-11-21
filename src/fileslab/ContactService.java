/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileslab;


import java.io.*;
import java.util.*;

/**
 *
 * @author Ryan
 */
public class ContactService {
    public List<String> getLinesInFile(String filePath) throws IOException{
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while(line != null){
                System.out.println(line);
                line = in.readLine();   
            }
            in.close();
            return lines;
        }
    public void addNewContact(List<String> contactLines, String filePath) throws IOException{
        File file = new File(filePath);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            for(String line: contactLines){
                out.println(line);
            }
            out.close();
        }
    }
    public String findContactAndState(int contactNumber, String filePath) throws IOException{
        final int BASE = -3;
        final int CONTACT_ADDER = 3;
        final int LINE_ADDER = 2;
        List<String> contactLines = getLinesInFile(filePath);
        
        String contactName = contactLines.get(BASE + CONTACT_ADDER * contactNumber);
        String contactCityStateZip = contactLines.get(BASE + CONTACT_ADDER * contactNumber + 2);
        String[] parts = contactCityStateZip.split(" ");
        String state = parts[parts.length - 2];
        return contactName + " -State: " + state;
        
    }
}

