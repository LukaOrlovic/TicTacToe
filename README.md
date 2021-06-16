# TicTacToe (Iks oks)

Ovaj projekat se sastoji od klijentskog dela aplikacije (JavaFX aplikacija), koja pomoću soketa i JAX-WS komunicira sa serverskim delom aplikacije. JAX-WS je implementiran za prijavu korisnika.

Zadatak je bio implementirati igricu iks oks. Kad se korisnik uloguje na sistem, može da odabere iz padajućeg menija da započne igru. Za potrebe ove aplikacije korišćena je nit sa klijentske strane za merenje poteza potrebnih za zavrsetak igre.

U projektu su korišćeni sledeći mikro arhitekturni paterni: Singleton, Bridge, Facade i Template method.