// A) This is a Solo or Pair activity
// B) Write your name(s) in 1/8 crosswise
// C) You can open previous sample program
// D) Use of internet is strictly prohibited (Violaton = ZERO)
// E) Hands-on quiz duration = 90 minutes (Time is UP - Everyone should stay outside the lab)

// 1) Play the video (OutputFlow.mp4)
// 2) Analyze the program that implements abstract class (HotelRoom - StandardRoom, DeluxeRoom, SuiteRoom)
// 3) In reference to the video, construct your source program here...
// 4) Use the sample inputs sequentially from the video when you test your program
// 5) Every correct output is equivalent to 4 pts

// ONE TIME CHECKING ONLY
// YOU CAN ASK FOR CHECKING EVEN IF TIME DURATION IS NOT OVER
// "UNNECESSARY NOISE" WOULD MEAN -5 pts PER OCCURENCE
// INTERACTION WITH OTHER PAIR = ZERO

import java.util.Scanner;

public class HotelManagementApp {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner a = new Scanner(System.in);
        HotelRoom[] rooms = new HotelRoom[6];
        HotelRoom del = new DeluxeRoom(null, 0, true);
        HotelRoom stand = new StandardRoom(null, 0, true);
        HotelRoom suite = new SuiteRoom(null, 0, true);
        
    while(true){
        for (int i = 0; i <rooms.length; i++){
            System.out.println(HotelRoom.rooms[i]);
        }
        System.out.println("Enter Room to book: ");
        String roomNumber = s.nextLine();
        System.out.println("Enter the number of night(s)");
        int night =s.nextInt();
        System.out.println("Are you a member? (T/F)");
        String intput= a.nextLine();

        if(intput == "t");{
            for(HotelRoom room :rooms){
                if(roomNumber == "101"){
                  del = new DeluxeRoom("101", 1500.0, false);
                  room.bookRoom(0);
                  System.out.println(room.calculatePrice(night,true));
                }
                }
        }       
    }
    }
}