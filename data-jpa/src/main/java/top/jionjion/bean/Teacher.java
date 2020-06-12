package top.jionjion.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 *
 * 	@author JionJion
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
}
