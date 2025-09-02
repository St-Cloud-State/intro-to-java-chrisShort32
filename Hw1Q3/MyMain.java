package Hw1Q3;

import java.io.FileInputStream;
import java.io.IOException;

public class MyMain {
     public static void main(String[] args) throws IOException {
        // Create the PersonList
        PersonList plist = new PersonList();

        // Set the file input
        FileInputStream inputFile = new FileInputStream("Hw1Q2/people.txt");
        
        // Read the file
        System.out.println("Reading from file.....\n\n");
        plist.store(inputFile);

        // Display the list
        System.out.println("Displaying the list of people.....\n\n");
        plist.display(System.out);
        
        // Test find
        System.out.println("\n\nTesting find method.....\n\n");

        System.out.println("Searching for Person ID 2");
        int foundIndex = plist.find("2");
        plist.findHelper(foundIndex);

        System.out.println("Searching for Person ID 15");
        foundIndex = plist.find("15");
        plist.findHelper(foundIndex);

        System.out.println("Searching for Person ID 20");
        foundIndex = plist.find("20");
        plist.findHelper(foundIndex);

        System.out.println("Searching for Person ID 4");
        foundIndex = plist.find("4");
        plist.findHelper(foundIndex);
     }
}
