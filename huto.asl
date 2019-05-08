// Agent Huto in project GreenHouse.mas2j

/* Initial beliefs and rules */



/* Initial goals */

!hutesrevar.


/* Plans */

+!hutesrevar : hut <- .print("Hutes");hutes;.abolish(hut);!hutesrevar.
+!hutesrevar: true <- .wait(1000);!hutesrevar.
-!hutesrevar <- !hutesrevar.
