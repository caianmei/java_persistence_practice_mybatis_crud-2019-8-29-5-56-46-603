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
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @GetMapping("/{id}")
	public ResponseEntity<Object> queryEmployeeById(@PathVariable Integer id) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		if (employeeMapper.queryEmployeeById(id) != null) {
			return ResponseEntity.ok(employeeMapper.queryEmployeeById(id));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		if (employeeMapper.queryEmployeeById(employee.getId()) == null) {
			return employeeMapper.insert(employee) == 1 ? ResponseEntity.created(null).build():ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee) {
		if (employeeMapper.queryEmployeeById(id) != null) {
			employeeMapper.update(id,employee);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Integer	id) {
		if (id == null) {
			return  ResponseEntity.badRequest().build();
		}
		if (employeeMapper.queryEmployeeById(id) != null) {
			employeeMapper.deleteEmployeeById(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
