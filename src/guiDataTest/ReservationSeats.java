package guiDataTest;

import java.util.ArrayList;


public class ReservationSeats {
		
	private ArrayList<int[]> customerSeats = new ArrayList<int[]>();//total of seats in the reservation


	public void addSeat(int rowNumber, int seatNumber){
		
		int[] seat = new int[2];//array to store the row and seat numbers for each seat in the reservation
		seat[0]= rowNumber;
		seat[1]= seatNumber;
		customerSeats.add(seat); //add selected seats to the List
		
	}
	
	
	public void removeSeat(int rowNumber, int seatNumber){
		
		for(int i = 0; i < customerSeats.size(); i++) { 
			if(customerSeats.get(i)[1]==seatNumber && customerSeats.get(i)[0]==rowNumber) {
				customerSeats.remove(i);
 
			}  
		}	
	}
	
	public void removeAllSeats(){
		customerSeats.clear();
	}
	
	public String getSeats(){
		String seats="";
		for(int i = 0; i < customerSeats.size(); i++)
		{
		  //build String
		  seats = seats + "Seat: " + customerSeats.get(i)[1] + " - Row: " + customerSeats.get(i)[0] + "\n"; 
		}
		return seats;
	}
	
	public ArrayList<int[]> getCustomerSeats() {
		return customerSeats;
	}
	
}
