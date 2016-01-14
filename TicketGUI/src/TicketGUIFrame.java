import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketGUIFrame extends JFrame {

	private JLabel orderMsg = new JLabel("Enter how many tickets you'd like to purchase(1-6)");
	private JTextField amt = new JTextField(7);
	private JLabel infoMsg = new JLabel("");
	private JLabel soldOutMsg = new JLabel("");
	private int MIN_TIX = 1;
	private int MAX_TIX = 6;
	private int TOT_TIX = 75;
	private int tixPurchased =0; 
	private int percentPurchased = 0;
	
	TicketGUI account;
	TicketGUIStatus stat = new TicketGUIStatus();
	
	public TicketGUIFrame(TicketGUI b){
		account = b;
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
		//controlPanel.setLayout(new FlowLayout());
		
		JButton order = new JButton("Purchase Tickets");
		stat.setPreferredSize(new Dimension(500,500));
		ActionListener d = new orderListener();
		getRootPane().setDefaultButton(order);
		order.addActionListener(d);
		
		controlPanel.add(orderMsg);
		amt.setMaximumSize(new Dimension(50,50));
        amt.setHorizontalAlignment(JTextField.CENTER);
		controlPanel.add(amt, BorderLayout.CENTER);
		controlPanel.add(order);
		controlPanel.add(infoMsg);
		controlPanel.add(stat);
		controlPanel.add(soldOutMsg);
		add(controlPanel);
	}
	
	
	class orderListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String a = amt.getText();
			int tixLeft = account.getTicketsAvailable();
			
			if (!(amt.equals(""))) {
				try {
					int numTickets = Integer.parseInt(a);
					if (numTickets < MIN_TIX || numTickets > MAX_TIX) {
						infoMsg.setText("Ticket orders must be 1-6");
						amt.setText("");
					}
					else if (tixLeft == 0) {
						soldOutMsg.setText("The event is sold out!");
						amt.setText("");
					}
					else if (numTickets > tixLeft) {
						infoMsg.setText("There are only " + tixLeft + " tickets left.");
						amt.setText("");
					}
					else {
						TicketGUI.order(numTickets);
						if (account.getTicketsAvailable() == 0) {
							infoMsg.setText(numTickets + " tickets purchased. ");
							soldOutMsg.setText("This event is sold out!");
						} else {
							infoMsg.setText(numTickets + " tickets purchased. " + account.getTicketsAvailable() + " tickets remaining.");
						}
						amt.setText("");
						tixPurchased += numTickets; 
						percentPurchased = ((tixPurchased * 300) / TOT_TIX);
					} 
				} catch (NumberFormatException ex) {
					infoMsg.setText("Please enter a valid number of tickets"); 
					amt.setText("");
				}
					
			}	
			
			stat.setNewValues(50, 25, percentPurchased);
		}
	}
	
	
}
