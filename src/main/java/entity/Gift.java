package entity;

public class Gift {

	//Attributs
	private long id;
	private String nom;
	private String lien;
	private long id_event_list;
	
	//Constructeur
	
	public Gift(long id, String nom, String lien, long id_event_list) {
	
		this.id = id;
		this.nom = nom;
		this.lien = lien;
		this.id_event_list= id_event_list;
	}
	
	public Gift() {
			
	}
	//Getters et setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}
	
	public long getId_event_list() {
		return id_event_list;
	}


	public void setId_event_list(long id_event_list) {
		this.id_event_list = id_event_list;
	}

}
