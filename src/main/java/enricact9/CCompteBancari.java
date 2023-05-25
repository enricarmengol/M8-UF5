/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enricact9;

/**
 *
 * @author arcedo
 */
public class CCompteBancari {

      private int numero;
      private CPersona propietari;
      private float saldo;
      private static int next_account = 1234;
      private static float saldo_inicial = 100;

      public CCompteBancari(int numero, CPersona propietari, float saldo) {
            this.numero = numero;
            this.propietari = propietari;
            this.saldo = saldo;
      }

      public CCompteBancari(CCompteBancari comptebanc) {
            this.numero = comptebanc.getNumero();
            this.propietari = comptebanc.getPropietari();
            this.saldo = comptebanc.getSaldo();
      }

      public CCompteBancari() {
            this.numero = next_account;
            next_account+=1;
            this.propietari = new CPersona();
            this.saldo = saldo_inicial;
      }

      public int getNumero() {
            return numero;
      }

      public void setNumero(int numero) {
            this.numero = numero;
      }

      public CPersona getPropietari() {
            return propietari;
      }

      public void setPropietari(CPersona propietari) {
            this.propietari = propietari;
      }

      public float getSaldo() {
            return saldo;
      }

      public void setSaldo(float saldo) {
            this.saldo = saldo;
      }

      public static int getNext_account() {
            return next_account;
      }

      public static void setNext_acount(int next_acount) {
            CCompteBancari.next_account = next_acount;
      }

      public static float getSaldo_inicial() {
            return saldo_inicial;
      }

      public static void setSaldo_inicial(float saldo_inicial) {
            CCompteBancari.saldo_inicial = saldo_inicial;
      }

      public static void modificar_saldo_inicial(float salari) {
            setSaldo_inicial(salari);
      }

      public float consult_saldo() {
            return this.getSaldo();
      }

      public boolean comprovar_num_secret(int num_introduit) {
            boolean comprovant = false;
            if (num_introduit == this.getPropietari().getSecret_num()) {
                  comprovant = true;
            }
            return comprovant;
      }

      public boolean ingressar(int cuantitat, int num_secret) {
            boolean comprovant = false;
            if (num_secret == this.getPropietari().getSecret_num()) {
                  this.setSaldo(cuantitat + this.getSaldo());
                  comprovant = true;
            }
            return comprovant;
      }

      public boolean extreure(int cuantitat, int num_secret) {
            boolean comprovant = false;
            if (num_secret == this.getPropietari().getSecret_num() && this.getSaldo() - cuantitat >= 0) {
                  this.setSaldo(this.getSaldo() - cuantitat);
                  comprovant = true;
            }
            return comprovant;
      }
}
