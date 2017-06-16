import java.util.*;

class validate618{

	public static ArrayList fullDate=new ArrayList();

	public static ArrayList initMonth(int month_num,int day_num){
		ArrayList month=new ArrayList();
		int count=1;
		for(int i=0;i<day_num;i++){
			String s=Integer.toString(month_num)+"-"+Integer.toString(count);
			count++;
			month.add(s);
		}
		return month;
	}

	public static void initEachmonth(){
		ArrayList Jan=new ArrayList();
		Jan=initMonth(1,31);
		System.out.println("January: "+Jan);

		ArrayList Feb=new ArrayList();
		Feb=initMonth(2,28);
		System.out.println("February: "+Feb);

		ArrayList Mar=new ArrayList();
		Mar=initMonth(3,31);
		System.out.println("March: "+Mar);

		ArrayList Apr=new ArrayList();
		Apr=initMonth(4,30);
		System.out.println("April: "+Apr);

		ArrayList May=new ArrayList();
		May=initMonth(5,31);
		System.out.println("May: "+May);

		ArrayList Jun=new ArrayList();
		Jun=initMonth(6,30);
		System.out.println("June: "+Jun);

		ArrayList Jul=new ArrayList();
		Jul=initMonth(7,31);
		System.out.println("July: "+Jul);

		ArrayList Aug=new ArrayList();
		Aug=initMonth(8,31);
		System.out.println("August: "+Aug);

		ArrayList Sep=new ArrayList();
		Sep=initMonth(9,30);
		System.out.println("September: "+Sep);

		ArrayList Oct=new ArrayList();
		Oct=initMonth(10,31);
		System.out.println("October: "+Oct);

		ArrayList Nov=new ArrayList();
		Nov=initMonth(11,30);
		System.out.println("November: "+Nov);

		ArrayList Dec=new ArrayList();
		Dec=initMonth(12,31);
		System.out.println("December: "+Dec);

		
		fullDate.addAll(Jan);
		fullDate.addAll(Feb);
		fullDate.addAll(Mar);
		fullDate.addAll(Apr);
		fullDate.addAll(May);
		fullDate.addAll(Jun);
		fullDate.addAll(Jul);
		fullDate.addAll(Aug);
		fullDate.addAll(Sep);
		fullDate.addAll(Oct);
		fullDate.addAll(Nov);
		fullDate.addAll(Dec);
		System.out.println("full: "+fullDate);

	}

	public static void sortBydate(){
		Map m=new HashMap();
		int count=1;
		for(int i=0;i<fullDate.size();i++){
			//count++;
			m.put(count++,fullDate.get(i));

		}
		System.out.println(m);
	}

	public static void main(String[] args){
		initEachmonth();
		sortBydate();
	}
}