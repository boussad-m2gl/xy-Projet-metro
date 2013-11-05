package materiel;

public interface Clavier {
	public boolean touchePresse(int key) throws Exception;
	public void resetTouche(int key) throws Exception;
}
