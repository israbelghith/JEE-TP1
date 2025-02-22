package tn.itbs.Models;

public class Produit {
	private int id ;
	private String nom;
	private int  quantite;
	public Produit(int id, String nom, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
	}
	public Produit() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
