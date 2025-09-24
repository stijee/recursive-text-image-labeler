public class Test {
    public static void main(String[] args) {
        Pet[] pets = new Pet[5];

        pets[0] = new Dog("Max");
        pets[1] = new Dog("Fido");
        pets[2] = new Dog("Spot");
        pets[3] = new Cat("Fluffy", 9);
        pets[4] = new Cat("Mowzer", 9);

        // Loop through the array and call printName() and makeNoise() for each pet
        for (Pet pet : pets) {
            pet.printName();
            pet.makeNoise();
        }
    }
}
