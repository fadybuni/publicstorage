public class App {
    public static void main(String[] args) throws Exception {
        
        database theDatabase = new database();
        IDandPasswords idandpasswords = new IDandPasswords();
		
		
		LoginPage loginpage = new LoginPage(idandpasswords.getLoginInfo());

        // Sleep for 300 seconds
        Thread.sleep(30000);
    }
}
