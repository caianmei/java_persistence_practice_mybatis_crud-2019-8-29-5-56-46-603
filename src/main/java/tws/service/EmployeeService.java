package tws.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.constant.Constant;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> queryEmployeeList() {
		List<Employee> employees = employeeMapper.selectAll();
		for (Employee employee : employees) {
			employee.setName("zybank" + employee.getName());
		}
		return employees;
	}
	
	public boolean createEmployee(Employee employee) {
		return employeeMapper.insert(employee) == 1;
	}
	
	public int updateEmployee(Integer id, Employee employee) {
		return id == null ? Constant.TWO: employeeMapper.update(id, employee);
	}
	
	public int deleteEmployeeById(Integer id) {
		return id == null ? Constant.TWO: employeeMapper.deleteEmployeeById(id);
	}

	public List<Employee> queryEmployeesWithPage(Map<String, Integer> pageQuery) {
		int startIndex = (pageQuery.get("page") -1) * pageQuery.get("pageSize");
		//int nextIndex = startIndex + Integer.valueOf(pageQuery.get("pageSize"));
		Map<String,Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("startIndex", startIndex);
		pageMap.put("pageSize", pageQuery.get("pageSize"));
		List<Employee> returnEmployees = employeeMapper.selectByPage(pageMap);
//		List<Employee> tatloEmployees = employeeMapper.selectAll();
//		List<Employee> returnEmployees = new ArrayList<>();
//		if (tatloEmployees.size() >= startIndex && tatloEmployees.size() < nextIndex) {
//			returnEmployees = tatloEmployees.subList(startIndex,tatloEmployees.size());
//		} else if(tatloEmployees.size() > nextIndex){
//			returnEmployees = tatloEmployees.subList(startIndex,nextIndex);
//		}	
		return returnEmployees;
	}
}
