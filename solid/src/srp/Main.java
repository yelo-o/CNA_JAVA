package srp;

interface Animal {
    void speak();
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("meow");
    }
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("bark");
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

