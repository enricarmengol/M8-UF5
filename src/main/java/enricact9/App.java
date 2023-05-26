/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package enricact9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author arcedo
 */
public class App {

      // Variables generals
      static Scanner sc = new Scanner(System.in);
      static int opt_menu;
      static ArrayList account = new ArrayList();
      static int n_acc, n_sec;

      // Metode per introduir el nom correctament a una compte
      static void nom_compte(CCompteBancari compte) {
            boolean valid_data = false;
            while (valid_data == false) {
                  System.out.printf("   - Nom: ");
                  compte.getPropietari().setNom(sc.nextLine());
                  if (compte.getPropietari().getNom().substring(0, 1).equals(" ") || compte.getPropietari().getNom().toUpperCase().equals("NULL")) {
                        System.out.println("     - Nom invalid.");
                        System.out.println("  - Introdueix-ho un altre cop: ");
                  } else {
                        valid_data = true;
                  }
            }
      }

      // Metode per introduir el primer cognom correctament a una compte
      static void p_cognom_compte(CCompteBancari compte) {
            boolean valid_data = false;
            while (valid_data == false) {
                  System.out.printf("   - Primer Cognom: ");
                  System.out.println("jijijija");
                  compte.getPropietari().setPrimer_cognom(sc.nextLine());
                  if (compte.getPropietari().getPrimer_cognom().substring(0, 1).equals(" ") || compte.getPropietari().getPrimer_cognom().toUpperCase().equals("NULL")) {
                        System.out.println("     - Primer Cognom invalid.");
                        System.out.println("  - Introdueix-ho un altre cop: ");
                  } else {
                        valid_data = true;
                  }
            }
      }

      // Metode per introduir el segon cognom correctament a una compte
      static void s_cognom_compte(CCompteBancari compte) {
            boolean valid_data = false;
            while (valid_data == false) {
                  System.out.printf("   - Segon Cognom: ");
                  compte.getPropietari().setSegon_cognom(sc.nextLine());
                  if (compte.getPropietari().getSegon_cognom().substring(0, 1).equals(" ") || compte.getPropietari().getSegon_cognom().toUpperCase().equals("NULL")) {
                        System.out.println("     - Segon Cognom invalid.");
                        System.out.println("  - Introdueix-ho un altre cop: ");
                  } else {
                        valid_data = true;
                  }
            }
      }

      // Metode per introduir el numero secret correctament a una compte
      static void n_sec_compte(CCompteBancari compte) {
            boolean valid_data = false;
            while (valid_data == false) {
                  System.out.printf("   - Número Secret (el numero ha de tenir quatre xifres): ");
                  compte.getPropietari().setSecret_num(Integer.parseInt(sc.nextLine()));
                  if (compte.getPropietari().getSecret_num() > 999 && compte.getPropietari().getSecret_num() < 10000) {
                        System.out.println("     - Número Secret asignat correctement.");
                        valid_data = true;
                  } else {
                        System.out.println("     - Número secret invalid.");
                        System.out.println("  - Introdueix-ho un altre cop: ");
                  }
            }
      }

      // Metode per crear una nova compte
      static void nou_compte() {
            System.out.printf("\n");
            CCompteBancari compte = new CCompteBancari();
            System.out.println("- Introdueix les dades del propietari de compte següents:");
            nom_compte(compte);
            p_cognom_compte(compte);
            s_cognom_compte(compte);
            n_sec_compte(compte);
            System.out.printf("\n-  Compte creada correctament.\n");
            System.out.println("  · Numero de compte: " + compte.getNumero());
            System.out.println("  · Saldo actual: " + compte.getSaldo());
            account.add(compte);
            System.out.printf("\n\n");
      }
      

