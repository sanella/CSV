import java.io.FileNotFoundException;
import java.io.IOException;


public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		try {
			CsvBuilder.saveObject("users", new User("sanela", 25, false));
			CsvBuilder.saveObject("users", new User("Kinez", 15, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] str = {"sanela", "25", "false"};
		User newUser;
		newUser = CsvBuilder.findObject(str, "users");
		System.out.println(newUser.toString());
		
	}
}
