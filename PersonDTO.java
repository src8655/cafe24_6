package algorithm.baekjoon;

import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import org.junit.Test;

public class PersonDTO {

	public Scanner sc;
	
	private int id;
	private String pw;
	private String name;
	private String email;
	private String gender;
	private String hobby;
	private String phone;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setUp() {
		sc = new Scanner(System.in);
	}
	
	//id는 100미만의 숫자
	@Test
	public void getIdResult() {
		setUp();
		id = sc.nextInt();
		//id 범위 지정
		assertTrue(id<100);
	}
	//pw에는 반드시 대문자 한개 이상 포함
	@Test
	public void getPwResult() {
		setUp();
		pw = sc.next();
		int result = 0;
		boolean flag = false;
		for(int i=0;i<pw.length();i++) {
			if(65<=pw.charAt(i)&&pw.charAt(i)<=90) {
				flag = true;
				break;
			}
		}
		if(flag) result = 1;
		assertTrue(result==1);
	}
	//name의 최대 길이는 5
	@Test
	public void getNameResult() {
		setUp();
		name = sc.next();
		assertTrue(name.length()<=5);
	}
	//email은 정해진 규칙 따라야 함(@ 및 닷컴 표기, 길이)
	@Test
	public void getEmailResult() {
		setUp();
		email = sc.next();
		boolean a = false;
		boolean b = false;
		int gol = email.indexOf("@");
		int dot = email.indexOf(".");
		//@가 있다면
		if(gol!=-1&&email.charAt(0)!='@') a = true;
		//.가 있고, @보다 뒤에 있으며 마지막 위치가 아니라면
		if(dot!=-1&&dot>gol&&email.charAt(email.length()-1)!='.') b = true;
		assertTrue(a&&b&&email.length()<100);
	}
	//gender은 두가지 경우만 가능
	@Test
	public void getGenderResult() {
		setUp();
		gender = sc.next();
		assertTrue(gender.equals("남성")||gender.equals("여성"));
	}
	//hobby는 슬래시로 구분 + 3개 이상 입력 + 개당 길이 5 이내
	@Test
	public void getHobbyResult() {
		setUp();
		hobby = sc.next();
		boolean flag = true;
		String [] arr = hobby.split("/");
		if(arr!=null&&arr.length>=3) { 
			int idx = 0;
			while(idx<arr.length) {
				if(arr[idx].length()>5) {
					flag = false;
					break;
				}
				idx++;
			}
		}else flag = false;
		assertTrue(flag);
	}
	//phone은 대쉬 기호 2개 필수 + 3,4,4 + only 숫자
	@Test
	public void getPhoneResult() {
		setUp();
		phone = sc.next();
		boolean flag = true;
		String [] arr = phone.split("-");
		if(arr!=null&&arr.length==3) { 
			if(arr[0].length()==3&&arr[1].length()==4&&arr[2].length()==4) {
				for(int i=0;i<arr[0].length();i++) {
					//숫자가 아니면
					if(!(48<=arr[0].charAt(i)&&arr[0].charAt(i)<=57)
							||!(48<=arr[1].charAt(i)&&arr[1].charAt(i)<=57)
							||!(48<=arr[2].charAt(i)&&arr[2].charAt(i)<=57)) {
						flag = false;
						break;
					}
				}
				//4,4의 마지막 문자
				if(!(48<=arr[1].charAt(3)&&arr[1].charAt(3)<=57)
					||!(48<=arr[1].charAt(3)&&arr[1].charAt(3)<=57)) {
					flag = false;
				}
			}else flag = false;
		}else flag = false;
		assertTrue(flag);
	}
	//age는 세자리 수까지 입력 가능
	@Test
	public void getAgeResult() {
		setUp();
		age = sc.nextInt();
		//id 범위 지정
		assertTrue(1<=age&&age<150);
	}
}
