/**
 * TV 객체용 클래스
 * 
 * @author 김민규
 * @version 1.0
 */
public class TV {

	int channel = 0;
	int vol = 0;
	boolean onOff = false;
	/**
	 * 전원을 켠다
	 */
	// .length : 배열용 특수 클래스를 위한 멤버 변수(필드) * 예약어 아님!
	// 강사님 코드
	void powerOn() {
		onOff = true;
	}
	
	/**
	 * TV 전원을 끈다
	 */
	void powerOff() {
		onOff = false;
	}
	/**
	 * 전원을 확인한다
	 * @return 켜져있으면 true 반환 , 꺼져있으면 false 반환
	 */
	public boolean isPower() {
		if(onOff==true) {
			return true;
		}
		return false;
	}
	/**
	 * TV 채널명, 음량 출력한다
	 */
	public void print() {
		System.out.print("채널은 " + channel +"번,");
		System.out.print("음량은 " + vol);
		System.out.println();
	}
}
