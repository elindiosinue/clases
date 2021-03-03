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
#define N 4

typedef enum {soltero = 1, casado, viudo, separado}estado;

typedef struct
{
	char nombre[CAR];
	char apellidos[CAR_APELL];
	int edad;
	estado e_civil;
	char poblacion[CAR];
}Cliente;


void pedir_nombre_fichero (char nombre[])
{
	printf ("\nIntroduzca el nombre del fichero: ");
	gets (nombre);
	fflush (stdin);
}


void desea_seguir (char *seguir)
{
	do
	{
		printf("\nDesea realizar mas tramites?? (S/N): ");
		scanf("%c", seguir);
		fflush(stdin);
	}while ((*seguir) != 'S' && (*seguir) != 's' && (*seguir) != 'N' && (*seguir) != 'n');
}


void mostrar_menu ()
{
 	printf ("\n  MENU\n");
	printf ("--------\n");
	printf ("1). Aniadir un cliente al fichero.\n");
	printf ("2). Listar todos los clientes de la empresa.\n");
	printf ("3). Listar todos los datos de los clientes casados cuya edad sea menor de 30 anios\n");
	printf ("4). Listar todos los datos de una persona, introduciendo previamente su nombre y apellidos\n");
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


void pedir_estado_civil (int *estado)
{
	do
	{
		printf ("\nIntroduzca el estado civil (1 = soltero, 2 = casado, 3 = viudo, 4 = separado): ");
		scanf ("%d", estado);
		fflush (stdin);
	}while (*estado < soltero || *estado > separado);
	
}


void pedir_poblacion (char poblacion[])
{
	printf ("\nIntroduzca la poblacion: ");
	gets (poblacion);
	fflush (stdin);
}


void introducir_cliente_en_fichero (char nombre_f[], Cliente lista [], int cont)
{
	FILE *f =fopen (nombre_f, "wb");
	
	fwrite (lista, sizeof (Cliente), cont, f);
	
	fclose(f);
}


void alta_cliente (Cliente lista [], int *cont, char nombre_f[])
{
	int estado;
	
	if (*cont == N)
	{
		printf ("\nNo se pueden introducir mas clientes.\n");
		return;
	}
	
	pedir_nombre (lista[*cont].nombre);
	pedir_apellidos (lista[*cont].apellidos);
	pedir_edad (&(lista[*cont].edad));
	//pedir_estado_civil (&estado);
	pedir_poblacion (lista[*cont].poblacion);
	
	(*cont)++;
	
	introducir_cliente_en_fichero (nombre_f, lista, *cont);
}


void listado_completo_clientes (int cont, Cliente lista[], char nombre_f[])
{
	if (cont == 0)
	{
		printf ("\nNo hay datos de clientes.\n");
		return;
	}
	
	FILE *f = fopen (nombre_f, "rb");
	
	Cliente aux;
	
	fread(&aux, sizeof(Cliente), 1, f);
	
	printf ("\nLISTADO COMPLETO DE CLIENTES:\n");
	while(!feof(f))
	{
		printf ("%s - %s - %d - %s\n", aux.nombre, aux.apellidos, aux.edad, aux.poblacion);
		fread(&aux, sizeof(Cliente), 1, f);
	}
	fclose(f);
}


void listado_casados_treinta (int cont, Cliente lista [], char nombre_f[])
{
	if (cont == 0)
	{
		printf ("\nNo hay datos de clientes.\n");
		return;
	}
	
	FILE *f = fopen (nombre_f, "rb");
	
	Cliente aux;
	
	fread(&aux, sizeof(Cliente), 1, f);
	
	printf ("\nLISTADO MENORES DE 30:\n");
	while(!feof(f))
	{
		if (aux.edad < 30)
			printf ("%s - %s - %d - %s\n", aux.nombre, aux.apellidos, aux.edad, aux.poblacion);
		fread(&aux, sizeof(Cliente), 1, f);
	}
	fclose(f);
}


int buscar_cadena1 (char nombre[], Cliente lista [], int cont)
{
	for (int i = 0; i < cont; i++)
	{
		if (strcmp(nombre, lista[i].nombre) == 0)
			return i;
	}
	return -1;
}


int buscar_cadena2 (char apellidos[], Cliente lista [], int cont)
{
	for (int i = 0; i < cont; i++)
	{
		if (strcmp(apellidos, lista[i].apellidos) == 0)
			return i;
	}
	return -1;
}


void listado_nombre_apellidos (int cont, Cliente lista [])
{
	if (cont == 0)
	{
		printf ("\nNo hay datos de clientes.\n");
		return;
	}
	
	char nombre[CAR];
	char apellidos[CAR_APELL];
	int pos_nom, pos_apell;
	
	pedir_nombre (nombre);
	pos_nom = buscar_cadena1(nombre, lista, cont);
	
	if (pos_nom != -1)
	{
		pedir_apellidos (apellidos);
		pos_apell = buscar_cadena2(apellidos, lista, cont);
		
		if (pos_apell != -1 && (pos_nom == pos_apell))
			printf ("%s %s - %d - %s", lista[pos_nom].nombre, lista[pos_nom].apellidos, lista[pos_nom].edad, lista[pos_nom].poblacion);
		else
			printf ("\nLos apellidos del cliente no existen\n");
	}		
	else
		printf ("\nEl nombre del cliente no existe\n");
}


void tratar_opcion (char nombre_f[], int op, Cliente lista [], int *cont)
{
	switch (op)
	{
		case 1: alta_cliente (lista, cont, nombre_f);
				break;
		case 2: listado_completo_clientes (*cont, lista, nombre_f);
				break;
		case 3: listado_casados_treinta (*cont, lista, nombre_f);
				break;
		case 4: listado_nombre_apellidos(*cont, lista);
				break;
	}
}


void cargar_datos_existentes (Cliente lista [], char nombre_f[], int *cont)
{
	FILE *f = fopen (nombre_f, "rb");
	
	if (f == NULL)
	{
		printf ("\nNo se ha encontrado el fichero '%s'.\n", nombre_f);
		return;
	}
	
	Cliente aux;
	
	printf ("\nListado de clientes de la empresa:\n");
	fread (&aux, sizeof (Cliente), 1, f);		// lee la info del primer registro y la almacena en aux
	
	while (*cont < N && !feof(f))
	{
		lista[*cont] = aux;
		printf ("%s - %s - %d - %s.\n", aux.nombre, aux.apellidos, aux.edad, aux.poblacion);
		fread (&aux, sizeof (Cliente), 1, f);
		(*cont)++;
	}
	fclose (f);
}


int main ()
{
	Cliente lista [N];
	
	int cont_clientes = 0;
	char seguir;
	int opcion;
	char nombre_f[CAR];
	
	pedir_nombre_fichero (nombre_f);
	cargar_datos_existentes (lista, nombre_f, &cont_clientes);
	
	do
	{
		mostrar_menu ();
		leer_opcion (&opcion);
		tratar_opcion (nombre_f, opcion, lista, &cont_clientes);
		desea_seguir (&seguir);
	}while (seguir == 'S' || seguir == 's');
}


