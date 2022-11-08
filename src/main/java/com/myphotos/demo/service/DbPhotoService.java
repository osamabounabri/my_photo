package com.myphotos.demo.service;

import com.myphotos.demo.model.Photo;
import com.myphotos.demo.repository.IPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("mainPhotoService")
public class DbPhotoService implements IPhotoService{

    @Autowired
    private IPhotoRepository iPhotoRepository;

    @Override
    public Iterable<Photo> getAll(){
        return iPhotoRepository.findAll();
    }

    @Override
    public Optional<Photo> getById(int id){

        return iPhotoRepository.findById(id);

    }

    @Override
    public Photo create(Photo photo){

        return iPhotoRepository.save(photo);

    }

    @Override
    public Optional<Photo> update(int id, Photo photo){

         Optional<Photo> foundPhoto = iPhotoRepository.findById(id);

         if(!foundPhoto.isPresent()){

             return Optional.empty();

         }

         foundPhoto.get().setUrl(photo.getUrl());
         iPhotoRepository.save(foundPhoto.get());

         return foundPhoto;

    }

    @Override
    public Boolean delete(int id){

        Optional<Photo> foundPhoto = iPhotoRepository.findById(id);

        if(!foundPhoto.isPresent()){

            return false;

        }

        iPhotoRepository.delete(foundPhoto.get());
        return true;

    }

}
