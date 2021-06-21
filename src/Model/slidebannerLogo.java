package Model;

public class slidebannerLogo {
	private long slidebannerLogoID;
	public slidebannerLogo(long slidebannerLogoID, String slidebannerLogoName) {
		
		this.slidebannerLogoID = slidebannerLogoID;
		this.slidebannerLogoName = slidebannerLogoName;
	}



	private String slidebannerLogoName;
	

	public slidebannerLogo() {
		
	}

	public long getSlidebannerLogoID() {
		return slidebannerLogoID;
	}

	public void setSlidebannerLogoID(long slidebannerLogoID) {
		this.slidebannerLogoID = slidebannerLogoID;
	}

	public String getSlidebannerLogoName() {
		return slidebannerLogoName;
	}

	public void setSlidebannerLogoName(String slidebannerLogoName) {
		this.slidebannerLogoName = slidebannerLogoName;
	}

	
	
	public String getSlidebannerLogo() {
		return getSlidebannerLogo();
	}
	
}