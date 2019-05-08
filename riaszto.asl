// Agent Riaszto in project GreenHouse.mas2j

/* Initial beliefs and rules */



/* Initial goals */

!riasztasravar.


/* Plans */

+!riasztasravar : riaszt <- .print("Riasztas");riasztas;.abolish(riaszt);!riasztasravar.
+!riasztasravar: true <- .wait(1000);!riasztasravar.
-!riasztasravar <- !riasztasravar.
