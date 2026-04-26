# Trivia applicatie (backend)

Deze applicatie is gemaakt op basis van de [trivia API](https://opentdb.com/).  
Het probleem met die API is dat het niet alleen leuke triva vragen levert, maar ook direct de goede antwoorden er bij.  
Een slimme gebruiker kan op die manier erg makkelijk valsspelen.  

De Trivia Applicatie biedt daar een oplossing voor.  

## Links
- [frontend](https://github.com/MRensen/quad-frontend)
- [website](https://trivia-frontend-vtg86.ondigitalocean.app/)

## Endpoints
De applicatie biedt twee endpoints:

| Endpoint           | Beschrijving                                                                                         | Input                                                            | Output                                                              |
|--------------------|------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|---------------------------------------------------------------------|
| GET /questions     | Via dit endpoint kan de gebruiker vragen ophalen met de antwoord mogelijkheden                       | **Type: Parameter** (optioneel) <br/>amount (hoeveelheid vragen) | List<id, type,  difficulty,  category,  question,  List\<answers\>> |
| POST /checkanswers | Via dit endpoint kan de gebruiker de gegeven antwoorden controleren op basis van het id van de vraag | **Type: Body** <br/>List<id, antwoord>                                | List<id, boolean>                                                   |
|                    |                                                                                                      |                                                                  |                                                                     |

## Installatiehandleiding

De makkelijkste manier om deze Trivia App te gebruiken, is via de [website](https://trivia-frontend-vtg86.ondigitalocean.app/).  
Deze paragraaf zal uitleggen hoe je het lokaal kunt draaien.  

### Download de backend en de frontend
- `git clone https://github.com/MRensen/quad-backend`
- `git clone https://github.com/MRensen/quad-frontend`

### Run de backend in de backend root-map
- `mvn spring-boot run`

### Run de frontend in de frontend root-map
- `mvn run dev`

### Belangrijk
In de frontend staat een `.env` bestand met de juiste waarde er in voor een local deploy. 
Dit is geen best-practice, maar omdat er geen geheimen in staan en om het je makkelijk te maken, 
staat dit bestand vast voor je klaar.