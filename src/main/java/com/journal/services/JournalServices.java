package com.journal.services;

import com.journal.entity.Journal;
import com.journal.entity.User;
import com.journal.repositry.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JournalServices {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;

    public ArrayList<Journal> getAllJournals() {

        return (ArrayList<Journal>) journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId id) {

        return journalRepository.findById(id);
    }

    @Transactional
    public void createJournal(Journal journal, String username) {
        User user = userService.getUserByUsername(username);
        Journal saved = journalRepository.save(journal);
        user.getJournalEntries().add(saved);
        userService.createUser(user);
    }

    public void deleteJournal(ObjectId id, String username) {
        User user = userService.getUserByUsername(username);
        user.getJournalEntries().removeIf(journal -> journal.getId().equals(id));
        journalRepository.deleteById(id);
        userService.createUser(user);
    }
}
