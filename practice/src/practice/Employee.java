package practice;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String emp_name = null;
	List<Employee> reports;
	public Employee(String nm)
	{
		this.setEmp_name(nm);
		reports = new ArrayList<Employee>();
	}
	public void add_report(Employee emp)
	{
		this.reports.add(emp);
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	public static Employee create_company()
	{
		Employee ceo = new Employee("ceo");
		
 		Employee vp1 = new Employee("vp1");
		Employee dir1 = new Employee("dir1");
		Employee mgr1 = new Employee("mgr1");
		Employee emp1 = new Employee("emp1");
		Employee emp2 = new Employee("emp2");
		mgr1.add_report(emp1);
		mgr1.add_report(emp2);
		dir1.add_report(mgr1);
		Employee mgr2 = new Employee("mrgr2");
		Employee emp3 = new Employee("emp3");
		Employee emp4 = new Employee("emp4");
		mgr2.add_report(emp3);
		mgr2.add_report(emp4);
		dir1.add_report(mgr2);
		vp1.add_report(dir1);
		Employee dir2 = new Employee("dir2");
		
		Employee mgr3 = new Employee("mgr3");
		Employee emp5 = new Employee("emp5");
		Employee emp6 = new Employee("emp6");
		mgr3.add_report(emp5);
		mgr3.add_report(emp6);
		Employee mgr4 = new Employee("mgr4");
		Employee emp7 = new Employee("emp7");
		Employee emp8 = new Employee("emp8");
		mgr4.add_report(emp7);
		mgr4.add_report(emp8);
		dir2.add_report(mgr3);
		dir2.add_report(mgr4);
		vp1.add_report(dir2);
		ceo.add_report(vp1);
		
		Employee vp2 = new Employee("vp2");
		Employee dir3 = new Employee("dir3");
		vp2.add_report(dir3);
		Employee dir4 = new Employee("dir4");
		vp2.add_report(dir4);
		ceo.add_report(vp2);
		Employee vp3 = new Employee("vp3");
		Employee dir5 = new Employee("dir5");
		Employee dir6 = new Employee("dir6");
		vp3.add_report(dir5);
		vp3.add_report(dir6);
		ceo.add_report(vp3);
		return ceo;
	}
	public static int FindCommonManager(Employee ceo, Employee emp1, Employee emp2)
	{
		if (ceo == null)
			return 0;
		int ret = 0;
		for (Employee emp : ceo.reports) {
			if (emp.emp_name.equals(emp1.emp_name) || emp.emp_name.equals(emp2.emp_name))
				ret = 1;
			ret = ret +  FindCommonManager(emp, emp1, emp2);
				
		}
		if (ret == 2)
		{
			System.out.println(ceo.emp_name);
			return 0;
		}
		return ret;
	}
	public static void test_common_mgr()
	{
		Employee emp1 = new Employee("vp1");
		Employee emp3 = new Employee("emp3");
		Employee ceo = create_company();
		FindCommonManager(ceo, emp1, emp3);

	}
}
