package top.jionjion.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *	数据库表对应的实体类
 *	注意使用包装类型替换基本类型
 *	数据库表在创建时随项目启动而创建
 *	JPA定义规范,Hibernate各种实现,ORM框架映射
 */
@Entity
public class Teacher {

	@Id
	@GeneratedValue					//自动生成数据库对应的序列表
	private Integer id;
	
	@Column(length=20,nullable=false)	//长度,非空
	private String name;
	
	@Column(name="WORKDAY")	  			//字段名
	private Date workday;
	
	private String address;
	
	private Integer age;

	
	
	public Teacher() {
		super();
	}

	public Teacher(Integer id, String name, Date workday, String address, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.workday = workday;
		this.address = address;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWorkday() {
		return workday;
	}

	public void setWorkday(Date workday) {
		this.workday = workday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", workday=" + workday + ", address=" + address + ", age=" + age
				+ "]";
	}
	
	

}
