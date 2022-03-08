package com.rvmagrini.springboot.controllers;

import com.rvmagrini.springboot.models.Speaker;
import com.rvmagrini.springboot.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getSpeakers() {
        return speakerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable Long id) {
        return speakerRepository.getById(id);
    }

    @PostMapping
    public Speaker createSpeaker(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping("/{id}")
    public void deleteSpeaker(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker) {
        // TODO: validate that all attributes were passed in, otherwise return 400 bad request
        Speaker existingSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

}
