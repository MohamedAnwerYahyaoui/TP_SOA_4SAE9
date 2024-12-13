# TP_SOA_4SAE9

## Application RESTful avec JAX-RS et JWT

### Informations personnelles
- **Nom :** Yahyaoui  
- **Prénom :** Mohamed Anwer  
- **Classe :** 4SAE9  

---

## Description

Cette application est une API RESTful construite avec **JAX-RS** (Java API for RESTful Web Services). Elle permet la gestion des rendez-vous et des logements tout en incluant un système d'authentification basé sur des **JSON Web Tokens (JWT)**. 

Elle offre plusieurs points d'accès pour interagir avec des entités comme les rendez-vous et les logements, tout en garantissant la sécurité des opérations via l'authentification et la gestion des permissions.

---

## Fonctionnalités principales

### Gestion des rendez-vous
- **Ajouter un rendez-vous**
- **Récupérer un rendez-vous** par ID ou par référence
- **Mettre à jour un rendez-vous**
- **Supprimer un rendez-vous**
- **Lister tous les rendez-vous**

### Gestion des logements
- **Ajouter un logement**
- **Récupérer tous les logements**
- **Rechercher des logements** par délégation ou par référence
- **Mettre à jour un logement**
- **Supprimer un logement**
  ### Authentification avec JWT
- **Authentifier un utilisateur** avec un nom d'utilisateur et un mot de passe
- **Générer un jeton JWT** pour l'utilisateur authentifié
- **Protéger les ressources sensibles** avec des annotations de sécurité

---

## Structure de l'application

### Contrôleurs principaux

#### RendezVousController
- **URL de base :** `/api/RDV`
- Gère les opérations CRUD (Create, Read, Update, Delete) pour les rendez-vous.
- **Exemples d'endpoints :**
  - `POST /addRDV` : Ajouter un rendez-vous
  - `GET /getAllRDV` : Récupérer tous les rendez-vous

#### LogementController
- **URL de base :** `/api/log`
- Gère les opérations CRUD pour les logements.
- **Exemples d'endpoints :**
  - `POST /addLog` : Ajouter un logement
  - `GET /getAllLog` : Récupérer tous les logements

#### AuthenticationEndPoint
- **URL de base :** `/api/authentication`
- Gère l'authentification et la génération de jetons JWT.
- **Exemple d'endpoint :**
  - `POST /` : Authentifier un utilisateur et retourner un JWT

---
## Configuration de l'application

- **Point d'accès global :** `/api` (défini dans la classe `RestActivator`)
- **Annotations :** Les ressources REST sont configurées avec des annotations JAX-RS comme `@Path`, `@GET`, `@POST`, `@PUT`, et `@DELETE`.
- **Sécurité :** La classe `Secured` est utilisée pour restreindre l'accès à certaines routes.

---

## Bibliothèques

- **JAX-RS** pour la création des services REST
- **io.jsonwebtoken** pour la gestion des JWT

---

## Utilisation

1. **Authentifiez-vous** via l'endpoint `/api/authentication` pour obtenir un JWT.
2. **Utilisez le JWT** obtenu dans l'en-tête `Authorization` pour accéder aux ressources sécurisées.
3. **Interagissez avec les différents endpoints** pour gérer les rendez-vous et les logements.

---
