package main;

import javax.swing.JOptionPane;

import controller.Controller;
import controller.HandlerMapping;

public class EmployeeMain {

	public static void main(String[] args) {
		String menu = "register -- 사원정보 등록\n"
				+ "search -- 사원정보 검색(이름)\n"
				+ "update -- 사원 정보 수정\n"
				+ "delete -- 실적이 100미만인 사원을 삭제\n"
				+ "all -- 전체 사원정보 출력\n"
				+ "salary -- 직급별 연봉 평균을 출력\n"
				+ "dispatch -- 월별 파견 횟수를 출력\n"
				+ "max_min -- 최고 연봉자와 최저 연봉자 출력\n"
				+ "exit -- 프로그램 종료\n"
				+ "원하시는 메뉴를 입력하세요";
		while(true) {
			String command = JOptionPane.showInputDialog(menu);
			if(command.equals("exit")) break;
			Controller controller = HandlerMapping.getInstance().createController(command);
			
			if(controller != null)
				controller.excute();
			
		}
			
			
			
			
			
			
			
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
			
		}
}






