/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author knz
 */

public class Pharmacy {

    // DataFields
    private String name;
    private Medicine[] medicines = new Medicine[MaxNumberOfMedicines];
    private int overTheCounterQuantity;
    private int prescriptionQuantity;
    private int numberOfMedicines;
    private static int MaxNumberOfMedicines = 100;

    // Constructors
    public Pharmacy(String name) { // takes one parameter
        setName(name);
        this.medicines = new Medicine[MaxNumberOfMedicines];
        this.overTheCounterQuantity = 0;
        this.prescriptionQuantity = 0;
        this.numberOfMedicines = 0;
        this.MaxNumberOfMedicines = 100; // This constructor sets up the initial state of a Pharmacy object, creating an
                                         // array to hold the medicines that the pharmacy carries, and initializing the
                                         // quantity and number of medicines to 0.
    }

    // Setters for pharmacy that sets the name for pharmacy
    public void setName(String Name) {
        this.name = Name;
    }

    public void setMaxNumberOfMedicines(int MaxNumberOfMedicines) {
        // Check if the number is positive or it returns its default value
        if (MaxNumberOfMedicines >= 0)
            this.MaxNumberOfMedicines = MaxNumberOfMedicines;
        else
            this.MaxNumberOfMedicines = 100;
    }

    // Getters for all datafields
    public Medicine[] getMedicines() {
        return medicines;
    }

    public int getPrescriptionQuantity() {
        return prescriptionQuantity;
    }

    public int getOverTheCounterQuantity() {
        return overTheCounterQuantity;
    }

    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    public static int getMaxNumberOfMedicines() {
        return MaxNumberOfMedicines;
    }

    // addMedicine
    public boolean addMedicine(Medicine newMedicine) {
        // Check if we reached the maximum number of medicines
        // Check if the array medicine is full
        if (numberOfMedicines == MaxNumberOfMedicines) {
            System.out.println("Error, could not add the medicine.");
            return false;
        }
        // if the array is not full, check if it exists or not
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].equals(newMedicine)) {
                System.out.println("Medicine already exists.");
                return false;
            }
        }
        // if the medicine does not exist, add medicine to the medicine array
        medicines[numberOfMedicines] = newMedicine;
        // increment the number of medicines in the pharmacy
        numberOfMedicines++;
        // Check the type of the medicine, and adjust its quantity accordingly
        if (newMedicine instanceof OverTheCounter)
            overTheCounterQuantity += newMedicine.getQuantity();
        else
            prescriptionQuantity += newMedicine.getQuantity();
        System.out.print("New medicine is added successfully\n");
        return true;
    }

    // raisePrises
    public void raisePrises(double percentage) {
        if (percentage > 0) // increase price when percentage is positve
            for (int i = 0; i < numberOfMedicines; i++)
                medicines[i].setPrice(medicines[i].getPrice() * (100 + percentage) / 100);
        else // decrease price when percentage is negative
            for (int i = 0; i < numberOfMedicines; i++)
                medicines[i].setPrice(medicines[i].getPrice() * (100 - percentage) / 100);
    }

    // searchByNameAndDose
    public int searchByNameAndDose(String name, int dose) {
        int index;
        for (int i = 0; i < numberOfMedicines; i++)
            // check if name and dose of the medicine matches the given
            if (medicines[i].getName().equalsIgnoreCase(name)
                    && medicines[i].getDose() == dose) {
                index = i;
                /*
                 * return the number of medicine in the array that matches the
                 * given name and dose
                 */
                return index;
            }
        return -1;
    }

    // searchByName
    public int[] searchByName(String name) {
        int numbMedicine = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            // check how many medicines matches the given name
            if (medicines[i].getName().equalsIgnoreCase(name))
                numbMedicine++;
        }
        // Create an array of size the total number of medicines that matches the given
        int[] indices = new int[numbMedicine];
        int index = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            /*
             * if the name matches, assign the medicine's index in the medicine
             * array to each element in the new array
             */
            if (medicines[i].getName().equalsIgnoreCase(name)) {
                indices[index] = i;
                index++;
            }
        }
        return indices;
    }

    // searchByComposition
    public int[] searchByComposition(String composition) {
        int count = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            // check how many medicines matches the composition
            if (medicines[i].getComposition().equalsIgnoreCase(composition))
                count++;
        }
        // Create an array of size the total number medicines that matches the given
        int[] indices = new int[count];
        int index = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            /*
             * if the composition matches, assign the medicine's index in the
             * medicine array to each element in the new array
             */
            if (medicines[i].getComposition().equalsIgnoreCase(composition)) {
                indices[index] = i;
                index++;
            }
        }
        return indices;
    }

    // sellMedicine
    public void sellMedicine(String name, int dose, int quantity) {
        // if the medicine exists
        if (searchByNameAndDose(name, dose) != -1) {
            // Get the medicine that matches the given name, dose
            Medicine medicine = medicines[searchByNameAndDose(name, dose)];
            if (medicine.getQuantity() >= quantity) {
                /*
                 * if enough quantity, adjust the medicine quantity in the
                 * pharmacy and adjust it accordingly
                 */
                medicine.setQuantity(medicine.getQuantity() - quantity);
                // Adjust the medicine quantity depending on its type
                if (medicine instanceof OverTheCounter) {
                    overTheCounterQuantity -= quantity;
                } else {
                    prescriptionQuantity -= quantity;
                }
                System.out.println("Selling successful.");
            } // if the available quantity is less than needed
            else {
                System.out.println("The available quantity is not enough");
            }
        } else {
            System.out.println("Medicine not found.");
        }
    }

    // restock
    public boolean restock(String name, int dose, int quantity) { // find the index of the medicine in the medicines
                                                                  // array. If the medicine is found (i.e., the
                                                                  // searchByNameAndDose() method returns a non-negative
                                                                  // index), it is stored in the medicine variable.
        Medicine medicine = medicines[searchByNameAndDose(name, dose)];
        if (searchByNameAndDose(name, dose) != -1) {
            medicine.setQuantity(medicine.getQuantity() + quantity);
            if (medicine instanceof OverTheCounter) // checks if the medicine is an instance of the OverTheCounter class
                                                    // by using the instanceof operato
                overTheCounterQuantity += quantity;
            else
                prescriptionQuantity += quantity;
            System.out.print("Restock successfull.");
            return true;
        }
        return false;
    }

    // toString returns a string representation of an object that represents a
    // pharmacy. The returned string contains information about the pharmacy's name,
    // the number of medicines it carries, the quantity of over-the-counter
    // medicines it carries, and the quantity of prescription medicines it carries.
    public String toString() {
        return "Pharmacy: " + this.name + "\nNumber of Medicines: "
                + getNumberOfMedicines() + "\nOver the counter quantity: "
                + getOverTheCounterQuantity() + "\nPrescription quantity: "
                + getPrescriptionQuantity();
    }
}
