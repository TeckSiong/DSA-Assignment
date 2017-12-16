/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;
import ADT.BubbleSort;
import ADT.ADTTheListInterface;
import ADT.ADTTheList;
import Domain.Food;
import Java.Restaurant;
import Domain.RestaurantOwner;
import Domain.orders;
import java.util.*;
/**
 *
 * @author Jeffrey
 */
public class FoodMenu {
    
    public Scanner scan = new Scanner(System.in);
    public static ADTTheListInterface<Food> AllFood = new ADTTheList<>();
    ADTTheListInterface<Food> flist = new ADTTheList<>();
    
    public static ArrayList<orders> orders = new ArrayList<>();
    ArrayList<orders> orders1 = new ArrayList<>();
    
    int classify = 1 ;
    
    public void addFood()
    {
        String option;
        
        
       do{
           Food f=new Food();
            option="";
        System.out.println("Add New Food\n(Type \"exit\" at any input to Cancel");
        System.out.println("--------------------------------");
        System.out.print("Please input Food Name : ");
        f.setFoodName(scan.nextLine());
        if(checkExit(f.getFoodName()))
            return;
       
        f.setPrice(checkInput("Please input a price : "));
        if(checkExit(f.getPrice()+""))
            return;
        f.setQuantity(checkIntInput("Please input a quantity : "));
        if(checkExit(f.getQuantity()+""))
            return;
       // checkInput("Please input a Category : ");
       
        String cat =  chooseCategory();
        f.setCategory(cat);
        if(checkExit(f.getCategory()+""))
            return;
       
         String day = chooseAvailableDay();
        f.setDayAvailable(day);
        if(checkExit(f.getDayAvailable()+""))
            return;
        f.setCompanyID(Restaurant.ID);
        AllFood.addItem(f);
       
        System.out.println("\nYou Are successfully add new food, Food ID Is "+f.getFoodID()+"\n");
        System.out.println("Summary Of new Food");
        System.out.println("Food Name       : "+ f.getFoodName());
        System.out.println("Quantity        : "+ f.getQuantity());
        System.out.println("Category        : "+ f.getCategory());
        System.out.println("Available Day   :"+ f.getDayAvailable());
        System.out.println("Price/Unit      :"+ f.getPrice());
        System.out.println("Company ID      :"+ f.getCompanyID());
       do{
        
        System.out.println("\nDo you want to add more food? Y/N");
        option = scan.nextLine();}while(!option.equals("Y")&& !option.equals("N"));}while(option.equals("Y"));
        MainMenu();
    }
    
    public static boolean checkExit(String test)
   {
       boolean exit = false;
       if(test.equals("exit"))
          exit=true;
       return exit;
   }
    
