package database;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import carte.Carte;
import carte.CartePiochable;
import personnage.CartePersonnage;

public class RessourceLoader {

	
	public static final String CARTES_PERSONNAGE = "cp";
	public static final String CARTES_LUMIERE = "cl";
	public static final String CARTES_TENEBRE = "ct";
	public static final String CARTES_VISION = "cv";
	
	public static final String DOS_PERSONNAGE = "dp";
	public static final String DOS_LUMIERE = "dl";
	public static final String DOS_TENEBRE = "dt";
	public static final String DOS_VISION = "dv";
	
	private final int ID_DOS_PERSONNAGE = 60;
	private final int ID_DOS_LUMIERE = 58;
	private final int ID_DOS_TENEBRE= 59;
	private final int ID_DOS_VISION= 61;
	
	private Map<String, Map<Carte, Image>> ressourcesCartes;
	private Map<String, Image> ressourcesDosCartes;
	
	
	public RessourceLoader() {
		this.ressourcesCartes = new HashMap<String, Map<Carte,Image>>();
		this.ressourcesDosCartes = new HashMap<String, Image>();
	}
	
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
	
	private static Map<Integer, Carte> getMapType(CartePiochable.Type t, Map<Integer, Carte> cartes){
		
		Map<Integer, Carte> cartesType = new HashMap<Integer, Carte>();
		
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
	
	private static Map<Integer, Carte> getMapPersonnage(Map<Integer, Carte> cartes){
		
		Map<Integer, Carte> cartesPersonnage = new HashMap<Integer, Carte>();
		
		for(Integer i: cartes.keySet()) {
			
			Carte c = cartes.get(i);
			if(cartes.get(i) instanceof CartePersonnage) {
				
				CartePersonnage carte = (CartePersonnage) c;
				cartesPersonnage.put(i,carte);
			}
		}
		return cartesPersonnage;
	}

	private static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
	
	private static Image loadImage(int id) throws IOException {
		String name = ""+id+".png";
		String url = "ressources/cartes/"+name;
		System.out.println(url);
		Image picture = ImageIO.read(new File(url));
		return picture;
	}
	
	private static Map<Carte, Image> getMapImageCarte(Map<Integer, Carte> cartes) throws IOException{
		
		Map<Carte, Image> mapCarteImage = new HashMap<Carte, Image>();
		
		for(Integer i : cartes.keySet()) {
		
			Carte c = cartes.get(i);
			Image img = loadImage(i);
			mapCarteImage.put(c,img);
		}
		
		return mapCarteImage;
	}
	
	
	public void loadRessources() {
		
		try {
			Map<Integer, Carte> cartes = loadCards();
			
			Map<Integer, Carte> mapT = getMapType(CartePiochable.Type.TENEBRE, cartes);
			Map<Integer, Carte> mapL = getMapType(CartePiochable.Type.LUMIERE, cartes);
			Map<Integer, Carte> mapV = getMapType(CartePiochable.Type.VISION, cartes);
			Map<Integer, Carte> mapP = getMapPersonnage(cartes);
			
			Map<Carte, Image> mapIT = getMapImageCarte(mapT);
			Map<Carte, Image> mapIL = getMapImageCarte(mapT);
			Map<Carte, Image> mapIV = getMapImageCarte(mapT);
			Map<Carte, Image> mapIP = getMapImageCarte(mapT);
			
			
			this.ressourcesCartes.put(CARTES_TENEBRE, mapIT);
			this.ressourcesCartes.put(CARTES_LUMIERE, mapIL);
			this.ressourcesCartes.put(CARTES_LUMIERE, mapIV);
			this.ressourcesCartes.put(CARTES_LUMIERE, mapIP);
			
			this.ressourcesDosCartes.put(DOS_TENEBRE, loadImage(ID_DOS_TENEBRE));
			this.ressourcesDosCartes.put(DOS_LUMIERE, loadImage(ID_DOS_LUMIERE));
			this.ressourcesDosCartes.put(DOS_VISION, loadImage(ID_DOS_VISION));
			this.ressourcesDosCartes.put(DOS_PERSONNAGE, loadImage(ID_DOS_PERSONNAGE));

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RessourceLoader rl = new RessourceLoader();
		rl.loadRessources();
	}
	
	
}
