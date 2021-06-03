package service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpajaxDao;
import vo.Empajax;

@Service
public class EmpajaxService {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int update(Empajax emp) throws ClassNotFoundException, SQLException {
		
		EmpajaxDao dao = sqlsession.getMapper(EmpajaxDao.class);
		
		int result = dao.update(emp);
		
		return result;
	}
	
	public int insert(Empajax emp) throws ClassNotFoundException, SQLException {
		
		EmpajaxDao dao = sqlsession.getMapper(EmpajaxDao.class);
		
		int result = dao.insert(emp);
		
		return result;
	}
	
	public int delete(int empno) throws ClassNotFoundException, SQLException {
		
		EmpajaxDao dao = sqlsession.getMapper(EmpajaxDao.class);
		
		int result = dao.delete(empno);
		
		return result;
	}
	
	public List<Empajax> getAllEmp() throws ClassNotFoundException, SQLException{
		
		EmpajaxDao dao = sqlsession.getMapper(EmpajaxDao.class);
		
		List<Empajax> list = dao.getAllEmp();
		
		
		return list;
	}
	
	public Empajax getEmp(int empno) {
		
		EmpajaxDao dao =sqlsession.getMapper(EmpajaxDao.class);
		
		Empajax emp = null;
		
		try {
			emp = dao.getEmp(empno);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return emp;
	}
}
