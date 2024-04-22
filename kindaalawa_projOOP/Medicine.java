/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author knz
 */
public class Medicine {

    // DataFields declaring private variables
    private String name;
    private String composition;
    private int dose;
    private double price;
    private int quantity;

    // Constructors for medicine
    public Medicine(String name, String composition, int dose) {
        // calling the defined constructor , filling other values with default values//
        this(name, composition, dose, 10, 0);
    }
    public Medicine(String name , String composition ,int dose, double price , int quantity) {
        setMedicine(name, composition, dose, price, quantity);
    }

    public void setMedicine(String name, String composition, int dose,
            double price, int quantity) {
        // this is defined constructor takes all data fields as parameters , uses the
        // setters to set the instnces data fields//
        setName(name);
        setComposition(composition);
        setDose(dose);
        setPrice(price);
        setQuantity(quantity);
    } // setters

    public void setName(String name) { // setting name as lowercase for a undifined format//
        name.toLowerCase();
        this.name = name;
    }

    public void setComposition(String composition) { // setting composition as lowercase for a undifined format//
        composition.toLowerCase();
        this.composition = composition;
    }

    public void setDose(int dose) {
        // checking if dose is positive , if not set to its default value //
        if (dose > 0)
            this.dose = dose;
        else
            this.dose = 1000;
    }

    public void setPrice(double price) {
        // checking if price is positive , if not set to its defalut value//
        if (price > 0)
            this.price = price;
        else
            this.price = 10;
    }

    public void setQuantity(int quantity) {
        // checking if quantity is positive , if not set to default//
        if (quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 0;
    }

    // Getters for all data fields
    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public int getDose() {
        return dose;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // toString method returns a string representation of an object that contains
    // information about the name, composition, dose, price, and quantity of an item
    public String toString() {
        return "name: " + getName() + "/ncomposition: " + getComposition() +
                "/ndose: " + getDose() + "/nprice: " + getPrice() + "/nquantity: "
                + getQuantity();
    }

    // equals
    public boolean equals(Medicine medicine) { // The equals method first checks whether the name of the current
                                               // Medicine object is equal to the name of the Medicine object passed as
                                               // the parameter, ignoring the case of the characters, using the
                                               // equalsIgnoreCase() method.
        return name.equalsIgnoreCase(medicine.getName()) &&
                dose == medicine.getDose(); // checks whether the dose of the current Medicine object is equal to the
                                            // dose of the Medicine object passed as the paramete
    }
}
