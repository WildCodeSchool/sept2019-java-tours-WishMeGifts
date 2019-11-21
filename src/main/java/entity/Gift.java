package entity;

public class Gift {

	//Attributs
	private Long id;
	private String nom;
	private String lien;
	
	
	//Constructeur
	public Gift(Long id, String nom, String lien) {
	
		this.id = id;
		this.nom = nom;
		this.lien = lien;
	}
	
	
	public Gift() {
		
		
		// TODO Auto-generated constructor stub
	}


	//Getters et setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
