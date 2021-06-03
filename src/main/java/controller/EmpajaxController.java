package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.EmpajaxService;
import vo.Empajax;

@RestController
@RequestMapping("/emp")
public class EmpajaxController {
	
	@Autowired
	private EmpajaxService empajaxsevice;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody Empajax emp) {
		
		int result = 0;
		try {
			result = empajaxsevice.insert(emp);
		} catch (Exception e) {
			e.getMessage();
		}
		
		if(result > 0) {
			System.out.println(result);
			return new ResponseEntity<String>("emp data register sucess", HttpStatus.OK);
		}else {
			System.out.println(result);
			return new ResponseEntity<String>("emp data register fail", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable int no, @RequestBody Empajax emp) {
		
		int result = 0;
		try {
			result = empajaxsevice.update(emp);
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println(no);
		if(result > 0) {
			System.out.println(result);
			return new ResponseEntity<String>("emp data update sucess", HttpStatus.OK);
		}else {
			System.out.println(result);
			return new ResponseEntity<String>("emp data update fail", HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/{empno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable int empno) {
		
		int result = 0;
		try {
			result = empajaxsevice.delete(empno);
		} catch (Exception e) {
			e.getMessage();
		}
		
		if(result > 0) {
			System.out.println(result);
			return new ResponseEntity<String>("emp data delete sucess", HttpStatus.OK);
		}else {
			System.out.println(result);
			return new ResponseEntity<String>("emp data delete fail", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Empajax> getAllEmp() throws ClassNotFoundException, SQLException{
		
		List<Empajax> list = new ArrayList<Empajax>();
		
		list = empajaxsevice.getAllEmp();
		
		return list;
	}
	
	@RequestMapping(value = "/{empno}" , method = RequestMethod.POST)
	public Empajax getEmp(@PathVariable int empno) {
		
		Empajax emp = null;
		
		try {
			emp = empajaxsevice.getEmp(empno);
		} catch (Exception e) {
			e.getMessage();
		}
		return emp;
	}
	
	
}

























