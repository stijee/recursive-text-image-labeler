class Pet {
    protected String name; 

    // initialize the pet's name
    public Pet(String name) {
        this.name = name;
    }

    // print the pet's name
    public void printName() {
        System.out.println(name);
    }

    // make a generic noise 
    public void makeNoise() {
        System.out.println(name + " makes a noise.");
    }
}

class Cat extends Pet {
    private int lives; 

    // initialize the cat's name and number of lives
    public Cat(String name, int lives) {
        super(name);
        this.lives = lives;
    }

    // Override makeNoise method to provide specific behavior for cats
    @Override
    public void makeNoise() {
        System.out.println(name + " (" + lives + " lives) says meow.");
    }
}

class Dog extends Pet {

    // initialize the dog's name
    public Dog(String name) {
        super(name);
    }

    // Override makeNoise method to provide specific behavior for dogs
    @Override
    public void makeNoise() {
        System.out.println(name + " says woof.");
    }
}
