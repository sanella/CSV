
public interface CSVInterface<T> {
	
	public String objectToCsv();
	
	public T csvToObject(String csv);
	
}
