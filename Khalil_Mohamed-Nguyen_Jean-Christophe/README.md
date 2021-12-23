# Zoo
Projet Java Gestion de ZOO (Module Algorithmique et UML - Mickaël Martin-Nevot)
Auteur : Nguyen Jean Christophe, Khalil Mohamed

# Contenu Archive
Vous trouverais dans cette archive :
- un dossier Documents regroupant toute la documentation/Diagram demander.
- un Dossier doc Contenant la JavaDoc.
- un dossier Projet_Zoo contenant le dossier src ( code du projet ) et bin.
- un executable Zoo.jar pour pouvoir lancer la simulation.

# Informations

Pour lancer l'application Zoo.jar.

Il faut donc aller dans le répertoire de l'application et faire la commande suivante :

```java -jar Zoo.jar```

# Attention

Il est vivement conseiller de lancer la simulation depuis eclipse concernant la simulation Loups,
car l'encodage de windows ne permet pas l'affichage des caracteres spéciaux et seront donc remplacer 
par des "?".

Une soslution serait de changer l'encodage des fichier de windows via cette ligne de commande 
dans le temrinal windows :
``System.setProperty("file.encoding", "UTF-8")``

Assurer vous egalement que eclipse soit sous encodage UTF-8.
Pour faire cela ouvrez le projet dans eclipse et faites clic droit sur le dossier racine -> aller dans ``Properties`` -> Text file encoding choisir others -> UTF-8

Sur Ubuntu, normalement il y aura pas de problèmes de caracteres spéciaux.
