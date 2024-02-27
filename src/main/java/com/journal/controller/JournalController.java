package com.journal.controller;

import com.journal.entity.Journal;
import com.journal.services.JournalServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalServices journalServices;

    @GetMapping
    public List<Journal> getAllJournals() {
        return journalServices.getAllJournals();
    }

    @PostMapping("/{username}")
    public Journal createJournal(@RequestBody Journal journal, @PathVariable String username) {
        journalServices.createJournal(journal, username);
        return journal;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable ObjectId id) {
        Optional<Journal> journal = journalServices.getJournalById(id);
        if(journal.isPresent()) {
            return new ResponseEntity<Journal>(journal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{username}/{id}")
    public void deleteJournal(@PathVariable ObjectId id, @PathVariable String username) {
        journalServices.deleteJournal(id, username);
    }
}
