package com.myphotos.demo.service;

import com.myphotos.demo.model.Photo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService implements IPhotoService{


    private List<Photo> photoList;
    private int lastId;

    public PhotoService(){

        photoList = new ArrayList<>();

        photoList.add(new Photo(1, "./img/01.png"));
        photoList.add(new Photo(2, "./img/02.png"));
        photoList.add(new Photo(3, "./img/03.png"));

        lastId = 3;

    }

    @Override
    public Iterable<Photo> getAll(){
        return photoList;
    }

    @Override
    public Optional<Photo> getById(int id){

        Optional<Photo> photo = photoList.stream().filter(item -> item.getId() == id ).findFirst();

        return photo;

    }

    @Override
    public Photo create(Photo photo){

        lastId++;

        photo.setId(lastId);

        photoList.add(photo);

        return photo;

    }

    @Override
    public Optional<Photo> update(int id, Photo photo){

        Optional<Photo> foundPhoto = photoList.stream().filter(item -> item.getId() == id).findFirst();

        if(!foundPhoto.isPresent()){

            return Optional.empty();

        }

        foundPhoto.get().setUrl(photo.getUrl());

        return foundPhoto;

    }

    @Override
    public Boolean delete(int id){

        Optional<Photo> foundPhoto = photoList.stream().filter(item -> item.getId() == id).findFirst();

        if(!foundPhoto.isPresent()){

            return false;

        }

        photoList.remove(foundPhoto.get());

        return true;

    }

}
