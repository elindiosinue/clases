/*
VERSION 1
  El programa va a mantener una lista de socios de un club.

  De cada socio se guardara su numero de socio, su nombre y si es vip.

  El usuario dara de alta todos los socios que quiera.

  Finalmente el programa mostrara un listado ordenado.

VERSION 2
  El programa va a mantener una lista de socios de un club.

  De cada socio se guardara su numero de socio, su nombre y si es vip.

  El usuario dispondra de un menu de opciones:
  1) Alta de socio. El numero de socio no puede repetirse.
  2) Baja de socio. El usuario indicara el numero y el programa borrara el registro.
  3) Modificacion de socio. El usuario indicara el numero y pedira de nuevo el nombre
  y si es vip.
  4) Listado de socios. Ordenado alfabeticamente.
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>


#define LIMITE 4


// TIPOS DE DATOS
struct socio
{
	int numero;
	char nombre[30];
	char vip;
};


int pedir_numero ()
{
	int numero;

	do{
		printf("Introduzca el numero de socio: ");
		scanf("%d", &numero);
		fflush(stdin);
	}while (numero <= 0);

	return numero;
}


char pedir_vip ()
{
	char vip;

	do{
		printf("Es socio vip (s/n)?: ");
		scanf("%c", &vip);
		fflush(stdin);
	}while (vip != 's' && vip != 'n');

	return vip;
}


char * pedir_nombre()
{
	char nombre[30];

	printf("Introduzca el nombre: ");
	gets(nombre);
	fflush(stdin);

	return nombre;
}


void mostrar_lista_socios (struct socio lista_socios[], int contador)
{
	printf("\nLISTADO\n-------\n");

	for (int i = 0; i < contador; i++)
	{
		printf("%d - %s ", lista_socios[i].numero, lista_socios[i].nombre);
		if (tolower(lista_socios[i].vip) == 's')
			printf("(VIP)\n");
		else
			printf("\n");
	}
}


void ordenar_lista_socios (struct socio lista_socios[], int tam)
{
  int i, j, menor;
  struct socio aux; // Variable para intercambio.

  for (i = 0; i < tam; i++)
  {
    menor = i;  // Se calcula el menor elemento a partir de i.
    for (j = i+1; j < tam; j++)
      if (strcmp(lista_socios[j].nombre, lista_socios[menor].nombre) < 0)
        menor = j;

    // Se intercambia el elemento i con el elemento menor.
    aux = lista_socios[i];
    lista_socios[i] = lista_socios[menor];
    lista_socios[menor] = aux;
  }
}

void mostrar_menu()
{
	printf("\nMENU PRINCIPAL\n--------------\n");
	printf("1.- Alta de socio.\n");
	printf("2.- Baja de socio.\n");
	printf("3.- Modificacion de socio.\n");
	printf("4.- Listado de socios.\n");
	printf("5.- Salir.\n\n");
}


void leer_opcion (int *op)
{
	do{
		printf("Introduzca opcion: ");
		scanf ("%d", op);
		fflush(stdin);
	}while((*op) < 1 || (*op) > 5);
}

void duplicar_estructura (struct socio lista[], struct socio lista_aux[], int contador)
{
	for (int i = 0; i < contador; i++)
		lista_aux[i] = lista[i];
}


void listado_socios (struct socio lista[], int contador_socios)
{
	struct socio lista_aux[10];

	duplicar_estructura (lista, lista_aux, contador_socios);
	ordenar_lista_socios (lista_aux, contador_socios);
	mostrar_lista_socios (lista_aux, contador_socios);
}


int numero_repetido (int numero, struct socio lista[], int contador)
{
	for (int i = 0; i < contador; i++)
		if (numero == lista[i].numero)
		{
			printf("Codigo de socio repetido.\n");
			return 1;
		}
	
	return 0;
}


void alta_socio (struct socio lista[], int *contador)
{
	if ((*contador) == LIMITE)
	{
		printf("\n\nNo pueden darse de alta mas registros de socios.\n\n");
		return;
	}

	do{
		lista[*contador].numero = pedir_numero();
	}while(numero_repetido (lista[*contador].numero, lista, *contador));
	
	strcpy(lista[*contador].nombre, pedir_nombre());
	lista[*contador].vip = pedir_vip();

	(*contador)++;
}


int buscar_socio (struct socio lista[], int numero_a_borrar, int contador)
{
	/*
	La función devolvera el indice del registro-celda que contiene
	al socio que estamos buscando.
	Si no se encuentra, devolvera el valor -1.
	*/

	for (int i = 0; i < contador; i++)
		if (numero_a_borrar == lista[i].numero)
			return i;
	
	return -1;
}


