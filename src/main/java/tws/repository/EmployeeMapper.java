package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
	
    List<Employee> selectAll();
    
    int insert(@Param("employee") Employee employee);
	
	Employee queryEmployeeById(@Param("id") Integer id);
	
	void update(@Param("id") int id,@Param("employee")Employee employee);
	
	void deleteEmployeeById(@Param("id") int id);
}
