
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author knz
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pharmacy pharmacy = new Pharmacy("myPharma");
        System.out.print("Welcome to 'myPharma' pharmacy system.");
        //call the menu method
        int choice = menu();
        //check if the user didn't choose the exit option from the menu
        while (choice != 8) {
            switch (choice) {
                //AddMedicine
                case 1:
                    System.out.print("\nEnter the information of the "
                            + "new medicine: \n\nChoose o or O for over the "
                            + "counter medicine and p or P for \nprescription "
                            + "medicine: ");
                    char ch = in.next().charAt(0);
                    //Check character validity
                    while (ch != 'O' && ch != 'o' && ch != 'p' && ch != 'P') {
                        System.out.print("\nInvalid character. \nChoose o or O "
                                + "for over the counter medicine and p or P for"
                                + "\nprescription medicine:");
                        ch = in.next().charAt(0);
                    }
                    //If character is valid
                    System.out.print("name: ");// enter the name
                    String addname = in.next(); 
                    System.out.print("composition: "); // enter the composition
                    String composition = in.next();
                    System.out.print("dose: "); // enter the dose
                    int dose = in.nextInt(); 
                    System.out.print("quantity: "); //enter the quantity
                    int quantity = in.nextInt(); 
                    System.out.print("price: "); // enter the price
                    double price = in.nextDouble(); 
                    //Check medicine type   
                    if (ch == 'o' || ch == 'O') {
                        System.out.print("Enter the minimum Age for this "
                                + "medicine: ");
                        int minAge = in.nextInt(); 
                        //Create new Over the Counter object
                        OverTheCounter med = new OverTheCounter(addname,
                                composition, dose, price, quantity, minAge);
                        //Call method addMedicine
                        pharmacy.addMedicine(med);
                    } else {
                        System.out.print("Enter the doctor specialization"
                                + "for this medicine: ");
                        String doctorSpecialization = in.next();
                        //Create new Prescription object
                        Prescription med = new Prescription(addname,
                                composition, dose, price, quantity,
                                doctorSpecialization);
                        //Call method addMedicine
                        pharmacy.addMedicine(med);
                    }
                    break;

                //SearchByName
                case 2:
                    System.out.print("\nEnter the name of the medicine to be "
                            + "found: ");
                    String searchname = in.next();
                    /*Create an array of all the medicines found with the same 
                    name by calling the searchByName method*/
                    int[] array = pharmacy.searchByName(searchname);
                    //if the array is not null
                    if (array != null) {
                        System.out.println(array.length + (array.length > 1
                                ? " medicines " : " medicine ") + "found matching "
                                + "this name.");
                        int count=1;
                        for (int i = 0; i < array.length; i++) {
                            /*Search for the medicine that matches the
                                number of each medicine in the array*/
                            Medicine med = pharmacy.getMedicines()[array[i]];
                            /*Display the medicines information according
                                to its type*/
                            if (med instanceof OverTheCounter) {
                                OverTheCounter med1 = (OverTheCounter) med;
                                System.out.print(count++ +"-"+ med1.toString()+"\n");
                            } //if medicine instanceof Prescription
                            else {
                                Prescription med1 = (Prescription) med;
                                System.out.print(count++ +"-"+ med1.toString()+"\n");
                            }
                        }
                    } //If array is null
                    else {
                        System.out.println("Medicine not found.");
                    }
                    break;

                //SearchByComposition
                case 3:
                    System.out.print("\nEnter the composition of the"
                            + "medicine to be found: ");
                    String searchcomposition = in.next(); 
                    /*Create an array of all the medicines found with the same
                    composition by calling the searchByComposition method*/
                    int[] arraycomposition = pharmacy.searchByComposition(searchcomposition);
                    //if the array is not null
                    if (arraycomposition != null) {
                        System.out.println(arraycomposition.length + (arraycomposition.length > 1
                                ? " medicines " : " medicine ") + "found matching "
                                + "this composition.");
                        int count=1;
                        for (int i = 0; i < arraycomposition.length ; i++) {
                            /*Search for the medicine that matches the
                                number of each medicine in the array*/
                            Medicine med = pharmacy.getMedicines()[arraycomposition[i]];
                            /*Display the medicines information according
                                to its type*/
                            if (med instanceof OverTheCounter) {
                                OverTheCounter med1 = (OverTheCounter) med;
                                System.out.print(count++ +"-"+ med1.toString()+"\n");
                            } //if medicine instanceof Prescription
                            else {
                                Prescription med1 = (Prescription) med;
                                System.out.print(count++ +"-"+ med1.toString()+"\n");
                            }
                        }
                    } //If the array is null
                    else {
                        System.out.println("Medicine not found.");
                    }
                    break;

                //Sellmedicine
                case 4:
                    System.out.print("\nEnter the name of the medicine: "); // enter the name
                    String sellName = in.next(); 
                    System.out.print("Enter the dose: "); // enter dose
                    int sellDose = in.nextInt();
                    System.out.print("Enter the quantity: "); // enter quantity
                    int sellQuantity = in.nextInt();
                    //Call sellMedicine method
                    pharmacy.sellMedicine(sellName, sellDose, sellQuantity);
                    break;

                //restockMedicine
                case 5:
                    System.out.print("\nEnter the name of the medicine: "); // enter the name of medicine
                    String restockName = in.next();
                    System.out.print("Enter the dose: "); // enter the dose
                    int restockDose = in.nextInt();
                    System.out.print("Enter the quantity: "); // enter the quantity
                    int restockQuantity = in.nextInt();
                    //Call restock method
                    pharmacy.restock(restockName, restockDose,
                            restockQuantity);
                    break;

                //displayAllMedicines
                case 6:
                    int num = 1;
                    //for loop to pass through all the medicines in the array
                    for (int i = 0; i < pharmacy.getNumberOfMedicines(); i++) {
                        System.out.print("\nMedicine " + num++ + " : "
                                + pharmacy.getMedicines()[i].toString()
                                + "\n--------------------");
                    }
                    break;

                //displayinformation
                case 7:
                    System.out.println(pharmacy.toString());
                    break;

                //Exit
                case 8:
                    System.exit(0); 

                //Default case when choice<1 and >8
                default:
                    while (choice < 1 || choice > 8) {
                        System.out.print("Invalid number.\nEnter your choice"
                                + " (between 1 and 8): ");
                        choice = in.nextInt();
                    }
            }
            choice = menu();
        }
    }

    // menu method that displays the options for the user to choose one of them
    public static int menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("\n-----------------------------------"
                + "\n\nChoose one of the following options:"
                + "\n1- Add a new medicine"
                + "\n2- Search for a medicine by name"
                + "\n3- Search for a medicine by composition"
                + "\n4- Sell a medicine"
                + "\n5- Restock a medicine"
                + "\n6- Display all medicine"
                + "\n7- Display information"
                + "\n8- Exit \nEnter your choice (between 1 and 8): ");
        int choice = in.nextInt();
        return choice; //the method prompts the user to enter their choice by printing the message "Enter your choice (between 1 and 8): "
    }
}
