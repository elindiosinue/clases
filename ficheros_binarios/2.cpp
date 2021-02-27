/*
2)	Realizar un programa que lea un fichero binario "productos.dat" que 
contiene los productos que una empresa tiene en almacen. El fichero tiene 
la siguiente informacion:

-	Codigo de producto (longitud 5, por ejemplo "PR001").
-	Cantidad en stock (entero).

El programa debe dar como resultado un fichero con la misma estructura que 
el anterior llamado "reponer.dat" donde solo aparezcan los productos que se 
necesitan reponer.

Se necesita reponer un producto cuando exista en almacen una cantidad inferior 
a 20 unidades del producto.
*/


#include <stdio.h>

#define CAR 6		// caracteres cadena
#define MIN 20		// minimo productos

typedef struct
{
	char codigo[CAR];	// codigo articulos
	int cantidad;		// cantidad de articulos
}Articulo;


void crear_nuevo_fichero ()
{
	//Articulo aux2;
	
	FILE *f, *g;
	
	f = fopen ("productos.dat", "rb");
	g = fopen("reponer.dat", "wb");
	
	if (f == NULL)
		printf("\n\nError al abrir el archivo de productos.\n\n");
	else
	{
		fread (&aux2, sizeof(Articulo), 1, f);
		
		while (!feof(f))
		{
			if (aux2.cantidad <= MIN)
				fwrite(&aux2, sizeof(Articulo), 1, g);
				
			fread (&aux2, sizeof(Articulo), 1, f);
		}
	fclose(f);
	fclose(g);
	}
}


void leer_fichero ()
{
	Articulo aux;
	
	FILE * f;
	
	f = fopen("productos.dat", "rb");
	
	fread(&aux, sizeof(Articulo), 1, f);
	
	printf("\nContenido fichero 'Productos':\n");
	while(!feof(f))
	{
		printf("%s - %d\n", aux.codigo, aux.cantidad);
		fread(&aux, sizeof(Articulo), 1, f);
	}
	fclose(f);
}


void leer_fichero_nuevo ()
{
	Articulo aux;
	
	FILE * f;
	
	f = fopen("reponer.dat", "rb");
	
	fread(&aux, sizeof(Articulo), 1, f);
	
	printf("\nContenido fichero 'Reponer':\n");
	while(!feof(f))
	{
		printf("%s - %d\n", aux.codigo, aux.cantidad);
		fread(&aux, sizeof(Articulo), 1, f);
	}
	fclose(f);
}


int main()
{		
	leer_fichero ();
	crear_nuevo_fichero ();
	leer_fichero_nuevo ();
}
