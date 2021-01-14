package controller;

import java.util.ArrayList;

import dao.EmployeeDAO;
import vo.EmployeeVO;

public class MaxMinController implements Controller {

	@Override
	public void excute() {
		ArrayList<EmployeeVO> list = EmployeeDAO.getInstance().maxMinEmployee();
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}
