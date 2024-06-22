public class App {
    public static void main(String[] args) throws Exception 
    {
        
        //database theDatabase = new database();
        IDandPasswords idandpasswords = new IDandPasswords();
		
		new LoginPage(idandpasswords.getLoginInfo());

    }
}
