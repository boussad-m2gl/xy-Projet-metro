package ObserverPackage;

/**
 * Interface Sujet pour le patron de conception observer
 * 
 * */
public interface Subject {
	
	public void register(Observer obj);
	public void unregister(Observer obj);
	public void notifyObservers();
	
}
