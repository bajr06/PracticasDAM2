# Items a evaluar
## 1. Comprobar del directorio de archivos
1. Comprobación de la existencia de plantas.xml.
2. Comprobación de la existencia de plantas.dat.
3. Comprobación de la existencia de empleados.dat.
4. Comprobación/Creación deñ árbol de directorios necesarios.
5. Control de errores si no existe o hay problemas en el directorio.


## 2. Carga de datos
1. Lectura del fichero plantas.dat.
2. Caarga de los datos en un ArrayList de tipo Planta.
3. Lectura del fichero binario de empleados.
4. Carga de datos en el ArrayList tipo Empleado.
5. Control de errores si hay problemas en la carga de datos.


## 3. Identificación del usuario.
1. Comprobación de la contraseña y el usuario.
2. Mostrar menú según el usuario.
3. Control de errores si el usuario no existe, usuario de forma incorrecta, o el cargo
4. Relleno de los códigos con el número cero a la izquierda.


## 4. Menú vendendores
1. Listar los datos del catálogo uniendo los datos del fichero de acceso directo (accediendo él como un fichero de acceso directo) y ArrayList de Plantas.
2. Redirigir desde el catálogo pasando el código de la planta a la funcionalidad de realizar la planta.
3. Introducir datos válidos de la cantidad (letra, ni negativos, carácteres especiales -> es número), sin errores.


## 5. Realizar venta
1. Permitir realizar la acción varias veces hasata que el usuario decida.
2. Introducir los datos correctos (código, cantidad) -> es número.
3. Comprobar stock
	1. Lectura del campo stock (fichero acceso directo).
4. Mostrar resumen compra antes finalizar -> Previsualización del ticket.
5. Aceptar venta y actualizar stock
	1. Modificación del camppo de fichero de acceso directo.
	2. Calcular el total a pagar.
6. Generar tickets
	1. Tomar el nombre del ticket secuencial - Leer el último del ticket generado
	2. Escribir el ticket en un fichero de carácteres con formato indicado - Hay que incluir los datos del empleado.


## 6. Devolución
1. Buscar el ticket de la devolución por el código.
2. Escribir en el fichero de carácteres la línea --DEVOLUCION--.
3. Leer el total del ticket de la devolución, modificarlo para ponerlo en negativo.
4. Modificar el stock de las plantas han sido devueltas.
5. Mover el ticket en la carpeta de devolución.


## 7. Búsqueda de tickets
1. Leer el fichero de carácteres indicado por teclado.


## 8. Menú de gestores
1. Gestión de plantas.
	1. Dar de alta planta.
		1. Añadir el elemendo al ArrayList.
		2. Escribir en el fichero de Acceso directo.
		3. Sobreescribir en el fichero al finalizar (.xml).
	2. Dar de baja a la planta
		1. Modificar stock fichero de acceso directo y comprobar que es cero el stock (precio = 0, stock = 0).
		2. Escribir la línea de la planta con el código y precio en el fichero de bajas.
	3. Rescatar planta o dar stock.
		1. Insertar código de planta -> Comprobación de que es un número.
		2. Leer fichero bajas, obtener el precio correcto.
		3.  Modificar fichero de acceso directo con los datos.
		4. Eliminar el dato del fichero de bajas.
2. Gestión empleados.
	1. Dar de alta empleado.
		1. Añadir empleado al ArrayList.
		2. Control de errores de los datos del empleado.
		3. Escribir al empleado en el fichero empleado.dat.
	2. Dar de baja empleado.
		1. Escribir el elemeneto Empleado en ArrayList baja y eliminarle en las altas.
		2. Escribir el ArrayList bajaEmpleado en el fichero.
		3. Sobreescribir el fichero empleado.dat.
	3. Rescatar empleado.
		1. Leer fichero de bajas empleado - Cargar elementos.
		2. Obtener el empleado deseado - Eliminar el elemento del Array.
		3. Sobreescribir fichero bajaEmpleado
		4. Sobreescribir fichero Empleado.
3. Calcular estadísticas de los tickets.
	1. Total recaudado.
		1.  Leer todos los tickets.
		2. Obtener el campo total y sumarlo.
	2. Plantas más vendidas.
		1. Leer todos los tickets.
		2. Almacenar en una estructura todas las plantas y sumar la cantidad.
		3. Ordenar por el campo cantidad.

```C
#include <stdio.h>
#include <stdlib.h>

int main() {
	printf("Bienvenido al vivero de C+#\n");

	return EXIT_SUCCESS;
}
```