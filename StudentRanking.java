import java.util.*;

class StudentRanking 
{

	static List<Student> stdList;
	static String subs[]={"Math","Science","Lang1","Lang2"};
	static class Student
	{
		private String name;
		private Map<String,Integer> subMarks;

		Student(String name,int lang1,int lang2,int math,int sci){
			this.name=name;
			subMarks=new HashMap<>();
			subMarks.put("Math",math);
			subMarks.put("Science",sci);
			subMarks.put("Lang1",lang1);
			subMarks.put("Lang2",lang2);
			
		}
		public int getTotalMarks(){
			Collection<Integer> marks=subMarks.values();
			int tot=0;
			for(int mark:marks){
				tot+=mark;
			}
			return tot;
		}
		public int getMarks(String sub){
			Integer marks=subMarks.get(sub);
			if(marks == null)
				return 0;
			else
				return marks;
		}
		public String toString(){
			
			StringBuilder print=new StringBuilder();
			Set<String> subjects=subMarks.keySet();
			
			print.append(name+"\t");
			for(String sub:subjects){
				print.append(sub+" : "+subMarks.get(sub)+"\t");
			}
			print.append("Total : "+getTotalMarks()+"\n");

			
			return print.toString();
		}
		public int subjects(){
			return subMarks.size();
		}
	}
	public static void main(String[] args) 
	{
		stdList=new ArrayList<>();
		stdList.add(new Student("aaa",10,20,30,40));
		stdList.add(new Student("bbb",10,20,30,40));
		stdList.add(new Student("ccc",60,70,90,80));
		stdList.add(new Student("ddd",70,60,90,80));
		stdList.add(new Student("eee",90,90,70,80));
		showList();
		
		System.out.println("------------------------------After ranking------------------------------------");
		Collections.sort(stdList,(s1,s2)->{ 
			int tot1=s1.getTotalMarks();
			int tot2=s2.getTotalMarks(); 
			int result=tot2-tot1;

			if(result==0){
				
				for(String sub:subs){
					result=s2.getMarks(sub)-s1.getMarks(sub);
					if(result != 0)
						return result;
				}
				result=s1.name.compareTo(s2.name);
			}
			return result;
		});
		showList();
	}
	public static void showList(){

		System.out.println("No\tName\tMath\tScience\tLang1\tLang2\tTotal\n");
		int i=1;
		for(Student s: stdList){
			System.out.println(i+"\t"+s.name+"\t"+s.getMarks("Math")+"\t"+
			s.getMarks("Science")+"\t"+s.getMarks("Lang1")+"\t"+s.getMarks("Lang2")+"\t"+s.getTotalMarks());
			i++;
		}
		System.out.println("\n");
	}
}
