/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.ADTTheListInterface;
import ADT.ADTTheList;
import ADT.BubbleSort;
import Domain.Food;
import Client.Restaurant;
import Domain.RestaurantOwner;
import java.util.*;
/**
 *
 * @author Jeffrey
 */
public class FoodMenu {
    
    public Scanner scan = new Scanner(System.in); //Use to enable input
                                                 //from the client or restaurant owner
    public static ADTTheListInterface<Food> AllFood = new ADTTheList<>();   
    //Declare the ADT list that use to store all the food
    //object inside the list but not yet display in menu
    ADTTheListInterface<Food> flist = new ADTTheList<>(); 
    //Declare a list to store the food inside the food menu to display to client

    public void addFood()  //add new food method
    {
        String option;  //variable string to store the input string from the scanner
        
        
       do{
           Food f=new Food();   //create new food object
            option="";
        System.out.println("Add New Food\n(Type \"exit\" at any input to Cancel");
        System.out.println("--------------------------------");
        System.out.print("Please input Food Name : ");
        f.setFoodName(scan.nextLine());       // input new food name
        if(checkExit(f.getFoodName()))          //check user is exit when they dont want to add new food anymore
            return;
       
        f.setPrice(checkInput("Please input a price : "));  
        if(checkExit(f.getPrice()+""))      // input new food price
            return;
        f.setQuantity(checkIntInput("Please input a quantity : "));
        if(checkExit(f.getQuantity()+""))   //input new quantity
            return;
       
       
        String cat =  chooseCategory();  //input new category of the food method
        f.setCategory(cat);     //
        if(checkExit(f.getCategory()+""))
            return;
       
         String day = chooseAvailableDay(); //choose day available that the food display on the menu.
        f.setDayAvailable(day);            //set the result in the new food object
        if(checkExit(f.getDayAvailable()+""))
            return;
        f.setCompanyID(Restaurant.ID);
        AllFood.addItem(f); //add the new food object in the list
       
        System.out.println("\nYou Are successfully add new food, Food ID Is "+f.getFoodID()+"\n");
        System.out.println("Summary Of new Food");
        System.out.println("Food Name       : "+ f.getFoodName());
        System.out.println("Quantity        : "+ f.getQuantity());
        System.out.println("Category        : "+ f.getCategory());
        System.out.println("Available Day   :"+ f.getDayAvailable());
        System.out.println("Price/Unit      :"+ f.getPrice());
        System.out.println("Company ID      :"+ f.getCompanyID()); 
               //display the summary food object that latest added
       do{
        
        System.out.println("\nDo you want to add more food? Y/N");
           //allow the user continue add new food if they want
        option = scan.nextLine();}while(!option.equals("Y")&& !option.equals("N"));}while(option.equals("Y"));
        MainMenu();  //go back to main menu after they have add all the food.
    }
    
    public static boolean checkExit(String test) 
                      //this method use to check if the user want exit in middle of the transaction
   {
       boolean exit = false;
       if(test.equals("exit"))  //if user type 'exit' it will exit transaction and jump back to main menu
          exit=true;
       return exit;
   }
    
