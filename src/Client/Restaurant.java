/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.ADTTheListInterface;
import ADT.ADTTheList;
import java.util.*;
import Domain.RestaurantOwner;
import Client.FoodMenu;

/**
 *
 * @author Jeffrey
 */
public class Restaurant {

    public Scanner scan = new Scanner(System.in);
    public static int count = 0;  //use to capture the result of the occurance of some event in the for loop.
    public String temp;         //Use to temporary store the scanner input result for comparison later.
    public static int id = 1000;   //use static variable to assign new identity id each 
                                                                    //time new restaurant is created
    public ADTTheListInterface<String> input = new ADTTheList<>(); //Declare new ADT list to manupulate the data
    public static ADTTheListInterface<RestaurantOwner> Ro = new ADTTheList<>();  
                                                    //Declare new ADT list to manupulate the data
    public static int ID;     //use to store the id of the restaurant each time a restaurant is login,
                                                                        //to identify which restaurant
    //is login to reduce the work of retrieve data again from the list later.
    public static String RESTAURANT_NAME; //Use to temporary store the restaurant name to selected by client.
    public boolean loginDeActivated = false;  //To capture the status login of the restaurant owner

    public void registrationRestaurantOwner() {
        System.out.println("Registration Of Restaurant Owner\n(Type \"exit\" at any input to Cancel Registration");
        System.out.println("--------------------------------");
        String name = "";
        do {
            System.out.print("Please input Restaurant Name : ");
            name = scan.nextLine();
            if (name.isEmpty()) {
                System.out.println("Please input a name");
            }
        } while (name.isEmpty());  //check input is empty, required input again if empty
        input.addItem(name);    //use ADT List to temporary add and store all the information in the String list 

        String contact = "";
        do {
            System.out.print("Please input Contact No : ");
            contact = scan.nextLine();
            if (!contact.matches("[1-9][0-9]{9,14}")) //check patern of the contact no is matches with the input.
            {
                System.out.println("Contact Not Valid Please Input 10-15 contact Number");  //display error message 
            }                                                                     //if input contact not valid
        } while (!contact.matches("[1-9][0-9]{9,14}")); //check patern of the contact no is matches with the input.
        input.addItem(contact);    //use ADT List to temporary add and store all the information in the String list 

        name = "";

        do {

            System.out.print("Please input Password : ");
            name = scan.nextLine();
            if (name.isEmpty()) {
                System.out.println("Please input a password");
            }
        } while (name.isEmpty());
        input.addItem(name);  //use ADT List to temporary add and store all the information in the String list 

        name = "";
        do {
            System.out.print("Please input Address : ");
            name = scan.nextLine();
            if (name.isEmpty()) {
                System.out.println("Please input an address");
            }
        } while (name.isEmpty());
        input.addItem(name);   //use ADT List to temporary add and store all the information in the String list 

        input.addItem(chooseStyleMethod()); //use ADT List to temporary add and store 
                                          //all the information in the String list 

        do {
            if (count > 0) {
                System.out.println("Times Not Valid"); //display error message if time invalid
            }
            System.out.print("Please input Available Time : Start TIme (Format HH:MM)");
            temp = scan.nextLine();  //store input result in a temporary variable

            count++;
        } while (!checkTime(temp)); //to check the time format is valid if input by the owner
        count = 0;
        input.addItem(temp);  //store info in the list
        System.out.print("Please input Available Time : To");
        do {
            if (count > 0) {
                System.out.println("Time Not Valid");  //display error message if time invalid
            }
            System.out.print("Please input Available Time : End TIme (Format HH:MM");
            temp = scan.nextLine();

            count++;
        } while (!checkTime(temp)); //to check the time format is valid if input by the owner
        count = 0;
        input.addItem(temp); //store info in the list
        RestaurantOwner o = new RestaurantOwner(id, input.returnItem(0), input.returnItem(1),
                input.returnItem(2), input.returnItem(3), input.returnItem(4), input.returnItem(5) + 
                        " - " + input.returnItem(6));
        Ro.addItem(o);  //retrieve all the input result from the temporary list and store 
                                   //in a new restaurant object and add the 
        //new  restaurant object into the ADT restaurant list.

        System.out.println("\nYou Are successfully Register New Account, Your ID Is " + id + "\n");
        id++;
        System.out.println("Summary Of Registration Of Restaurant Owner");
        System.out.println("Restaurant Name : " + input.returnItem(0));
        System.out.println("Contact No      : " + input.returnItem(1));
        System.out.println("Password        : " + input.returnItem(2));
        System.out.println("Address         :" + input.returnItem(3));
        System.out.println("Style           :" + input.returnItem(4));
        System.out.println("Status           : Activated");
        System.out.println("Available Time  :" + input.returnItem(5) + "-" + input.returnItem(6)); 
                                                         //retrieve all data from the input temp
        //temporary list and display in the summary 
        System.out.println("\nPress any key to continue");
        input.clearAll();  //clear all the input list after the result successfully store in the restaurant list.
        scan.nextLine();   //enable line space 

    }

