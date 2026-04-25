# Trivia applicatie (backend)

Deze applicatie is gemaakt op basis van de [trivia API](https://opentdb.com/).  
Het probleem met die API is dat het niet alleen leuke triva vragen levert, maar ook direct de goede antwoorden er bij.  
Een slimme gebruiker kan op die manier erg makkelijk vals spelen.  

De Trivia Applicatie biedt daar een oplossing voor.  

## Links
- [frontend](https://github.com/MRensen/quad-frontend)
- [website]()

## Endpoints
De applicatie biedt twee endpoints:

| Endpoint           | Beschrijving                                                                                         | Input                                 | Output                                                                                               |
|--------------------|------------------------------------------------------------------------------------------------------|---------------------------------------|------------------------------------------------------------------------------------------------------|
| GET /questions     | Via dit endpoint kan de gebruiker vragen ophalen met de antwoord mogelijkheden                       | optioneel: amount (hoveelheid vragen) | List<<br/>id, <br/>type, <br/> difficulty, <br/> category, <br/> question, <br/> List<answers><br/>> |
| POST /checkanswers | Via dit endpoint kan de gebruiker de gegeven antwoorden controleren op basis van het id van de vraag | List<<br/>id, <br/>antwoord<br/>>     | List<<br/>id, <br/>boolean<br/>>                                                                     |
|                    |                                                                                                      |                                       |                                                                                                      |

