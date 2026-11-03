# Booking System

Un'API REST per la gestione delle prenotazioni alberghiere, sviluppata con **Java e Spring Boot**.

Il progetto nasce con l'obiettivo di mettere in pratica e approfondire le competenze nello sviluppo backend, attraverso la realizzazione di un sistema che permette agli utenti di consultare le camere disponibili, effettuare prenotazioni e gestire le proprie prenotazioni.

Gli amministratori possono invece gestire le camere e monitorare tutte le prenotazioni effettuate.

## Tecnologie utilizzate

- **Java 21** – Linguaggio di programmazione.
- **Spring Boot** – Framework per lo sviluppo backend.
- **Spring Web** – Creazione delle API REST.
- **Spring Data JPA** – Gestione delle entità e accesso al database.
- **Spring Security** – Gestione dell'autenticazione e delle autorizzazioni.
- **JWT** – Autenticazione tramite token.
- **MySQL 8** – Database relazionale.
- **Maven** – Gestione delle dipendenze e compilazione.
- **Bruno** – Test delle API REST.
- **JUnit 5 e Mockito** – Test automatici.

## Funzionalità previste

### Autenticazione e gestione degli utenti (Authentication)

- Registrazione di nuovi utenti.
- Login tramite email e password.
- Autenticazione tramite JWT.
- Gestione dei ruoli (USER e ADMIN).
- Visualizzazione delle informazioni del proprio account.

### Gestione delle camere (Room Management)

- Creazione di nuove camere.
- Visualizzazione di tutte le camere.
- Ricerca di una camera tramite ID.
- Modifica delle informazioni di una camera.
- Eliminazione o disattivazione di una camera.
- Gestione delle tipologie di camere (SINGLE, DOUBLE, SUITE).

### Gestione delle prenotazioni (Booking Management)

- Creazione di nuove prenotazioni.
- Visualizzazione delle proprie prenotazioni.
- Ricerca di una prenotazione tramite ID.
- Cancellazione delle prenotazioni.
- Gestione dello stato delle prenotazioni.
- Visualizzazione di tutte le prenotazioni da parte degli amministratori.

### Ricerca delle disponibilità (Availability)

- Ricerca delle camere disponibili in base alle date di check-in e check-out.
- Verifica della disponibilità delle camere.
- Controllo della sovrapposizione tra prenotazioni.
- Verifica della capacità massima delle camere.

## Struttura del database

Il database è composto da cinque tabelle principali:

| Tabella | Descrizione |
|---|---|
| users | Informazioni degli utenti registrati |
| roles | Ruoli disponibili nel sistema |
| user_roles | Relazione tra utenti e ruoli |
| rooms | Informazioni sulle camere |
| bookings | Informazioni sulle prenotazioni |

### Relazioni

- Un utente può effettuare più prenotazioni (One-to-Many).
- Una camera può essere associata a più prenotazioni in periodi differenti (One-to-Many).
- Un utente può avere più ruoli e un ruolo può essere assegnato a più utenti (Many-to-Many).

## Architettura del progetto

L'applicazione segue un'architettura a livelli (Layered Architecture).

```text
src/main/java/com/example/booking/
│
├── config/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── security/
├── exception/
└── BookingApplication.java
```

### Responsabilità dei livelli

- **Controller:** gestione delle richieste HTTP e delle risposte.
- **Service:** implementazione della logica applicativa.
- **Repository:** accesso e gestione dei dati nel database.
- **Entity:** rappresentazione delle tabelle del database.
- **DTO:** gestione dei dati in ingresso e in uscita.
- **Security:** configurazione della sicurezza e autenticazione.
- **Config:** configurazioni generali dell'applicazione.
- **Exception:** gestione centralizzata degli errori.

## API REST

### Authentication API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| POST | `/api/auth/register` | Registra un nuovo utente |
| POST | `/api/auth/login` | Effettua il login |

### User API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| GET | `/api/users/me` | Recupera le informazioni dell'utente autenticato |
| GET | `/api/users` | Recupera tutti gli utenti (ADMIN) |
| GET | `/api/users/{id}` | Recupera un utente tramite ID (ADMIN) |

### Room API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| POST | `/api/rooms` | Crea una nuova camera (ADMIN) |
| GET | `/api/rooms` | Recupera tutte le camere |
| GET | `/api/rooms/{id}` | Recupera una camera tramite ID |
| PUT | `/api/rooms/{id}` | Modifica una camera (ADMIN) |
| PATCH | `/api/rooms/{id}/availability` | Modifica la disponibilità di una camera (ADMIN) |
| DELETE | `/api/rooms/{id}` | Elimina una camera (ADMIN) |

### Booking API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| POST | `/api/bookings` | Crea una nuova prenotazione |
| GET | `/api/bookings/my` | Recupera le proprie prenotazioni |
| GET | `/api/bookings/{id}` | Recupera una prenotazione tramite ID |
| PATCH | `/api/bookings/{id}/cancel` | Cancella una prenotazione |
| GET | `/api/bookings` | Recupera tutte le prenotazioni (ADMIN) |
| PATCH | `/api/bookings/{id}/status` | Modifica lo stato di una prenotazione (ADMIN) |

### Availability API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| GET | `/api/rooms/available` | Cerca le camere disponibili in base alle date e al numero di ospiti |
