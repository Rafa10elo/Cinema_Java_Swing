import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaManagement {
    int CURRENT_PERSON_ID;
    List<User> usersList ;
    List<Movie> moviesList;
    public CinemaManagement() {

        this.usersList = getUsersFromFile();
    }
    public void register(String username, String password, String email) {
        User newUser = new User(username, password, email);
        usersList.add(newUser);
        setUsersToFile();
        System.out.println("registration successful " + username);
    }
    public boolean login(String username, String password) {
        for (User user : usersList) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                CURRENT_PERSON_ID = user.getUSER_ID();
                System.out.println("Login successful! Welcome, " + username);
                System.out.println(CURRENT_PERSON_ID);

                return true;
            }
        }
        System.out.println("Invalid credentials, please try again.");
        return false;

    }


    public void setUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Lenovo/Desktop/Cinema_Java_Swing/Files_Of_The_Project/Users_File.txt"))) {
            for (User user : usersList) {
                writer.write(user.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsersFromFile() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Lenovo/Desktop/Cinema_Java_Swing/Files_Of_The_Project/Users_File.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromFileFormat(line);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return users;

    }
    public synchronized void bookTicket(Ticket ticket) {
        User currentUser = getCurrentUser();
        if (currentUser != null) {
            currentUser.addTicket(ticket);
            setUsersToFile();
            System.out.println("Ticket booked for: " + currentUser.getUserName());
        } else {
            System.out.println("No user is currently logged in.");
        }
    }
    public synchronized void cancelTicket(Ticket ticket) {
        User currentUser = getCurrentUser();
        if (currentUser != null) {
            currentUser.removeTicket(ticket);
            setUsersToFile();
            System.out.println("Ticket canceled for: " + currentUser.getUserName());
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void logout() {
        CURRENT_PERSON_ID = -1;
        System.out.println("User logged out.");
    }

    public User getCurrentUser() {
        System.out.println("CURRENT_PERSON_ID: " + CURRENT_PERSON_ID);  // Debug
        for (User user : usersList) {
            System.out.println("Checking user: " + user.getUSER_ID());  // Debug
            if (user.getUSER_ID() == CURRENT_PERSON_ID) {
                System.out.println("Found logged in user: " + user.getUserName());//Debug
                return user;
            }
        }
        System.out.println("No user found for CURRENT_PERSON_ID: " + CURRENT_PERSON_ID);  // Debug
        return null;
    }



}
