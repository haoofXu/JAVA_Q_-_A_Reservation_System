import java.io.IOException;

public class Test {
	
	
	public static void main (String[] arg) throws IOException
    {
		boolean isRunning = true;
		while(isRunning){
			Stdout.println();
			Stdout.println("================= ����ԤԼϵͳ =================");
			Stdout.println(" 1. ����Ա��¼");
			Stdout.println(" 2. ��ʦ��¼");
			Stdout.println(" 3. ѧ����¼");
			Stdout.println(" 4. �˳�ϵͳ");
			int choose = Stdin.readInt();
			switch(choose){
			//	1. ����Ա��¼
			case 1:
				Stdout.println();
				Stdout.println("  1�� ���ѧ��");
				Stdout.println("  2�� �����ʦ");
				choose = Stdin.readInt();
				switch(choose){
				case 1:
					Stdout.println("�û�����");
					String ssname = Stdin.readString();
					Stdout.println("��    �룺");
					String sspassword = Stdin.readString();
					Student ss = new Student(ssname, sspassword);
					ss.regRequest(ssname, sspassword);
					break;
				case 2:
					Stdout.println("�û�����");
					String ttname = Stdin.readString();
					Stdout.println("��    �룺");
					String ttpassword = Stdin.readString();
					Teacher tt = new Teacher(ttname, ttpassword);
					tt.regRequest(ttname, ttpassword);
					break;
				}
				break;
			//	2. ��ʦ��¼
			case 2:
				Stdout.println();
				Stdout.println("�û�����");
				String tname = Stdin.readString();
				Stdout.println("��    �룺");
				String tpassword = Stdin.readString();
				
				In in2 = new In("Teachers.csv");
			    String taccounts[] = in2.readAllStrings();
			    in2.close();
			    boolean tlogin = false;
			    for (int i=0;i<taccounts.length;i++){
			    	String details[] = taccounts[i].split(",");
			    	if(details[0].equals(tname) && details[1].equals(tpassword)){
			    		Stdout.println("��½�ɹ���");
			    		tlogin = true;
			    		break;
			    	}
				}
			    //	��¼����
				if(tlogin){
					Teacher tea = new Teacher(tname, tpassword);
					Stdout.println();
					Stdout.println("  1. �޸��û���");
					Stdout.println("  2. �޸�����");
					Stdout.println("  3. �޸�ԤԼ���ڷ�Χ");
					Stdout.println("  4. �޸�ԤԼʱ�䷶Χ");
					Stdout.println("  5. �޸�ԤԼ��ַ");
					Stdout.println("  6. ���ÿ�ԤԼѧ��");
					Stdout.println("  7. ��ѯԤԼ");
					
					choose = Stdin.readInt();
					switch(choose){
					case 1:
						Stdout.println("    ���û�����");
						tname = Stdin.readString();
						tea.modifyName(tname);
						break;
					case 2:
						Stdout.println("    �����룺");
						tname = Stdin.readString();
						tea.modifyKey(tname);
						break;
					case 3:
						Stdout.println("    ��ʼԤԼ���ڣ���ʽ��2017-12-20����");
						String tdate1 = Stdin.readString();
						Stdout.println("    ����ԤԼ���ڣ�");
						String tdate2 = Stdin.readString();
						tea.setDate(tdate1, tdate2);
						break;
					case 4:
						Stdout.println("    ��ʼԤԼʱ�䣨��ʽ:9:00��Ӣ��ð�ţ���");
						tdate1 = Stdin.readString();
						Stdout.println("    ����ԤԼʱ�䣺");
						tdate2 = Stdin.readString();
						tea.setTime(tdate1, tdate2);
						break;
					case 5:
						Stdout.println("    ԤԼ�ص㣺");
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
			//	3. ѧ����¼
			case 3:
				Stdout.println();
				Stdout.println("�û�����");
				String name = Stdin.readString();
				Stdout.println("��    �룺");
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
			    		Stdout.println("��½�ɹ���");
			    		login = true;
			    		break;
			    	}
				}
			    //	��¼����
				if(login){
					Student stu = new Student(name, password);
					Stdout.println();
					Stdout.println("  1. �޸��û���");
					Stdout.println("  2. �޸�����");
					Stdout.println("  3. ԤԼ��ʦ");
					Stdout.println("  4. ��ѯԤԼ");
					
					choose = Stdin.readInt();
					switch(choose){
					case 1:
						Stdout.println("    ���û�����");
						name = Stdin.readString();
						stu.modifyName(name);
						break;
					case 2:
						Stdout.println("    �����룺");
						name = Stdin.readString();
						stu.modifyKey(name);
						break;
					case 3:
						name = stu.getTeacher();
						if(name == null){
							Stdout.println("û��������ѡ�ε���ʦ��");
							break;
						}
						else{
							Stdout.println("��ԤԼ��ʦ��" + name);
							
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

							Stdout.println("��ԤԼ���ڣ�" + DateStart + " - " + DateEnd);
							Stdout.println("��ԤԼʱ�䣺" + TimeStart + " - " + TimeEnd);
							Stdout.println("��ԤԼ�ص㣺" + Address);
							Stdout.println();

							Stdout.println("ԤԼ���ڣ�");
							String date = Stdin.readString();
							Stdout.println("��ʼʱ�䣨��ʽ:9:00��Ӣ��ð�ţ���");
							String start = Stdin.readString();
							Stdout.println("����ʱ�䣺");
							String end = Stdin.readString();
							
							stu.addRecord(date, start, end);
						}
						break;
					case 4:
						name = stu.getTeacher();
						if(name == null){
							Stdout.println();
							Stdout.println("û��ԤԼ��");
							break;
						}
						else{

							String date = stu.getDate();
							String start = stu.getStartTime();
							String End = stu.getEndTime();
							if(date==null){
								Stdout.println("û��ԤԼ��");
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
								Stdout.println("ԤԼ��ʦ��" + name);
								Stdout.println("���ڣ�" + date);
								Stdout.println("ʱ�䣺" + start + " - " + End);
								Stdout.println("��ַ��" + Address);
								
							}
							

							Stdout.println("ȡ��ԤԼ��(Y/N)");
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
