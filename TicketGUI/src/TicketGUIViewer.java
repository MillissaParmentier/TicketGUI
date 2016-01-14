
import javax.swing.JFrame;

public class TicketGUIViewer {
	
	public static void main(String[] args) {
		
		TicketGUI tickets = new TicketGUI(75);
		
		JFrame frame = new TicketGUIFrame(tickets);
		
		frame.setSize(400, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
