/*
En una empresa se desea disponer de un fichero con la siguiente informacion  de sus clientes:

-	Nombre: 20 caracteres.
-	Apellidos: 40 caracteres.
-	Edad: entre 0 y 120.
-	Estado civil: 1-soltero, 2-casado, 3-viudo, 4-separado.
-	Poblacion: 20 caracteres.

Realizar un programa que inicialmente pida el nombre del fichero de clientes y permita:

-	Aniadir un cliente al fichero. Los datos se pediran por teclado.
-	Listar todos los clientes de la empresa.
-	Listar en pantalla todos los datos de los clientes casados cuya edad sea menor de 30 anios.
-	Listar todos los datos de una persona, introduciendo previamente su nombre y apellidos.
*/


#include <stdio.h>
#include<stdlib.h>
#include <string.h>	

#define CAR 20
#define CAR_APELL 40

//typedef enum {soltero = 1, casado, viudo, separado}estado;

typedef struct
{
	char nombre[CAR];
	char apellidos[CAR_APELL];
	int edad;
	//estado e_civil;
	char e_civil[CAR];
	char poblacion[CAR];
}Cliente;

typedef struct nodo
{
	Cliente datosCliente;
	nodo *sig;
}nodoCliente;


void desea_seguir (char *op)
{
	do
	{
		printf("\nDesea seguir?? (S/N): ");
		scanf("%c", op);
		fflush(stdin);
	}while ((*op) != 'S' && (*op) != 's' && (*op) != 'N' && (*op) != 'n');
}

void mostrar_menu ()
{
 
 	printf ("\n  MENU\n");
	printf ("--------\n");
	printf ("1). Alta cliente.\n");
	printf ("2). Listar todos los clientes de la empresa.\n");
	printf ("3). Listar en pantalla los datos de los clientes casados menores de 30 anios.\n");
	printf ("4). Listar todos los datos de una persona, introduciendo previamente su nombre y apellidos.\n");
}

void leer_opcion (int *op)
{
	do
	{
		printf("\nIntroduzca opcion: ");
		scanf("%d", op);
		fflush(stdin);
	}while ((*op) != 1 && (*op) != 2 && (*op) != 3 && (*op) != 4);
}

void listado_completo_clientes (nodoCliente *lista)
{
	if (lista == NULL)
	{
		printf ("\nNo hay datos de clientes.\n");
		return;
	}
	printf ("\nLISTADO COMPLETO:\n");
	
	while (lista != NULL)
	{
		printf ("%s %s - %d - %s - %s.\n", lista->datosCliente.nombre, lista->datosCliente.apellidos, 
										   lista->datosCliente.edad, lista->datosCliente.e_civil, lista->datosCliente.poblacion);
		lista = lista->sig;
	}	
}

void pedir_nombre (char nombre[])
{
	printf ("\nIntroduzca el nombre: ");
	gets (nombre);
	fflush (stdin);
}

void pedir_apellidos (char apellidos[])
{
	printf ("\nIntroduzca los apellidos: ");
	gets (apellidos);
	fflush (stdin);
}

void pedir_edad (int *edad)
{
	printf ("\nIntroduzca la edad: ");
	scanf ("%d", edad);
	fflush (stdin);
}

void pedir_estado_civil (char estado[])
{
	printf ("\nIntroduzca el estado civil (soltero, casado, viudo, separado): ");
	gets (estado);
	fflush (stdin);
}

void pedir_poblacion (char poblacion[])
{
	printf ("\nIntroduzca la poblacion: ");
	gets (poblacion);
	fflush (stdin);
}

void insertar_nodo_en_lista (nodoCliente **lista, nodoCliente *aux_nodo)
{
	if (*lista == NULL)
		*lista = aux_nodo;
	else
	{
		// Buscamos el final de la lista para guardar el nuevo nodo, ya que el problema no exige ordenacion de ningun tipo.
		nodoCliente *busca = *lista;
		
		while (busca->sig != NULL)
			busca = busca->sig;
		
		aux_nodo->sig = busca->sig;
		busca->sig = aux_nodo;	
	}
}

void alta_cliente (nodoCliente **lista)
{
	nodoCliente *nuevo;
	
	nuevo = (nodoCliente*)malloc (sizeof(nodoCliente));
	
	pedir_nombre (nuevo->datosCliente.nombre);
	pedir_apellidos (nuevo->datosCliente.apellidos);
	pedir_edad (&(nuevo->datosCliente.edad));
	pedir_estado_civil (nuevo->datosCliente.e_civil);
	pedir_poblacion (nuevo->datosCliente.poblacion);
	
	nuevo->sig = NULL,
	
	insertar_nodo_en_lista(lista, nuevo);
	
	printf ("\nEl cliente se ha dado de alta.\n");
}

void listado_casados_treinta (nodoCliente *lista)
{
	if (lista == NULL)
	{
		printf ("\nNo hay datos de clientes.\n");
		return;
	}
	
	printf ("\nLISTADO CASADOS MENORES DE 30:\n");
	
	while (lista != NULL)
	{
		if (/*lista->datosCliente.e_civil == 'casado' && */lista->datosCliente.edad < 30)
			printf ("%s %s - %d - %s - %s.\n", lista->datosCliente.nombre, lista->datosCliente.apellidos, 
										   lista->datosCliente.edad, lista->datosCliente.e_civil, lista->datosCliente.poblacion);
		
		lista = lista->sig;
	}
}

