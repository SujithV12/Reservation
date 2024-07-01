package busReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Booking 
{
	String passengerName;
	int busNo;
	Date date;
	
	Booking()
	{
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter name of the passenger:");
			passengerName=scanner.next();
			
			System.out.println("Enter bus number:");
			busNo=scanner.nextInt();
			
			System.out.println("Enter date dd-mm-yyy");
			String dateInput=scanner.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				dateFormat.parse(dateInput);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
	public boolean isAvailable(ArrayList<Booking>bookings, ArrayList<Bus>buses) {
		int  capacity = 0;
		for (Bus bus:buses)
		{
		if(bus.getBusNo() == busNo)
			capacity = bus.getCapacity();
		}
		int booked =0;
		for(Booking b: bookings) 
		{
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
				
		}
		return booked<capacity?true:false;
	}
	
	}
	
	

