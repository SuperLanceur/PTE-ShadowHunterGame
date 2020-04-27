package database;

public class QueryGenerator {

	public static String AllFrom(String table) {
		return "SELECT * FROM " + getTable(table);
	}
	
	public static String WithId(String table, int d) {
		return "SELECT * FROM " + getTable(table) + "WHERE id =" + d;
	}
	
	public static String WithName(String s, String name) {
		return "SELECT * FROM " + getTable(s) + "WHERE nom ='" + name + "'";
	}
	
	public static String getTable(String s) {
		return "public.\"" + s + "\"";
	}
	
}
