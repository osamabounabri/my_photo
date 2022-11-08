package com.myphotos.demo.service;

import com.myphotos.demo.model.Photo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface IPhotoService {


    public Iterable<Photo> getAll();

    public Optional<Photo> getById(int id);

    public Photo create(Photo photo);

    public Optional<Photo> update(int id, Photo photo);

    public Boolean delete(int id);

}