    public double checkInput(String title)
    {
        int i=0;
        double x=0;
         do{
             i=0;
        System.out.println();
        System.out.print(title);
        try{
           x = scan.nextDouble();
                }catch(Exception e)
        {
            System.out.println("Invalid Input");
            i++;
        }scan.nextLine();}while(i!=0);
       
        return x;
    }
     public void displayAllFood()
     {
         System.out.print(AllFood.getSize());
         ADTTheList<String> name = new ADTTheList<String>();
         int option=0;
         int j=0;
         int grabFoods=0;
        // System.out.println("Food Name        Category         Quantity           Price         Display Day");
          //System.out.println("=========        ========         ========           =====         ===========");
          System.out.printf("%20s %20s %20s %20s %20s\n","Foodname","Category","Quantity","Price(RM)","Display Day");
          System.out.printf("%20s %20s %20s %20s %20s\n\n","========","========","========","=====","===========");
         if(AllFood.checkEmpty())
         {
             System.out.println("Empty Food List");
         }
         for(int i=0;i<AllFood.getSize();i++)
         {
             if(AllFood.returnItem(i).getCompanyID()==Restaurant.ID)
             { 
                 //System.out.println(j+"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice()+"         "+     AllFood.get(i).getDayAvailable());
                System.out.printf("%10s %10s %20s %20s  %20.2f %20s\n",j,AllFood.returnItem(i).getFoodName(),AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),AllFood.returnItem(i).getPrice(), AllFood.returnItem(i).getDayAvailable());
                 j++;
                 name.addItem(AllFood.returnItem(i).getFoodName());
             }
         }
         do{
         System.out.println("Please select a food : ");
         try{
         option = scan.nextInt();scan.nextLine();}catch(Exception e){
             System.out.println("Invalid Input");
             scan.nextLine();
             displayAllFood();
         }
         if(option<=name.getSize())
         {
             for(int i=0;i<AllFood.getSize();i++)
             {if(name.returnItem(option).equals(AllFood.returnItem(i).getFoodName()))
             {System.out.println("Food That you selected : "+AllFood.returnItem(i).getFoodName());
               grabFoods=i;}
             }
             
         }else
         {
            MainMenu();
         }
         }while(option>name.getSize());
         if(!name.checkEmpty())
         {
         System.out.println("1. Delete Food  2. Update Food  3.Exit");
         String grab = scan.nextLine();
         do{if(grab.equals("1")){deleteFood(grabFoods);displayAllFood();}else if(grab.equals("2")){updateFood(grabFoods);displayAllFood();}else if(grab.equals("3")){displayAllFood();}else{System.out.println("Invalid Input");}}while(!grab.equals("1") &&!grab.equals("2")&& !grab.equals("2")&&!grab.equals("3"));}else{return;}
         name.clearAll();
     }
     
     public void updateFood(int option)
     {
        String choose="";
        String name="";
        do{
        System.out.println("  Food ID       : "+AllFood.returnItem(option).getFoodID());
        System.out.println("1.Food Name     :"+AllFood.returnItem(option).getFoodName());
        System.out.println("2.Category      : "+AllFood.returnItem(option).getCategory());
        System.out.println("3.Quantity      : "+AllFood.returnItem(option).getQuantity());
        System.out.println("4.Price         :"+AllFood.returnItem(option).getPrice());
        System.out.println("5.Day Available : "+AllFood.returnItem(option).getDayAvailable());
        System.out.print("Please select a option to Edit : ");
        choose=scan.nextLine();
        if(choose.equals("1"))
        {
            System.out.print("Please input a food name : ");
            name=scan.nextLine();
            if(!name.isEmpty())
                AllFood.returnItem(option).setFoodName(name);
            name="";
        }
        else if(choose.equals("2"))
        {
             System.out.print("Please input a Category : ");
             
            name=chooseCategory();
            if(!name.isEmpty())
                AllFood.returnItem(option).setCategory(name);
        }
        else if(choose.equals("3"))
        {
             AllFood.returnItem(option).setQuantity(checkIntInput("Please input a quantity : "));
        }
        else if(choose.equals("4"))
        {
            AllFood.returnItem(option).setPrice(checkInput("Please input a price : "));
        }
        else if(choose.equals("5"))
        {
            AllFood.returnItem(option).setDayAvailable(chooseAvailableDay());
        }else
            System.out.println("Invalid Input");}while(choose.isEmpty()||(!choose.equals("1")&& !choose.equals("2")&& !choose.equals("3") && !choose.equals("4") && !choose.equals("5")));
     }
     
     public void deleteFood(int option)
     {
         String options="";
         do{
         System.out.println("Are you sure you want to delete ? Y/N");
         options=scan.nextLine();
         if(options.equals("Y"))
         AllFood.deleteItem(option);
         else if(!options.equals("Y")&& !options.equals("N"))
         System.out.println("Invalid Input...");}while(!options.equals("Y")&& !options.equals("N"));
     }
     public int checkIntInput(String title)
    {
        Scanner in = new Scanner(System.in);
        int i=0;
        int j=0;
         do{
            
       System.out.println();
        System.out.print(title);
        try{
            i=0;
           
           
            j=in.nextInt();
            
           if(j<0)
               i++;
           
               
                }catch(Exception e)
        {
            
            System.out.println("Invalid Input");
            i++;
        }in.nextLine();}while(i!=0);
       
        
        return j;
    }
    
     public String chooseAvailableDay()
   {
       String style="";
       int choose;
       System.out.print("Please choose a Day (1.Monday & Tuesday or 2.Wednesday & Thursday or 3.Friday & Saturday or 4.Sunday or 4.Sunday 5.No Display"
                );
       choose = scan.nextInt();
       scan.nextLine();
       switch(choose)
       {
           case 1:
                style="Monday & Tuesday";
                break;
            case 2:
                 style="Wednesday & Thursday";
                break;
            case 3:
                 style="Friday & Saturday";
                break;
           case 4:
                 style = "Sunday";
                   break;
            default:
                   style = "None";
                   break;
                
               
       }
       return style;
   }
     
     public String chooseCategory()
   {
       String styles="";
       System.out.print("Please choose a Category (1.Set or 2.Beverage or 3.Noodles or 4.Others(Please Specify)) "
                );
      
       
       switch(scan.nextInt())
       {
           case 1:
                styles="Set";
                break;
            case 2:
                 styles="Beverage";
                break;
            case 3:
                 styles="Noodles";
                break;
            default:
                   System.out.print("Please input other category: ");
                   scan.nextLine();
                   styles = scan.nextLine();
                   break;
                
               
       }
      scan.nextLine();
       return styles;
   }
     
     public void displayMenu()
     {
         
        
         String options;
         int option=0;
        
         int CompanyName=0;
         
         
         Calendar cal = Calendar.getInstance();
         int d = cal.get(Calendar.DAY_OF_WEEK);
         System.out.print("Today Menu List : \n");
         System.out.print("Select Company Name : \n");
         
         for(int i=0;i<Restaurant.Ro.getSize();i++)
         {
             System.out.print(i+" "+Restaurant.Ro.returnItem(i).getRestaurantName()+"\n");
         }
         int x=0;
         
         
         int count = 0;
         String status = "";
         ArrayList<Integer> show = new ArrayList<>();
         
         do{try{
         CompanyName = Restaurant.Ro.returnItem(scan.nextInt()).getId();scan.nextLine();x=0;}catch(Exception e){System.out.println("Please input again");x=1;scan.nextLine();}}while(x==1);
        //  System.out.println("Food Name        Category         Quantity           Price");
         // System.out.println("=========        ========         ========           =====");
         System.out.printf("%20s %20s %20s %20s\n","Foodname","Category","Quantity","Price(RM)");
         System.out.printf("%20s %20s %20s %20s\n\n","========","========","========","=====");
         for(int i=0;i<Restaurant.Ro.getSize();i++)
         {
             if(CompanyName==Restaurant.Ro.returnItem(i).getId())
              status = Restaurant.Ro.returnItem(i).getStatus();
         }
         if(AllFood.checkEmpty())
         {
             System.out.println("Empty Food List");
         }
         for(int i=0;i<AllFood.getSize();i++)
         {
            
             if(d==1 && AllFood.returnItem(i).getCompanyID()==CompanyName && status.equals("Activated") &&AllFood.returnItem(i).getDayAvailable().equals("Sunday"))
             { flist.addItem(AllFood.returnItem(i));
              //   System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
            System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),AllFood.returnItem(i).getFoodName(),AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),AllFood.returnItem(i).getPrice());
              show.add(i);
             count = count + i;
             }
             if((d==2 || d==3)&& AllFood.returnItem(i).getCompanyID()==CompanyName && status.equals("Activated")&& (AllFood.returnItem(i).getDayAvailable().equals("Monday & Tuesday")))
             {flist.addItem(AllFood.returnItem(i));
                  //  System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
              System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),AllFood.returnItem(i).getFoodName(),AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),AllFood.returnItem(i).getPrice());
            
                  show.add(i);
             count = count + i;
             }
                 if((d==4 || d==5) && AllFood.returnItem(i).getCompanyID()==CompanyName && status.equals("Activated")&& (AllFood.returnItem(i).getDayAvailable().equals("Wednesday & Thursday")))
                 {flist.addItem(AllFood.returnItem(i)); 
                  //System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"             "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                 System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),AllFood.returnItem(i).getFoodName(),AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),AllFood.returnItem(i).getPrice());
            
                  show.add(i);
                 count = count + i;
                 }
                     if((d==6 || d==7) && AllFood.returnItem(i).getCompanyID()==CompanyName &&status.equals("Activated")&& (AllFood.returnItem(i).getDayAvailable().equals("Friday & Saturday")))
                     { flist.addItem(AllFood.returnItem(i));
                     // System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"            "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                    System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),AllFood.returnItem(i).getFoodName(),AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),AllFood.returnItem(i).getPrice());
            
                     show.add(i);
                     count = count + i;
                     }
           
                         }  
        
         int icount=0;
         do{
              System.out.println("1. Place Order 2. Sort Order");
             try{
                  option = scan.nextInt();
                  scan.nextLine();
                  icount=1;
             }catch(Exception ex)
             {
                 System.out.println("Invalid Input...");
                 icount=0;
             }
                 }while(icount==0);
            icount=0;
          if(option==1)
          {
        int aaa = 0;
         int abc;
         int quant;
         double total = 0;
         
         do{
         System.out.println("Please place your order :");
         abc = scan.nextInt();
         
         abc = abc - 1;
         String name = flist.returnItem(abc).getFoodName();
         
 if(name != " "){
         for(int s = 0 ; s< AllFood.getSize();s++){
             if(name.equals( AllFood.returnItem(s).getFoodName())){
                 
         System.out.println("Kindly key in quantity :");
         quant = scan.nextInt();
                 
         orders od = new orders(classify,AllFood.returnItem(s).getCompanyID(),AllFood.returnItem(s).getFoodName(),quant,AllFood.returnItem(s).getPrice());
         
         orders.add(od);
         
         total = total + (quant * AllFood.returnItem(s).getPrice());
         
         
             }
         }}else
     System.out.println("Incorrect input...\n\n");
         
         
         System.out.println("Do you wish to make another oder ? (1 = exit)");
         aaa = scan.nextInt();
         
         }while(aaa==0);
         
         classify++;
         
         System.out.println("\n\n\n=============== Order Summary ===============\n\n\n");
         System.out.println("Food     " + "Quantity       " + "Price (RM)  \n");
         for(int y = 0; y < orders.size();y++)
         System.out.println(orders.get(y).getname()+ "           " +  orders.get(y).getquantity() +"              "+ (orders.get(y).getprice()*orders.get(y).getquantity())+ "\n");
         
         System.out.println("=============== Total amount need to pay : ===============\n");
         System.out.println("                                          " + total);
         
         }else
          { System.out.println("Please choose a sort options : 1. Sort By Name 2. Sort By Categories 3. Sort By Price");
                          options=scan.nextLine();
                         switch(options)
                         {
                             case "1":
                                  if(!AllFood.checkEmpty())
                                  BubbleSort.bubble_srt((ADTTheList)AllFood,1);
                                  flist.clearAll();
                                  displayMenu();
                                  break;
                             case "2":
                                 
                                 if(!AllFood.checkEmpty())
                                  BubbleSort.bubble_srt((ADTTheList)AllFood,2);
                                 flist.clearAll();
                                 displayMenu();
                                 break;
                             default:
                                  if(!AllFood.checkEmpty())
                                  BubbleSort.bubble_srt((ADTTheList)AllFood,3);
                                 flist.clearAll();
                                 displayMenu();
                                 break;
                                  
                         }}
     
     
     }
     
     public void MainMenu()
    {
        Restaurant r = new Restaurant();
        FoodMenu f = new FoodMenu();
        Scanner s = new Scanner(System.in);
        int option=0;
        do{
        System.out.println("Main Menu");
        System.out.println("=========");
        System.out.println("1.Display All Food");
        System.out.println("2.Add Food");
        System.out.println("3.Display Menu");
        System.out.println("4.Display Account Info");
        System.out.println("5.Exit");
        System.out.print("Please select an option : ");
         option=s.nextInt();s.nextLine();
        if(option>5 || option <=0)
            System.out.println("Invalid Input");
       }while(option>5 || option <=0);
        switch(option)
        {
            case 1:
                f.displayAllFood();
                break;
            case 2:
                f.addFood();
                break;
            case 3:
                f.displayMenu();
                break;
            case 4:
                r.DisplayAccountInfo();
                break;
            default:
                r.Login();
                
        }
        
    }
 
}
