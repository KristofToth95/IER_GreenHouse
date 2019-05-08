// Agent Ontozo in project GreenHouse.mas2j

/* Initial beliefs and rules */



/* Initial goals */

!ontozesrevar.


/* Plans */

+!ontozesrevar : ontoz <- .print("Ontozes");.wait(1000);ontozes;.abolish(ontoz);!ontozesrevar.
+!ontozesrevar: true <- .wait(1000);!ontozesrevar.
-!ontozesrevar <- !ontozesrevar.
