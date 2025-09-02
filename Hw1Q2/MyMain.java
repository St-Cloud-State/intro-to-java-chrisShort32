import java.util.LinkedList;
import java.io.*;

public class MyMain {

    public static void store(InputStream input, LinkedList<Person> people) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String data;
        while ((data = reader.readLine()) != null) {

            // File is space separated, create String array of the id, first name, and last
            // name
            String[] person = data.split(" ");
            people.add(new Person(person[0], person[1], person[2]));
        }
    }

    public static void display(OutputStream output, LinkedList<Person> people) throws IOException {

        for (int i = 0; i < people.size(); i++) {
            String person = people.get(i).toString();
            output.write(person.getBytes());
            output.write("\n".getBytes());
        }

    }

    public static int find(String searchId, LinkedList<Person> people) {

        for (int i = 0; i < people.size(); i++) {
            if (searchId.equals(people.get(i).getId())) {
                return i;
            }
        }

        return -1;
    }

    public static void findHelper(int index, LinkedList<Person> person) {
        if (index < 0) {
            System.out.println("Person not found");
        }
        else {
            System.out.println("Person found at index: " + index);
            System.out.println(person.get(index).toString());
        }
    }

    public static void main(String[] args) throws IOException {

        // Create the list of persons
        LinkedList<Person> personList = new LinkedList<>();

        // set the input file
        FileInputStream inputFile = new FileInputStream("Hw1Q2/people.txt");
        
        System.out.println("Reading from file.....\n\n");
        store(inputFile, personList);

        System.out.println("Displaying the list of people.....\n\n");
        display(System.out, personList);

        // Test find
        System.out.println("\n\nTesting find method.....\n\n");

        System.out.println("Searching for Person ID 2");
        int foundIndex = find("2", personList);
        findHelper(foundIndex, personList);

        System.out.println("Searching for Person ID 15");
        foundIndex = find("15", personList);
        findHelper(foundIndex, personList);

        System.out.println("Searching for Person ID 20");
        foundIndex = find("20", personList);
        findHelper(foundIndex, personList);

        System.out.println("Searching for Person ID 4");
        foundIndex = find("4", personList);
        findHelper(foundIndex, personList);

    }
}