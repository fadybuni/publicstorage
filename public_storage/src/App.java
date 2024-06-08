public class App {
    public static void main(String[] args) throws Exception {
        
        database theDatabase = new database();
        IDandPasswords idandpasswords = new IDandPasswords();
		
		
		LoginPage loginpage = new LoginPage(idandpasswords.getLoginInfo());

        Thread.sleep(30000);
    }
}
