/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author knz
 */
public class Prescription extends Medicine { // hat it inherits all the properties and methods of the Medicine class
    // Prescription class is a subclass of the Medicine class that adds a
    // doctorSpecialization
    // DataFields
    private String doctorSpecialization;

    // Constructors
    public Prescription(String name, String composition, int dose,
            String doctorSpecialization) { // takes four parameters
        this(name, composition, dose, 10, 0, doctorSpecialization); // This constructor calls the second constructor
                                                                    // with the provided parameter
    }

    public Prescription(String name, String composition, int dose,
            double price, int quantity, String doctorSpecialization) { // takes six parameters
        super(name, composition, dose, price, quantity); // This constructor first calls the constructor of its
                                                         // superclass
        setDoctorSpecialization(doctorSpecialization);
    } // These constructors allow the creation of Prescription objects with different
      // combinations of attributes, providing flexibility and convenience for
      // creating instances of the Prescription

    // Setter ts the value of the doctorSpecialization field.
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    // Getter method that returns the value of the doctorSpecialization field.
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    // method returns a string representation of an object that represents a
    // prescription medication. The returned string contains information about the
    // prescription medication, including its name, composition, dose, price, and
    // quantity, as well as the specialization of the doctor who prescribed the
    // medication.
    public String toString() {
        return "Prescription: \n " + this.toString()
                + "\n  doctor specialization: " + getDoctorSpecialization();

    }
}
