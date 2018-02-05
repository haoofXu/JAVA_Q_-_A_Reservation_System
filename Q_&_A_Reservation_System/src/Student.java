import java.io.IOException;

public class Student extends Services {

	static String id;
	static String key;
	
	Student(String name, String password){
		this.id = name;
		this.key = password;
	}
	
	//	学生注册请求
	void regRequest(String name, String password) throws IOException{
		In in = new In("Students.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Students.csv");
	    for (int i=0;i<accounts.length;i++){
			out.println(accounts[i]);
		}
	    out.println(name + "," + password + "," + "NULL" + "," + "NULL" + "," + "NULL" + "," + "NULL");
	}
	
	//	修改用户名
	void modifyName(String newName) throws IOException{
		In in = new In("Students.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Students.csv");
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	if(details[0].equals(this.id)){
	    		String md = newName;
	    		for(int ii = 1; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("修改成功！");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	

	//	修改密码
	void modifyKey(String newName) throws IOException{
		In in = new In("Students.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Students.csv");
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	if(details[0].equals(this.id)){
	    		String md = details[0] + "," + newName;
	    		for(int ii = 2; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("修改成功！");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	
	//	获取预约老师姓名
	public static String getTeacher() throws IOException{
		String teacherStr = null;
		In inAcc = new In("Students.csv");
		String acc[] = inAcc.readAllStrings();
		inAcc.close();
		for(int i = 0;i<acc.length;i++){
			if (id.equals(csvOperator.getTitle(acc[i]))){
//				Stdout.println(csvOperator.getMoney(acc[i]));
				teacherStr = csvOperator.getMoney(acc[i]);
				if(teacherStr.equals("NULL")){
					teacherStr = null;
				}
			}
		}
//		Stdout.println(teacherStr);
		return teacherStr;
	}
	
	//	获取预约日期
	public static String getDate() throws IOException{
		String teacherStr = null;
		In inAcc = new In("Students.csv");
		String acc[] = inAcc.readAllStrings();
		inAcc.close();
		for(int i = 0;i<acc.length;i++){
			if (id.equals(csvOperator.getTitle(acc[i]))){
				teacherStr = csvOperator.getStart(acc[i]);
				if(teacherStr.equals("NULL")){
					teacherStr = null;
				}
			}
		}
		return teacherStr;
	}
	
	//	获取预约开始时间
	public static String getStartTime() throws IOException{
		String teacherStr = null;
		In inAcc = new In("Students.csv");
		String acc[] = inAcc.readAllStrings();
		inAcc.close();
		for(int i = 0;i<acc.length;i++){
			if (id.equals(csvOperator.getTitle(acc[i]))){
				teacherStr = csvOperator.getEnd(acc[i]);
				if(teacherStr.equals("NULL")){
					teacherStr = null;
				}
			}
		}
		return teacherStr;
	}

	//	获取预约结束时间
	public static String getEndTime() throws IOException{
		String teacherStr = null;
		In inAcc = new In("Students.csv");
		String acc[] = inAcc.readAllStrings();
		inAcc.close();
		for(int i = 0;i<acc.length;i++){
			if (id.equals(csvOperator.getTitle(acc[i]))){
				teacherStr = csvOperator.getTimeEnd(acc[i]);
				if(teacherStr.equals("NULL")){
					teacherStr = null;
				}
			}
		}
		return teacherStr;
	}
	
	//	预约老师
	void addRecord(String Date, String Start, String End) throws IOException{
		boolean finish = false;
		boolean addIn = false;
		
		String teacherStr = getTeacher();
		if(teacherStr==null){
			Stdout.println("警告！没有老师许可预约");
		}
		else{
			In in = new In("Teachers.csv");
			String Teachers[] = in.readAllStrings();
		    in.close();
		    
		    In inRec = new In("Records.csv");
			String recs[] = inRec.readAllStrings();
			inRec.close();
		    
		    Out out = new Out("Records.csv");
		    for (int i=0;i<recs.length;i++){
				out.println(recs[i]);
			}
	
		    for (int i=0;i<Teachers.length;i++){
				if(teacherStr.equals(csvOperator.getTitle(Teachers[i]))){
					String date[] = Date.split("-");
					String DateStart = csvOperator.getMoney(Teachers[i]);
					String DateEnd = csvOperator.getStart(Teachers[i]);
					String TimeStart = csvOperator.getEnd(Teachers[i]);
					String TimeEnd = csvOperator.getTimeEnd(Teachers[i]);
					String dateStart[] = DateStart.split("-");
					String dateEnd[] = DateEnd.split("-");
					String timeStart[] = TimeStart.split(":");
					String timeEnd[] = TimeEnd.split(":");
					if(date[0].compareTo(dateStart[0])>=0 
							&& date[1].compareTo(dateStart[1])>=0
							&& date[2].compareTo(dateStart[2])>=0
							&& date[0].compareTo(dateEnd[0])<=0
							&& date[1].compareTo(dateEnd[1])<=0
							&& date[2].compareTo(dateEnd[2])<=0
							)
					{
						String ss[] = Start.split(":");
						String ee[] = End.split(":");
						
//						Stdout.println(timeStart[0]);
//						Stdout.println(ss[0]);
//						Stdout.println(timeEnd[0]);
//						Stdout.println(ee[0]);
						
						int st1 = Integer.parseInt(ss[0]);
						int st2 = Integer.parseInt(timeStart[0]);
						int ed1 = Integer.parseInt(ee[0]);
						int ed2 = Integer.parseInt(timeEnd[0]);
						
						if(st1 >= st2 && st1 <= ed1
								&& ed1 <= ed2 )
						{
							In in2 = new In("Students.csv");
						    String accounts[] = in2.readAllStrings();
						    in2.close();
						    Out out2 = new Out("Students.csv");
						    for (int i2=0;i2<accounts.length;i2++){
						    	String idname = csvOperator.getTitle(accounts[i2]);
						    	if(idname.equals(this.id)){
						    		out2.println(this.id + "," + this.key + "," + teacherStr + 
						    				"," + Date +
						    				"," + Start + "," + End);
						    	}
						    	else{
						    		out2.println(accounts[i2]);
						    	}
							}
						    addIn = true;
							Stdout.println("预约成功！");
						}
						else{
							Stdout.println("预约失败！不在规定时间内！");
							break;
						}
					}
					else{
						Stdout.println("预约失败！不在规定日期内！");
						break;
					}
				}
			}
		    if(addIn){
				In inAcc = new In("Records.csv");
				String acc[] = inAcc.readAllStrings();
			    inAcc.close();
		    	Out outAcc = new Out("Records.csv");
			    for (int i=0;i<acc.length;i++){
			    	outAcc.println(acc[0]);
				}
			    outAcc.println(teacherStr + "," + id + "," + Date + "," + Start + "," + End);
			    outAcc.close();
		    }
		    out.close();
	    }
	}
	
	//	取消预约
	void cancelRecord() throws IOException{
		
		    
		In inRec = new In("Records.csv");
		String recs[] = inRec.readAllStrings();
		inRec.close();
		    
		Out out = new Out("Records.csv");
	    for (int i=0;i<recs.length;i++){
	    	if(!this.id.equals(csvOperator.getValue(recs[i]))){
		    	out.println(recs[i]);
	    	}
		}
	    out.close();
	    
	    In in2 = new In("Students.csv");
		String Students[] = in2.readAllStrings();
	    in2.close();
	    
		Out out2 = new Out("Students.csv");
	    for (int i=0;i<Students.length;i++){
	    	if(this.id.equals(csvOperator.getTitle(Students[i]))){

				String Password = csvOperator.getValue(Students[i]);
				String Teacher = csvOperator.getMoney(Students[i]);
	    		
	    		
				String md = this.id + "," + Password + "," +  Teacher +
						 "," + "NULL" +  "," + "NULL" +  "," + "NULL";
//				Stdout.println(md);
		    	out2.println(md);
	    	}
	    	else{
		    	out2.println(Students[i]);
	    	}
		}
    	out2.close();
	    Stdout.println("取消成功！");
	}
}
