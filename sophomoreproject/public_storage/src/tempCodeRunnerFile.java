public class App {
    public static void main(String[] args) throws Exception {


        // Other operations (e.g., initializing database, login page, etc.)
        database theDatabase = new database();
        IDandPasswords idandpasswords = new IDandPasswords();
        LoginPage loginpage = new LoginPage(idandpasswords.getLoginInfo());

        // Simulate delay for demonstration purposes
        Thread.sleep(30000);
    }
}
