/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;
import ADT.ADTTheListInterface;
import ADT.ADTTheList;
import java.util.*;
import Domain.RestaurantOwner;
import Java.FoodMenu;

/**
 *
 * @author Jeffrey
 */
public class Restaurant {
    
    public Scanner scan = new Scanner(System.in);
    public static int Time;
    public static int count=0;
    public String temp;
    public static int id=1000;
    public ADTTheListInterface<String> input = new ADTTheList<>();
    public static ADTTheListInterface<RestaurantOwner> Ro = new ADTTheList<>();
    public static int ID;
    public static String password;
    public static String RESTAURANT_NAME;
    public boolean loginDeActivated = false;
    
   public void registrationRestaurantOwner()
    {
        System.out.println("Registration Of Restaurant Owner\n(Type \"exit\" at any input to Cancel Registration");
        System.out.println("--------------------------------");
        String name="";
        do{
        System.out.print("Please input Restaurant Name : ");
        name=scan.nextLine();
        if(name.isEmpty())
            System.out.println("Please input a name");
        }while(name.isEmpty());
        input.addItem(name);
        
        String contact="";
        do{
        System.out.print("Please input Contact No : ");
        contact = scan.nextLine();
        if(!contact.matches("[1-9][0-9]{9,14}"))
            System.out.println("Contact Not Valid Please Input 10-15 contact Number");
        }while(!contact.matches("[1-9][0-9]{9,14}"));
        input.addItem(contact);
       
        name="";
       
        do{
            
       System.out.print("Please input Password : ");
        name=scan.nextLine();
        if(name.isEmpty())
            System.out.println("Please input a password");
        }while(name.isEmpty());
        input.addItem(name);
        
        name="";
        do{
         System.out.print("Please input Address : ");
        name=scan.nextLine();
        if(name.isEmpty())
           System.out.println("Please input an address");
         }while(name.isEmpty());
        input.addItem(name);
       
        input.addItem(chooseStyleMethod());
       
         do{
             if(count>0)
              {
                  System.out.println("Times Not Valid");
              }
         System.out.print("Please input Available Time : Start TIme (Format HH:MM)");
          temp = scan.nextLine();
          
         count++;
         }while(!checkTime(temp));
         count=0;
         input.addItem(temp);
         System.out.print("Please input Available Time : To");
          do{
              if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time : End TIme (Format HH:MM");
        temp = scan.nextLine();
        
         count++;
        }while(!checkTime(temp));
         count=0;
         input.addItem(temp);
        RestaurantOwner o = new RestaurantOwner(id,input.returnItem(0),input.returnItem(1),
                input.returnItem(2),input.returnItem(3),input.returnItem(4),input.returnItem(5)+" - "+input.returnItem(6));
        Ro.addItem(o);
        
         System.out.println("\nYou Are successfully Register New Account, Your ID Is "+id+"\n");
         id++;
        System.out.println("Summary Of Registration Of Restaurant Owner");
        System.out.println("Restaurant Name : "+input.returnItem(0) );
        System.out.println("Contact No      : "+ input.returnItem(1));
        System.out.println("Password        : "+ input.returnItem(2));
        System.out.println("Address         :"+ input.returnItem(3));
        System.out.println("Style           :"+ input.returnItem(4));
        System.out.println("Status           : Activated");
        System.out.println("Available Time  :"+input.returnItem(5)+"-"+input.returnItem(6));
        System.out.println("\nPress any key to continue");
        input.clearAll();
        scan.nextLine();
        
       
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
   
   public void DisplayAccountInfo()
   {
       for(int i=0;i<Ro.getSize();i++){
           if(Ro.returnItem(i).getId()==ID)
           {
                System.out.println("ID               : "+Ro.returnItem(i).getId());
               System.out.println("Name              : "+Ro.returnItem(i).getRestaurantName());
               System.out.println("Address           : "+Ro.returnItem(i).getAddress());
               System.out.println("Contact No        : "+Ro.returnItem(i).getContactNo());
               System.out.println("Password          : "+Ro.returnItem(i).getPassword());
               System.out.println("Status            : "+Ro.returnItem(i).getStatus());
                System.out.println("Style            : "+Ro.returnItem(i).getStyle());
                 System.out.println("Available Time  : "+Ro.returnItem(i).getAvailableTime());
                 System.out.println("Options : 1. Deactivated Account  2. Update Details 3.Exit");
                 String cc = scan.nextLine();
                 if(cc.equals("1"))
                 { 
                     System.out.println("Are you sure ? Y/N");
                     if(scan.nextLine().equals("Y"))
                     {DeactivatedAccount(i);
                     return;}
                     else if(scan.nextLine().equals("N"))
                     {
                         DisplayAccountInfo();
                     }else
                     {
                         System.out.println("Invalid Input");
                         DisplayAccountInfo();
                     }
                 
                 }else if(cc.equals("2")){
                    
                    System.out.println("1.name 2.Password 3. Address 4.Cancel");
                    String choose = scan.nextLine();
                    if(choose.equals("1"))
                    {
                        System.out.print("Please input a name : ");
                        String name=scan.nextLine();
                        if(!name.isEmpty())
                        Ro.returnItem(i).setRestaurantName(name);
                        name="";
                        DisplayAccountInfo();
                    }else if(choose.equals("2"))
                    {
                        System.out.print("Please input a password : ");
                        String name=scan.nextLine();
                        if(!name.isEmpty())
                        Ro.returnItem(i).setPassword(name);
                        name="";
                        DisplayAccountInfo();
                    }else if(choose.equals("3"))
                    {
                        System.out.print("Please input an address : ");
                        String name=scan.nextLine();
                        if(!name.isEmpty())
                        Ro.returnItem(i).setAddress(name);
                        name="";
                        DisplayAccountInfo();
                    }else
                    {
                        DisplayAccountInfo();
                    }
                 
                    
                 }else{return;}
           }
       }
       FoodMenu f = new FoodMenu();
       f.MainMenu();
      
   }
   
   public void DeactivatedAccount(int account)
   {
       Ro.returnItem(account).setStatus("Deactivated");
        Ro.returnItem(account).setRestaurantName(Ro.returnItem(account).getRestaurantName() + "(Deactivated)");
      System.out.println("Deactivated Completed");
       Login();
   }
   
   public String chooseStyleMethod()
   {
       String style="";
       System.out.print("Please choose a Style (1.Korean or 2.Japanese or 3.Thai, "
               + "other character for other options) : ");
       style = scan.nextLine();
       
       switch(style)
       {
           case "1":
                style="Korean Style";
                break;
            case "2":
                 style="Japanese Style";
                break;
            case "3":
                 style="Thai Style";
                break;
            default:
                   System.out.print("Please input other style: ");
                   style = scan.nextLine();
                   break;
                
               
       }
       return style;
   }
   
   public void Login()
   {
      
       String choose;
       do{
       System.out.println("Login or Registration Restaurant? 1. Registration 2.Login 3.Exit");
       choose=scan.nextLine();
       if(choose.equals("1"))
       {
           registrationRestaurantOwner();
           Login();
       }else if(choose.equals("2"))
       {
           boolean login=false;
           
       System.out.println("Login Page");
       System.out.println("==========");
       System.out.print("Please input a ID       : ");
       String ID=scan.nextLine();
       System.out.print("Please input a Password : ");
       String pass=scan.nextLine();
       for(int i=0;i<Ro.getSize();i++)
       {
          // System.out.println(Ro.get(i).getId()+""+ Ro.get(i).getPassword());
           if(ID.equals(Ro.returnItem(i).getId()+"") && pass.equals(Ro.returnItem(i).getPassword()))
           {
               if(Ro.returnItem(i).getStatus().equals("Deactivated")){
               loginDeActivated = true;
                   
                   System.out.println(Ro.returnItem(i).getStatus());
               }else{
               System.out.println("Login Sucessfully");
               this.ID=Ro.returnItem(i).getId();
               password=Ro.returnItem(i).getPassword();
               RESTAURANT_NAME=Ro.returnItem(i).getRestaurantName();
               FoodMenu f = new FoodMenu();
               f.MainMenu();
               
               login=true;}
               
           }

       }
       
       if(login==false)
       {
           if(loginDeActivated)
           {
               System.out.println("Sorry you have already deactivated your account");
               loginDeActivated=false;
           }else
           System.out.println("Login Failed, Password or ID Invalid");
            
        Login();
       }
       }else if(choose.equals("3"))
       {
          // MainMenu m = new MainMenu();
         //  m.main();
       }else
       {
           System.out.println("Invalid Input");
       }}while(!choose.equals("1") && !choose.equals("3") && !choose.equals("2"));
       
       
   }
    
    
}
