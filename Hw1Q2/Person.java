

public class Person {
    
    // Fields
    private String firstName;
    private String lastName;
    private String id;

    // Constructor
    public Person (String newId, String newFirstName, String newLastName){
        firstName = newFirstName;
        lastName = newLastName;
        id = newId;
    }

    // Setters
    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public void setId( String newId) {
        id = newId;
    }

   // Getters
   public String getFirstName() {
    return firstName;
   }

   public String getLastName() {
    return lastName;
   }

   public String getId() {
    return id;
   }

   // toString
   @Override
   public String toString() {
    return id + " " + firstName + " " + lastName; 
   }
}