void desplazar_celdas (struct socio lista[], int contador, int indice)
{
	for (int i = indice; i < contador - 1; i++)
		lista [i] = lista [i + 1];
}


void baja_socio (struct socio lista[], int *contador)
{
	/*
	1) Pedimos el numero de socio.
	2) Buscamos el registro de ese socio.
	3) Si no existe informamos al usuario y salimos.
	4) Si existe, desplazamos los registros que esten a la derecha una 
	posicion hacia la izquierda, y decrementamos el valor del contador.
	*/

	// Paso 1:
	int numero_a_borrar = pedir_numero();

	// Paso 2:
	int indice = buscar_socio (lista, numero_a_borrar, *contador);

	// Pasos 3 y 4:
	if (indice == -1) // No lo ha encontrado.
		printf("No se ha encontrado ningun socio con ese numero.\n\n");
	else
	{
		desplazar_celdas (lista, *contador, indice);
		(*contador)--;
	}
}


void modificacion_socio (struct socio lista[], int contador)
{
	/*
	1) Pedimos el numero de socio.
	2) Buscamos el registro de ese socio.
	3) Si no existe informamos al usuario y salimos.
	4) Si existe pedimos de nuevo el nombre y si es socio vip.
	*/

	// Paso 1:
	int numero_a_borrar = pedir_numero();

	// Paso 2:
	int indice = buscar_socio (lista, numero_a_borrar, contador);

	// Pasos 3 y 4:
	if (indice == -1) // No lo ha encontrado.
		printf("No se ha encontrado ningun socio con ese numero.\n\n");
	else
	{
		strcpy(lista[indice].nombre, pedir_nombre());
		lista[indice].vip = pedir_vip();
	}
}


void tratar_opcion (struct socio lista[], int *contador, int opcion)
{
	switch (opcion)
	{
		case 1: alta_socio (lista, contador);
			    break;
		case 2: baja_socio (lista, contador);
			    break;
		case 3: modificacion_socio (lista, *contador);
			    break;
		case 4: listado_socios (lista, *contador);
	}
}

int desea_cargar_fichero()
{
	int respuesta;

	do{
		printf("\n\nDesea cargar los datos del fichero de socios (1 = SI, 0 = NO)?: ");
		scanf("%d", &respuesta);
		fflush(stdin);
	}while ((respuesta != 0) && (respuesta != 1));

	return respuesta;
}


int desea_guardar_fichero()
{
	int respuesta;

	do{
		printf("\n\nDesea grabar los datos en el fichero de socios (1 = SI, 0 = NO)?: ");
		scanf("%d", &respuesta);
		fflush(stdin);
	}while ((respuesta != 0) && (respuesta != 1));

	return respuesta;
}


void cargar_datos_fichero (int *contador_socios, struct socio lista[])
{
	FILE *f = fopen("socios.dat", "rb");

	if (f == NULL)
	{
		printf("\n\nError al abrir el archivo de socios.\n\n");
		return;
	}

	struct socio s;
	
	fread(&s, sizeof(struct socio), 1, f);
	
	while (((*contador_socios) != LIMITE) && (!feof(f)))
	{
		lista[(*contador_socios)] = s;
		(*contador_socios)++;
		fread(&s, sizeof(struct socio), 1, f);
	}

	fclose (f);
}


void grabar_datos_fichero (int contador_socios, struct socio lista[])
{
	FILE *f = fopen("socios.dat", "wb");

	fwrite (lista, sizeof(struct socio), contador_socios, f);

	fclose(f);
}


void main()
{
	// El fichero de datos se llama "socios.dat".

	// ESTRUCTURA DE DATOS
	struct socio lista_socios [LIMITE];
	int contador_socios = 0;
	int opcion;

	if (desea_cargar_fichero())
		cargar_datos_fichero(&contador_socios, lista_socios);

	// PROGRAMA
	do{
		mostrar_menu();
		leer_opcion (&opcion);
		tratar_opcion (lista_socios, &contador_socios, opcion);
	}while (opcion != 5);

	if (desea_guardar_fichero())
		grabar_datos_fichero (contador_socios, lista_socios);
}