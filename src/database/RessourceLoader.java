package database;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import carte.Carte;
import carte.CartePiochable;
import personnage.CartePersonnage;

public class RessourceLoader {

	private static Map<Integer, Carte> loadCards() throws ClassNotFoundException, IOException{
		
		Table t = new Table();
		Map<Integer, Carte> cartes = new HashMap<Integer,Carte>();
		for(int i = 0; i < 61; i++) {
			
			String query = QueryGenerator.selectId(i+1);
			t.remplirTableQuery(query);
		
			byte[] obj = t.getList().get(i).getObjet();
			if(obj != null) {
				Object o = deserialize(obj);
				Carte c = (Carte)o;
				cartes.put(i+1, c);
			}
		}
		return cartes;
	}
	
	private static Map<Integer, CartePiochable> getMapType(CartePiochable.Type t, Map<Integer, Carte> cartes){
		
		Map<Integer, CartePiochable> cartesType = new HashMap<Integer, CartePiochable>();
		
		for(Integer i: cartes.keySet()) {
			
			Carte c = cartes.get(i);
			if(cartes.get(i) instanceof CartePiochable) {
				
				CartePiochable carte = (CartePiochable) c;
				
				CartePiochable.Type type = carte.getType();
				if(t == type) {
					cartesType.put(i,carte);
				}
			}
		}
		return cartesType;
	}
	
	private static Map<Integer, CartePersonnage> getMapPersonnage(Map<Integer, Carte> cartes){
		
		Map<Integer, CartePersonnage> cartesPersonnage = new HashMap<Integer, CartePersonnage>();
		
		for(Integer i: cartes.keySet()) {
			
			Carte c = cartes.get(i);
			if(cartes.get(i) instanceof CartePersonnage) {
				
				CartePersonnage carte = (CartePersonnage) c;
				cartesPersonnage.put(i,carte);
			}
		}
		return cartesPersonnage;
	}

	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
	
	public static void main(String[] args) {
		
		try {
			Map<Integer, Carte> cartes = loadCards();
			System.out.println(cartes);
			System.out.println(getMapType(CartePiochable.Type.TENEBRE, cartes));
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
