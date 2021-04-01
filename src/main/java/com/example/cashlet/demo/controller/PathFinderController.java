package com.example.cashlet.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.cashlet.demo.model.PiratePath;
import com.example.cashlet.demo.model.PirateMap;
import com.example.cashlet.demo.service.PathFinderService;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;



@RestController
@RequestMapping(value="/",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public class PathFinderController{

    @Autowired
    PathFinderService service;

    private List<List<PirateMap>> map = new ArrayList<>();

    @RequestMapping(path="map",method = RequestMethod.POST)
	public ResponseEntity<List<List<PirateMap>>> mapData(@RequestBody List<List<PirateMap>> list){   
        this.map = list;
        return new ResponseEntity<List<List<PirateMap>>>(list,HttpStatus.OK);
	}

    @RequestMapping(path="findPath",method = RequestMethod.GET)
	public ResponseEntity<PiratePath> findPath( @RequestParam int startXPosition,
    @RequestParam int startYPosition,
    @RequestParam int targetXPosition,
    @RequestParam int targetYPosition)
	{   
		
        PiratePath path = service.findPath(map, startXPosition, startYPosition, targetXPosition, targetYPosition);
        if(path.coins == 0){
            return new ResponseEntity<PiratePath>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<PiratePath>(path,HttpStatus.OK);
	}

}


