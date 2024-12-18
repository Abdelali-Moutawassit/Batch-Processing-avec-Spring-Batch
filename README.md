# Spring Batch - Traitement des Commandes

## Description
Ce projet implémente un job **Spring Batch** qui traite des commandes en :
1. Lisant un fichier CSV contenant une liste de commandes (commande, client, montant).
2. Appliquant une remise de 10 % sur le montant de chaque commande.
3. Insérant les commandes mises à jour dans une base de données **HSQLDB**.

---

## Fonctionnalités
- Lecture des commandes depuis un fichier CSV.
- Application de transformations sur les données.
- Persistance des données transformées dans une base de données.
- Affichage des résultats des données insérées en fin de traitement.

---

## Structure du Projet
Le projet est organisé comme suit :
```
src/main/java/
├── com/example/batch/
│   ├── BatchConfiguration.java
│   ├── JobCompletionNotificationListener.java
│   ├── Order.java
│   ├── OrderItemProcessor.java
├── resources/
│   ├── application.properties
│   ├── orders.csv
```

---

## Pré-requis
- **Java** 11 ou supérieur
- **Maven** 3.x ou supérieur
- IDE compatible avec Spring (IntelliJ, Eclipse)

---

## Fichier CSV
Le fichier `orders.csv` contient les commandes à traiter avec le format suivant :
```
orderId,customerName,amount
1,John Doe,200
2,Jane Smith,150
3,Bob Johnson,300
4,Alice Williams,400
5,Mary Brown,500
```

---

## Configuration de l'Application
### application.properties
Le fichier `application.properties` configure la base de données HSQLDB ainsi que Spring Batch :
```properties
# HSQLDB Configuration
spring.datasource.url=jdbc:hsqldb:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.hsqldb.jdbc.JDBCDriver

# Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Spring Batch
spring.batch.initialize-schema=always
```

---

## Étapes Principales
### 1. Configuration Batch
Le fichier `BatchConfiguration.java` contient la configuration principale :
- **Lecteur** (`FlatFileItemReader`) pour lire les données CSV.
- **Processeur** (`OrderItemProcessor`) pour transformer les données.
- **Écrivain** (`JdbcBatchItemWriter`) pour insérer dans la base de données.

### 2. Processeur
Le processeur `OrderItemProcessor.java` applique une remise de 10 % sur le montant.

### 3. Notification
Le listener `JobCompletionNotificationListener.java` affiche les commandes insérées après la complétion du job.

---

## Exécution
1. Cloner le projet.
2. Créer le fichier `orders.csv` dans `src/main/resources`.
3. Lancer l'application via votre IDE ou en ligne de commande :
   ```bash
   mvn spring-boot:run
   ```
4. Les commandes insérées seront affichées dans la console.

---

## Auteur
 ADELALI MOUTAWASSIT
---
