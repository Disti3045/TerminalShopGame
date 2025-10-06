import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Inizializzazione Giocatore
		Shopkeeper player = new Shopkeeper();
		int contaGiorni = 0;
		boolean continua = true;
		Scanner scanner = new Scanner(System.in);
		//Inizializzazione Inventario
		LinkedList<SlotInventario> inventario = new LinkedList<>();
		String[] oggetti = {"healthFlask", "strengthPotion", "speedTalisman", "poisonusAmulet"};
		for (int i = 0; i < player.slotOggetti; i++) {
			inventario.add(new SlotInventario(i, oggetti[i], 16, prezzoOggetti(oggetti[i])));
			}
		
		//Inizializzazione NPC
		String[] nomiNpc = {"Arvelin", "Toraen", "Myrrha", "Kaelthorn", "Eldaris",
				"Seraphine", "Gorvak", "Lirwen", "Thandor", "Vesryn",
				"Maelion", "Ruvira", "Orrik", "Sylthra", "Fenndar",
				"Ilmora", "Drogan", "Velthar", "Nyssa", "Korveth",
				"Elorin", "Tessara", "Grivak", "Aenwyn", "Morric",
				"Yllira", "Torvek", "Saphren", "Draelis", "Cynora"};
		LinkedList<Npc> npc = new LinkedList<>();
		for(int i=0; i<nomiNpc.length; i++) {
			npc.add(new Npc(nomiNpc[i]));
		}
		
		//Loop Gioco
		while(continua) {
			int scorteVendute=0;
			int moneteGuadagnate=0;
			int ricercatiSistemati=0;
			//Inizio Giornata
			System.out.println("Giorno " + contaGiorni + "...");
			System.out.println("La prima luce filtra tra le persiane, "
					+ "\naccendendo di riflessi dorati le bottiglie e i metalli. "
					+ "\nLe strade ancora vuote si destano piano, "
					+ "\ne una chiave gira nella serratura.");
			System.out.println();
			//Resoconto Inventario
			System.out.println("Tra scaffali silenziosi, le mani scorrono sulle merci, "
					+ "\ncontando, pesando, ricordando. "
					+ "\nOgni oggetto sembra avere una storia "
					+ "\nda sussurrare nella penombra dell’alba.");
			System.out.println("========Inventario=========");
			for (int i = 0; i<player.slotOggetti; i++) {
				StampaSlot(i, inventario);
			}
			System.out.println();
			//Lista Ricercati
			System.out.println("Sul muro della piazza, "
					+ "\nnuovi volti si aggiungono alla carta ingiallita; "
					+ "\ngli occhi disegnati paiono seguirti, "
					+ "\nimmobili eppure inquieti, "
					+ "\nnel vento del mattino.");
			LinkedList<Ricercato> ricercati = new LinkedList<>();
			ListaRicercati(ricercati, npc);
			StampaListaRicercati(ricercati);
			//Inizio clienti
			int clienti = 15;
			int clientiServiti=0;
			
			LinkedList<Npc> trovati = new LinkedList<>();
			Random random = new Random();
			while (clientiServiti < clienti) {
			    System.out.println("La campanella sulla porta tintinna piano,"
			            + "\nspezzando il silenzio."
			            + "\nUn nuovo cliente varca la soglia...");
			    Npc cliente;
			    do {
			        int numero = random.nextInt(npc.size());
			        cliente = npc.get(numero);
			    } while (trovati.contains(cliente));
			    trovati.add(cliente);
			    System.out.println("È entrato " + cliente.nome + "!\n");
			    ServiCliente(cliente, player, inventario, ricercati, oggetti, scorteVendute, moneteGuadagnate, ricercatiSistemati, scanner);
			    clientiServiti++;
			}
			//Post-Giornata
			System.out.println("Le ultime monete tintinnano nel baule, "
					+ "\nla porta si chiude con un suono secco e familiare. "
					+ "\nFuori, il cielo si tinge d’ambra "
					+ "\nmentre il mondo rallenta e tace.");
			System.out.println();
			System.out.println("========Resoconto=========");
			System.out.println("Le mani ancora sporche di polvere contano il guadagno: "
					+ "\n"+moneteGuadagnate+" monete per "+scorteVendute+" scorte vendute e "
					+ "\n"+ricercatiSistemati+" ricercati in meno da affrontare. "
					+ "\nOgni cifra pesa più del silenzio che segue.");
			System.out.println();
			//Recupero scorte
			RecuperaScorte(inventario, player, scanner);
			System.out.println();
			//Fine Giornata
			System.out.println("Vuoi continuare?");
			System.out.println("1. Continua");
			System.out.println("2. Chiudi");
			int scelta;
			scelta = scanner.nextInt();
			if(scelta==1) {
				continua=true;
			}else {
				continua = false;
			}
			contaGiorni++;
		}
		scanner.close();
	}
	
	public static void StampaSlot(int numeroSlot, LinkedList<SlotInventario> inventario) {
		System.out.println(inventario.get(numeroSlot));
	}
	
	public static void ListaRicercati(LinkedList<Ricercato> ricercati, LinkedList<Npc> npc) {
	    Random random = new Random();
	    Random random2 = new Random();
	    int maxRicercati = Math.min(5, npc.size());
	    while (ricercati.size() < maxRicercati) {
	        int taglia = random2.nextInt(20) + 1;
	        int numero = random.nextInt(npc.size());
	        Npc candidato = npc.get(numero);
	        boolean presente = false;
	        for (Ricercato r : ricercati) {
	            if (r.nome.equals(candidato.nome)) {
	                presente = true;
	                break;
	            }
	        }
	        if (!presente) {
	            Ricercato ricercato = new Ricercato(candidato, taglia);
	            ricercati.add(ricercato);
	        }
	    }
	}

	
	public static void StampaListaRicercati(LinkedList<Ricercato> ricercati) {
	    System.out.println("========Lista Ricercati=========");
	    for (int r = 0; r < ricercati.size(); r++) {
	        Ricercato ric = ricercati.get(r);
	        System.out.println(r + ": " + ric.nome + " (Taglia: " + ric.taglia + "$)");
	    }
	}
	
	public static void RecuperaScorte(LinkedList<SlotInventario> inventario, Shopkeeper player, Scanner scanner) {
		int spesaTotale=0;
		System.out.println("========Porto della città=========");
		System.out.println("Le acque scure riflettono luci tremolanti: "
				+ "\nlanterne fluttuanti legate alle banchine e "
				+ "\nfuochi azzurri sulle imbarcazioni. "
				+ "\nTra il crepuscolo e l’oscurità, "
				+ "\nun mercante avanza lungo il molo nella tua direzione...");
		System.out.println("Hai a disposizione " + player.valutaDisponibile +"$");
		for (int i = 0; i<player.slotOggetti; i++) {
			System.out.println("Hai ancora:");
			StampaSlot(i, inventario);
			SlotInventario slotCorrente = inventario.get(i);
			int price = PrezzoDinamico(player, slotCorrente);
			if(slotCorrente.numeroOggetti!=slotCorrente.stack) {
				System.out.println("Desideri acquistare delle scorte?");
				System.out.println("1. Full");
				System.out.println("2. Metà");
				System.out.println("3. Nessuna");
				int scelta = scanner.nextInt();
				if(scelta==1) {
					int numeroScorte=slotCorrente.stack - slotCorrente.numeroOggetti;
					if(player.valutaDisponibile>=price) {
						player.valutaDisponibile -= price*numeroScorte;
					}
					System.out.println("L'acquisto delle scorte ti è costato" + price + "$");
					slotCorrente.numeroOggetti = slotCorrente.stack;
					spesaTotale += price*numeroScorte;
				}else if(scelta==2) {
					player.valutaDisponibile -= price*slotCorrente.stack/2;
					System.out.println("L'acquisto delle scorte ti è costato" + price + "$");
					slotCorrente.numeroOggetti = slotCorrente.stack/2;
					spesaTotale += price*slotCorrente.stack/2;
				}else {
					System.out.println("Hai scelto di non acquistare scorte");
				}
				continue;
			}
		}
		System.out.println("Grazie per aver visitato il porto...");
		System.out.println("Hai speso un totale di " + spesaTotale + "$");
	}
	
	public static int PrezzoDinamico(Shopkeeper player, SlotInventario slot) {
		int price = 0;
		if(slot.nomeOggetto == "healthFlask") {
			price = 5 + Math.max(0, 10 - player.reputazione);
		}else if(slot.nomeOggetto == "strengthPotion") {
			price = 7 + Math.max(0, 10 - player.reputazione);
		}else if(slot.nomeOggetto == "speedTalisman") {
			price = 7 + Math.max(0, 10 - player.reputazione);
		}else if(slot.nomeOggetto == "poisonusAmulet") {
			price = 3 + Math.max(0, 10 - player.reputazione);
		}
		return price;
	}
	
	public static void ServiCliente(Npc cliente, Shopkeeper player, LinkedList<SlotInventario> inventario, LinkedList<Ricercato> ricercati, String[] oggettiInVendita,int scorteVendute,int moneteGuadagnate,int ricercatiSistemati, Scanner scanner) {
	    int sovraprezzo = 0;
	    Random random = new Random();
	    Ricercato ricercato = trovaRicercato(cliente, ricercati);
	    boolean isRicercato = ricercato != null;
	    int scelta = random.nextInt(player.slotOggetti);
	    String richiesta = oggettiInVendita[scelta];
	    if (isRicercato) {
	        sovraprezzo = random.nextInt(20);
	    }

	    System.out.println("Il cliente è interessato all'acquisto di " + richiesta + ".");
	    System.out.println("Sei disposto a vendere?");
	    System.out.println("1. Sì");
	    System.out.println("2. No");
	    if (isRicercato) {
	        System.out.println("3. Offri un poisonusAmulet");
	    }
	    int opt = scanner.nextInt();
	    if (opt == 1) {
	        SlotInventario slotScelto = null;
	        for (SlotInventario slot : inventario) {
	            if (slot.nomeOggetto.equals(richiesta)) {
	                slotScelto = slot;
	                break;
	            }
	        }
	        if (slotScelto != null && slotScelto.numeroOggetti > 0) {
	            slotScelto.numeroOggetti--;
	            int price = prezzoOggetti(slotScelto.nomeOggetto) + sovraprezzo;
	            player.valutaDisponibile += price;
	            scorteVendute++;
	            moneteGuadagnate += price;

	            System.out.println("La stretta di mano sigilla l’accordo, "
	                    + "\nil tintinnio delle monete rompe la quiete.\n"
	                    + "Vendita completata con successo: "
	                    + "\nil borsello pesa di " + price + " monete in più.\n");
	        } else {
	        	System.out.println("Il cliente attende, ma gli scaffali restano muti.\n" 
	        			+ "Vendita non completata: le scorte sono terminate, " 
	        			+ "\nsolo un sospiro di delusione riempie il negozio vuoto." 
	        			+ "\nIl tuo banco perde affidabilità: " 
	        			+ player.reputazione + "PR");
	            player.reputazione -= 2;
	        }

	    } else if (isRicercato && opt == 3) {
	        SlotInventario slotAmuleto = null;
	        for (SlotInventario slot : inventario) {
	            if (slot.nomeOggetto.equals("poisonusAmulet")) {
	                slotAmuleto = slot;
	                break;
	            }
	        }
	        if (slotAmuleto != null && slotAmuleto.numeroOggetti > 0) {
	            slotAmuleto.numeroOggetti--;
	            int price = slotAmuleto.prezzo;
	            player.valutaDisponibile += price + ricercato.taglia;
	            ricercatiSistemati++;
	            moneteGuadagnate += price + ricercato.taglia;

	            System.out.println("La cassa si apre, un luccichio cupo emerge tra le ombre.\n"
	                    + "L’amuleto, avvolto in una pelle annerita, passa di mano.\n"
	                    + "Il ricercato lo accetta, senza esitazione...\n"
	                    + "Hai guadagnato la taglia di " + ricercato.taglia + "$!\n");

	            ricercati.remove(ricercato);
	        } else {
	            System.out.println("Non hai più amuleti velenosi da offrire...");
	            player.reputazione -= 1;
	        }
	    } else {
	        System.out.println("Tra il fruscio delle stoffe e il crepitio delle lampade, "
	                + "\nl’affare si spegne in un silenzioso rifiuto.");
	        player.reputazione -= 1;
	    }
	}
	
	public static int prezzoOggetti(String oggetto) {
		int price = 0;
		if(oggetto == "healthFlask") {
			price = 7;
		}else if(oggetto == "strengthPotion") {
			price = 8; 
		}else if(oggetto == "speedTalisman") {
			price = 10; 
		}else if(oggetto == "poisonusAmulet") {
			price = 2; 
		}
		return price;
	}
	
	public static Ricercato trovaRicercato(Npc cliente, LinkedList<Ricercato> ricercati) {
	    for (Ricercato r : ricercati) {
	        if (r.nome.equals(cliente.nome)) {
	            return r;
	        }
	    }
	    return null;
	}
}
