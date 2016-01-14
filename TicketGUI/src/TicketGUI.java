
public class TicketGUI {
	
	static int ticketsAvailable=75;
	
	public TicketGUI (int startTickets) {
		ticketsAvailable = startTickets;
	}
	
	public int getTicketsAvailable() {
		return ticketsAvailable;
	}
	
	public void setTicketsAvailable(int ticketsAvailable) {
		TicketGUI.ticketsAvailable = ticketsAvailable;
	}

	public static void deduct(int tix) {
		ticketsAvailable = ticketsAvailable - tix;
	}
	
	public static void order(int numTix) {
		ticketsAvailable = ticketsAvailable - numTix;
	}
}
