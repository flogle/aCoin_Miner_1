package data;

public class ACoinData {

	private long id;
	private boolean canMine;
	private String current_app_version;
	
	public ACoinData(long id, boolean canMine, String current_app_version) {
		
		this.current_app_version = current_app_version;
		this.id = id;
		this.canMine = canMine;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCanMine() {
		return canMine;
	}

	public void setCanMine(boolean canMine) {
		this.canMine = canMine;
	}

	public String getCurrent_app_version() {
		return current_app_version;
	}

	public void setCurrent_app_version(String current_app_version) {
		this.current_app_version = current_app_version;
	}
	
	
	
}
