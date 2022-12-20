# Examen2

Leandro Pino Barrientos A partir del taller 02 de medición de Terrremotos

A partir del taller 02 Se pide:

En el contexto de un proyecto de SmartCity para Temuco, se quiere simular el funcionamiento de un sensor sismológico, el cual almacena una lectura sismológica por cada hora del día.
Los datos que se recopilen permitirán hacer un estudio de N días (un número entero) respecto de la actividad sísmica registrada por el sensor.
Finalmente, se tiene una matriz con los datos recopilados por el sensor para N días con 24 lecturas diarias.
Para efectos de esta simulación, se debe considerar que:

la cantidad de días a revisar la define el usuario (N) y se lee por teclado (set-up del sensor).
el valor de cada registro se genera de forma aleatoria, con valores entre 0.5 y 9.5 grados en escala de Richter, que son los valores min. y máx. soportados por el sensor.
============================================================================================================

Con los datos ya almacenados se requiere saber:

i) ¿Qué intensidad? ¿Qué día? y a ¿Qué hora ocurrió el sismo más intenso?

ii) ¿Cuántos días en total se registraron sismos ≥ 5.5 grados?

iii) ¿Hay alerta de escalada sísmica? Se considera escalada sísmica, si para un mismo día, las lecturas del sensor registran al menos 4 lecturas consecutivas superiores a 6.0 grados Richter.

iv) ¿Hay alerta de enjambre sísmico? Se considera enjambre sísmico, si se registran al menos 3 días seguidos con escalada sísmica.

v) Se debe además crear un MENÚ que permita acceder a las opciones anteriores, considerando una opción para <>, previa confirmación del usuario.

============================================================================================================

Cambios con la version del Taller original: -Se creó un archivo .csv para visualizar los terremotos 
-Se creó un menú que permite moverse entre lo pedido o las opciones que existen 
-Para ver mejor las Guis, se usó la librería de Jform
