package Locators;



public class Login_Locators_Repo {
	public static String note="//p[contains(text(),'To log in, enter your username and password, then ')]";
	public static String username="//input[@id='j_username']";
	public static String password="//input[@id='j_password']";
	public static String login_button="//span[@id='loginspan']";
	public static String clear_button="//span[@id='clearspan']";
	public static String request_account_link="//a[contains(text(),'Request Account')]";
	public static String forgot_password_link="//a[contains(text(),'Forgot password?')]";
	public static String build_number_text="//td[contains(text(),'Build Number:9.3.6 (Build 47)')]";
	public static String search_box="//*[@id=\"QUICKSEARCH_STRING\"]";
	public static String search_button="//*[@id=\"top_simpleSearch\"]";
	public static String logout_button="//a[@id=\"logout\"]";
	public static String error_message="//p[contains(text(),'Invalid user ID or password.')]";
	public static String login_message="//p[contains(text(),'You have successfully logged into the application ')]";
}
