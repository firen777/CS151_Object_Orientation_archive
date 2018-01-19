import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Albert Chan
 *
 */
public class SimpleCalendar {

	
	public static void main(String[] args) throws ClassNotFoundException, ParseException {
		
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		CalendarModel m = new CalendarModel();
		MonthViewPanel monthView = new MonthViewPanel(m);
		
		JPanel dayView = new DayViewPanel(m);
		
		JScrollPane dayViewSP = new JScrollPane(dayView);
		dayViewSP.setPreferredSize(new Dimension(600,300));
		
		//panel3.setPreferredSize(new Dimension(600,300));
		
		frame.add(monthView, BorderLayout.WEST);
		frame.add(dayViewSP, BorderLayout.CENTER);
		frame.add(new CreateEventPanel(m), BorderLayout.SOUTH);
		frame.add(new TopControllerPanel(m), BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}



/*
 * CalendarModel hc = new CalendarModel();
		String option = "";
		
		Scanner sc = new Scanner(System.in);
		GregorianCalendar g = new GregorianCalendar();
		System.out.println(g.get(GregorianCalendar.MINUTE));
		
		System.out.print(hc.calendarHIGHLIGTDate());
		
		System.out.println("Select one of the following options:");
		System.out.println("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
		option = sc.nextLine();
		
		//==========!Q==========//
		while (!option.equalsIgnoreCase("Q")){
			//==========L==========//
			if (option.equalsIgnoreCase("L")) {
				try {
					hc.openCalendarEventList("events.txt");
					System.out.println("Loaded");
				} catch (IOException e) {
					System.out.println("\"events.txt\" not found. Is this the first time you run this program?");
				}
			} 
			//==========V==========//
			else if (option.equalsIgnoreCase("V")){
				System.out.println("[D]ay view or [M]view ?");
				option = sc.nextLine();
				//==========D==========//
				if (option.equalsIgnoreCase("D")) {
					System.out.print(hc.todayDescription());
					System.out.println("[P]revious or [N]ext or [M]ain menu ?");
					option = sc.nextLine();
					//==========!Menu==========//
					while (!option.equalsIgnoreCase("M")){
						//==========P==========//
						if (option.equalsIgnoreCase("P")){
							hc.previousDay();
							System.out.print(hc.todayDescription());
						}
						//==========N==========//
						else if (option.equalsIgnoreCase("N")) {
							hc.nextDay();
							System.out.print(hc.todayDescription());
						}
						System.out.println("[P]revious or [N]ext or [M]ain menu ?");
						option = sc.nextLine();
					}
					hc.resetDate(); //reset HelloCalendar's current date
				}
				//==========MonthView==========//
				else if (option.equalsIgnoreCase("M")) {
					System.out.print(hc.thisMonthDescription());
					System.out.println("[P]revious or [N]ext or [M]ain menu ?");
					option = sc.nextLine();
					//==========!Menu==========//
					while (!option.equalsIgnoreCase("M")){
						//==========P==========//
						if (option.equalsIgnoreCase("P")){
							hc.previousMonth();
							System.out.print(hc.thisMonthDescription());
						}
						//==========N==========//
						else if (option.equalsIgnoreCase("N")) {
							hc.nextMonth();
							System.out.print(hc.thisMonthDescription());
						}
						System.out.println("[P]revious or [N]ext or [M]ain menu ?");
						option = sc.nextLine();
					}
					hc.resetDate(); //reset HelloCalendar's current date
				}
			}
			//==========C==========//
			else if (option.equalsIgnoreCase("C")) {
				System.out.println("Title:");
				String context = sc.nextLine();
				
				System.out.println("date: (MM/DD/YYYY)");
				String inputDate = sc.nextLine();
				
				System.out.println("Starting time:");
				String startTime = sc.nextLine();
				
				System.out.println("Ending time (type 'x' if not applicable):");
				String endTime = sc.nextLine();
				
				if (endTime.equalsIgnoreCase("X")) {
					hc.addEvent(context, inputDate, startTime);
				} else {
					hc.addEvent(context, inputDate, startTime, endTime);
				}
			}
			//==========G==========//
			else if (option.equalsIgnoreCase("G")) {
				System.out.println("date: (MM/DD/YYYY)");
				String inputDate = sc.nextLine();
				System.out.print(hc.targetDayDescription(inputDate));
			}
			//==========E==========//
			else if (option.equalsIgnoreCase("E")) {
				System.out.println(hc.getAllEvent());
			}
			//==========D==========//
			else if (option.equalsIgnoreCase("D")) {
				System.out.println("[S]elected or [A]ll ?");
				option = sc.nextLine();
				//==========S==========//
				if (option.equalsIgnoreCase("S")) {
					System.out.println("date: (MM/DD/YYYY)");
					String inputDate = sc.nextLine();
					if (hc.deleteSelectedEvents(inputDate)){
						System.out.print("Event Deleted\n");
					} else {
						System.out.print("Event not found! No action is performed.\n");
					}
				}
				//==========A==========//
				else if (option.equalsIgnoreCase("A")) {
					hc.deleteAllEvents();
					System.out.print("All Deleted\n");
				}
			}
			
			
			System.out.println("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
			option = sc.nextLine();
		}
		
		try {
			hc.saveCalendarEventList("events.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Saving eventList as \"events.txt\"");
 */
 