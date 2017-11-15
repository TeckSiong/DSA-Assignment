/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;
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
    public static ArrayList<Food> AllFood = new ArrayList<>();
    ArrayList<Food> flist = new ArrayList<>();
    
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
        AllFood.add(f);
       
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
        option = scan.nextLine();}while(!option.equals("Y")&&!option.equals("N"));}while(option.equals("Y"));
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
         System.out.print(AllFood.size());
         ArrayList<String> name = new ArrayList<>();
         int option=0;
         int j=0;
         int grabFoods=0;
         System.out.println("Food Name        Category         Quantity           Price          Day");
          System.out.println("=========        ========         ========           =====         ===");
         
         for(int i=0;i<AllFood.size();i++)
         {
             if(AllFood.get(i).getCompanyID()==Restaurant.ID)
             { 
                 System.out.println(j+"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice()+"         "+     AllFood.get(i).getDayAvailable());
                 j++;
                 name.add(AllFood.get(i).getFoodName());
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
         if(option<=name.size())
         {
             for(int i=0;i<AllFood.size();i++)
             {if(name.get(option).equals(AllFood.get(i).getFoodName()))
             {System.out.println("Food That you selected : "+AllFood.get(i).getFoodName());
               grabFoods=i;}
             }
             
         }else
         {
            MainMenu();
         }
         }while(option>name.size());
         if(!name.isEmpty())
         {
         System.out.println("1. Delete Food  2. Update Food  3.Exit");
         String grab = scan.nextLine();
         do{if(grab.equals("1")){deleteFood(grabFoods);displayAllFood();}else if(grab.equals("2")){updateFood(grabFoods);displayAllFood();}else if(grab.equals("3")){return;}else{System.out.println("Invalid Input");}}while(!grab.equals("1") &&!grab.equals("2")&& !grab.equals("2")&&!grab.equals("3"));}else{return;}
         name.clear();
     }
     
     public void updateFood(int option)
     {
        String choose="";
        String name="";
        do{
        System.out.println("  Food ID       : "+AllFood.get(option).getFoodID());
        System.out.println("1.Food Name     :"+AllFood.get(option).getFoodName());
        System.out.println("2.Category      : "+AllFood.get(option).getCategory());
        System.out.println("3.Quantity      : "+AllFood.get(option).getQuantity());
        System.out.println("4.Price         :"+AllFood.get(option).getPrice());
        System.out.println("5.Day Available : "+AllFood.get(option).getDayAvailable());
        System.out.print("Please select a option to Edit : ");
        choose=scan.nextLine();
        if(choose.equals("1"))
        {
            System.out.print("Please input a food name : ");
            name=scan.nextLine();
            if(!name.isEmpty())
                AllFood.get(option).setFoodName(name);
            name="";
        }
        else if(choose.equals("2"))
        {
             System.out.print("Please input a Category : ");
             
            name=chooseCategory();
            if(!name.isEmpty())
                AllFood.get(option).setCategory(name);
        }
        else if(choose.equals("3"))
        {
             AllFood.get(option).setQuantity(checkIntInput("Please input a quantity : "));
        }
        else if(choose.equals("4"))
        {
            AllFood.get(option).setPrice(checkInput("Please input a price : "));
        }
        else if(choose.equals("5"))
        {
            AllFood.get(option).setDayAvailable(chooseAvailableDay());
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
         AllFood.remove(option);
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
       System.out.print("Please choose a Day (1.Monday & Tuesday or 2.Wednesday & Thursday or 3.Friday & Saturday or 4.Sunday "
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
            default:
                   style = "Sunday";
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
        
        
         int CompanyName=0;
         
         
         Calendar cal = Calendar.getInstance();
         int d = cal.get(Calendar.DAY_OF_WEEK);
         System.out.print("Today Menu List : \n");
         System.out.print("Select Company Name : \n");
         
         for(int i=0;i<Restaurant.Ro.size();i++)
         {
             System.out.print(i+" "+Restaurant.Ro.get(i).getRestaurantName()+"\n");
         }
         int x=0;
         
         
         int count = 0;
         ArrayList<Integer> show = new ArrayList<>();
         
         do{try{
         CompanyName = Restaurant.Ro.get(scan.nextInt()).getId();scan.nextLine();x=0;}catch(Exception e){System.out.println("Please input again");x=1;scan.nextLine();}}while(x==1);
          System.out.println("Food Name        Category         Quantity           Price");
          System.out.println("=========        ========         ========           =====");
         for(int i=0;i<AllFood.size();i++)
         {
            
             if(d==1 && AllFood.get(i).getCompanyID()==CompanyName && AllFood.get(i).getDayAvailable().equals("Sunday"))
             { flist.add(AllFood.get(i));
                 System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
             show.add(i);
             count = count + i;
             }
             if((d==2 || d==3)&& AllFood.get(i).getCompanyID()==CompanyName && (AllFood.get(i).getDayAvailable().equals("Monday & Tuesday")))
             {flist.add(AllFood.get(i));
                    System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
             show.add(i);
             count = count + i;
             }
                 if((d==4 || d==5) && AllFood.get(i).getCompanyID()==CompanyName && (AllFood.get(i).getDayAvailable().equals("Wednesday & Thursday")))
                 {flist.add(AllFood.get(i)); 
                  System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"             "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                 show.add(i);
                 count = count + i;
                 }
                     if((d==6 || d==7) && AllFood.get(i).getCompanyID()==CompanyName && (AllFood.get(i).getDayAvailable().equals("Friday & Saturday")))
                     { flist.add(AllFood.get(i));
                      System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"            "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                     show.add(i);
                     count = count + i;
                     }
           
                         }  
         
         
         
         String aaa = " ";
         int abc;
         int quant;
         double total = 0;
         
         do{
         System.out.println("Please place your order :");
         abc = scan.nextInt();
         
 if(abc <= count){
         for(int s = 0 ; s< show.size();s++){
             if(abc == show.get(s)){
                 
         System.out.println("Kindly key in quantity :");
         quant = scan.nextInt();
                 
         orders od = new orders(classify,Restaurant.Ro.get(CompanyName).getRestaurantName(),AllFood.get(s).getFoodName(),AllFood.get(s).getQuantity(),AllFood.get(s).getPrice());
         
         orders.add(od);
         
         total = total + (quant * AllFood.get(s).getPrice());
         
         break;
             }
         }}else
     System.out.println("Incorrect input...\n\n");
         
         
         System.out.println("Do you wish to make another oder ? (Y/N)");
         aaa = scan.nextLine();
         }while(aaa.equals("Y"));
         
         classify++;
         
         
         /*System.out.println("Please choose a sort options : 1. Sort By Name 2. Sort By Categories 3. Sort By Price");
                          options=scan.nextLine();
                         switch(options)
                         {
                             case "1":
                                  Collections.sort(AllFood,Comparator.comparing(Food::getFoodName));
                                  flist.clear();
                                  displayMenu();
                                  break;
                             case "2":
                                 Collections.sort(AllFood,Comparator.comparing(Food::getCategory));
                                 flist.clear();
                                 displayMenu();
                                 break;
                             default:
                                 Collections.sort(AllFood,Comparator.comparing(Food::getPrice));
                                 flist.clear();
                                 displayMenu();
                                 break;
                                  
                         }*/
     
     
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
