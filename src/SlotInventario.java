public class SlotInventario{
	int numeroSlot;
	String nomeOggetto;
	int stack = 16;
	int numeroOggetti;
	int prezzo;
	
	public SlotInventario(int numeroSlot, String nomeOggetto, int numeroOggetti, int prezzo) {
        this.numeroSlot = numeroSlot;
        this.nomeOggetto = nomeOggetto;
        this.numeroOggetti = numeroOggetti;
    }
	
	@Override
    public String toString() {
        return "Slot " + numeroSlot + ": " + nomeOggetto +
               " (" + numeroOggetti + "/" + stack + ") " + "Prezzo di Vendita: " +prezzo +"$";
    }
}