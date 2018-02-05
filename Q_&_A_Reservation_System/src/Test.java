import java.io.IOException;

public class Test {
	
	
	public static void main (String[] arg) throws IOException
    {
		boolean isRunning = true;
		while(isRunning){
			Stdout.println();
			Stdout.println("================= 答疑预约系统 =================");
			Stdout.println(" 1. 管理员登录");
			Stdout.println(" 2. 老师登录");
			Stdout.println(" 3. 学生登录");
			Stdout.println(" 4. 退出系统");
			int choose = Stdin.readInt();
			switch(choose){
			//	1. 管理员登录
			case 1:
				Stdout.println();
				Stdout.println("  1。 添加学生");
				Stdout.println("  2。 添加老师");
				choose = Stdin.readInt();
				switch(choose){
				case 1:
					Stdout.println("用户名：");
					String ssname = Stdin.readString();
					Stdout.println("密    码：");
					String sspassword = Stdin.readString();
					Student ss = new Student(ssname, sspassword);
					ss.regRequest(ssname, sspassword);
					break;
				case 2:
					Stdout.println("用户名：");
					String ttname = Stdin.readString();
					Stdout.println("密    码：");
					String ttpassword = Stdin.readString();
					Teacher tt = new Teacher(ttname, ttpassword);
					tt.regRequest(ttname, ttpassword);
					break;
				}
				break;
			//	2. 老师登录
			case 2:
				Stdout.println();
				Stdout.println("用户名：");
				String tname = Stdin.readString();
				Stdout.println("密    码：");
				String tpassword = Stdin.readString();
				
				In in2 = new In("Teachers.csv");
			    String taccounts[] = in2.readAllStrings();
			    in2.close();
			    boolean tlogin = false;
			    for (int i=0;i<taccounts.length;i++){
			    	String details[] = taccounts[i].split(",");
			    	if(details[0].equals(tname) && details[1].equals(tpassword)){
			    		Stdout.println("登陆成功！");
			    		tlogin = true;
			    		break;
			    	}
				}
			    //	登录操作
				if(tlogin){
					Teacher tea = new Teacher(tname, tpassword);
					Stdout.println();
					Stdout.println("  1. 修改用户名");
					Stdout.println("  2. 修改密码");
					Stdout.println("  3. 修改预约日期范围");
					Stdout.println("  4. 修改预约时间范围");
					Stdout.println("  5. 修改预约地址");
					Stdout.println("  6. 设置可预约学生");
					Stdout.println("  7. 查询预约");
					
					choose = Stdin.readInt();
					switch(choose){
					case 1:
						Stdout.println("    新用户名：");
						tname = Stdin.readString();
						tea.modifyName(tname);
						break;
					case 2:
						Stdout.println("    新密码：");
						tname = Stdin.readString();
						tea.modifyKey(tname);
						break;
					case 3:
						Stdout.println("    开始预约日期（格式：2017-12-20）：");
						String tdate1 = Stdin.readString();
						Stdout.println("    结束预约日期：");
						String tdate2 = Stdin.readString();
						tea.setDate(tdate1, tdate2);
						break;
					case 4:
						Stdout.println("    开始预约时间（格式:9:00、英文冒号）：");
						tdate1 = Stdin.readString();
						Stdout.println("    结束预约时间：");
						tdate2 = Stdin.readString();
						tea.setTime(tdate1, tdate2);
						break;
					case 5:
						Stdout.println("    预约地点：");
						tdate1 = Stdin.readString();
						tea.setAddress(tdate1);
						break;
					case 6:
						tea.setStu();
						break;
					case 7:
						tea.getVies();
						break;
					}
				}
				
				
				break;
			//	3. 学生登录
			case 3:
				Stdout.println();
				Stdout.println("用户名：");
				String name = Stdin.readString();
				Stdout.println("密    码：");
				String password = Stdin.readString();
				
				In in = new In("Students.csv");
			    String accounts[] = in.readAllStrings();
			    in.close();

//		    	Stdout.println(accounts.length);
			    boolean login = false;
			    for (int i=0;i<accounts.length;i++){
//			    	Stdout.println(1);
			    	String details[] = accounts[i].split(",");
//			    	Stdout.println(details[0] );
//			    	Stdout.println(name );
//			    	Stdout.println(details[1] );
//			    	Stdout.println(password );
			    	if(details[0].equals(name) && details[1].equals(password)){
			    		Stdout.println("登陆成功！");
			    		login = true;
			    		break;
			    	}
				}
			    //	登录操作
				if(login){
					Student stu = new Student(name, password);
					Stdout.println();
					Stdout.println("  1. 修改用户名");
					Stdout.println("  2. 修改密码");
					Stdout.println("  3. 预约老师");
					Stdout.println("  4. 查询预约");
					
					choose = Stdin.readInt();
					switch(choose){
					case 1:
						Stdout.println("    新用户名：");
						name = Stdin.readString();
						stu.modifyName(name);
						break;
					case 2:
						Stdout.println("    新密码：");
						name = Stdin.readString();
						stu.modifyKey(name);
						break;
					case 3:
						name = stu.getTeacher();
						if(name == null){
							Stdout.println("没有允许你选课的老师！");
							break;
						}
						else{
							Stdout.println("可预约老师：" + name);
							
							In inAcc = new In("Teachers.csv");
							String acc[] = inAcc.readAllStrings();
							inAcc.close();
							String DateStart = null, DateEnd = null, TimeStart = null, TimeEnd = null, Address = null;
							for(int i = 0;i<acc.length;i++){
								if (name.equals(csvOperator.getTitle(acc[i]))){
									String data[] = acc[i].split(",");
									DateStart = data[2];
									DateEnd = data[3];
									TimeStart = data[4];
									TimeEnd = data[5];
									Address = data[6];
								}
							}

							Stdout.println("可预约日期：" + DateStart + " - " + DateEnd);
							Stdout.println("可预约时间：" + TimeStart + " - " + TimeEnd);
							Stdout.println("可预约地点：" + Address);
							Stdout.println();

							Stdout.println("预约日期：");
							String date = Stdin.readString();
							Stdout.println("开始时间（格式:9:00、英文冒号）：");
							String start = Stdin.readString();
							Stdout.println("结束时间：");
							String end = Stdin.readString();
							
							stu.addRecord(date, start, end);
						}
						break;
					case 4:
						name = stu.getTeacher();
						if(name == null){
							Stdout.println();
							Stdout.println("没有预约！");
							break;
						}
						else{

							String date = stu.getDate();
							String start = stu.getStartTime();
							String End = stu.getEndTime();
							if(date==null){
								Stdout.println("没有预约！");
							}
							else{
								In inAcc = new In("Teachers.csv");
								String acc[] = inAcc.readAllStrings();
								inAcc.close();
								String Address = null;
								for(int i = 0;i<acc.length;i++){
									if (name.equals(csvOperator.getTitle(acc[i]))){
										String data[] = acc[i].split(",");
										Address = data[6];
									}
								}
								Stdout.println("预约老师：" + name);
								Stdout.println("日期：" + date);
								Stdout.println("时间：" + start + " - " + End);
								Stdout.println("地址：" + Address);
								
							}
							

							Stdout.println("取消预约？(Y/N)");
							name = Stdin.readString();
							if(name.equals("Y")){
								stu.cancelRecord();
							}
						}
						

						
						
						break;
					}
				}
				
				
				break;
			case 4:
				isRunning = false;
				break;
			default:
				choose = 0;
			}
		}

		
    } 
}
