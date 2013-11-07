package com.github.dybskiy.redactor.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.github.dybskiy.redactor.model.RedactorImage;
import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.photos.Photo;
import com.googlecode.flickrjandroid.photos.PhotoList;
import com.googlecode.flickrjandroid.photosets.Photoset;
import com.googlecode.flickrjandroid.photosets.Photosets;
import com.googlecode.flickrjandroid.photosets.PhotosetsInterface;

@Service
public class RedactorService {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object data() {
		Flickr f = new Flickr("02747b875273bddcaf425bb0394862b8");
		PhotosetsInterface photosetsInterface = f.getPhotosetsInterface();
		Photosets photosets;
		List images = new ArrayList();
		try {
			photosets = photosetsInterface.getList("66956608@N06");
			for (Photoset photoset : photosets.getPhotosets()) {
				Photoset photos = photosetsInterface.getPhotos(photoset.getId(), 100, 1);
				RedactorImage image = new RedactorImage();
				image.setFolder(photos.getTitle());
				image.setTitle(photos.getTitle());
				PhotoList photoList = photos.getPhotoList();
				for (Photo photo : photoList) {
					image.setThumb(photo.getSmallUrl());
					image.setImage(photo.getOriginalUrl());
					images.add(image);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FlickrException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return images;
	}
}
