package bitjava.day01_03.Prob03;

public class Teacher extends Person
{

	private int numCourses; //private int numCourses = 0;
	private String[] courses; //private String[] courses = {};
	private static final int MAX_COURSES = 5; //제한이 명시되어있으니 static(정적변수)으로 만들어준것이다

	public static void main(String[] args)
	{

	}

	public Teacher(String name, String address)
	{
		super(name, address);
		numCourses = 0;
		courses = new String[MAX_COURSES];
	}

	public boolean addCourse(String course)
	{
		//있으면 추가 ㄴ 없으면 추가 ㅇ
		for (int i = 0; i < numCourses; i++)
		{
			if (courses[i].equals(course))
			{
				return false;
			}
		}
		courses[numCourses] = course;
		numCourses++;
		return true;

	}

	public boolean removeCourse(String course)
	{
		boolean found = false;
		int courseIndex = 1; //이상태에서는 아무의미 없는 초기값인데 나중에 실행이 이상할때 찍어보려고 넣는수랍니다..

		for (int i = 0; i < numCourses; i++)
		{
			if (courses[i].equals(course))
			{
				courseIndex = i;
				found = true;
				break;
			}
		}
		if (found)
		{
			for (int i = courseIndex; i < numCourses - 1; i++)
			{
				courses[i] = courses[i + 1];
			}
			numCourses--;
			return true;
		} else
		{
			return false;
		}

	}

	@Override
	public String toString()
	{
		return "Teacher : " + super.getName() + "( " + super.getAddress() + " )";
	}

}
