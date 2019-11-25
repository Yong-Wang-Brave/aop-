/*
package all.aa;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class wenjuceshi {

	public static void main(String[] args) {


		List<Studentswenju> a = Lists.newArrayList(
				new Studentswenju("钢笔", "红本")
				, new Studentswenju("钢笔", "本子"));
		List<Studentswenju> b = Lists.newArrayList(
				new Studentswenju("圆珠笔", "绿本"));
		List<Studentswenju> c = Lists.newArrayList(
				new Studentswenju("钢笔", "蓝子"),
				new Studentswenju("铅笔", "黄本"));


		List<Student> students = new ArrayList<>();
		students.add(new Student(
				66, "程序汪"));
		students.add(new Student(
				7, "小红"));
		students.add(new Student(
				69, "小美"));
		//先判断是不是空否则输出null ，在判断是不是空集合，否则输出空集合，最后输出
		//students=null;
	//	Optional.ofNullable(students).orElse(Collections.emptyList()).forEach(System.out::println);
		System.out.println(students);
		System.out.println("勇哥哥");
	*/
/*	Student(age=1, name=程序汪)
		Student(age=2, name=小红)
		Student(age=3, name=小美)*//*


*/
/*	Optional+findFirst
			集合中找一条数据*//*

		Optional<String> oFindFirst=
				//stream 为集合创建串行流
				students.stream()
						//filter 方法用于通过设置的条件过滤出元素。
						.filter(Objects::nonNull)
						//map 方法用于映射每个元素到对应的结果
						.map(Student::getName)
						.filter(f-> StringUtils.equals(f,"程序汪"))
						.findFirst();

		//这样判断和if-else没区别
System.out.println(oFindFirst);
		if(oFindFirst.isPresent()){
			System.out.println("给"+oFindFirst.get()+"发奖金啦");
		}


		//那就来个简洁的ifPresent


		oFindFirst.ifPresent(f->{System.out.println("给"+f+"发奖金啦");});




	//	filter过滤
		students.stream()
				.filter(Objects::nonNull)
				.forEach(f->{
					System.out.println(f.getName());
				});


	*/
/*	map集合变形*//*


		List<String> names=students.stream()
				.filter(Objects::nonNull)
				.map(Student::getName)
				.collect(Collectors.toList());
		System.out.println("马匹集合便行");
		names.forEach(System.out::println);

		System.out.println("马匹集合便行");
*/
/*		flatMap扁平化
		和map的区别是，map是1对1的，flatMap是1对多

		相等有集合list.add 和list.addAll区别

		如下把学生集合中文具集合属性，扁平化在输出

		对应复杂的集合嵌套类，处理起来非常爽*//*



*/
/*	students.stream()
				.filter(Objects::nonNull)
				.map(Student::getStudentswenju)
				.flatMap(List::stream)
				.forEach(System.out::println);*//*



		//list转map
		System.out.println(students);
	Map<String,Student> map=students.stream()
				.filter(Objects::nonNull)
				.collect(
						Collectors
								.toMap(Student::getName,s->s));
	System.out.println(JSON.toJSON(map));




		//list转map分组
		Map<String,List<Student>> map2=students
				.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.groupingBy(stu->stu.getName()));
		System.out.println("map2"+map2);
		*/
/*limit
				当集合空是limit返回的是一个空集合不是null

		这样不容易NEP*//*


		List<String> names2=students.stream()
				.filter(Objects::nonNull)
				.map(Student::getName)
				.filter(f->StringUtils.equals(f,"aaa"))
				.limit(1).collect(Collectors.toList());
		names2.forEach(System.out::println);


	*/
/*	skip
		limit+skip类似mysql的limit关键字用法*//*

		List<String> names33=students.stream()
				.filter(Objects::nonNull)
				.map(Student::getName)
				.skip(2)
				.limit(1).collect(Collectors.toList());
		names33.forEach(System.out::println);


		*/
/*集合排序
				那是相当简洁*//*

System.out.println("集合排序");
		Collections.sort(students,
				Comparator.comparing(Student::getAge));
		students.forEach(System.out::println);


		*/
/*并行
		不能乱用小心线程安全问题，后面有空单独整理下这个并行的*//*

		System.out.println("集合排序");
		students.parallelStream().forEach(System.out::println);
	}






}
*/
