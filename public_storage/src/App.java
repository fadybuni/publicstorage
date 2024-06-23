public class App {
    public static void main(String[] args) throws Exception 
    {
        IDandPasswords idandpasswords = new IDandPasswords();
		
		new LoginPage(idandpasswords.getLoginInfo());

    }
}
