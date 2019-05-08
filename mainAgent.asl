// Agent water in project GreenHouse.mas2j



/* Initial beliefs and rules */



/* Initial goals */



!wait.


/* Plans */

+!wait : futes <- .wait(1000);.send(futo,tell,fut);.abolish(futes);!wait.
+!wait : hutes <- .wait(1000);.send(huto,tell,hut);.abolish(hutes);!wait.
+!wait : riasztas <- .wait(1000);.send(riaszto,tell,riaszt);.abolish(riasztas);!wait.
+!wait : ontozes <- .send(ontozo,tell,ontoz);.abolish(ontozes);!wait.
+!wait : true <- .wait(1000);!wait.
-!wait <- !wait.


