package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
	
    List<Employee> selectAll();
    
    List<Employee> selectByPage(@Param("map")Map<String, Integer> pageMap);
    
    int insert(@Param("employee") Employee employee);
	
	Employee queryEmployeeById(@Param("id") Integer id);
	
	int update(@Param("id") int id,@Param("employee")Employee employee);
	
	int deleteEmployeeById(@Param("id") int id);
}