      // Metode per introduir les dades i comprovar que les dades siguin correctes
      static void intro_data() {
            // Faig un iterador que tindra totes les dades les comptes a l'array list
            Iterator i = account.iterator();
            try {
                  // Si no hi ha una compte executara l'exepció
                  if (!i.hasNext()) {
                        throw new Exception("");
                  } else {
                        System.out.println("   - Introdueix les seguents dades: ");
                        System.out.printf("     - Numero de la teva compte: ");
                        n_acc = Integer.parseInt(sc.nextLine());
                        System.out.printf("     - Numero secret: ");
                        n_sec = Integer.parseInt(sc.nextLine());
                        // Mentres hi ha una seguent compte
                        while (i.hasNext()) {
                              System.out.printf("\n");
                              // Creo una compte amb les dades del iterador
                              CCompteBancari compte = (CCompteBancari) i.next();
                              // Si el numero secret es el mateix que s'ha introduit y el numero de compte tambe doncs entra 
                              if (n_sec == compte.getPropietari().getSecret_num() && n_acc == compte.getNumero()) {
                                    switch (opt_menu) {
                                          case 2 -> {
                                                mod_acc(compte);
                                          }
                                          case 3 -> {
                                                del_acc(compte);
                                          }
                                          case 4 -> {
                                                consult_saldo(compte);
                                          }
                                          case 5 -> {
                                                ingres(compte);
                                          }
                                          case 6 -> {
                                                extract(compte);
                                          }
                                          case 7 -> {
                                                mod_num_sec(compte);
                                          }
                                          default -> {
                                                System.out.println("- ERROR: Opció erronia.");
                                          }
                                    }
                                    System.out.println("\n\n");
                                    break;
                              } else if (!i.hasNext()) {
                                    System.out.println("  - Les dades introduides no es corresponen amb ninguna de les comptes registrades.");
                                    System.out.printf("\n\n");
                              }
                        }
                  }
            } catch (Exception ex) {
                  System.out.println("  - ERROR: No hi ha comptes");
            }
      }

      // Metode per modificar una compte
      static void mod_acc(CCompteBancari compte) {
            boolean mod_menu = false;
            do {
                  String opt_mod;
                  System.out.println("   - Dades que pots modificar: ");
                  System.out.println("      1. Nom del Propietari");
                  System.out.println("      2. Primer cognom del Propietari");
                  System.out.println("      3. Segon cognom del Propietari");
                  System.out.println("      0. Sortir");
                  System.out.printf("   - Introdueix el número de l'opció que vols seleccionar:");
                  opt_mod = sc.nextLine();
                  switch (opt_mod) {
                        case "0" ->
                              mod_menu = true;
                        case "1" -> {
                              nom_compte(compte);
                        }
                        case "2" -> {
                              p_cognom_compte(compte);
                        }
                        case "3" -> {
                              s_cognom_compte(compte);
                        }
                        default ->
                              System.out.println("    - Opció invalida.");
                  }
            } while (mod_menu == false);
      }

      // Metode per eliminar una compte
      static void del_acc(CCompteBancari compte) {
            account.remove(compte);
            System.out.println("  - Compte eliminada correctamen.");
      }

      // Metode per consultar el saldo
      static void consult_saldo(CCompteBancari compte) {
            System.out.println("  · El teu saldo acctual es de " + compte.consult_saldo() + "€.");
      }

      // Metode per ingresar diers
      static void ingres(CCompteBancari compte) {
            System.out.printf("  - Introdueix la quantitat que introduiras:");
            compte.ingressar(Integer.parseInt(sc.nextLine()), n_sec);
            System.out.println("     - S'ha fet l'ingres correctament.");
            System.out.println("      · Saldo actual: " + compte.getSaldo());
      }

      // Metode per modificar el numero secret 
      static void mod_num_sec(CCompteBancari compte) {
            n_sec_compte(compte);
      }

      // Metode per extraure diners
      static void extract(CCompteBancari compte) {
            System.out.printf("  - Introdueix la quantitat que introduiras:");
            compte.extreure(Integer.parseInt(sc.nextLine()), n_sec);
            System.out.println("    - S'ha fet l'extracció correctament.");
            System.out.println("      · Saldo actual: " + compte.getSaldo());
      }

      // Main
      public static void main(String[] args) {
            boolean menu = false;
            while (menu == false) {
                  System.out.println("- Opcions per escollir:");
                  System.out.println("   1. Crear nou compte");
                  System.out.println("   2. Modificar compte");
                  System.out.println("   3. Eliminar compte");
                  System.out.println("   4. Consultar saldo");
                  System.out.println("   5. Ingressar");
                  System.out.println("   6. Extreure");
                  System.out.println("   7. Modificar número secret");
                  System.out.println("   0. Sortir");
                  System.out.printf("- Introdueix la opció que vols escollir: ");
                  opt_menu = Integer.parseInt(sc.nextLine());
                  if (opt_menu == 1) {
                        nou_compte();
                  } else if (opt_menu == 0) {
                        menu = true;
                        System.out.println("- Fins la següent!!!");
                  } else {
                        intro_data();
                  }
            }
      }
}
