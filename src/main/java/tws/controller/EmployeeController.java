package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.queryEmployeeList());
    }
    
	@PostMapping("")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee) ? ResponseEntity.created(null).build():ResponseEntity.badRequest().build();		
	}
	
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Employee>> queryCompaniesWithPageAndPageSize(@RequestParam Map<String, Integer> pageQuery){					
		return ResponseEntity.ok(employeeService.queryEmployeesWithPage(pageQuery));
	}
//	@PutMapping("/{id}")
//	public ResponseEntity<Object> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee) {
//		if (employeeMapper.queryEmployeeById(id) != null) {
//			employeeMapper.update(id,employee);
//			return ResponseEntity.ok().build();
//		}else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Object> deleteEmployee(@PathVariable Integer	id) {
//		if (id == null) {
//			return  ResponseEntity.badRequest().build();
//		}
//		if (employeeMapper.queryEmployeeById(id) != null) {
//			employeeMapper.deleteEmployeeById(id);
//			return ResponseEntity.ok().build();
//		}else {
//			return ResponseEntity.notFound().build();
//		}
//		
//	}
}
