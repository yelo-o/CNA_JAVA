class Vehicle {
	void run() {
		System.out.println("차량이 달립니다");
	}
}
class Bus extends Vehicle {
	@Override
	void run() {
		System.out.println("버스가 달립니다");
	}
}
class Taxi extends Vehicle {
	@Override
	void run() {
		System.out.println("택시가 달립니다");
	}
}
class Driver {
	void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
public class inheritanceTest_07 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		//매개값으로 Bus 객체를 제공하고 driver() 메소드 호출
		Bus bus = new Bus();
		driver.drive(bus);
		//매개값으로 Taxi 객체를 제공하고 driver() 메소드 호출
		Taxi taxi = new Taxi();
		driver.drive(taxi);
	}
}