    public double checkInput(String title) //This method use to check the input is valid input 
                                           //exception if invalid input is occur
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
            //Thid method is use to display all the food in the restaurant owner side (Not client side)
     {
       
         ADTTheList<String> name = new ADTTheList<String>();  
                                //declare the ADT list that store the name of the food name
         int option=0;          //these variable use to comparison 
         int j=0;  
         int grabFoods=0;
       
          System.out.printf("%20s %20s %20s %20s %20s\n","Foodname","Category","Quantity","Price(RM)",
                  "Display Day");
          System.out.printf("%20s %20s %20s %20s %20s\n\n","========","========","========","=====",
                  "===========");
         if(AllFood.checkEmpty())  //check the list is empty
         {
             System.out.println("Empty Food List");  //display food empty list message if list is empty
         }
         for(int i=0;i<AllFood.getSize();i++)  //get all food item in the list
         {
             if(AllFood.returnItem(i).getCompanyID()==Restaurant.ID)  
                  //return all the food item that for currently login restaurant only
             { 
                System.out.printf("%10s %10s %20s %20s  %20.2f %20s\n",j,AllFood.returnItem(i).getFoodName(),
                        AllFood.returnItem(i).getCategory(),
                        AllFood.returnItem(i).getQuantity(),AllFood.returnItem(i).getPrice(), 
                        AllFood.returnItem(i).getDayAvailable());
                 j++; //use to display the number in the left hand side of the list 
       
                 name.addItem(AllFood.returnItem(i).getFoodName()); 
                            //add food item that selected in the temporary food name list to display to owner
             }
         }
         do{
         System.out.println("Please select a food : ");
         try{
         option = scan.nextInt();scan.nextLine();}catch(Exception e){ //to check invalid input from the user
             System.out.println("Invalid Input");
             scan.nextLine();
             displayAllFood();
         }
         if(option<=name.getSize())  //use to capture and display the food selected by user
         {
             for(int i=0;i<AllFood.getSize();i++)
             {if(name.returnItem(option).equals(AllFood.returnItem(i).getFoodName()))
             {System.out.println("Food That you selected : "+AllFood.returnItem(i).getFoodName());
               grabFoods=i;}
             }
             
         }else
         {
            MainMenu();  //if invalid input in capture, it will return to main menu again.
         }
         }while(option>name.getSize());
         if(!name.checkEmpty())
         {
         System.out.println("1. Delete Food  2. Update Food  3.Exit");
         String grab = scan.nextLine();
         if(grab.equals("1")){deleteFood(grabFoods);displayAllFood();}else if(grab.equals("2"))
         {updateFood(grabFoods);displayAllFood();}else if(grab.equals("3"))
         {displayAllFood();}else{displayAllFood();}}else{return;}
         name.clearAll();
     }
     
