package com.player.controller;

import com.player.model.artists.ArtistDto;
import com.player.model.artists.Artists;
import com.player.service.artists.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mykola_Zalyayev
 */
@Controller
@RequestMapping(value = "/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ArtistDto addArtist(@RequestBody ArtistDto artistDto) {
        return artistService.addArtist(artistDto);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Artists getAllArtists() {
        Artists artists = new Artists();
        artists.setArtistDtos(artistService.getAllArtists());
        return artists;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArtistDto getArtistById(@PathVariable Integer id) {
        return artistService.getArtistById(id);
    }
}