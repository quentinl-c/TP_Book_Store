# TP Book Store

## Book Store 📚

### Setup

* Créer un nouveau projet web dynamique
* Copier les sources
* Vérifier les informations du `persistence.xml` notamment le :
```xml
 <jta-data-source>... </jta-data-source>
 ```
* En exécutant le serveur une première fois, la table `books` devrait se créer. Vous pouvez également la créer de cette manière :
```sql
CREATE TABLE IF NOT EXISTS books(
isbn VARCHAR(255) NOT NULL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
author VARCHAR(255) NOT NULL,
price DOUBLE NOT NULL);
```
* Pour peupler la table, vous pouvez utiliser ces commandes :
```sql
INSERT INTO books (isbn, title, author, price) VALUES ('2221203321', 'La Servante écarlate', 'Margaret Atwood', 11.5);
INSERT INTO books (isbn, title, author, price) VALUES ('2266258966', 'La Magie du rangement', 'Marie Kondo', 6.95);
INSERT INTO books (isbn, title, author, price) VALUES ('143022889X', 'Beginning Java EE 6 with GlassFish 3', 'Antonio Goncalves', 43.91);
```
* Vérifier que tout fonctionne en vous rendant sur `/welcome`

### Consignes

* Intégrer une autre nouvelle fonctionnalité : la création d'une facture dans la BD à la fin du checkout
  * Compléter l'entité `LineItem` qui référence des entités `Book`
    * Quel est le type de la relation entre l'entité  `LineItem` et l'entité `Book` ?
    * Implanter cette relation
    * Les champs ne doivent pas être `null`
    * N'oubliez pas de déclarer la classe dans le `persistence.xml`
  * Compléter l'entité `Invoice` qui contient des entités `LineItem`
    * Quel est le type de la relation entre l'entité  `Invoice` et l'entité `LineItem` ?
    * Implanter cette relation
    * Les champs ne doivent pas être `null`
    * N'oubliez pas de déclarer la classe dans le `persistence.xml`
  * Créer un EJB `@Stateless` `InvoiceDAOImpl` qui implante `InvoiceDAO` 
  * Compléter la servlet `ProcessInvoice.java` qui enregistrer le panier comme facture en BD
  * Compléter la page de remerciement pour y intégrer les informations sur l'achat (cf. `[]` )
