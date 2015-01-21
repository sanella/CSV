import java.io.*;

public class CsvBuilder {

	private static InputStream is;
	private static OutputStream os;
	private static FileOutputStream fos;
	private static FileInputStream fis;
	private static String basePath = "." + File.separator + "Base"
			+ File.separator;
	private static String currentOpen = null;

	public static <T extends CSVInterface<T>> void saveObject(String fileName,
			T objectToSave) throws IOException {
		if (fileName.equals(currentOpen)) {
			os.write(objectToSave.objectToCsv().getBytes());

		} else {

			fos = new FileOutputStream(basePath + fileName + ".csv", true);
			os = new DataOutputStream(fos);
			currentOpen = fileName;
			os.write(objectToSave.objectToCsv().getBytes());
		}
		System.out.println(basePath);
		os.flush();
		System.out.println(objectToSave.objectToCsv());
	}

	public static <T extends CSVInterface<T>> T findObject(String[] str, String fileName) throws FileNotFoundException {
		fis = new FileInputStream(basePath+fileName+".csv");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length - 1; i++) {
			sb.append(str[i]).append(", ");
		}
		sb.append(str[str.length - 1]);

		BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
		String line = "";
		try {
			String search = sb.toString();
			while ((line = bis.readLine()) != null) {

				if (line.equals(search)) {
					//T newT = ;
					//newT.csvToObject(line);
					return (new T().csvToObject(line));
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

		return null;

	}
}
