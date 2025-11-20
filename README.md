# Activité 2.1 : Calculatrice Client/Serveur via Sockets TCP

## 📋 Description
Cette activité vise à améliorer l'application Client/Serveur (développée précédemment) pour dépasser la limitation de l'échange d'un seul octet. 

L'objectif est de permettre l'échange de chaînes de caractères complètes afin de réaliser une **calculatrice basique**. Le client envoie une opération formatée (ex: "55 * 25") et le serveur parse cette chaîne, effectue le calcul et renvoie le résultat.

## 🛠️ Architecture
Le projet est organisé en deux packages :

1.  **`serverPackage`** :
    *   **`Server`** : Écoute sur le port 1234. Il reçoit la chaîne de caractères, la découpe (parsing), exécute l'opération mathématique et renvoie le résultat.
2.  **`clientPackage`** :
    *   **`Client`** : Récupère les saisies utilisateur (entiers et opérateur), effectue une validation locale de l'opérateur, concatène la requête et l'envoie au serveur.

## ⚙️ Fonctionnalités Techniques

*   **Flux de Caractères** : Utilisation des classes de traitement de flux de texte pour échanger des commandes complexes :
    *   `PrintWriter` (Côté Client) pour envoyer la chaîne formatée.
    *   `BufferedReader` et `InputStreamReader` (Côté Serveur) pour lire la ligne entière envoyée.
*   **Parsing de Données** : Le serveur utilise la méthode `split(" ")` pour séparer les opérandes de l'opérateur.
*   **Validation** : Le client vérifie que l'opérateur saisi est valide (+, -, *, /) avant l'envoi.

## 🚀 Prérequis
*   Java JDK 8 ou supérieur.
*   Port **1234** disponible.

## ▶️ Instructions d'Exécution

### 1. Démarrer le Serveur
Exécutez la classe `serverPackage.Server`.
> **Console Serveur :**
> `Je suis un serveur en attente la connexion d'un client`

### 2. Démarrer le Client
Exécutez la classe `clientPackage.Client`. Suivez les instructions affichées :

1.  Saisissez le premier entier.
2.  Saisissez l'opérateur (le programme bouclera tant que l'opérateur n'est pas valide).
3.  Saisissez le deuxième entier.

> **Exemple d'interaction Client :**
> ```text
> donner entier 1: 10
> donner l'opérateur: +
> donner entier 2: 20
> la resultat=30
> ```

> **Sortie correspondante sur le Serveur :**
> ```text
> un client est connecté
> Addition : 10 + 20 = 30
> ```

## ⚠️ Note Technique
Dans cette version, le serveur renvoie le résultat via `os.write(res)`. Cela envoie le résultat sous forme d'octet/entier brut. Le client le lit avec `is.read()`. 
*Note : Cette méthode fonctionne parfaitement pour des résultats simples, mais pourrait nécessiter une adaptation (flux d'objets ou DataStream) pour des grands nombres ou des nombres décimaux.*

