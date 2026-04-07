# UnoVersion3.0
🎮 UNO 3.0 (Java)
📌 Descripción

Este proyecto es una implementación del juego de cartas UNO en Java. Permite jugar contra múltiples jugadores controlados por la computadora, siguiendo las reglas básicas del juego, incluyendo cartas especiales y penalizaciones.

🧠 Características principales
Juego por turnos
Soporte para jugador humano e inteligencia artificial
Cartas especiales:
Salto
Reversa
Roba 2
Roba 4
Comodín
Validación de jugadas
Sistema de penalización por no decir "UNO"
Selección de color en cartas comodín


🏗️ Estructura del proyecto

El sistema está dividido en las siguientes clases:

Card: Representa una carta del juego (número o especial)
Deck: Administra el mazo de cartas
Hand: Maneja las cartas de cada jugador
Player: Controla el comportamiento del jugador (humano o IA)
Game: Contiene la lógica principal del juego
Main: Punto de entrada del programa


🔄 Funcionamiento del juego
1. Se crean los jugadores (1 humano + 3 IA)
2. Se reparten 7 cartas a cada jugador
3. Se coloca una carta inicial en la mesa
4. Los jugadores juegan por turnos:
• Si tienen una carta válida, la juegan
• Si no, roban una carta
5. Se aplican efectos de cartas especiales
6. Si un jugador se queda con una carta debe decir "UNO"
7. Gana el jugador que se queda sin cartas

⚙️ Requisitos
Java JDK 8 o superior
Consola o IDE (NetBeans, IntelliJ, Eclipse)
▶️ Ejecución
Compilar el proyecto:
javac Uno3_0/*.java
Ejecutar:
java Uno3_0.Main

🎯 Reglas implementadas
Coincidencia por:
Color
Número
Tipo de carta
Cartas comodín pueden jugarse en cualquier momento
Cartas +4 obligan al siguiente jugador a robar 4 cartas
Si no se dice "UNO", se penaliza con 2 cartas

🤖 Inteligencia Artificial

Los jugadores IA:

Juegan la primera carta válida disponible
Roban carta si no tienen jugadas
Eligen color aleatorio en comodines

🚀 Posibles mejoras
Interfaz gráfica (GUI)
Modo multijugador real
Mejorar estrategia de la IA
Sistema de puntuación
Guardado de partidas

👤 Autor

Proyecto desarrollado como práctica de Programación Orientada a Objetos en Java.
