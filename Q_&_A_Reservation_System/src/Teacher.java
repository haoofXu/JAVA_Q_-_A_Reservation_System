import java.io.IOException;

public class Teacher extends Services {

	static String id;
	static String key;
	
	Teacher(String name, String password){
		this.id = name;
		this.key = password;
	}
	
	//	��ʦע������
	void regRequest(String name, String password) throws IOException{
		In in = new In("Teachers.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Teachers.csv");
	    for (int i=0;i<accounts.length;i++){
			out.println(accounts[i]);
		}
	    out.println(name + "," + password + 
	    		"," + "NULL" + "," + "NULL" + "," + "NULL" + "," + "NULL"
	    		+ "," + "NULL" + "," + "NULL" + "," + "NULL" + "," + "NULL");
	}
	
	//	�޸��û���
	void modifyName(String newName) throws IOException{
		In in = new In("Teachers.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Teachers.csv");
	    
	    In in2 = new In("Students.csv");
	    String accounts2[] = in2.readAllStrings();
	    in2.close();
	    Out out2 = new Out("Students.csv");
	    for (int i=0;i<accounts2.length;i++){
	    	String details[] = accounts2[i].split(",");
	    	if(details[2].equals(this.id)){
	    		String md = details[0] + ","  + details[1] + "," 
	    	+ newName + ","  + details[3] + "," 
	    				 + details[4] + ","  + details[5];
	    		out2.println(md);
	    	}
	    	else{
				out2.println(accounts2[i]);
	    	}
	    }
	    out2.close();
	    
	    In in3 = new In("Records.csv");
	    String accounts3[] = in3.readAllStrings();
	    in3.close();
	    Out out3 = new Out("Records.csv");
	    for (int i=0;i<accounts3.length;i++){
	    	String details[] = accounts3[i].split(",");
	    	if(details[0].equals(this.id)){
	    		String md = newName + "," + details[1] + "," + details[2] +
	    				"," + details[3] + "," + details[4];
	    		out3.println(md);
	    	}
	    	else{
				out3.println(accounts3[i]);
	    	}
	    }
	    out3.close();
	    
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	if(details[0].equals(this.id)){
	    		String md = newName;
	    		for(int ii = 1; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("�޸ĳɹ���");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	

	//	�޸�����
	void modifyKey(String newName) throws IOException{
		In in = new In("Teachers.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Teachers.csv");
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	if(details[0].equals(this.id)){
	    		String md = details[0] + "," + newName;
	    		for(int ii = 2; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("�޸ĳɹ���");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	
	
	
	//	�鿴ԤԼ��Ϣ
	public static void getRecords() throws IOException{
		In inAcc = new In("Records.csv");
		String acc[] = inAcc.readAllStrings();
		inAcc.close();
		for(int i = 0;i<acc.length;i++){
			Stdout.println();
			if (id.equals(csvOperator.getTitle(acc[i]))){
				Stdout.println("ѧ����" + csvOperator.getValue(acc[i]));
				Stdout.println("���ڣ�" + csvOperator.getMoney(acc[i]));
				Stdout.println("ʱ�䣺" + csvOperator.getStart(acc[i]) + " - " +
						csvOperator.getEnd(acc[i]));
			}
		}
	}
	
	//	����ԤԼ����
	public void setDate(String start, String end) throws IOException{
		In in = new In("Teachers.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Teachers.csv");
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	
	    	if(details[0].equals(this.id)){

	    		String md = details[0];
	    		for(int ii = 1; ii < 2; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		md += "," + start + "," + end;
	    		
	    		for(int ii = 4; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("�޸ĳɹ���");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	
	//	�޸ĵ�ַ
	public void setAddress(String newName) throws IOException{
		In in = new In("Teachers.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Teachers.csv");
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	
	    	if(details[0].equals(this.id)){

	    		String md = details[0];
	    		for(int ii = 1; ii < 6; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		md += "," + newName;
	    		
	    		for(int ii = 7; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("�޸ĳɹ���");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	
	//	����ԤԼʱ��
	public void setTime(String start, String end) throws IOException{
		In in = new In("Teachers.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("Teachers.csv");
	    for (int i=0;i<accounts.length;i++){
	    	String details[] = accounts[i].split(",");
	    	
	    	if(details[0].equals(this.id)){

	    		String md = details[0];
	    		for(int ii = 1; ii < 4; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		md += "," + start + "," + end;
	    		
	    		for(int ii = 6; ii < details.length; ii++){
	    			md = md + "," + details[ii];
	    		}
	    		out.println(md);
	    		Stdout.println("�޸ĳɹ���");
	    	}
	    	else{
				out.println(accounts[i]);
	    	}
		}
	}
	

	//	��ѯԤԼ
	void getVies() throws IOException{
	    In in3 = new In("Records.csv");
	    String accounts3[] = in3.readAllStrings();
	    in3.close();
	    boolean find = false;
	    for (int i=0;i<accounts3.length;i++){
	    	String details[] = accounts3[i].split(",");
	    	if(details[0].equals(this.id)){
	    		find = true;
				Stdout.println("ԤԼѧ����" + details[1]);
				Stdout.println("���ڣ�" + details[2]);
				Stdout.println("ʱ�䣺" + details[3] + " - " + details[4]);
				
				
//				In in = new In("Teachers.csv");
//			    String accounts[] = in.readAllStrings();
//			    in.close();
//			    for (int i1=0;i1<accounts.length;i1++){
//			    	String details1[] = accounts[i].split(",");
//			    	if(details1[0].equals(this.id)){
//			    		Stdout.println("��ַ��" + details1[6]);
//			    		break;
//			    	}
//				}
			    Stdout.println();
	    	}
	    }
	    if(!find){
	    	Stdout.println("û��ѧ��ԤԼ��");
	    }
	    
	}
	
//	��ѯԤԼ
	void setStu() throws IOException{
	    In in3 = new In("Teachers.csv");
	    String accounts3[] = in3.readAllStrings();
	    in3.close();
	    for (int i=1;i<accounts3.length;i++){
	    	String details[] = accounts3[i].split(",");
	    	if(details[0].equals(this.id)){
	    		String st1 = details[7];
	    		String st2 = details[8];
	    		String st3 = details[9];
	    		Stdout.println("��ԤԼ���ѧ����");
				if(st1.equals("NULL")){
					Stdout.println("��");
				}else{
					Stdout.println(st1);
					if(st2.equals("NULL")){}
					else{
						Stdout.println(st2);
						if(st3.equals("NULL")){}
						else{
							Stdout.println(st3);
						}
					}
				}
	    	}
	    	
	    	Stdout.println("���ѧ����(Y/N)");
	    	String choose = Stdin.readString();
			if(choose.equals("Y")){
				
				In in = new In("Students.csv");
			    String accounts[] = in.readAllStrings();
			    in.close();
			    for (int j=1;j<accounts.length;j++){
			    	String detailsj[] = accounts[j].split(",");
			    	Stdout.println(detailsj[0]);
				}
				
			    Stdout.println("��ӣ�");
			    choose = Stdin.readString();
			    if(details[7].equals("NULL")){
			    	details[7] = choose;
			    }else if(details[8].equals("NULL")){
			    	details[8] = choose;
			    }else if(details[9].equals("NULL")){
			    	details[9] = choose;
			    }
			    
			    Out out = new Out("Teachers.csv");
			    for (int k=0;k<accounts3.length;k++){
			    	if(csvOperator.getTitle(accounts3[k]).equals(this.id)){

			    		String md = details[0] + "," + details[1] + ","+ details[2] + ","
			    				+ details[3] + ","+ details[4] + ","+ details[5] + ","
			    				+ details[6] + ","+ details[7] + ","+ details[8] + ","
			    				+ details[9];
			    		
			    		out.println(md);
			    		Stdout.println("��ӳɹ���");
			    	}
			    	else{
						out.println(accounts3[k]);
			    	}
				}
			    
			    
			    Out out2 = new Out("Students.csv");
			    for (int k=0;k<accounts.length;k++){
			    	details = accounts[k].split(",");
			    	if(csvOperator.getTitle(accounts[k]).equals(choose)){

			    		String md = details[0] + "," + details[1] + ","+ this.id + ","
			    				+ details[3] + ","+ details[4] + ","+ details[5];
			    		out2.println(md);
			    	}
			    	else{
						out2.println(accounts[k]);
			    	}
				}
			    
			}
	    }
	    
	    
	}
	
}
