/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import ADT.ADTOrder;
import ADT.ADTTheList;
import ADT.ADTTheListInterface;
import ADT.BubbleSort;
import java.util.*;
import Domain.Schedule;
import ADT.ScheduleADT;
import ADT.ScheduleInterface;
import static Client.FoodMenu.AllFood;
import static Client.foodOrder.orders1;
import Domain.Distance;
import Domain.Food;
import Domain.orders;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author KD
 */
public class ScheduleOrder {
    public Scanner scan = new Scanner(System.in);
    public static int Time;
    public static int count=0;
    public String temp;
    public static int id=7000;
    public static ScheduleInterface<Distance> distanceList = new ScheduleADT<>();
    public ScheduleInterface<String> input = new ScheduleADT<>();
    public static ScheduleInterface<Schedule> SC = new ScheduleADT<>();
    public static ADTOrder<orders> orders1 = new ADTOrder<>();
    public static int ID;
    public static String password;
    public static String RESTAURANT_NAME;
    public boolean loginDeActivated = false;
    public Scanner scan1 = new Scanner(System.in);
    ADTTheListInterface<Food> flist = new ADTTheList<>();

    

    MainMenu main = new MainMenu();

    public int classify = 10001;
    
    public void test(){
        distanceList.distanceBetweenPlaces();
        System.out.println(distanceList.calculateDistance("pv15", "taman melawati")+"please work");
    }
   public void MakeScheduleOrder()
    {
        /*
        String options;
        int option = 0;
        int resno = 0;
        int CompanyName = 0;

        Calendar cal = Calendar.getInstance();
        int d = cal.get(Calendar.DAY_OF_WEEK);
        
        if(Restaurant.Ro.isEmpty()){
            Domain.RestaurantOwner.RestList();
        }

       // System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSelect Company Name : \n");

        for (int i = 0; i < Restaurant.Ro.getSize(); i++) {
            System.out.print(i + " " + Restaurant.Ro.returnItem(i).getRestaurantName() + "\n");
            resno++;
        }
        if(resno == 0){
        
             System.out.println("Sorry, non restaurant is serving currently...");
             scan1.nextLine();
             
             main.customer();
        }else{
            System.out.println();
            System.out.print("Select Company Name : ");
        }
        int x = 0;

        int count = 0;
        String status = "";
        ArrayList<Integer> show = new ArrayList<>();

        do {
            try {
                CompanyName = Restaurant.Ro.returnItem(scan1.nextInt()).getId();
                scan1.nextLine();
                x = 0;
            } catch (Exception e) {
                System.out.println("Please input again");
                x = 1;
                scan1.nextLine();
            }
        } while (x == 1);
        //  System.out.println("Food Name        Category         Quantity           Price");
        // System.out.println("=========        ========         ========           =====");
        System.out.printf("%20s %20s %20s %20s\n", "Foodname", "Category", "Quantity", "Price(RM)");
        System.out.printf("%20s %20s %20s %20s\n\n", "========", "========", "========", "=====");
        for (int i = 0; i < Restaurant.Ro.getSize(); i++) {
            if (CompanyName == Restaurant.Ro.returnItem(i).getId()) {
                status = Restaurant.Ro.returnItem(i).getStatus();
            }
        }
        if (AllFood.checkEmpty()) {
            System.out.println("Empty Food List");
        }
        for (int i = 0; i < AllFood.getSize(); i++) {

            if (d == 1 && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && AllFood.returnItem(i).getDayAvailable().equals("Sunday")) {
                flist.addItem(AllFood.returnItem(i));
                //   System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());
                show.add(i);
                count = count + i;
            }
            if ((d == 2 || d == 3) && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && (AllFood.returnItem(i).getDayAvailable().equals("Monday & Tuesday"))) {
                flist.addItem(AllFood.returnItem(i));
                //  System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());

                show.add(i);
                count = count + i;
            }
            if ((d == 4 || d == 5) && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && (AllFood.returnItem(i).getDayAvailable().equals("Wednesday & Thursday"))) {
                flist.addItem(AllFood.returnItem(i));
                //System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"             "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());

                show.add(i);
                count = count + i;
            }
            if ((d == 6 || d == 7) && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && (AllFood.returnItem(i).getDayAvailable().equals("Friday & Saturday"))) {
                flist.addItem(AllFood.returnItem(i));
                // System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"            "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());

                show.add(i);
                count = count + i;
            }

        }

        int icount = 0;
        do {
            System.out.println("\nPress any key to continue");
            scan1.nextLine();
            System.out.println("1. Place Order 2. Sort Order");
            try {
                option = scan1.nextInt();
                scan1.nextLine();
                icount = 1;
            } catch (Exception ex) {
                System.out.println("Invalid Input...");
                icount = 0;
            }
        } while (icount == 0);
        icount = 0;
        if (option == 1) {

            int aaa = 0;
            int abc;
            int quant;
            int subtotal = 0;
            double total = 0;

            do {
                System.out.print("\n\n\nPlease place your order :");
                abc = scan1.nextInt();

                abc = abc - 1;
                String name = flist.returnItem(abc).getFoodName();

                if (name != " ") {
                    for (int s = 0; s < AllFood.getSize(); s++) {
                        if (name.equals(AllFood.returnItem(s).getFoodName())) {

                            System.out.print("Kindly key in quantity :");
                            quant = scan1.nextInt();

                            custLogin cust = new custLogin();
                            
                            orders od = new orders(classify,AllFood.returnItem(s).getFoodID() ,AllFood.returnItem(s).getCompanyID(), AllFood.returnItem(s).getFoodName(), quant, AllFood.returnItem(s).getPrice(), "Pending",cust.getcustID());

                            orders1.add(od); //add to node
                            

                            subtotal = subtotal + quant;
                            total = total + (quant * AllFood.returnItem(s).getPrice());

                        }
                    }
                } else {
                    System.out.println("Incorrect input...\n\n");
                }

                System.out.print("\n\n\nDo you wish to make another oder ? (1 = exit)");
                aaa = scan1.nextInt();

            } while (aaa == 0);

            classify++;

            System.out.println("\n\n\n=============== Order Summary ===============\n\n\n");
            System.out.println("Food     " + "Quantity       " + "Price (RM)  \n");
            for (int y = 1; y <= orders1.getSize(); y++) {
                System.out.println(orders1.getEntry(y).getname() + "           " + orders1.getEntry(y).getquantity() + "              " + (orders1.getEntry(y).getprice() * orders1.getEntry(y).getquantity()) + "\n");
            }

            System.out.println("=============== Total amount need to pay : ===============\n");
            System.out.println("                       SubTotal:" + subtotal + "(S)   RM" + total);

            do {

                System.out.print("\n\n\nCard No        :");
                String card = scan1.nextLine();

                if (card.length() == 16) {

                    System.out.println("\n\n= = =Thank you and come again= = =\n\n");
                    aaa = 0;
                } else {
                    System.out.println("\n\n! ! !Invalid card! ! !\n\n");
                }

            } while (aaa == 1);

        } */
        
        classify++;

    
        
        
        
        System.out.print("Please input Receiver Name                    :");
        String recName="";
        recName=scan.nextLine();
        input.addItem(recName);
        
        System.out.print("Please input Receiver Address                 :");
        String recAddress="";
        recAddress=scan.nextLine();
        input.addItem(recAddress);
        
       count=0;
        do{
             if(count>0)
              {
                  System.out.println("Date Not Valid");
              }
         System.out.print("Please input correct date (Format yyyy-MM-dd) :");
          temp = scan.nextLine();
         count++;
         }while(!isValidDate(temp)||!isAfterTodayDate(temp));
        
       count=0;
         input.addItem(temp);
        
         do{
             if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time  (Format HH:MM)   :");
          temp = scan.nextLine();
         count++;
         
         }while(!checkTime(temp));
         count=0;
         input.addItem(temp);
        
        
        
         count=0;
         input.addItem(temp);
        Schedule schedule = new Schedule(id,input.getIndexItem(0),input.getIndexItem(1),
                input.getIndexItem(2),input.getIndexItem(3),classify);
        SC.addItem(schedule);
        
         System.out.println("\nYou Are successfully Make a Schedule Order, Your ID Is "+id+"\n");
         id++;
        System.out.println("Summary Of Registration Of Restaurant Owner");
        System.out.println("Receiver Name   : "+input.getIndexItem(0) );
        System.out.println("Receiver Address: "+ input.getIndexItem(1));
        System.out.println("Deliver Date    : "+ input.getIndexItem(2));
        System.out.println("Deliver Time    :"+ input.getIndexItem(3));
        System.out.println("\nPress any key to continue");
        input.clearAll();
        scan.nextLine();
       
    }
   
