package database;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import carte.Carte;
import carte.CarteLieu;
import carte.CartePiochable;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
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
	
	private Map<Carte, BufferedImage> ressourcesCartes;
	private Map<String, BufferedImage> ressourcesDosCartes;
	
	
	public RessourceLoader() {
		this.ressourcesCartes = new HashMap<Carte,BufferedImage>();
		this.ressourcesDosCartes = new HashMap<String, BufferedImage>();
	}
	
	private Map<Integer, Carte> loadCards() throws ClassNotFoundException, IOException{
		
		Table t = new Table();
		Map<Integer, Carte> cartes = new HashMap<Integer,Carte>();
		for(int i = 0; i < 67; i++) {
			
			String query = QueryGenerator.selectId(i+1);
			t.remplirTableQuery(query);
		
			Record r = t.getList().get(i);
			byte[] obj = r.getObjet();
			if(obj != null) {
				Object o = deserialize(obj);
				Carte c = (Carte)o;
				c.setNom(r.getNom());
				cartes.put(i+1, c);
			}
		}
		return cartes;
	}
	
	private Map<Integer, Carte> getMapType(CartePiochable.Type t, Map<Integer, Carte> cartes){
		
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
	
	private Map<Integer, Carte> getMapPersonnage(Map<Integer, Carte> cartes){
		
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
	
	private BufferedImage loadImage(int id) throws IOException {
		String name = ""+id+".png";
		String url = "ressources/cartes/"+name;
		BufferedImage picture = ImageIO.read(new File(url));
		return picture;
	}
	
	private Map<Carte, BufferedImage> getMapImageCarte(Map<Integer, Carte> cartes) throws IOException{
		
		Map<Carte, BufferedImage> mapCarteImage = new HashMap<Carte, BufferedImage>();
		
		for(Integer i : cartes.keySet()) {
		
			Carte c = cartes.get(i);
			BufferedImage img = loadImage(i);
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
			/*
			Map<Carte, Image> mapIT = getMapImageCarte(mapT);
			Map<Carte, Image> mapIL = getMapImageCarte(mapL);
			Map<Carte, Image> mapIV = getMapImageCarte(mapV);
			Map<Carte, Image> mapIP = getMapImageCarte(mapP);
			*/
			
			this.ressourcesCartes = (getMapImageCarte(cartes));
			
			this.ressourcesDosCartes.put(DOS_TENEBRE, loadImage(ID_DOS_TENEBRE));
			this.ressourcesDosCartes.put(DOS_LUMIERE, loadImage(ID_DOS_LUMIERE));
			this.ressourcesDosCartes.put(DOS_VISION, loadImage(ID_DOS_VISION));
			this.ressourcesDosCartes.put(DOS_PERSONNAGE, loadImage(ID_DOS_PERSONNAGE));

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Carte> getCartes() {
		return new ArrayList<Carte>(this.ressourcesCartes.keySet());
	}
	
	
	public static List<CartePiochable> getCartesType(CartePiochable.Type t, List<Carte> cartes){
		
		List<CartePiochable> cartesType = new ArrayList<CartePiochable>();
		
		for(Carte c : cartes) {
			if(c instanceof CartePiochable) {
				
				CartePiochable carte = (CartePiochable) c;
				System.out.println(carte.getNom()+" "+carte.getType());
				CartePiochable.Type type = carte.getType();
				
				if(t == type) {
					cartesType.add(carte);
				}
			}
		}
		return cartesType;
	}
	
	public static List<CarteLieu> getCartesType(List<Carte> cartes){
		
		List<CarteLieu> cartesLieu = new ArrayList<CarteLieu>();
		
		for(Carte c : cartes) {
		
			if(c instanceof CarteLieu) {
				
				CarteLieu carte = (CarteLieu) c;
				cartesLieu.add(carte);
			}
		}
		return cartesLieu;
	}

	public static List<CartePersonnage> getCartesPersonnages(List<Carte> cartes) {
		List<CartePersonnage> cartesLieu = new ArrayList<CartePersonnage>();
		
		for(Carte c : cartes) {
		
			if(c instanceof CartePersonnage) {
				
				CartePersonnage carte = (CartePersonnage) c;
				cartesLieu.add(carte);
			}
		}
		return cartesLieu;
	}
	
	public Map<Carte,BufferedImage> getRessourceCartes(){
		return this.ressourcesCartes;
	}
	
	public Map<String,BufferedImage> getRessourceDosCartes(){
		return this.ressourcesDosCartes;
	}
	
	public static Image toJavaFX(BufferedImage img) {
		Image image =  SwingFXUtils.toFXImage(img, null);
		return image;
	}	
}
