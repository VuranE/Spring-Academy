package hr.tis.academy.controller;

import hr.tis.academy.dto.JournalAttractionDto;
import hr.tis.academy.dto.TravelJournalDto;
import hr.tis.academy.dto.TravelJournalPatchDto;
import hr.tis.academy.mapper.JournalMapper;
import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.JournalAttraction;
import hr.tis.academy.model.TravelJournal;
import hr.tis.academy.repository.UserRepository;
import hr.tis.academy.repository.exception.InputIsNullException;
import hr.tis.academy.repository.exception.WrongInputException;
import hr.tis.academy.service.AttractionService;
import hr.tis.academy.service.TravelJournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel-journal")
public class TravelJournalController {
    private final TravelJournalService travelJournalService;
    private final AttractionService attractionService;
    private final UserRepository userRepository;

    public TravelJournalController(TravelJournalService travelJournalService, AttractionService attractionService, UserRepository userRepository) {
        this.travelJournalService = travelJournalService;
        this.attractionService = attractionService;
        this.userRepository = userRepository;
    }


    @PostMapping("/{userId}")
    public ResponseEntity<HttpStatus> createJournal(@PathVariable Long userId, @RequestBody TravelJournalDto travelJournalDto) {

        for(JournalAttractionDto journalAttractionDto : travelJournalDto.getAttractions()){
            if(attractionService.fetchAttractionByAttractionName(journalAttractionDto.getAttraction()) == null ){
                //posalji kod 400
                throw new WrongInputException("Atrakcija ne postoji");
            }
        }

        //napravi journal u bazi
        AppUser user = userRepository.findAppUserByIdJPQL(userId);
        travelJournalDto.setAppUser(user);
        Long newJournalId = travelJournalService.createJournal(JournalMapper.INSTANCE.dtoToClass(travelJournalDto)); //MAPPER
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/travel-journal/" + newJournalId).build();
    }

    @GetMapping("/{travelJournalId}")
    public ResponseEntity<TravelJournal> fetchJournal(@PathVariable Long travelJournalId)
    {
        TravelJournal travelJournal = travelJournalService.fetchJournalById(travelJournalId);
        if(travelJournal == null)
        {
            throw new InputIsNullException("Putopis ne postoji");
        }
        return ResponseEntity.ok().body(travelJournal);
    }

    @PatchMapping("/{travelJournalId}")
    public ResponseEntity<HttpStatus> patchJournal(@PathVariable Long travelJournalId, @RequestBody TravelJournalPatchDto travelJournalPatchDto)
    {
        TravelJournal travelJournal = travelJournalService.fetchJournalById(travelJournalId);

        if(travelJournal == null)
        {
            throw new InputIsNullException("Putopis ne postoji");
        }

        if(travelJournal.getEndDate() == null)
        {
            travelJournal.setEndDate(travelJournalPatchDto.getEndDate());
        }
        if(!travelJournal.getDescription().equals(travelJournalPatchDto.getDescription()))
        {
            travelJournal.setDescription(travelJournalPatchDto.getDescription());
        }

        travelJournal.getAttractions().add(travelJournalPatchDto.getJournalAttraction());

        travelJournalService.createJournal(travelJournal);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