     public void updateFood(int option)  //This method is use to update food item in the list
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
        System.out.print("Please select a option to Edit : ");  //display all the info of the food that use selected
        choose=scan.nextLine();  //input scanner store in choose variable
        if(choose.equals("1"))  //if user input '1' will updated food name
        {
            System.out.print("Please input a food name : ");
            name=scan.nextLine();
            if(!name.isEmpty())
                AllFood.returnItem(option).setFoodName(name);
            name="";
        }
        else if(choose.equals("2")) //if user input '2' will updated food category
        {
             System.out.print("Please input a Category : ");
             
            name=chooseCategory();   //input new category to the food
            if(!name.isEmpty())    //check the input is not empty
                AllFood.returnItem(option).setCategory(name); //set new category to the currentfood selected
        }
        else if(choose.equals("3")) //if user input '3' will updated food quantity
        {
             AllFood.returnItem(option).setQuantity(checkIntInput("Please input a quantity : ")); 
                                                                      //updated food quantity
        }
        else if(choose.equals("4")) //if user input '4' will updated food price
        {
            AllFood.returnItem(option).setPrice(checkInput("Please input a price : ")); //updated food price
        }
        else if(choose.equals("5"))  //if user input '5' will updated food day to display the food
        {
            AllFood.returnItem(option).setDayAvailable(chooseAvailableDay());
                                   //updated food choose the day to display the food
        }else
            System.out.println("Invalid Input");}while(choose.isEmpty()||(!choose.equals("1")&& 
                !choose.equals("2")&& !choose.equals("3") && !choose.equals("4") && !choose.equals("5")));
     }
     
     public void deleteFood(int option) //Delete food method
     {
         String options=""; 
         do{
         System.out.println("Are you sure you want to delete ? Y/N");  
         options=scan.nextLine();   //input new input to the option
         if(options.equals("Y"))     // if option is 'Y' then delete the food
         AllFood.deleteItem(option);   //called the adt delete method 
                                        //to delete the item in specific position in the list
         else if(!options.equals("Y")&& !options.equals("N"))  //check if the input is not both 'Y' and 
             //'N' then display invalid input message then loop again to let user input again
         System.out.println("Invalid Input...");}while(!options.equals("Y")&& !options.equals("N"));
     }
     public int checkIntInput(String title) //check the input is valid input method
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
    
     public String chooseAvailableDay() //choose the day that food display the food in the list method
   {
       String style="";
       String choose;
       System.out.print("Please choose a Day (1.Monday & Tuesday or 2.Wednesday & Thursday "
               + "or 3.Friday & Saturday or 4.Sunday or 4.Sunday 5.No Display"
                );
       choose = scan.nextLine();  //capture the inpur and store in the list
     
       switch(choose)
       {
           case "1":
                style="Monday & Tuesday";
                break;
            case "2":
                 style="Wednesday & Thursday";
                break;
            case "3":
                 style="Friday & Saturday";
                break;
           case "4":
                 style = "Sunday";
                   break;
            default:
                   style = "None";
                   break;
                
               
       }
       return style;
   }
     
     public String chooseCategory() //choose the category that food display the in the list method
   {
       String styles="";
       System.out.print("Please choose a Category (1.Set or 2.Beverage or 3.Noodles or 4.Others(Please Specify)) "
                );
       String x = scan.nextLine(); //capture the input and store in the list
       
       switch(x)
       {
           case "1":
                styles="Set";
                break;
            case "2":
                 styles="Beverage";
                break;
            case "3":
                 styles="Noodles";
                break;
            default:
                   System.out.print("Please input other category: ");
                   styles = scan.nextLine();
                   break;
                
               
       }
    
       return styles;
   }
     
     public void displayMenu() //This method use to display the food menu
     {
         
        
         String options; //use to capture user selection input
        
         int CompanyName=0; //use to store user client selection restaurant to make order food
         
         
         Calendar cal = Calendar.getInstance();  
                  //get today date to determine which item to display in the food menu today
         int d = cal.get(Calendar.DAY_OF_WEEK);
         System.out.print("Today Menu List : \n");
         System.out.print("Select Company Name : \n");
         
         for(int i=0;i<Restaurant.Ro.getSize();i++) //loop restaurant size to get all the restaurant
         {
             System.out.print(i+" "+Restaurant.Ro.returnItem(i).getRestaurantName()+"\n"); 
                                  //display all the restaurant to client make selection
         }
         int x=0;
         
         
         //int count = 0;
         String status = ""; //capture restaurant to ensure restaurant is activated in thier status
      
         
         do{try{
         CompanyName = Restaurant.Ro.returnItem(scan.nextInt()).getId();scan.nextLine();x=0;}catch(Exception e)
         {System.out.println("Please input again");x=1;scan.nextLine();}}while(x==1);
         
         System.out.printf("%20s %20s %20s %20s\n","Foodname","Category","Quantity","Price(RM)");
         System.out.printf("%20s %20s %20s %20s\n\n","========","========","========","=====");
         for(int i=0;i<Restaurant.Ro.getSize();i++)
         {
             if(CompanyName==Restaurant.Ro.returnItem(i).getId())  //
              status = Restaurant.Ro.returnItem(i).getStatus();
         }
         if(AllFood.checkEmpty())
         {
             System.out.println("Empty Food List");
         }
         for(int i=0;i<AllFood.getSize();i++) 
                       //loop and display the food based on the day available condition
         {
            
             if(d==1 && AllFood.returnItem(i).getCompanyID()==CompanyName && 
                     status.equals("Activated") &&
                     AllFood.returnItem(i).getDayAvailable().equals("Sunday"))
             { flist.addItem(AllFood.returnItem(i));
               System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),
                       AllFood.returnItem(i).getFoodName(),
                       AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),
                       AllFood.returnItem(i).getPrice());
             
            // count = count + i;
             }
             if((d==2 || d==3)&& AllFood.returnItem(i).getCompanyID()==CompanyName && 
                     status.equals("Activated")&& 
                     (AllFood.returnItem(i).getDayAvailable().equals("Monday & Tuesday")))
             {flist.addItem(AllFood.returnItem(i));
                  System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),
                          AllFood.returnItem(i).getFoodName(),
                          AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),
                          AllFood.returnItem(i).getPrice());
            
              
          //   count = count + i;
             }
                 if((d==4 || d==5) && AllFood.returnItem(i).getCompanyID()==CompanyName && 
                         status.equals("Activated")&& 
                         (AllFood.returnItem(i).getDayAvailable().equals("Wednesday & Thursday")))
                 {flist.addItem(AllFood.returnItem(i)); 
                  System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),
                          AllFood.returnItem(i).getFoodName(),
                          AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),
                          AllFood.returnItem(i).getPrice());
            
               
                // count = count + i;
                 }
                     if((d==6 || d==7) && AllFood.returnItem(i).getCompanyID()==CompanyName &&
                             status.equals("Activated")&& 
                             (AllFood.returnItem(i).getDayAvailable().equals("Friday & Saturday")))
                     { flist.addItem(AllFood.returnItem(i));
                    System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(),
                            AllFood.returnItem(i).getFoodName(),
                            AllFood.returnItem(i).getCategory(),AllFood.returnItem(i).getQuantity(),
                            AllFood.returnItem(i).getPrice());
            
                   
                   //  count = count + i;
                     }
           
                         }  
        
          System.out.println("Please choose a sort options : 1. Sort By Name 2. Sort By Categories "
                  + "3. Sort By Price 4.Exit");
                          options=scan.nextLine(); //input to let user choose thier sort order of the food list
                              BubbleSort bs = new BubbleSort();  //called bubblesort method
                         switch(options)
                         {
                         
                             case "1":
                                  if(!AllFood.checkEmpty())
                                  bs.bubble_srt(AllFood,1); //sort list based on name
                                  flist.clearAll(); //clear temporary food list that display to client
                                  displayMenu();  //after sort will display the new updated food 
                                                     //list accroding to new sort order
                                  break;
                             case "2":
                                 
                                 if(!AllFood.checkEmpty())
                                 bs.bubble_srt(AllFood,2); //sort list based on categories
                                 flist.clearAll(); //clear temporary food list that display to client
                                 displayMenu();  //after sort will display the new updated food list
                                                  // accroding to new sort order
                                 break;
                             case "3":
                                  if(!AllFood.checkEmpty())
                                  bs.bubble_srt(AllFood,3); //sort list based on price
                                 flist.clearAll();  //clear temporary food list that display to client
                                 displayMenu(); //after sort will display the new updated food list 
                                                  //accroding to new sort order
                                 break;
                             default:
                                 if(!AllFood.checkEmpty())
                                 flist.clearAll();  //clear temporary food list that display to client
                                 MainMenu();  //other invalid option will bring back to mainmenu
                                 break;
                                  
                         }
     
     
     }
     
     public void MainMenu() //Method that display the main menu of the food
    {
        Restaurant r = new Restaurant(); //called to use some of the method in restaurant.java class
        Scanner s = new Scanner(System.in); //Scanner class use to let user key in the input from the keyboard
        
        System.out.println("Main Menu");
        System.out.println("=========");
        System.out.println("1.Display All Food");
        System.out.println("2.Add Food");
        System.out.println("3.Display Menu");
        System.out.println("4.Display Account Info");
        System.out.println("5.Exit");
        System.out.print("Please select an option : ");
        String  option1 =s.nextLine(); //store input result in the String variable
        
           
     
        switch(option1) //use the variable to detect the user selection option and called the 
                             //method based on the selection input
        {
            case "1":
                 displayAllFood(); 
                break;
            case "2":
                 addFood();
                break;
            case "3":
                 displayMenu();
                break;
            case "4":
                r.DisplayAccountInfo();
                break;
            default:
                r.Login();
                
        }
        
    }
 
}
