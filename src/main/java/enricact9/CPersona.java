/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enricact9;

/**
 *
 * @author arcedo
 */
public class CPersona {
    private String nom, primer_cognom, segon_cognom ;
    private int secret_num;
    public CPersona(String nom, String primer_cognom, String segon_cognom, int secret_num) {
        this.nom = nom;
        this.primer_cognom = primer_cognom;
        this.segon_cognom = segon_cognom;
        this.secret_num = secret_num;
    }
    public CPersona(CPersona persona) {
        this.nom = persona.getNom();
        this.primer_cognom = persona.getPrimer_cognom();
        this.segon_cognom = persona.getSegon_cognom();
        this.secret_num = persona.getSecret_num();
    }
    
    public CPersona() {
        this.nom = "";
        this.primer_cognom = "";
        this.segon_cognom = "";
        this.secret_num = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrimer_cognom() {
        return primer_cognom;
    }

    public void setPrimer_cognom(String primer_cognom) {
        this.primer_cognom = primer_cognom;
    }

    public String getSegon_cognom() {
        return segon_cognom;
    }

    public void setSegon_cognom(String segon_cognom) {
        this.segon_cognom = segon_cognom;
    }

    public int getSecret_num() {
        return secret_num;
    }

    public void setSecret_num(int secret_num) {
        this.secret_num = secret_num;
    }
}
