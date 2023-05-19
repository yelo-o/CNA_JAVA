
public class TVUser {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.powerOn(); // 티비를 켠다
		if(tv.isPower()) { // 티비가 켜져있다면
			tv.print(); // 티비의 정보를 출력한다
						// ex) 채널은 0번, 음량은 0
			
			tv.powerOff(); // TV를 끈다
			if(!tv.isPower()) {
				System.out.println("전원이 꺼졌습니다");
			}
		}
	}

}
