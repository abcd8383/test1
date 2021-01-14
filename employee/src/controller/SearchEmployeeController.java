package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EmployeeDAO;
import vo.EmployeeVO;

public class SearchEmployeeController implements Controller {

	@Override
	public void excute() {
		String name = JOptionPane.showInputDialog("검색할 사원명을 입력하세요");
		ArrayList<EmployeeVO> list = 
				EmployeeDAO.getInstance().selectNameEmployee(name);
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
		
	}

}









