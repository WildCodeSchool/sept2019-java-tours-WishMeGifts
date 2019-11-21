package entity;

import java.lang.String;
import java.sql.Date;


public class Events {
	
	  	private Long id;
	    private String intitule;
	    private String adresse;
	    private String message;
	    private Date dateEvents;
	    private String occasion;
	    
	    //constructor
	    public Events(Long id, String intitule, String adresse,  String message, Date dateEvents, String occasion) {
	        this.id = id;        
	        this.intitule = intitule;
	        this.adresse = adresse;
	        this.message = message;
	        this.setDateEvents(dateEvents);
	        this.occasion = occasion;
	      
	    }
	    
	    
	    //getters and setters
	    
	    public Long getId() {
			return id;
		}
	    
	    public void setId(Long id) {
			this.id = id;
		}


	    public String getIntitule() {
			return intitule;
		}


		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}
	    
		public String getAdresse() {
			return adresse;
		}


		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public Date getDateEvents() {
			return dateEvents;
		}


		public void setDateEvents(Date dateEvents) {
			this.dateEvents = dateEvents;
		}
		
		public String getOccasion() {
			return occasion;
		}


		public void setOccasion(String occasion) {
			this.occasion = occasion;
		}
	
	    

}
