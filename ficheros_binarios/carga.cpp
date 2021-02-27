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


void escribir_info_fichero (Articulo lista[])
{
	FILE *f;
	
	f = fopen("productos.dat", "wb");
	fwrite(&lista, sizeof(Articulo), 4, f);
	fclose(f);
}


void escribir_nuevo_fichero (Articulo aux)
{
	FILE *g;
	
	g = fopen("reponer.dat", "wb");
	
	if (aux.cantidad <= MIN)
	{
		fwrite(&aux, sizeof(Articulo), 4, g);
	}
	fclose(g);
}


void leer_fichero (Articulo lista[])
{
	Articulo aux;
	
	FILE * f;
	
	f = fopen("productos.dat", "rb");
	
	fread(&aux, sizeof(Articulo), 1, f);
	
	while(!feof(f))
	{
		printf("%s - %d\n", aux.codigo, aux.cantidad);
		fread(&aux, sizeof(Articulo), 1, f);
	}
	fclose(f);
}


int main()
{	
	Articulo lista[] = {{"A0001", 10}, {"A0002", 13}, {"A0003", 17}, {"A0004", 25}};
		
	escribir_info_fichero (lista);
	leer_fichero (lista);
}
