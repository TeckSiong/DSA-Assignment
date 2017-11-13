/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import java.util.*;
import Java.RestaurantOwner;
import Java.FoodMenu;
import Java.MainMenu;
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
    public ArrayList<String> input = new ArrayList<>();
    public static ArrayList<RestaurantOwner> Ro = new ArrayList<>();
    public static int ID;
    public static String password;
    public static String RESTAURANT_NAME;
    
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
        input.add(name);
        if(checkExit(input))
            return;
        String contact="";
        do{
        System.out.print("Please input Contact No : ");
        contact = scan.nextLine();
        if(!contact.matches("[1-9][0-9]{9,14}"))
            System.out.println("Contact Not Valid Please Input 10-15 contact Number");
        }while(!contact.matches("[1-9][0-9]{9,14}"));
        input.add(contact);
        if(checkExit(input))
            return;
        name="";
        do{
       System.out.print("Please input Password : ");
        name=scan.nextLine();
        if(name.isEmpty())
            System.out.println("Please input a password");
        }while(name.isEmpty());
        input.add(name);
        if(checkExit(input))
            return;
        name="";
        do{
         System.out.print("Please input Address : ");
        name=scan.nextLine();
        if(name.isEmpty())
           System.out.println("Please input an address");
         }while(name.isEmpty());
        input.add(name);
        if(checkExit(input))
            return;
        input.add(chooseStyleMethod());
        if(checkExit(input))
            return;
         do{
             if(count>0)
              {
                  System.out.println("Times Not Valid");
              }
         System.out.print("Please input Available Time : Start TIme (Format HH:MM)");
          temp = scan.nextLine();
          if(checkExit(input))
            return;
         count++;
         }while(!checkTime(temp));
         count=0;
         input.add(temp);
         System.out.print("Please input Available Time : To");
          do{
              if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time : End TIme (Format HH:MM");
        temp = scan.nextLine();
        if(checkExit(input))
            return;
         count++;
        }while(!checkTime(temp));
         count=0;
         input.add(temp);
        RestaurantOwner o = new RestaurantOwner(id,input.get(0),input.get(1),
                input.get(2),input.get(3),input.get(4),input.get(5)+" - "+input.get(6));
        Ro.add(o);
        id++;
         System.out.println("\nYou Are successfully Register New Account, Your ID Is "+Ro.get(0).getId()+"\n");
        System.out.println("Summary Of Registration Of Restaurant Owner");
        System.out.println("Restaurant Name : "+input.get(0) );
        System.out.println("Contact No      : "+ input.get(1));
        System.out.println("Password        : "+ input.get(2));
        System.out.println("Address         :"+ input.get(3));
        System.out.println("Style           :"+ input.get(4));
        System.out.println("Status           : Activated");
        System.out.println("Available Time  :"+input.get(5)+"-"+input.get(6));
        System.out.println("\nPress any key to continue");
        input.clear();
        scan.nextLine();
        
       
    }
   
   public static boolean checkExit(ArrayList l)
   {
       boolean exit = false;
       if(l.contains("exit"))
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
       for(int i=0;i<Ro.size();i++){
           if(Ro.get(i).getId()==ID)
           {
                System.out.println("ID               : "+Ro.get(i).getId());
               System.out.println("Name              : "+Ro.get(i).getRestaurantName());
               System.out.println("Address           : "+Ro.get(i).getAddress());
               System.out.println("Contact No        : "+Ro.get(i).getContactNo());
               System.out.println("Password          : "+Ro.get(i).getPassword());
               System.out.println("Status            : "+Ro.get(i).getStatus());
                System.out.println("Style            : "+Ro.get(i).getStyle());
                 System.out.println("Available Time  : "+Ro.get(i).getAvailableTime());
                 System.out.println("Options : 1. Deactivated Account  2. Update Details 3.Exit");
                 if(scan.nextLine().equals("1"))
                 { 
                     System.out.println("Are you sure ? Y/N");
                     if(scan.nextLine().equals("Y"))
                     {DeactivatedAccount(0);
                     return;}
                     else if(scan.nextLine().equals("N"))
                     {
                         DisplayAccountInfo();
                     }else
                     {
                         System.out.println("Invalid Input");
                         DisplayAccountInfo();
                     }
                 
                 }else if(scan.nextLine().equals("2")){}else{return;}
           }
       }
       FoodMenu f = new FoodMenu();
       f.MainMenu();
      
   }
   
   public void DeactivatedAccount(int account)
   {
       Ro.get(account).setStatus("Deactivated");
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
       for(int i=0;i<Ro.size();i++)
       {
           System.out.println(Ro.get(i).getId()+""+ Ro.get(i).getPassword());
           if(ID.equals(Ro.get(i).getId()+"") && pass.equals(Ro.get(i).getPassword()) && Ro.get(i).getStatus().equals("Activated"))
           {
               System.out.println("Login Sucessfully");
               this.ID=Ro.get(i).getId();
               password=Ro.get(i).getPassword();
               RESTAURANT_NAME=Ro.get(i).getRestaurantName();
               FoodMenu f = new FoodMenu();
               f.MainMenu();
               login=true;
               
           }

       }
       
       if(login==false)
       {System.out.println("Login Failed, Password or ID Invalid");
       
        Login();
       }
       }else if(choose.equals("3"))
       {
           MainMenu m = new MainMenu();
           m.main();
       }else
       {
           System.out.println("Invalid Input");
       }}while(!choose.equals("1") && !choose.equals("3") && !choose.equals("2"));
       
       
   }
    
    
}
