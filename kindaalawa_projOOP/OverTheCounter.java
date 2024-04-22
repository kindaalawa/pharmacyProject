/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author knz
 */
public class OverTheCounter extends Medicine {
    // OverTheCounter class is a subclass of the Medicine class that adds a minAge
    // DataFields
    private int minAge;

    // Constructors
    public OverTheCounter(String name, String composition, int dose,
            int minAge) { // calling the defined constructors , and filling the price and quantity with 10
                          // and 0
        this(name, composition, dose, 10, 0, minAge);
    }

    public OverTheCounter(String name, String composition, int dose,
            double price, int quantity, int minAge) {
        super(name, composition, dose, price, quantity);
        setMinAge(minAge); // This constructor first calls the constructor of the Medicine class using the
                           // super() method to initialize the name, composition, dose, price, and quantity
                           // fields. It then calls the setMinAge() method to set the minAge field.

    }

    // Setter method that sets the value of the minAge field
    public void setMinAge(int minAge) {
        if (minAge > 0)
            this.minAge = minAge;
        else
            this.minAge = 18;
    }

    // Getter method that returns the value of the minAge field.
    public int getMinAge() {
        return minAge;
    }

    // Override the toString method to include the minAge field
    @Override
    public String toString() {
        return " over the counter : \n" + this.toString()
                + " \n minAge: " + minAge;
    }

}
