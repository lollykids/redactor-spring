package com.github.dybskiy.redactor.model;

public class RedactorImage {

	private String thumb;
	private String image;
	private String title;
	private String folder;

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	@Override
	public String toString() {
		return "Image [thumb=" + thumb + ", image=" + image + ", title=" + title + ", folder=" + folder + "]";
	}

	
}