    public boolean checkTime(String test) // This method is use to check time format input by the user
    {
        boolean timeValid = true;      //set time format valid to true;
        if (test.length() == 5) //the length must 5 otherwise return false;
        {
            if (test.charAt(2) == ':') //The format must have ':' between minutes and seconds
            {
                String split[] = test.split(":");  //use ':' split the minutes and seconds
                try {
                    if (Integer.parseInt(split[0]) > 24 || Integer.parseInt(split[0]) < -1) {
                        timeValid = false;
                    }
                    if (Integer.parseInt(split[1]) >= 60 || Integer.parseInt(split[1]) < -1) {
                        timeValid = false;
                    }
                } catch (NumberFormatException ex) //exception catch if invalid input
                {
                    timeValid = false;
                }
            } else {
                timeValid = false;
            }
        } else //return false if all condition above cannot meet
        {
            timeValid = false;
        }
        return timeValid;  //return the time valid format to the methods previously called.
    }

    public void DisplayAccountInfo() //This method use to display all info about the login restaurant owner
    {
        for (int i = 0; i < Ro.getSize(); i++) {            //loop the restaurant list
            if (Ro.returnItem(i).getId() == ID) //get id from each restaurant and compare
                                                  //with the restaurant that currently login
            {
                System.out.println("ID               : " + Ro.returnItem(i).getId());         
                                                        //if id match then display all the restaurant information.
                System.out.println("Name              : " + Ro.returnItem(i).getRestaurantName());
                System.out.println("Address           : " + Ro.returnItem(i).getAddress());
                System.out.println("Contact No        : " + Ro.returnItem(i).getContactNo());
                System.out.println("Password          : " + Ro.returnItem(i).getPassword());
                System.out.println("Status            : " + Ro.returnItem(i).getStatus());
                System.out.println("Style            : " + Ro.returnItem(i).getStyle());
                System.out.println("Available Time  : " + Ro.returnItem(i).getAvailableTime());
                System.out.println("Options : 1. Deactivated Account  2. Update Details 3.Exit");
                String cc = scan.nextLine();        //input result that restarant selected
                if (cc.equals("1")) // If input ==1 deactivated account method call.
                {
                    System.out.println("Are you sure ? Y/N");
                    if (scan.nextLine().equals("Y")) 
                    {
                        DeactivatedAccount(i);
                        return;
                    } else if (scan.nextLine().equals("N")) {
                        DisplayAccountInfo();       //if user select no if will recursive call to display 
                                                   //account info again.
                    } else {
                        System.out.println("Invalid Input"); //other input treated as invalid keyboard input
                        DisplayAccountInfo();
                    }

                } else if (cc.equals("2")) {//If user select '2' it will have Updated restaurant info transaction

                    System.out.println("1.name 2.Password 3. Address 4.Cancel");  //edit name, password and etc.
                    String choose = scan.nextLine();
                    if (choose.equals("1")) //select '1' is change restaurant name.
                    {
                        System.out.print("Please input a name : ");
                        String name = scan.nextLine();      //captue input of new restaurant name
                        if (!name.isEmpty()) //check user input is empty,will required input again
                        {
                            Ro.returnItem(i).setRestaurantName(name);  
                                        //called the particular object and change the name to new name.
                        }
                        name = "";
                        DisplayAccountInfo();   //display restaurant latest updated info again after change.
                    } else if (choose.equals("2")) {
                        System.out.print("Please input a password : ");
                        String name = scan.nextLine();
                        if (!name.isEmpty()) {
                            Ro.returnItem(i).setPassword(name);
                        }
                        name = "";
                        DisplayAccountInfo();   //display restaurant latest updated info again after change.
                    } else if (choose.equals("3"))//If user select '3' it will have Updated restaurant address
                    {
                        System.out.print("Please input an address : ");
                        String name = scan.nextLine();   //captue input of new restaurant address
                        if (!name.isEmpty()) //check user input is empty,will required input again
                        {
                            Ro.returnItem(i).setAddress(name);  //set restaurant new address
                        }
                        name = "";
                        DisplayAccountInfo();    //display restaurant latest updated info again after change.
                    } else {
                        DisplayAccountInfo();     
                            //display restaurant latest updated info again althrogh there is no any changed.
                    }

                } else {
                    FoodMenu f = new FoodMenu();
                    f.MainMenu();
                } //if other invalid input is enter will go back display the main menu
            }
        }
        FoodMenu f = new FoodMenu();
        f.MainMenu();

    }

