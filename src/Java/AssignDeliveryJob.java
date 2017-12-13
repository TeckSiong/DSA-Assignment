/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Domain.DeliveryMen;
import java.util.*;

/**
 *
 * @author khosit
 */
public class AssignDeliveryJob {


    
    private final List<String> IDlist = new ArrayList<String>(); 
    private final List<String> meallist = new ArrayList<String>();
     private final List<String> adeliveryman = new ArrayList<String>();
     //private final ArrayList<DeliveryMen> deliveryman = new ArrayList<>();
    private final List<String> orderlist = new ArrayList<String>();
    
    public String abc;
    public String def;
    
    ArrayList<DeliveryMen> ad = new ArrayList();
        
    
    String[] ID = new String[]{"1001","1002","1003","1004"};
    String[] meal = new String[]{"Buger","Roti","Pepsi","Cola"};

    public void Order(){
        Scanner scanner = new Scanner(System.in);
        
        int no = 0;
          
        System.out.println("No ID      Meal");
        System.out.println("== =====   ==========");
         
        if (IDlist.isEmpty()) {
            for (int e = 0; e < ID.length; e++) {
                IDlist.add(ID[e]);
                meallist.add(meal[e]);
            }
        }
         
        for(int c = 0; c < IDlist.size();c++){
            System.out.println((c+1) +"  "+IDlist.get(c) +"    "+meallist.get(c));
        }
        
        System.out.println();
        System.out.print("Please enter No. of order: ");
        no = scanner.nextInt();
        System.out.println();
     
        for (int l = 0; l < IDlist.size(); l++) {
            
            if (no == l+1) {
                System.out.println("Your selected ID : "+IDlist.get(l));
                System.out.println();
                abc = IDlist.get(l);
                orderlist.add(abc);
                IDlist.remove(l);
                meallist.remove(l);
            }
        }
        
        
    }
    public ArrayList<DeliveryMen> list(){
        
        ad.add(new DeliveryMen(601001, "ABC123", "Jorn Lim", "011-12345678", "Pertaling Jaya", "13/11/2016", "Available    ",2,"Active"));
        ad.add(new DeliveryMen(601002, "Hii123", "Mark    ", "018-1234567", "Wangsa Maju", "10/11/2016", "Not Available",3,"Active"));
        ad.add(new DeliveryMen(601003, "Waa123", "Jolin   ", "017-1234567", "Setapak", "17/11/2016", "Available    ",3,"Active"));
        ad.add(new DeliveryMen(601004, "Qzz123", "Sam     ", "016-1234567", "Seremban", "21/11/2016", "Not Available",4,"Active"));
        ad.add(new DeliveryMen(601005, "Zaa123", "Zack    ", "013-1234567", "Port Dickson", "30/11/2016", "Not Available",5,"Active"));
        
        return ad;
    }
    
    
    public void delivery(){
        
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        
        int no2 = 0;
        
        if (ad.isEmpty()) {        
            list();
        }
        
        System.out.println("Available delivery men");
        System.out.println();
        System.out.println("No Delivery men      "+"  "+"Trip");
        System.out.println("== ===============   "+"  "+"====");
        
        
        
        for(int c = 0; c < ad.size();c++){
            int cc = c+1;
            if(ad.get(c).getStatus()== "Available    "){
                
                System.out.println(cc + "  " + ad.get(c).getDelmenName()+"             "+ad.get(c).getTrip());
                
            }
            //
        }
        
        
        System.out.println();
        System.out.print("Please enter No. of delivery man: ");
        no2 = scanner3.nextInt();
        System.out.println();
        
        
        for (int l = 0; l < ad.size(); l++) {
            if (no2 == (l+1)) {
                //System.out.print("Do you sure want "+deliveryman.get(l)+" to delivery order "+orderlist.get(l)+" ?");
                System.out.print("Do you sure want ");
                System.out.print(ad.get(l).getDelmenName() + " ");
                System.out.print("to assign order ");
                System.out.print(abc+ " ?");
                System.out.println();
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println();
                System.out.print("Please enter selection no.: "); 
                
                int ask = scanner3.nextInt();
                System.out.println();
                
                if(ask != 1){
                    System.out.println("Invalid!!");
                    delivery();
                
                }else {
                    String a = "Not Available";
                    def = ad.get(l).getDelmenName();
                    adeliveryman.add(def);
                    ad.get(l).setStatus(a);
                    ad.get(l).setTrip(+1);
                    
                    System.out.println();
                    
                    System.out.println("Do you want to continue assign other jobs? ");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.println();
                    System.out.print("Please enter selection no.: ");
                    
                    int yn =0;
                    yn = scanner4.nextInt();
                    
                    if(yn == 1){
                        System.out.println();
                        Order();
                        delivery();
                    }else{
                        System.out.println();
                    }
                }
        
            }
        }
    }
    
    public void assignjob(){
        System.out.println("Total Job Assign");
        System.out.println();
        System.out.println("OrderID    Delivery man");
        System.out.println("=======    ===============");
        
        
        
        for (int i = 0; i < orderlist.size(); i++) {
            System.out.println(orderlist.get(i) + "       " + adeliveryman.get(i));
        }
        
        
        System.out.println();
        System.out.println("The delivery jobs have assigned!!");
        System.out.println();
        
 
    }
    
    
    
    
    


    public void adStart() {
       
        AssignDeliveryJob o = new AssignDeliveryJob();
        o.Order();
        o.delivery();
        o.assignjob();
    }
    
}
