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
#define TRES 3

typedef struct
{
	int codigo;
	char nombre[CAR];
	int veces_alq;
}pelicula;

typedef struct nodo
{
	pelicula datosPeli;
	struct nodo *sig;
}nodoPeli;


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


nodoPeli * numero_repetido (int cod, nodoPeli *lista)
{
	while (lista != NULL)
		if (cod == lista -> datosPeli.codigo)
			return lista;
		else
			lista = lista -> sig;
	
	return 0;
}


void insertar_nodo_en_lista (nodoPeli **lista, nodoPeli *aux)
{
	if (*lista == NULL)
		*lista = aux;
	else
	{
		if ((*lista) -> datosPeli.veces_alq, aux -> datosPeli.veces_alq)	// si el nodo es mas grande q el primero de la lista...
		{
			aux -> sig = *lista;
			*lista = aux;			// lo colocamos el primero.
		}
		else	// si el nodo es mas pequenio que el primero
		{
			nodoPeli *nuevo = *lista;
					
			while (nuevo -> sig != NULL)
			{
				if (nuevo -> sig -> datosPeli.veces_alq, aux -> datosPeli.veces_alq)	// si el siguiente de nuevo es mas grande que el nodo a introducir...
					nuevo = nuevo -> sig;
			}
			aux -> sig = nuevo -> sig;
			nuevo -> sig = aux;
		}
	}
}


void alta_peli (nodoPeli **lista)
{
	int codigo;
	
	nodoPeli *aux;
	nodoPeli *repe;
	
	pedir_codigo (&codigo);
	repe = numero_repetido (codigo, *lista);
		
	if (!repe)
	{
		aux = (nodoPeli*) malloc (sizeof (nodoPeli));
			
		aux -> datosPeli.codigo = codigo;
		pedir_nombre (aux -> datosPeli.nombre);
		aux -> datosPeli.veces_alq = 1;
			
		aux -> sig = NULL;
		
		insertar_nodo_en_lista (lista, aux);
		printf ("\nLa pelicula se ha alquilado una vez.\n");
	}
	else
	{
		(repe -> datosPeli.veces_alq)++;
			
		printf ("\nLa pelicula se ha alquilado otra vez.\n");
	}
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


void cargar_fichero_completo (nodoPeli *lista)
{
	FILE *f = fopen("pelis.dat", "wb");
	
	if (f == NULL)
	{
		printf("Error. No se ha podido abrir el fichero.\n");
		return;
	}
	
	printf ("\nLISTADO DE TODAS LAS PELICULAS:\n");
	while (lista != NULL)
	{
		printf ("\n%d - %s - %d ", lista -> datosPeli.codigo, lista -> datosPeli.nombre, lista -> datosPeli.veces_alq);
			
		if (lista -> datosPeli.veces_alq == 1)
			printf ("vez.\n");
		else
			printf ("veces.\n");
				
		fwrite ((&lista ->datosPeli), sizeof(pelicula), 1, f);
		lista = lista -> sig;
	}
	fclose(f);
}


void crear_fichero_tres (nodoPeli *lista)
{
	FILE *f = fopen ("pelis.dat", "rb");
	FILE *g = fopen ("alquiladas.txt", "w");
	
	if (f == NULL || g == NULL)
	{
		printf("Error. No se ha podido abrir algunos de los ficheros.\n");
		return;
	}
	
	pelicula aux;
		
	printf ("\nLISTADO PELICULAS TOP:\n");
	fread (&aux, sizeof(pelicula), 1, f);

	for (int i = 0; i < TRES; i++)
	{
		printf("%s.\n", aux.nombre);
		fprintf (g, "\n%s", aux.nombre);		// escribira en 'alquiladas.txt' el titulo de la pelicula.
		fread (&aux, sizeof(pelicula), 1, f);
	}
	
	fclose(f);
	fclose(g);		
}


void crear_nodo (pelicula aux, nodoPeli **lista)
{
	nodoPeli *nuevo = (nodoPeli*) malloc (sizeof (nodoPeli));  		// reservo espacio para meter aqui la la info que 'tiene' aux
	
	nuevo -> datosPeli.codigo = aux.codigo;
	strcpy (nuevo -> datosPeli.nombre, aux.nombre);
	nuevo -> datosPeli.veces_alq = aux.veces_alq;
	
	nuevo -> sig = NULL;		// terminamos de crear el nodo.
	
	insertar_nodo_en_lista (lista, nuevo);	// reutilizamos la funcion
}


void cargar_fichero_inicial (nodoPeli **lista)
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
	
	while (!feof (f))
	{
		crear_nodo (aux, lista);
		printf ("%d - %s - %d (veces).\n", aux.codigo, aux.nombre, aux.veces_alq);
		fread (&aux, sizeof (pelicula), 1, f);
	}
	fclose (f);
}


int main ()
{
	nodoPeli *lista = NULL;
	
	char seguir;
	
	cargar_fichero_inicial (&lista);
	
	do
	{
		alta_peli (&lista);
		desea_seguir (&seguir);
	}while (seguir == 'N' || seguir == 'n');
	
	cargar_fichero_completo (lista);
	crear_fichero_tres (lista);
}