nodoCliente * nombre_y_apellidos_iguales (nodoCliente *lista, char nombre[], char apellidos[])
{
	while (lista != NULL)
	{
		if ((strcmp(nombre, lista->datosCliente.nombre) == 0) && (strcmp(apellidos, lista->datosCliente.apellidos) == 0))
			return lista;
		else
			lista = lista->sig;
	}
	return NULL;
}

void listado_nombre_apellidos (nodoCliente *lista)
{
	if (lista == NULL)
	{
		printf ("\nNo hay datos de clientes.\n");
		return;
	}
	
	nodoCliente *igual;
	
	char nombre[CAR];
	char apellidos[CAR_APELL];
	
	pedir_nombre (nombre);
	pedir_apellidos (apellidos);
	
	igual = nombre_y_apellidos_iguales (lista, nombre, apellidos);
	
	if (igual != NULL)
	{
		printf ("\nLISTADO SEGUN NOMBRE Y APELLIDOS:\n");
		printf ("%s %s - %d - %s - %s.\n", igual->datosCliente.nombre, igual->datosCliente.apellidos, 
										   	   igual->datosCliente.edad, igual->datosCliente.e_civil, igual->datosCliente.poblacion);
	}
	else
		printf ("\nEl cliente no se ha encontrado.\n");
}

void tratar_opcion (nodoCliente **lista, char op) 
{
	switch (op)
	{
		case 1: alta_cliente (lista);
				break;
		case 2: listado_completo_clientes (*lista);		// mando el contenido de la lista
				break;
		case 3: listado_casados_treinta (*lista);
				break;
		case 4: listado_nombre_apellidos(*lista);
	}
}

void pedir_nombre_fichero (char nombre_f[])
{
	printf ("\nIntroduzca el nombre del fichero: ");
	gets (nombre_f);
	fflush (stdin);
}

void crear_nodo (nodoCliente **lista, Cliente aux_cliente)
{
	nodoCliente *aux_nodo = (nodoCliente*)malloc (sizeof (nodoCliente));
	
	strcpy(aux_nodo->datosCliente.nombre, aux_cliente.nombre);
	strcpy(aux_nodo->datosCliente.apellidos, aux_cliente.apellidos);
	aux_nodo->datosCliente.edad = aux_cliente.edad;
	strcpy(aux_nodo->datosCliente.e_civil, aux_cliente.e_civil);
	strcpy(aux_nodo->datosCliente.poblacion, aux_cliente.poblacion);
	
	aux_nodo->sig = NULL;
	
	insertar_nodo_en_lista (lista, aux_nodo);
}

void leer_fichero_existente (nodoCliente **lista, char nombre_f[])
{
	FILE *f = fopen (nombre_f, "rb");
	
	Cliente aux_cliente;	// auxiliar para guardar los registros leidos, no los nodos. Lo que hay en el fichero.	
	
	if (f == NULL)
	{
		printf ("\nNo se ha encontrado el fichero %s. Se creara uno con este nombre.\n", nombre_f);
		return;
	}
	
	printf ("\nDATOS EXISTENTES DE CLIENTES:\n");
	fread (&aux_cliente, sizeof(Cliente), 1, f);
	
	while (!feof(f))		// imprimo para ver lo que hay en el fichero (se puede borrar).
	{
		printf ("%s %s - %d - %s - %s.\n", aux_cliente.nombre, aux_cliente.apellidos, 		// Muestra la info
										   aux_cliente.edad, aux_cliente.e_civil, aux_cliente.poblacion);
		crear_nodo (lista, aux_cliente);
		fread (&aux_cliente, sizeof(Cliente), 1, f);
	}
	fclose(f);
}

void volcar_datos_fichero (nodoCliente *lista, char nombre_f[])
{
	FILE *f = fopen (nombre_f, "wb");
	
	if (f == NULL)
	{
		printf("Error. No se ha podido abrir el fichero '%s'.\n", nombre_f);
		return;
	}
	
	while (lista != NULL)
	{
		fwrite ((&lista->datosCliente), sizeof (Cliente), 1, f);
		lista = lista->sig;
	}
	
	fclose (f);
	
	printf("\nSe han introducido los datos al fichero '%s'.\n", nombre_f);
}

void destruir_estructura (nodoCliente *lista)
{
	nodoCliente *aux;

	aux = lista;
	
	while (aux != NULL)
	{
		lista = lista -> sig;
		free (aux);
		aux = lista;
	}
	printf("\nHemos destruido la lista.\n\n");
}

int main ()
{
	nodoCliente *lista =  NULL;
	
	int opcion;
	char seguir;
	char nombre_f[CAR];
	
	pedir_nombre_fichero (nombre_f);
	leer_fichero_existente (&lista, nombre_f);		// Para saber los datos que hay en el fichero existente y meterlos en mi lista
													// Paso lista pq dentro de esta funcion hay otra (insertar) en la que la voy a
	do												// necesitar, y la paso como puntero porque se va a modificar.
	{
		mostrar_menu ();
		leer_opcion (&opcion);
		tratar_opcion (&lista, opcion);
		desea_seguir (&seguir);
	}while (seguir == 'S' || seguir == 's');
	
	volcar_datos_fichero (lista, nombre_f);
	destruir_estructura (lista);
}
