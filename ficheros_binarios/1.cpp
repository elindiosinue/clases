/*
1)	Realizar una programa que lea un fichero de texto y escriba un fichero binario
    llamado "letras.dat" con la siguiente informacion:

-	Letra (A-Z).
-	N?mero de veces que aparece la letra en el fichero  (sin distinguir mayusculas y 
	minusculas).

El programa dara la opcion de ver por pantalla el fichero creado.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>

#define TAM 30		// tamanio del nombre del fichero.
#define N 26


typedef struct
{
	char letra;
	int num_veces;
}Letra;


void pedir_nombre_fichero (char nombre[])
{
	printf ("\nIntroduzca el nombre del fichero: ");
	gets (nombre);
	fflush (stdin);
}


void veces_letras (char leido [], Letra datosletras [])
{
	FILE *leer;
	char c;
	
	leer = fopen (leido, "r");
	
	if (leer == NULL)
	{
		printf ("\nNo se ha podido abrir el fichero.\n");
	}
	else
	{
		c = fgetc (leer);
		
		while (!(feof(leer)))
		{
			if (isalpha(c))
			{
				(datosletras[toupper(c) - 'A'].num_veces)++;
			}
			c = fgetc (leer);
		}
	}
	fclose(leer);
}


void inicializar_lista (Letra datosletras [])
{
	for (int i = 0; i < N; i++)
	{
		datosletras[i].letra = i + 65;		// probar con i + 'A'.
		datosletras[i].num_veces = 0;
	}
}


void escribir_letras (Letra datosletras [])
{
	FILE *f;
	
	f = fopen ("letras.dat", "wb");
	
	for (int i = 0; i < N; i++)
	{
		fwrite (&datosletras[i], sizeof (Letra), 1, f);
	}
	fclose (f);
}


void mostrar_datos ()
{
	FILE *f = fopen("letras.dat", "rb");
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


void preguntar_si_mostrar ()
{
	char op;
	
	printf ("\nDesea que los datos se muestren por pantalla? (S/N): ");
	scanf ("%c", &op);
	fflush (stdin);
	
	if (op == 'S')
		mostrar_datos ();
}


int main ()
{
	Letra datosletras [N];
	char leido [TAM];
	
	inicializar_lista (datosletras);
	pedir_nombre_fichero (leido);
	veces_letras (leido, datosletras);
	escribir_letras (datosletras);
	preguntar_si_mostrar ();
}
