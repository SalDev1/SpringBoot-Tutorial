package org.example;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    // Logging
    // Authorization and Authorization.
    // Sanitize the Data
    public void checkout(String status) {
        System.out.println("Checkout Method from Shopping Cart Called");
    }
    public void nurseName() {
        System.out.println("Nurse Name is XYZ");
    }

    public int quantity() {
        return 2;
    }
}
