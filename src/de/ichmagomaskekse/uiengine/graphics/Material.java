package de.ichmagomaskekse.uiengine.graphics;

public enum Material {
	
	SAPP1_BACKGROUND("sapp1_background", "/assets/sample_app_1/background.jpg"),
	SAPP1_RIDER_BANNER("sapp1_rider_banner", "/assets/sample_app_1/rider_banner.jpg");
	
	String name, filepath;
	
	Material(String name, String filepath) {
		this.name=name;
		this.filepath=filepath;
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return filepath;
	}


}
