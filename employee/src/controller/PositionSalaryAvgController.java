package controller;

import java.util.HashMap;
import java.util.Iterator;

import dao.EmployeeDAO;

public class PositionSalaryAvgController implements Controller {

	@Override
	public void excute() {
		HashMap<String , Integer> map = 
				EmployeeDAO.getInstance().positionAvgSalary();
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		
	}

}







