# AvanceradJava_Miniprojekt1_V3
Final version??

I klassen ”Clock” finns en variabel current_state som håller reda på det nuvarande tillståndet.
Dessa tillstånd inkluderar att hämta tiden, hämta datum, ändra tiden och ändra på datumet.

Det finns 2 metoder i klassen Time, getTime(), getDate() samt 2 metoder i klassen Date, changeTime() och changeDate(),
Dessa implementerar dom olika åtgärderna beroende på det aktuella tillståndet. 
Exempelvis om tillståndet är Get_Time så kommer getTime() att hämta och visa den aktuella tiden.

Metoderna changeState(), readyToSet() och set() finns för att ändra på tillståndet baserat på vad användaren väljer i menyn, exempelvis om användaren vill ändra på tiden så går programmet från tillståndet Get_Time till Change_Time.
Dom olika metoderna kollar av tillståndet och hindrar även användaren att hamna i fel state, med hjälp av if/else-loopar.
