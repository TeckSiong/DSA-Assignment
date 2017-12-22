/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;


import ADT.ADTOrder;
import ADT.DelManADT;
import Domain.DeliveryMan;
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
    
    public static DelManADT<Domain.DeliveryMan> ad = new DelManADT<>();
    public static DelManADT<Domain.ProductStatus> ps = new DelManADT<>();
    public static ADTOrder<orders> od = new ADTOrder<>();
    public static DelManADT<Domain.TotalAssign> ta = new DelManADT<>();
   // public static ProductStatus<Domain.DeliveryMan> ad = new ProductStatus<>();

   // private final List<String> IDlist = new ArrayList<String>();
    //private final List<String> meallist = new ArrayList<String>();
   // private final List<String> adeliveryman = new ArrayList<String>();

   // private final List<String> orderlist = new ArrayList<String>();

    

    //String[] ID = new String[]{"1001", "1002", "1003", "1004"};
    //String[] meal = new String[]{"Buger", "Roti", "Pepsi", "Cola"};

    public void Order() {
        Scanner scanner = new Scanner(System.in);
        od = foodOrder.orders1;
        if(od.isEmpty()){
            Domain.orders.OrderList();
        }
        
        ps = DelManMaintain.sList;
        if (ps.isEmpty()) {
            Domain.ProductStatus.Status();
        }
        
        
        

        int no = 0;

        System.out.println("No ID      ");
        System.out.println("== =====   ");

        
            for (int e = 0; e < ps.getSize(); e++) {
                if(ps.getData(e).getStatus()=="Pending"){
                    System.out.println((e+1) + "  " + ps.getData(e).getOrderID());
                }
                    
            }
        

        

        System.out.println();
        System.out.print("Please enter No. of order: ");
        no = scanner.nextInt();
        System.out.println();

        for (int l = 0; l < od.getSize(); l++) {

            if (no == l + 1) {
                System.out.println("Your selected ID : " + ps.getData(l).getOrderID());
                System.out.println();
                abc = od.getEntry(l).getclassify();
                
                //delete order
                
                delivery();
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
                    System.out.print("Please Enter the devery distance: ");
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
                        delivery();
                    } else {
                        System.out.println();
                        ta.addData(new TotalAssign(abc,def));
                        System.out.println("The delivery jobs have assigned!!");
                    }
                    
                    
                }

            }
        }
        
        
    }

    public void assignjob() {
        System.out.println("Total Job Assign");
        System.out.println();
        System.out.println("OrderID    Delivery man");
        System.out.println("=======    ===============");

        for (int i = 0; i <= ta.getSize(); ++i) {
            
  
            System.out.println(ta.getData(i).getOrderId()+"       "+ta.getData(i).getDelName());
           
        }

        System.out.println();
        System.out.println("The delivery jobs have assigned!!");
        System.out.println();

    }

    public  void AssignDM() {

        AssignDeliverymen o = new AssignDeliverymen();
        o.Order();
        DelManMaintain.dList = ad ;
        DelManMaintain.sList = ps;


        
        
        
        
    }

}
