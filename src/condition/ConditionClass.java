package condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Joueur;

public class ConditionClass<T extends Comparable> extends Condition{

	
	private List<Class<T>> classes;

	
	public ConditionClass(Class<T> ... classes){

		// TODO
		this.classes = new ArrayList<Class<T>>();
		this.classes.addAll(Arrays.asList(classes));
	}


	@Override
	boolean isTrue(Joueur joueur) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
