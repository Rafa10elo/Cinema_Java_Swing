import java.util.ArrayList;
import java.util.List;

public class User {
    private static int USERS_COUNT=0;
    private int USER_ID;
    private String userName;
    private String password;
    private String email;
    private boolean adminProp;
    private  List<Ticket> ticketsList;


   public User(String userName , String password,  String email){
        USERS_COUNT++;
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
                ticketsList.add(Ticket.fromFileFormat(ticketString));
            }
        }
        return new User(id, userName, password, email, adminProp, ticketsList);
    }



        public String toFileFormat() {

        StringBuilder ticketsString = new StringBuilder();
        for (Ticket ticket : ticketsList) {
            ticketsString.append(ticket.toFileFormat()).append("|");
        }

        return USER_ID + "," + userName + "," + password + "," + email + "," + adminProp + "," + ticketsString;
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



}
