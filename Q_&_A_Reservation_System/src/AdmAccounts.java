import java.io.IOException;

public class AdmAccounts extends Services{

	static String id;
	
	AdmAccounts(String s){
		this.id = s;
	}
	
	//	��ʾ �ṩ���˻�
	static void printProviders() throws IOException{
		In in = new In("ProviderAccounts.csv");
	    String accounts[] = in.readAllStrings();
	    for (int i=0;i<accounts.length;i++){

			Stdout.println(csvOperator.getTitle(accounts[i]) + "\t\t " 
					+ csvOperator.getValue(accounts[i]) + "\t\t " 
					+ csvOperator.getMoney(accounts[i]));
		}
	    in.close();
	}
	
	//	����ṩ�̷���
	static void addService(String provider, String name, double price) throws IOException{
		In in = new In(provider + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    Out out = new Out(provider + "Services.csv");
	    for (int i=0;i<services.length;i++){
			out.println(services[i]);
		}
	    out.println(name + "," + price);
	    out.close();
	}
	
	//	ɾ���ṩ�̷���
	void delService(String provider, String name) throws IOException{
		In in = new In(provider + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    Out out = new Out(provider + "Services.csv");
	    for (int i=0;i<services.length;i++){
	    	if(name.equals(csvOperator.getTitle(services[i]))){}
	    	else{
	    		out.println(services[i]);
	    	}
		}
	    out.close();
	}
	
	//	�޸��ṩ�̷���۸�
	void adjService(String provider, String name, double price) throws IOException{
		In in = new In(provider + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    Out out = new Out(provider + "Services.csv");
	    for (int i=0;i<services.length;i++){
	    	if(name.equals(csvOperator.getTitle(services[i]))){
	    		out.println(name + "," + price);
	    	}
	    	else{
	    		out.println(services[i]);
	    	}
		}
	    out.close();
	}
	
	//	��ʾ �����¼
	static void printRecords(String provider) throws IOException{
		In in = new In(provider + "sRecord.csv");
	    String records[] = in.readAllStrings();
		for (int i=0;i<records.length;i++){
			Stdout.println(csvOperator.getTitle(records[i]) + "\t\t " + csvOperator.getValue(records[i]));
		}
	    in.close();
	}
	
	//	��ʾ�û��˻�
	static void printCustomers() throws IOException{
		In in = new In("CustomerAccounts.csv");
	    String accounts[] = in.readAllStrings();
	    for (int i=0;i<accounts.length;i++){
			Stdout.println(csvOperator.getTitle(accounts[i]) + "\t\t " 
					+ csvOperator.getValue(accounts[i]) + "\t\t " 
					+ csvOperator.getMoney(accounts[i]));
		}
	    in.close();
	}

	//	�����˿�  �����¼
	void addCRecord(String customer, String provider, String name) throws IOException{
		In in = new In(provider + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    
	    In inRec = new In(customer + "sRecord.csv");
		String recs[] = inRec.readAllStrings();
		inRec.close();
	    
	    Out out = new Out(customer + "sRecord.csv");
	    for (int i=0;i<recs.length;i++){
	    	//Stdout.println(recs[i]);
			out.println(recs[i]);
		}

	    for (int i=0;i<services.length;i++){
			if(name.equals(csvOperator.getTitle(services[i]))){
				out.println(provider + "," + name);
			}
		}
	    out.close();
	}
	
	//	ɾ���˿�  �����¼
	void delCRecord(String customer, String provider, String name) throws IOException{
		In inRec = new In(customer + "sRecord.csv");
		String recs[] = inRec.readAllStrings();
		inRec.close();
	    
	    Out out = new Out(customer + "sRecord.csv");
	    for (int i=0;i<recs.length;i++){
	    	if(provider.equals(csvOperator.getTitle(recs[i]))
	    			&& name.equals(csvOperator.getValue(recs[i]))){}
	    	else{ out.println(recs[i]); }
		}
	    out.close();
	}
	
	@Override
	void regRequest(String name, String password) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	//	��׼�ṩ��ע������
	void pRegRequest() throws IOException{
		In in = new In("ProviderRequests.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("ProviderRequests.csv");
		out.println(accounts[0]);
		out.close();
		In inAcc = new In("ProviderAccounts.csv");
	    String acc[] = inAcc.readAllStrings();
	    inAcc.close();
		Out outAcc = new Out("ProviderAccounts.csv");
	    for (int i=0;i<acc.length;i++){
			outAcc.println(acc[i]);
		}
	    for (int i=1;i<accounts.length;i++){
			outAcc.println(accounts[i]);
		}
	    outAcc.close();
    }
	
	//	��׼�û�ע������
	void cRegRequest() throws IOException{
		In in = new In("CustomerRequests.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("CustomerRequests.csv");
		out.println(accounts[0]);
		out.close();
		In inAcc = new In("CustomerAccounts.csv");
	    String acc[] = inAcc.readAllStrings();
	    inAcc.close();
		Out outAcc = new Out("CustomerAccounts.csv");
	    for (int i=0;i<acc.length;i++){
			outAcc.println(acc[i]);
		}
	    for (int i=1;i<accounts.length;i++){
			outAcc.println(accounts[i]);
		}
	    outAcc.close();
    }
}
