package mysql;

import com.bobo.dao.impl.PersonDaoImpl;
import com.bobo.domain.Person;

public class Main {
	public static void main(String[] args) {
		PersonDaoImpl exp= new PersonDaoImpl();//DAO数据库操作实例
		//Person p= null;
		try {
			//exp.add(new Person("龙艳彬", "男", "一位负责而又严格的人民教师"));
			while(true)
			{
				exp.add(new Person(1,"龙艳彬", "男", "一位负责而又严格而且认真的人民教师"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.toString();
		}
	}
}
