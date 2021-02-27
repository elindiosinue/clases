/*
1)	En un videoclub, al finalizar cada mes se dispone de un fichero binario con la siguiente informacion:

-	Codigo de pelicula (entero).
-	Nombre de pelicula (longitud 30).
-	Numero de veces que ha sido alquilada.

Se desea obtener un fichero de texto con las 3 peliculas mas alquiladas (ordenadas por su exito de mayor a menor). 
En cada linea debe aparecer el titulo de la pelicula.
*/

#include <stdio.h>
#include<stdlib.h>
#include <string.h>	

#define CAR 30
#define N 10
#define TRES 3

typedef struct
{
	int codigo;
	char nombre[CAR];
	int veces_alq;
}pelicula;


void pedir_codigo (int *codigo)
{
	printf ("\nIntroduzca el codigo de la pelicula: ");
	scanf ("%d", codigo);
	fflush (stdin);
}


void pedir_nombre (char nombre[])
{
	printf ("\nIntroduzca el titulo: ");
	gets (nombre);
	fflush (stdin);
}

void desea_seguir (char *seguir)
{
	do
	{
		printf("\nHa finalizado el mes?? (S/N): ");
		scanf("%c", seguir);
		fflush(stdin);
	}while ((*seguir) != 'S' && (*seguir) != 's' && (*seguir) != 'N' && (*seguir) != 'n');
}


int numero_repetido (int cod, pelicula lista[], int cont)
{
	for (int i = 0; i <= cont; i++)
	{
		if (cod == lista[i].codigo)
		{
			return i;
		}
	}
	return -1;
}


void alta_peli (int *cont, pelicula lista[])
{
	int codigo, repe;
	
	if (*cont == N)
	{
		printf ("\nNo se admiten mas peliculas.\n");
		return;
	}
	
	pedir_codigo (&codigo);
	repe = numero_repetido (codigo, lista, *cont);
	
	if (repe == -1)
	{
		lista[*cont].codigo = codigo;
		pedir_nombre (lista[*cont].nombre);
		lista[*cont].veces_alq = 1;
		
		(*cont)++;
		
		printf ("\nLa pelicula se ha alquilado una vez.\n");
	}
	else
	{
		(lista[repe].veces_alq)++;
			
		printf ("\nLa pelicula se ha alquilado otra vez.\n");
	}
}


/*void listado_peliculas (pelicula lista [], int cont)
{
	if (cont == 0)
		printf ("\nNo hay peliculas registradas.\n");
	else
	{
		printf ("\nLISTADO ACTUALIZADO DE PELICULAS (control):\n");
		for (int i = 0; i < cont; i++)
		{
			printf ("%d - %s - %d vez / veces.\n", lista[i].codigo, lista[i].nombre, lista[i].veces_alq);
		}
	}
}*/


void cargar_fichero_inicial (pelicula lista [], int *cont)
{
	FILE *f = fopen ("pelis.dat", "rb");
	
	if (f == NULL)
	{
		printf ("\nNo se ha encontrado el fichero 'pelis.dat'.\n");
		return;
	}
	
	pelicula aux;
	
	printf ("\nListado de peliculas del videoclub:\n");
	fread (&aux, sizeof (pelicula), 1, f);		// lee la info del primer registro y la almacena en aux
	
	while (*cont < N && !feof(f))
	{
		lista[*cont] = aux;
		printf ("%d - %s - %d (veces).\n", aux.codigo, aux.nombre, aux.veces_alq);
		fread (&aux, sizeof (pelicula), 1, f);
		(*cont)++;
	}
	fclose (f);
}


void cargar_fichero_completo (pelicula lista [], int cont)
{
	FILE *f = fopen("pelis.dat", "wb");

	fwrite (lista, sizeof(pelicula), cont, f);
	
	fclose(f);
}


void crear_fichero_tres (pelicula lista [], int cont)
{
	FILE *f = fopen("pelis.dat", "rb");
	FILE *g = fopen("alquiladas.txt", "w");

	pelicula aux;	// auxiliar tipo pelicula para guardar la info.
	
	if (f == NULL || g == NULL)
	{
		printf("Error. No se ha podido abrir algunos de los ficheros.\n");
		return;
	}
	
	printf ("\nLISTADO PELICULAS TOP:\n");
	fread (&aux, sizeof(pelicula), 1, f);

	for (int i = 0; i < TRES; i++)
	{
		printf("%s.\n", aux.nombre);
		fprintf (g, "\n%s", aux.nombre);		// escribira en 'alquiladas.txt' el titulo de la pelicula.
		fread (&aux, sizeof(pelicula), 1, f);
	}
	fclose (f);
	fclose (g);
}


void inicializar_alquiladas (pelicula lista [])
{
	for (int i = 0; i < N; i++)
		lista[i].veces_alq = -1;
}


void ordenar_datos (pelicula lista [])
{
	pelicula aux;	// auxiliar tipo pelicula para guardar el registro al hacer el intercambio (ordenamiento).
	
	for (int i = 0; i < N; i++)
		{
			for (int j = N - 1; j > i; j--)
			{
				if (lista[i].veces_alq < lista[j].veces_alq)
				{
					aux = lista[j];
					lista[j] = lista[j - 1];
					lista[j - 1] = aux;
				}
			}
		}	
}


int main ()
{
	pelicula lista [N];
	
	char seguir;
	int cont = 0;
	
	inicializar_alquiladas (lista);
	cargar_fichero_inicial (lista, &cont);	// 	Introducira en nuestra lista los datos del fichero en cuestion.
											//	Tb mostrara un listado de peliculas anteriormente registradas (si es que las hay).
	
	do
	{
		alta_peli (&cont, lista);
		desea_seguir (&seguir);
	}while (seguir == 'N' || seguir == 'n');
	
	ordenar_datos (lista);
	cargar_fichero_completo (lista, cont);	// aniadira las peliculas nuevas que se han registrado al fichero 'pelis.dat'.
	//listado_peliculas (lista, cont);		// funcion de control (borrar). Mostrara el total de peliculas del videoclub.
	crear_fichero_tres (lista, cont);		// lee de un fichero y escribe en otro.
}

