package controller;

import javax.swing.JOptionPane;

import dao.EmployeeDAO;

public class DeleteEmployeeController implements Controller {

	@Override
	public void excute() {
		String eno = JOptionPane.showInputDialog("삭제할 사번을 입력하세요");
		EmployeeDAO.getInstance().deleteEmployee(eno);
		
	}

}
