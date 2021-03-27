package io.zipcoder.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    List<Pet> petWareHouse = new ArrayList<>();

    public void runApp() {
        Console console = new Console(System.in, System.out);

        Integer input = console.getIntegerInput("Hi, how many pets do you have?");
        int count = 1;

        while (count <= input) {
            String type;
            String name;

            while(true) {
                String typeInput = console.getStringInput(String.format("What type of pet is Pet #%s", count));

                if(typeInput.equals("cat") || typeInput.equals("dog") || typeInput.equals("mouse") || typeInput.equals("parrot")) {
                    type = typeInput;
                    break;
                }

                System.out.println("That's not a pet type!");
            }

            name = console.getStringInput(String.format("What name of pet is Pet #%s", count));

            petWareHouse.add(matchType(name, type));
            count++;
        }

        for(Pet pet : petWareHouse) {
            System.out.println(String.format("%s says %s!", pet.getName(), pet.speak()));
        }
    }

    public Pet matchType(String name, String type) {
        switch (type) {
            case "cat":
                return createCat(name, type);
            case "dog":
                return createDog(name, type);
            case "mouse":
                return createMouse(name, type);
            case "parrot":
                return createParrot(name, type);
            default:
                System.out.println("Sorry something went wrong.");
        }
        return null;
    }

    public Cat createCat(String name, String type) {
        return new Cat(name, type);
    }

    public Dog createDog(String name, String type) {
        return new Dog(name, type);
    }

    public Mouse createMouse(String name, String type) {
        return new Mouse(name, type);
    }

    public Parrot createParrot(String name, String type) {
        return new Parrot(name, type);
    }
}
