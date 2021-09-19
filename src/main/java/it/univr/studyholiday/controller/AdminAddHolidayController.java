package it.univr.studyholiday.controller;

public class AdminAddHolidayController {
    //DB TABLE HOLIDAY(-id-, startdate, weeks, language, college)
    //CLASS Holiday(String language, LocalDate departureDate, int weeks, College college)
    //
    // ACTION > SELECT COLLEGE FROM LIST OF COLLEGES IN DATABASE
    // INSTRUCTIONS > "Seleziona il college per la vacanza. Se non è presente nella lista, tornare al menu principale e selezionare AGGIUNGI COLLEGE"
    // [DROP LIST WITH COLLEGES FROM DATABASE METHOD: College.getAll() returns ArrayList]
    //
    // ACTION > FILL FORM:
    //      DATEPICKER - Partenza
    //      NUMBER - Numero di settimane
    //
    //
    // ACTION > ADD FIELDTRIPS, AT LEAST ONE, can save multiple. when button save is pressed
    //          fieldtrip is added to an arraylist and n++.
    // INSTRUCTIONS > "Aggiungi almeno una gita per questa vacanza"
    // MESSAGE > "n gite salvate"
    //      TEXT - Destinazione
    //      INTEGER - Prezzo
    //      INTEGER - Ore
    //      TEXT -Descrizione
    //      BUTTON SAVE
    //
    // ACTION > ADD SURVEY QUESTIONS OPTIONAL
    // INSTRUCTIONS "Il questionario di default è composto di un commento e un voto."
    //              "Se vuoi aggiungere qui delle domande specifiche, fallo qui:"
    // TEXT - domanda
    //
    //
    //  CONFERMA E SALVA
    // il viaggio viene creato e salvato in database
}
