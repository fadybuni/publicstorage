public class App {
    public static void main(String[] args) throws Exception 
    {
        IDandPasswords idandpasswords = new IDandPasswords();
		
		new Display_LoginPage(idandpasswords.getLoginInfo());

    }
}
