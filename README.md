# UnoVersion3.0

Juego de UNO en consola desarrollado en Java. Esta versión permite jugar 1 humano contra 3 jugadores controlados por IA (Pepe, Toña, Mari).

## **Características principales**

- Juego de cartas UNO clásico con las reglas básicas.
- Soporte para **cartas especiales**:
  - SALTO
  - REVERSA
  - ROBA2
  - ROBA4
  - COMODIN (cambio de color)
- IA básica:
  - Juega la primera carta válida que encuentre.
  - Roba una carta si no tiene jugadas válidas.
  - Dice UNO automáticamente cuando le queda una carta.
- Detección de UNO:
  - El jugador humano debe decidir si dice UNO al quedarse con una carta.
  - Si no dice UNO, se le aplican 2 cartas de penalización.
- Visualización en consola del estado del juego y cartas de los jugadores.

---

## **Clases principales**

- **Main**: Punto de entrada del programa. Crea una instancia de `Game` y llama a `iniciar()`.
- **Game**: Controla el flujo del juego, turnos, efectos de cartas y dirección del juego.
- **Player**: Representa a un jugador (humano o IA) y maneja su mano de cartas.
- **Hand**: Representa la mano de un jugador, con métodos para jugar, agregar y validar cartas.
- **Deck**: Representa el mazo de cartas. Permite barajar y robar cartas.
- **Card**: Representa una carta, su color, tipo y número. Incluye lógica para determinar si es jugable sobre otra carta.

---

## **Cómo jugar**

1. Ejecuta `Main.java`.
2. Ingresa tu nombre cuando se te solicite.
3. Se repartirán **7 cartas** a cada jugador.
4. Durante tu turno:
   - Se mostrará tu mano y la carta en la mesa.
   - Selecciona el índice de la carta que quieres jugar.
   - Si solo te queda una carta, se te preguntará si deseas decir UNO (`s/n`).
   - Si no tienes cartas válidas, automáticamente robas una carta del mazo.
5. La partida continúa hasta que un jugador se quede sin cartas.
6. El primer jugador en quedarse sin cartas gana la partida.

---

## **Reglas especiales implementadas**

- Cartas especiales aplican efectos inmediatamente:
  - **SALTO**: Salta al siguiente jugador.
  - **REVERSA**: Cambia la dirección del juego.
  - **ROBA2**: El siguiente jugador roba 2 cartas y pierde turno.
  - **ROBA4**: El siguiente jugador roba 4 cartas y se elige color.
  - **COMODIN**: Permite cambiar el color.
- Penalización de **UNO**:
  - Si un jugador humano no dice UNO con una carta en mano, roba 2 cartas.
- Turnos y dirección del juego mostrados visualmente con flechas en consola.

---

## **Requisitos**

- Java 8 o superior
- Consola para ejecutar el juego

---

## **Mejoras futuras**

- Implementar IA más estratégica (priorizar cartas especiales o colores).
- Penalización para IA que no diga UNO (simulación más realista).
- Interfaz gráfica (GUI) en lugar de consola.
- Guardado y carga de partidas.
- Soporte multijugador en red.

---

## **Ejecución**

Compilar y ejecutar desde consola:

```bash
javac Uno3_0/*.java
java Uno3_0.Main
