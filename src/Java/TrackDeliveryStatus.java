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
public class TrackDeliveryStatus {
    
    ArrayList<DeliveryMen> ad = new ArrayList();
    AssignDeliveryJob t = new AssignDeliveryJob();
    
    
    public void Available(){
        System.out.println("Staff ID   Name          Status         Trips");
        System.out.println("========   ==========    =============  =====");
        
        for(int a = 0; a < ad.size();a++){
            
            if(ad.get(a).getStatus()== "Available    "){
                System.out.println(ad.get(a).getDelmenId()+"     "+ad.get(a).getDelmenName()+
                    "      "+ad.get(a).getStatus()+"      "+ad.get(a).getTrip());
            }
            
        }
    }
    
    public void NotAvailable(){
        System.out.println("Staff ID   Name          Status         Trips");
        System.out.println("========   ==========    =============  =====");
        
        for(int a = 0; a < ad.size();a++){
            
            if(ad.get(a).getStatus()== "Not Available"){
                System.out.println(ad.get(a).getDelmenId()+"     "+ad.get(a).getDelmenName()+
                    "      "+ad.get(a).getStatus()+"      "+ad.get(a).getTrip());
            }
            
        }
    }
    
    public void CheckStatus(){
        Scanner scanner = new Scanner(System.in);
        
        if(ad.isEmpty()){
            ad = t.list();
        }
        
        
        
        System.out.println();
        System.out.println("Which status of Deliveryman, that user want to view?");
        System.out.println("1.Available");
        System.out.println("2.Not Avilable");
        System.out.println("3.All");
        
        System.out.println();
        System.out.println("Enter Selection: ");
        int no = scanner.nextInt();
        
        if(no == 1){
            Available();
        }
        
        if(no == 2){
            NotAvailable();
        }
        
        if(no == 3){
            System.out.println("Staff ID   Name          Status         Trips");
            System.out.println("========   ==========    =============  =====");

            for (int a = 0; a < ad.size(); a++) {

                System.out.println(ad.get(a).getDelmenId() + "     " + ad.get(a).getDelmenName()
                        + "      " + ad.get(a).getStatus() + "      " + ad.get(a).getTrip());

            }
        }
        
        System.out.println();
        System.out.println("What Assign job ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println();
        System.out.print("Enter Selection: ");
        int v = scanner.nextInt();
        
        if(v == 1){
            
            t.adStart();
            RegisterDelMen a = new RegisterDelMen();
            a.menu();
        }else
            CheckStatus();
            
        
    }
}
