package testoflist;

import java.util.LinkedList;
import java.util.List;
class Stu {
	public String name;
	public Stu(String n) 
	{name = n;}
	public String getname(){return name;}
}
public class Test {

	public static void main(String []args)
	{
		List r = new LinkedList();
		r.add("你好");
		r.add(13);
		r.add(new Stu("lian"));
		System.out.println(r.get(0));
		System.out.println(r.get(1));
		Stu u = (Stu)r.get(2);
		System.out.println(((Stu)r.get(2)).name);
	}
}
