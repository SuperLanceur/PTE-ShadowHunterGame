package database;

public class TestAddingCard {
	
	private final static String url = "jdbc:postgresql://localhost:5432/ShadowHunterDatabase";
    private final static String user = "shManager";
    private final static String password = "shadowhunter1234";
/*	
	public static void main(String[] args) {
		
		CartePiochable instance = new CartePiochable(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 2, true)), new Condition());
	
		try {
			insertCartePiochable(instance);
			System.out.println(retrieveCartePiochable(0).getEffet());
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	  public static Connection connect() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	   }
	 
	  public static void insertCartePiochable(Carte instance) throws IOException, SQLException {
		  
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		
		oos = new ObjectOutputStream(baos);
		oos.writeObject(instance);
		oos.close();
			
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

		byte[] object = bais.readAllBytes();
		InputStream objectIS = new ByteArrayInputStream(object);
			
		String sql = "INSERT INTO public.\"Test\"" + "VALUES(?)";
				
		Connection conn = connect();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setBinaryStream(1, objectIS);
		pst.executeUpdate();
		  
	  }
	  
	  public static CartePiochable<?> retrieveCartePiochable(int pos) throws IOException, SQLException, ClassNotFoundException {
		  
		Connection conn = connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM public.\"Test\""); 
		  
		  byte[] object = null;
		  if(rs.next()) {
			  object = rs.getBytes(1);
		  }
		  
		ByteArrayInputStream in = new ByteArrayInputStream(object);
		    ObjectInputStream is = new ObjectInputStream(in);
		    return (CartePiochable<?>) is.readObject();
		  
	  }*/
}
