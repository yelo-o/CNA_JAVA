package dip;

class Cat {
    public void speak() {
        System.out.println("야옹");
    }
}

class Dog {
    public void speak() {
        System.out.println("멍멍");
    }
}

class ZooUser {
    private Dog dog;
    private Cat cat;

    public ZooUser() {
        dog = new Dog();
        cat = new Cat();
    }

    public void speakAll() {
        cat.speak();
        dog.speak();
    }
}

public class Main {
    public static void main(String[] args) {
        ZooUser zoo = new ZooUser();
        zoo.speakAll();
    }
}
