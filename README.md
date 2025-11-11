Trabajo práctico de **Interfaz Gráfica – 2° Instancia Evaluativa**  
Alumno: **Joaquín Ledo**

---

## Objetivo del proyecto

El objetivo fue ampliar y mejorar el juego original del Desafío 3, desarrollado en consola, para transformarlo en una aplicación gráfica con Swing, aplicando el patrón MVC (Modelo – Vista – Controlador) y agregando persistencia de datos.

---

Video explicando como funciona, lo subi a youtube para que se mas facil verlo le dejo el link:

https://youtu.be/MJ5SEgNi5BU?si=T7J7r7vDqRqbjZeh

---

##Esta segunda instancia evaluativa se centró en:

Implementar una interfaz gráfica completa, con menús, formularios y reportes.

Separar correctamente la lógica del juego en capas (modelo, vista y controlador).

Incorporar un sistema de persistencia en archivos de texto para jugadores e historial.

Mostrar estadísticas, ranking e historial desde la interfaz, sin usar consola.

---

##Nuevas funcionalidades implementadas
1. Interfaz gráfica con Swing

Se reemplazó la consola por una interfaz construida con JFrame, JPanel, JMenuBar, JList y JButton.
Las ventanas principales son:

VentanaConfiguracion: para registrar jugadores, definir parámetros del juego y acceder al historial.

VentanaJuego: muestra el estado de la partida en tiempo real, con información de rondas, apuestas y resultados.

VentanaReporteFinal: despliega el ranking final, estadísticas y las últimas tres partidas.

2. Patrón MVC aplicado

El proyecto se reestructuró completamente bajo el patrón Modelo – Vista – Controlador:

Modelo: contiene la lógica del juego (Jugador, Partida, Ronda, EstadoDelJuego, etc.).

Vista: maneja las interfaces visuales (VentanaConfiguracion, VentanaJuego, VentanaReporteFinal).

Controlador: conecta ambos componentes (ControladorConfiguracion, ControladorJuego, ControladorPersistencia).

Esto permite mantener la lógica separada de la presentación, facilitando futuras mejoras.

3. Persistencia en archivos de texto

Se implementó una clase ServicioDePersistencia que guarda y carga datos en formato .txt:

jugadores.txt → registra los jugadores con su tipo, dinero y victorias.

historial.txt → conserva el historial de partidas jugadas.

Los archivos se actualizan automáticamente al finalizar una partida, cumpliendo el requisito de persistencia sin usar base de datos.

4. Estadísticas y reportes

Al finalizar el juego, el sistema muestra un reporte con:

Ranking de jugadores.

Mayor apuesta realizada.

Mejor tiro obtenido.

Cantidad de jugadores afectados por trampas.

Últimas tres partidas jugadas.

5. Control de validaciones

Se valida que haya entre 2 y 4 jugadores antes de iniciar la partida.

No se permite agregar jugadores con nombre o apodo vacío.

El sistema impide iniciar si faltan datos requeridos.

---

Transparencia en el uso de IA y documentación

<img width="415" height="507" alt="image" src="https://github.com/user-attachments/assets/a7b287de-35db-40cb-8dd2-be9e6658042a" />

Pront Utilizado:

"Quiero que seas un programador experto en java y quiero que me ayudes a resolver las consignas de la segunda insatnacia evaluativa que te paso tene en cuenta que todo se usa como base el parcial previamente echo que te pase, yo ya cree el nuevo proyecto y esta es la estructura ayudame con el codigo para que ande no me des las respuestas para que copie sino que giame de como hacerlas, tene en cuenta que la profe me dijo que copie toda la logica del proyecto pasado en este."


Cumplir con los requisitos de persistencia y reportes solicitados por la consigna.

Resolver los conflictos surgidos durante el desarrollo de manera documentada y transparente.

El resultado es una aplicación completa, modular y mantenible que amplía el proyecto original del Casino de Dados y cumple con todos los objetivos de la 2° instancia evaluativa.

---
