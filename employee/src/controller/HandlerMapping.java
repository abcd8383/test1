package controller;
//싱글톤 패턴 적용
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
		
	}
	
	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public  Controller createController(String command) {
		Controller controller = null;
		switch(command) {
		case "salary":
			controller = new PositionSalaryAvgController();
			break;
		case "register":
			controller = new InsertEmployeeController();
			break;
		case "delete":
			controller = new DeleteEmployeeController();
			break;
		case "search":
			controller = new SearchEmployeeController();
			break;
		case "update":
			controller = new UpdateEmployeeController();
			break;
		case "dispatch":
			controller = new SelectMonthDispatchController();
			break;
		case "max_min":
			controller = new MaxMinController();
			break;
		case "all":
			controller = new SelectAllEmployeeController();
			break;
		}
		return controller;
	}
}







	