package sdcard;

public class MyFile {
	private String name;
	private String attribute;
	private String fullPath;
	private String artist;
	private String album;
	
	public MyFile(String name, String displayname, String fullPath, String artist, String album){
		this.name = name;
		this.fullPath = fullPath;
		this.artist = artist;
		this.album = album;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
	
	
}
