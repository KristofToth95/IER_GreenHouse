// Agent Futo in project GreenHouse.mas2j


/* Initial beliefs and rules */



/* Initial goals */

!futesrevar.


/* Plans */

+!futesrevar : fut<- .print("Futes");futes;.abolish(fut)!futesrevar.
+!futesrevar: true  <- .wait(1000);!futesrevar.
-!futesrevar <- !futesrevar.



