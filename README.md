# Projet tondeuse-kata

## Description

Le projet tondeuse-kata consiste à réaliser un programme ne Java qui implémente des tondeuse automatique.
Le but étant que les tondeuses parcourt une suite d'instruction prédéfinie sur une surface de rectangle prédéfinie.  

La description précise du kata avec les pré-requis et les attendus se trouve dans le fichier Tondeuse.pdf dans le répertoires "ressources".

## Démarche d'implémentation

Pour réaliser ce Kata j'ai choisi l'approche TDD(Test Driven Development). Cette approche permet d'avoir plus de fiabilité, de détecter les problèmes rapidement et de concevoir de manière itérative notre code.  
L'approche TDD suit généralement un cycle dit "Red-Green-Fecator", on écrit un test unitaire qui échoue (RED), on implémente ensuite le minimun requis pour que le test passe (VERT),puis on réaorganise et améliore le code sans changer le comportement (REFACTOR).  

J'ai donc commencer par créer une classe nommé Test en important la librairie Junit permettant de réaliser des TestUnitaires dans l'arborescence src/test/java.  

### Etape RED

Dans celle-ci j'ai créer un méthode permettant de récupérer la position d'une tondeuse ( cette fonctionnalité me paraissait être la plus importante). J'ai nommé cette méthode "shouldReturn12NWhengetPosition", cette méthode devait s'assurer qu'en appelant une méthode appelée getPosition d'une objet préconstruit on obtenait le retour chaine de caractère suivant "1 2 N".  
En lançant cette méthode nous avons obtenu du rouge (RED) -->ClassNotFoundException.  

### Etape GREEN
J'ai ensuite fait en sorte que cette méthode renvoie du vert puis renvoie le résultat attendu :  
création d'une classe tondeuse avec ses attributs et un premier constructeur  
création de la méthode getPosition

### Etape REFACTOR

J'ai ensuite réorganiser le code de la classe tondeuse puis renommé le nom de la classe de test de manière plus parlante TondeuseTest.  



Une fois la première méthode effectuée, je suis ensuite passé à une autre fonctionnalité "shouldReturn12WWhenPivoterGaucheé en opérant avec l'approche TDD et ainsi de suite pour les autres fonctionnalités.   
  
J'ai effectué tout ça jusqu'à obtenir le résultat attendu en lançant le programme java avec le fichier fourni en entrée, on obtient bien le résultat attendu et la bonne position pour les 2 tondeuses.


## Conclusion

En choisissant cette approche TDD je m'assure que le code est est couvert ( environ 90% de couverture) et qu'il répond aux différentes fonctionnalités attendues.

