/**
 * TV 상태 확인하기
 * @author 김민규
 * @version 1.0
 */
public class TV {

	int channel = 0;
	int vol = 0;
	boolean onOff = false;
	/**
	 * TV 전원을 켠다
	 * @return onOff를 true로 반환한다
	 */
	public boolean powerOn() {
		onOff = true;
		return onOff;
	}
	// .length : 배열용 특수 클래스를 위한 멤버 변수(필드) * 예약어 아님!
	// 강사님 코드
//	void powerOn() {
//		onOff = true
//	}
	
	/**
	 * TV 전원을 끈다
	 * @return onOff를 false로 반환한다
	 */
	public boolean powerOff() {
		onOff = false;
		return onOff;
	}
	/**
	 * onOff의 true/false 판단하여 boolean값 반환
	 * @return true 또는 false 반환
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
