import java.util.ArrayList;
import java.util.List;

public class User {
    private static int USERS_COUNT=CinemaManagement.getUsersCountFromFile();
    private int USER_ID;
    private String userName;
    private String password;
    private String email;
    private boolean adminProp;
    private  List<Ticket> ticketsList;
    Object USERS_LOCK = new Object();

   public User(String userName , String password,  String email){
        USERS_COUNT++;
      CinemaManagement.setUsersCountToFile();
        USER_ID =USERS_COUNT;
        this.userName = userName;
        this.password =password;
        this.email= email;
        ticketsList = new ArrayList<Ticket>();
        this.adminProp = false;
    }
    public User(int id, String userName, String password, String email, boolean adminProp,List ticketsList) {
        this.USER_ID = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.adminProp = adminProp;
        this.ticketsList = ticketsList;

    }

    public static User fromFileFormat(String userData) {
        String[] data = userData.split(",");
        int id = Integer.parseInt(data[0]);
        String userName = data[1];
        String password = data[2];
        String email = data[3];
        boolean adminProp = Boolean.parseBoolean(data[4]);

        String ticketsData = (data.length > 5) ? data[5] : "";
        List<Ticket> ticketsList = new ArrayList<>();
        if (!ticketsData.isEmpty()) {
            String[] ticketsArray = ticketsData.split("\\|");
            for (String ticketString : ticketsArray) {
                if (!ticketString.isEmpty()) {
                    ticketsList.add(Ticket.fromFileFormat(ticketString));
                }
            }
        }
        return new User(id, userName, password, email, adminProp, ticketsList);
    }



    public String toFileFormat() {
        StringBuilder ticketsString = new StringBuilder();
        for (Ticket ticket : ticketsList) {
            ticketsString.append(ticket.toFileFormat()).append("|");
        }

        return USER_ID + "," + userName + "," + password + "," + email + "," + adminProp + "," + ticketsString.toString();
    }


    public void addTicket(Ticket ticket) {
        synchronized(USERS_LOCK) {
            ticketsList.add(ticket);
        }
        System.out.println("Ticket added for user: " + userName);
    }

    public void removeTicket(Ticket ticket) {
        synchronized(USERS_LOCK) {
            if (ticketsList.contains(ticket)) {
                ticketsList.remove(ticket);
                System.out.println("Ticket removed for user: " + userName);
            } else {
                System.out.println("Ticket not found for user: " + userName);
            }
        }
    }
    public void displayTickets() {
        System.out.println("User: " + userName + " has the following tickets:");
        for (Ticket ticket : ticketsList) {
            System.out.println(ticket);
        }
    }

    public List<Ticket> getTicketsList() {
        return ticketsList;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public int getUSER_ID() {
        return USER_ID;
    }

    public static int getTheStaticCounter(){
       return USERS_COUNT;
    }


}
