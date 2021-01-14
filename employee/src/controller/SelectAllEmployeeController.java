package controller;

import java.util.ArrayList;

import dao.EmployeeDAO;
import vo.EmployeeVO;

public class SelectAllEmployeeController implements Controller {

	@Override
	public void excute() {
		ArrayList<EmployeeVO> list = EmployeeDAO.getInstance().selectAllEmployee();
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

}
