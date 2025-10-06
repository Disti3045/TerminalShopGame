public class Npc {
	String nome;
	
	Npc(String nome){
		this.nome = nome;
	}
	
	@Override
    public String toString() {
        return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Npc npc = (Npc) obj;
	    return nome.equals(npc.nome);
	}

	@Override
	public int hashCode() {
	    return nome.hashCode();
	}
}