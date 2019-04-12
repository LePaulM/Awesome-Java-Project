package affichageGraphique;

public class ZDialogInfo {
	  private String nom, tplateau,ecostme, nbreAnimaux,tps;

	  public ZDialogInfo(){}
	  public ZDialogInfo(String nom, String tplateau, String ecostme,  String nbreAnimaux,String tps){
	    this.nom = nom;
	    this.tplateau = tplateau;
	    this.ecostme=ecostme;
	    this.nbreAnimaux = nbreAnimaux;
	    this.tps = tps;
	  }
	  
	  /**
	   * Cette méthode permet de renvoyer la taille d'un des côtés du plateau. Puisque c'est un plateau carré, cela permettra de calculer sa taille.
	   * @return taille d'un côté : int 
	   */
	  public int getTaille() {
		  String caracteres[]=tplateau.split("");
		  String STPlateau="";
		  int i=0;
		  while (!(caracteres[i].equals("*"))) {
			STPlateau=STPlateau+caracteres[i]; 
			i++;
		  }
		  Integer taille = Integer.decode(STPlateau);
		  return(taille);
	  }
	  
	  /**
	   * Rédéfinition de la méthode toString. 
	   */
	  @Override
	  public String toString(){
	    String str;
		int nbreAnimauxMax=(getTaille()*getTaille())/2;
	    if(this.nom != null && this.tplateau != null && this.ecostme != null && this.nbreAnimaux != null && this.tps != null && Integer.decode(nbreAnimaux)<nbreAnimauxMax){
	      str = "Options choisies \n";
	      str += "Nom : " + this.nom + "\n";
	      str += "taille du plateau " + this.tplateau + "\n";
	      str += "Choix des écosystèmes : " + this.ecostme + "\n";
	      str += "Temps de simulation : " + this.tps + "\n";
	      str += "Nombre d'animaux sur le plateau : " + this.nbreAnimaux + "\n";
	    }
	    else if(this.nom != null && this.tplateau != null && this.ecostme != null && this.nbreAnimaux != null && this.tps != null){
	      str = "Le nombre d'animaux choisi n'est pas cohérent avec la taille du plateau !";
	    }
	    else {
	    	str="Aucune information !";
	    }
	    return str;
	  }


}