package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Empajax;


public interface EmpajaxDao {
	
	public int insert(Empajax emp) throws ClassNotFoundException, SQLException;
	
	public int update(Empajax emp) throws ClassNotFoundException, SQLException;
	
	public int delete(int empno) throws ClassNotFoundException, SQLException;
	
	public List<Empajax> getAllEmp() throws ClassNotFoundException, SQLException;
	
	public Empajax getEmp(int empno)throws ClassNotFoundException, SQLException;
}