    public void DeactivatedAccount(int account) //This method use to deactivated user account info
    {
        Ro.returnItem(account).setStatus("Deactivated");  
        //return current login restaurant object and set status to 'deactivated'
        Ro.returnItem(account).setRestaurantName(Ro.returnItem(account).getRestaurantName() + "(Deactivated)"); 
        //set thier name to
        //deactivated 
        //to let the client know the restaurant is 
        //already deactivated when they order food
        System.out.println("Deactivated Completed");  //inform user already deactivated thier account
        Login(); //disable user use the system after deactivated and return back to login page
    }

    public String chooseStyleMethod() //This method use to choose the restaurant style method
    {
        String style = "";  // set to empty string first for easier comparison later
        System.out.print("Please choose a Style (1.Korean or 2.Japanese or 3.Thai, "
                + "other character for other options) : ");
        style = scan.nextLine();   //capture input of new restaurant style

        switch (style) {
            case "1":
                style = "Korean Style";
                break;
            case "2":
                style = "Japanese Style";
                break;
            case "3":
                style = "Thai Style";
                break;
            default:
                System.out.print("Please input other style: ");
                style = scan.nextLine();  //allow input other style other than korean,
                                                  //japanese and thai style
                break;

        }
        return style; //return the style result to the method previously called.
    }

    public void Login() //Login Method
    {

        String choose;
        do {
            System.out.println("Login or Registration Restaurant? 1. Registration 2.Login 3.Exit");
            choose = scan.nextLine();  //input result of the options.
            if (choose.equals("1")) //if choose '1' wil go to registration page
            {
                registrationRestaurantOwner();   //called owner registartion method.
                Login();
            } else if (choose.equals("2")) //if choose '1' wil go to login page
            {
                boolean login = false;  //set login to false;

                System.out.println("Login Page");
                System.out.println("==========");
                System.out.print("Please input a ID       : ");
                String ID = scan.nextLine();              //input user id
                System.out.print("Please input a Password : ");
                String pass = scan.nextLine();             //input password
                for (int i = 0; i < Ro.getSize(); i++) {

                    if (ID.equals(Ro.returnItem(i).getId() + "") && pass.equals(Ro.returnItem(i).getPassword())) 
                                                                                //compare user id and password
                    {
                        if (Ro.returnItem(i).getStatus().equals("Deactivated")) {  //check deactivated status
                            loginDeActivated = true; 
                                            //set deactivated to true and disable login if user is deactivated

                        } else {
                            System.out.println("Login Sucessfully");  //login successfully if pass all the test
                            this.ID = Ro.returnItem(i).getId();
                                             //capture login id right after they successfully login
                            RESTAURANT_NAME = Ro.returnItem(i).getRestaurantName();
                            FoodMenu f = new FoodMenu();  //display main menu if successfully login.
                            f.MainMenu();

                            login = true;
                        } //set login to true

                    }

                }

                if (login == false) //if login is equal to false;=
                {
                    if (loginDeActivated) //and if deactivated is true
                    {
                        System.out.println("Sorry you have already deactivated your account"); 
                                                    //display deactivated account message
                        loginDeActivated = false;  //set to deactivated to false, this variable
                                                    //just only to display deactivated messaage
                    } else {
                        System.out.println("Login Failed, Password or ID Invalid"); 
                                 
                    }
                    Login();
                }
            } else if (choose.equals("3")) //choose 3 is go back to previous menu
            {
                MainMenu m = new MainMenu();
                m.MainMenu();
            } else {
                System.out.println("Invalid Input");
            }
        } while (!choose.equals("1") && !choose.equals("3") && !choose.equals("2")); 
                                                //other input treated as invalid input

    }

    public static void main(String[] args) //create main method to test the result
    {
        Restaurant m = new Restaurant();  //create main method to test the result
        m.Login();
    }

}
