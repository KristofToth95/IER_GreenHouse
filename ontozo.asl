// Agent Ontozo in project GreenHouse.mas2j



/* Initial goals */



!start.



/* Plans */



+!start : watercommand <- .print("Ontozesi parancs.");
							.wait(1000);
							waterplants;
							.abolish(watercommand);
							!start.
-!start <- !start.							
					




