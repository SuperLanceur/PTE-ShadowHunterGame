package database;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private String name;
	private List<Record> list = new ArrayList<Record>();
	
	public Table(String JavaTableName) {
		this.name = JavaTableName;
	}

	public void fillList(String query) {
		this.list = DatabaseManager.remplirTable(query);
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected List<Record> getList() {
		return list;
	}
	
	public String toString() {
		return this.getList().toString();
	}
	
	protected boolean isEmpty() {
		if(list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	


	
	
	
}
