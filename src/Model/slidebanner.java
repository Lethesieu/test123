package Model;

public class slidebanner {
	private long slidebannerID;
	public slidebanner(long slidebannerID, String slidebannerImage) {
		
		this.slidebannerID = slidebannerID;
		this.slidebannerImage = slidebannerImage;
	}
	private String slidebannerImage;
	
	
	
	public slidebanner() {
		
	}
	public long getSlidebannerID() {
		return slidebannerID;
	}
	public void setSlidebannerID(int slidebannerID) {
		this.slidebannerID = slidebannerID;
	}
	public String getSlidebannerImage() {
		return slidebannerImage;
	}
	public void setSlidebannerImage(String slidebannerImage) {
		this.slidebannerImage = slidebannerImage;
	}
	
}