   public void viewTodayScheduleOrder(){
       
       
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); 
        String currentDateFormat = dateFormat.format(currentDate);
        if(!SC.isEmpty()){
        for (int i = 0; i < SC.getSize(); i++) {
        try {
            Date comp1 = dateFormat.parse(SC.getIndexItem(i).getDate());
            Date comp2 = dateFormat.parse(currentDateFormat);
            if (comp1.compareTo(comp2) == 0)
            {
                System.out.printf("%15s %15s %15s %15s\n","Receiver Name","Receiver Address","Date","Time");
                System.out.printf("================================================================\n");
                System.out.printf("%15s %15s %15s %15s\n",SC.getIndexItem(i).getReceiverName(),SC.getIndexItem(i).getReceiverAddress(),SC.getIndexItem(i).getDate(),SC.getIndexItem(i).getTime());
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       
                    }
        }else
                System.out.println("Nothing to be deliver today");
       
       
   }
   
   public static boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
   public static boolean isAfterTodayDate(String inDate){
       if(!isValidDate(inDate)){
           System.out.println("fucker");
           return false;
       }else{
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); 
        String currentDateFormat = dateFormat.format(currentDate);
        
        try {
            Date comp1 = dateFormat.parse(inDate);
            Date comp2 = dateFormat.parse(currentDateFormat);
            if (comp1.compareTo(comp2) > 0) {
                return true;
        } else{
                System.out.println("The time should be after today");
            return false;
                
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       }
       
   }
   
   public static boolean checkExit(ADTTheListInterface<String> l)
   {
       ADTTheList f = (ADTTheList) l ;
       boolean exit = false;
       if(f.contains("exit"))
          exit=true;
       return exit;
   }
   
   public boolean checkTime(String test)
   {
       boolean timeValid = true;
       if( test.length()==5)
       {  if(test.charAt(2)==':' )
         {
            String split[]  = test.split(":");
            try{
                    if(Integer.parseInt(split[0])>24||Integer.parseInt(split[0])<-1)
                       timeValid=false;
                    if(Integer.parseInt(split[1])>=60||Integer.parseInt(split[1])<-1)
                       timeValid=false;
            }catch(NumberFormatException ex)
            {
                timeValid=false;
            }
         }else
           timeValid=false;}else
           timeValid=false;
       return timeValid;
   }
   
   
   
  
   
   
    
}
