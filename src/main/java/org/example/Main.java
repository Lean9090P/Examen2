package org.example;

import guis.Launcher;
import service.ServiceLauncher;

import javax.swing.*;

public class Main {
    static ServiceLauncher service = new ServiceLauncher();
    public static void main(String[] args) {
        runCreator();
    }
    public static void runCreator(){
        javax.swing.SwingUtilities.invokeLater(() -> {
            Launcher GUI =  new Launcher();
            GUI.setService(service);
            GUI.getData();
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GUI.setVisible(true);
        });

    }
}



/*
* Paso 2: Caso a desarrollar.

- En el contexto de un proyecto de SmartCity para Temuco, se quiere simular el funcionamiento de un sensor sismológico,
* el cual almacena una lectura sismológica por cada hora del día.

- Los datos que se recopilen permitirán hacer un estudio de N días (un número entero) respecto de la actividad sísmica
* registrada por el sensor.

- Finalmente, se tiene una matriz con los datos recopilados por el sensor para N días con 24 lecturas diarias.

Para efectos de esta simulación, se debe considerar que:

- la cantidad de días a revisar la define el usuario (N) y se lee por teclado (set-up del sensor).

- el valor de cada registro se genera de forma aleatoria, con valores entre 0.5 y 9.5 grados en escala de Richter,
* que son los valores min. y máx. soportados por el sensor.

Procesamiento de los datos.

Con los datos ya almacenados se requiere saber:

i) ¿Qué intensidad? ¿Qué día? y a ¿Qué hora ocurrió el sismo más intenso?

ii) ¿Cuántos días en total se registraron sismos ≥ 5.5 grados?

iii) ¿Hay alerta de escalada sísmica? Se considera escalada sísmica, si para un mismo día, las lecturas del sensor
* registran al menos 4 lecturas consecutivas superiores a 6.0 grados Richter.

iv) ¿Hay alerta de enjambre sísmico? Se considera enjambre sísmico, si se registran al menos 3 días seguidos con
* escalada sísmica.

v) Se debe además crear un MENÚ que permita acceder a las opciones anteriores, considerando una opción para
* <<Salir del sistema>>, previa confirmación del usuario.
*
* */