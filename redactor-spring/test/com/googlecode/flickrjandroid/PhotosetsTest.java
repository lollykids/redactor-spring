package com.googlecode.flickrjandroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 

import org.json.JSONException;

import com.github.dybskiy.redactor.model.RedactorImage;
import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.photos.Photo;
import com.googlecode.flickrjandroid.photos.PhotoList;
import com.googlecode.flickrjandroid.photosets.Photoset;
import com.googlecode.flickrjandroid.photosets.Photosets;
import com.googlecode.flickrjandroid.photosets.PhotosetsInterface;

public class PhotosetsTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException, FlickrException, JSONException {
		Flickr f = new Flickr("02747b875273bddcaf425bb0394862b8");
		PhotosetsInterface photosetsInterface = f.getPhotosetsInterface();
		Photosets photosets = photosetsInterface.getList("66956608@N06");
		List images = new ArrayList();
		for (Photoset photoset : photosets.getPhotosets()) {
			Photoset photos = photosetsInterface.getPhotos(photoset.getId(), 100, 1);
			RedactorImage image = new RedactorImage();
			image.setFolder(photos.getTitle());
			image.setTitle(photos.getTitle());
			System.out.println(photos);
			PhotoList photoList = photos.getPhotoList();
			for (Photo photo : photoList) {
				image.setThumb(photo.getSmallUrl());
				image.setImage(photo.getOriginalUrl());
				images.add(image);
			}
		}
		System.out.println(images);
	}
}
