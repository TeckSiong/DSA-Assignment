/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import ADT.ADTOrder;
import ADT.DelManADT;
import Domain.DeliveryMan;
import Domain.ProductStatus;
import Domain.TotalAssign;
import Domain.orders;
import java.util.*;

/**
 *
 * @author khosit
 */
public class AssignDeliverymen {

    public static int abc ;
    public static String def;
    public final int ab =0;
    public static DelManADT<Domain.DeliveryMan> ad = new DelManADT<>();
    public static DelManADT<Domain.ProductStatus> ps = new DelManADT<>();
    public static DelManADT<Domain.orders> od = new DelManADT<>();
    public static ADTOrder<orders> orders1 = new ADTOrder<>();
    
   // public static ProductStatus<Domain.DeliveryMan> ad = new ProductStatus<>();

   // private final List<String> IDlist = new ArrayList<String>();
    //private final List<String> meallist = new ArrayList<String>();
   // private final List<String> adeliveryman = new ArrayList<String>();

   // private final List<String> orderlist = new ArrayList<String>();

    

    //String[] ID = new String[]{"1001", "1002", "1003", "1004"};
    //String[] meal = new String[]{"Buger", "Roti", "Pepsi", "Cola"};

    public void Order() {
        Scanner scanner = new Scanner(System.in);
        od = DelManMaintain.oList;
        if(od.isEmpty()){
            Domain.orders.OrderList1();
        }
        
        
        ps = DelManMaintain.sList;
        if (ps.isEmpty()) {
            Domain.ProductStatus.Status();
        }
        
        
      
        orders1 = foodOrder.orders1;
        
            
        
        

        int no = 0;

        System.out.println("No ID      ");
        System.out.println("== =====   ");

        
            for (int e = 0; e < ps.getSize(); e++) {
                if(ps.getData(e).getStatus()=="Pending"){
                    System.out.println((e+1) + "  " + ps.getData(e).getOrderID());
                }
                    
            }
        System.out.println();
        System.out.println("00 Exit");

        

        System.out.println();
        System.out.print("Please enter No. of order: ");
        no = scanner.nextInt();
        System.out.println();
        

        for (int l = 0; l < ps.getSize(); l++) {

            if (no == l + 1) {
                System.out.println("Your selected ID : " + ps.getData(l).getOrderID());
                System.out.println();
                abc = ps.getData(l).getOrderID();

                
                delivery();
            }else if(no == 00){
                MainMenu mm = new MainMenu();
                mm.MainMenu();
            }
        }

    }

    public void delivery() {

        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        int no2 = 0;
        
        ad = DelManMaintain.dList;

        if (DelManMaintain.dList.isEmpty()) {
            Domain.DeliveryMan.DeliveryMenDetails();
        }

        

        System.out.println("Available delivery men");
        System.out.println();
        System.out.println("No Delivery men      ");
        System.out.println("== ===============   ");

        for (int c = 0; c < ad.getSize(); c++) {
            int cc = c + 1;
            if (ad.getData(c).getStatus() == "Available") {

                System.out.println(cc + "  " + ad.getData(c).getDelmenName());

            }
            //
        }
        System.out.println();
        System.out.println("00 Exit");

        System.out.println();
        System.out.print("Please enter No. of delivery man: ");
        no2 = scanner3.nextInt();
        System.out.println();

        for (int l = 0; l < ad.getSize(); l++) {
            if (no2 == (l + 1)) {
                //System.out.print("Do you sure want "+deliveryman.get(l)+" to delivery order "+orderlist.get(l)+" ?");
                System.out.print("Do you sure want ");
                System.out.print(ad.getData(l).getDelmenName() + " ");
                System.out.print("to assign order ");
                System.out.print(abc + " ?");
                System.out.println();
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println();
                System.out.print("Please enter selection no.: ");

                int ask = scanner3.nextInt();
                System.out.println();

                if (ask != 1) {
                    System.out.println("Invalid!!");
                    delivery();

                } else {
               
                    
                    
                    int di = ad.getData(l).getDelmenId();

                    System.out.println();
                    System.out.println("=====================================");
                    System.out.print("Please Enter the devery distance(km): ");
                    Scanner sc = new Scanner(System.in);
                    double distance = sc.nextDouble();
                    ad.getData(l).setTotalDistance(ad.getData(l).getTotalDistance() + distance);

                    System.out.println();
                    System.out.println("Set the time that pruduct will be reached:");
                    System.out.print("Hour: ");
                    Scanner sh = new Scanner(System.in);
                    int hs = sh.nextInt();
                    System.out.print("Minute: ");
                    Scanner sm = new Scanner(System.in);
                    int ms = sm.nextInt();
                    
                    System.out.println();
                    System.out.println("==========================");
                    System.out.println("Order ID  : "+abc);
                    System.out.println("Distance  : "+distance+"km");
                    System.out.println("Reach Time: "+hs+":"+ms);
                   
                    
                    for(int d = 0;d < ps.getSize();d++){
                        if(ps.getData(d).getOrderID()== abc){
                            ps.getData(d).setDelManId(di);
                            ps.getData(d).setMinute(ms);
                            ps.getData(d).setHour(hs);
                            ps.getData(d).setStatus("Delivering");
                        }
                    }   
                    
                    System.out.println("=====================================");
                    
                    String a = "Delivery";
                    def = ad.getData(l).getDelmenName();
                    ad.getData(l).setStatus(a);

                    System.out.println();
                    
                    

                    System.out.println("Do you want to continue assign other jobs? ");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.println();
                    System.out.print("Please enter selection no.: ");

                    int yn = 0;
                    yn = scanner4.nextInt();

                    if (yn == 1) {
                        System.out.println();
                        Order();
                        
                    } else {
                        System.out.println(); 
                        System.out.println("The delivery jobs have assigned!!");
                        MainMenu mm = new MainMenu();
                        mm.MainMenu();
                    }
                    
                    
                }

            }else if(no2 ==00){
                Order();
            }
        }
        
        
    }

    public  void AssignDM() {

        AssignDeliverymen o = new AssignDeliverymen();
        o.Order();
        DelManMaintain.dList = ad ;
        DelManMaintain.sList = ps;


        
        
        
        
    }

}
