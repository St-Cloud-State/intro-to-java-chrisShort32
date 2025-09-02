package Hw1Q3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> personList;

    // Constructor
    public PersonList() {
        this.personList = new LinkedList<>();
    }


    public void store(InputStream input) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String data;
        while ((data = reader.readLine()) != null) {
            // File is space separated, create String array of the id, first name, and last name
            String[] person = data.split(" ");
            personList.add(new Person(person[0], person[1], person[2]));
        }
    }

    public void display(OutputStream output) throws IOException {

        for (int i = 0; i < personList.size(); i++) {
            String person = personList.get(i).toString();
            output.write(person.getBytes());
            output.write("\n".getBytes());
        }

    }

    public int find(String searchId) {

        for (int i = 0; i < personList.size(); i++) {
            if (searchId.equals(personList.get(i).getId())) {
                return i;
            }
        }

        return -1;
    }

    public void findHelper(int index) {
        if (index < 0) {
            System.out.println("Person not found\n");
        }
        else {
            System.out.println("Person found at index: " + index);
            System.out.println(personList.get(index).toString() + "\n");
        }
    }
}
