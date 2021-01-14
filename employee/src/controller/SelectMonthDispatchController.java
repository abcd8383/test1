package controller;

import dao.EmployeeDAO;

public class SelectMonthDispatchController implements Controller {

	@Override
	public void excute() {
		String result = EmployeeDAO.getInstance().monthDispatch();
		System.out.println(result);
	}

}
