// LIBRERIAS
#include <stdio.h>
#include <ctype.h>
#include <string.h>


// CONSTANTES
#define TAM 26


// TIPOS
typedef struct
{
	char letra;
	int num_veces;
}Letra;



void leer_datos(char fichero_entrada[])
{
	printf("Introduzca el nombre del fichero: \n");
	scanf("%s", fichero_entrada);
	fflush(stdin);
}


void inicializar_lista_letras (Letra lista_letras[])
{
	for (int i = 0; i < TAM; i++)
	{
		lista_letras[i].letra = i + 65; // 65 es A.
		lista_letras[i].num_veces = 0;
	}
}


int desea_ver_contenido_estadisticas()
{
	int opcion;

	do{
		printf("Desea ver el contenido de las estadisticas (1 = SI, 0 = NO)?: ");
		scanf("%d", &opcion);
		fflush(stdin);
	}while(opcion != 1 && opcion != 0);

	return opcion;
}


void mostrar_contenido_estadisticas ()
{
	if (!desea_ver_contenido_estadisticas())
		return;
	
	FILE *f = fopen("salida.dat", "rb");
	Letra aux;

	if (f == NULL)
		printf("\n\nNo se puede abrir el archivo con los datos estadisticos.\n\n");
	else
	{
		printf("\nESTADISTICAS\n--------------------\n");
		fread (&aux, sizeof(Letra), 1, f);

		while (!feof(f))
		{
			printf("Letra %c - %d veces\n", aux.letra, aux.num_veces);
			fread (&aux, sizeof(Letra), 1, f);
		}
		
		fclose(f);
	}

}



void generar_estadistica (char nombre[], Letra lista_letras[])
{
	FILE *f = fopen (nombre, "r");
	char c;

	if (f == NULL)
	{
		printf("\n\nNo se ha podido abrir el archivo.\n\n");
		return;
	}
	
	c = fgetc(f);

	while(!feof(f))
	{
		// 1) Si hemos leido una letra:
		// - Incrementar en 1 el contador de la letra que acabamos de leer.
		// 2) Leer el siguiente caracter.

		if (isalpha(c))
			(lista_letras[toupper(c) - 'A'].num_veces)++;

		c = fgetc(f);
	}
		
	fclose(f);
}


void traspasar_lista_a_fichero (Letra lista_letras[])
{
	FILE *f = fopen("salida.dat", "wb");

	for (int i = 0; i < TAM; i++)
		fwrite(&lista_letras[i], sizeof(Letra), 1, f);

	fclose(f);
}



/****************************************************************************************************/
int main()
{
	Letra lista_letras[TAM];
	char nombre_fichero[100];

	leer_datos(nombre_fichero);
	inicializar_lista_letras (lista_letras);
	generar_estadistica(nombre_fichero, lista_letras);
	traspasar_lista_a_fichero(lista_letras);
	mostrar_contenido_estadisticas ();
	
}


/****************************************************************************************************/


/****************************************************************************************************/
