public class Ticket {
    private String movieName;
    private String showTime;
    private int seatNumber;


    public Ticket(String movieName, String showTime, int seatNumber) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.seatNumber = seatNumber;
    }


    public String toFileFormat() {
        return movieName + ";" + showTime + ";" + seatNumber;
    }


    public static Ticket fromFileFormat(String ticketData) {
        String[] data = ticketData.split(";");
        String movieName = data[0];
        String showTime = data[1];
        int seatNumber = Integer.parseInt(data[2]);
        return new Ticket(movieName, showTime, seatNumber);
    }


    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String toString() {
        return "Movie: " + movieName + ", Hall: " + showTime + ", Showtime: " + seatNumber;
    }
}
