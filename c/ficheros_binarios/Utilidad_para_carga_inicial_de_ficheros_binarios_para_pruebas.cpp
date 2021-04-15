#include <stdio.h>

typedef struct
{
	char codigo[6];
	int cantidad;
}Articulo;


void main()
{
	Articulo lista[] = {{"A0001", 10}, {"A0002", 13}, {"A0003", 17}, {"A0004", 25}};
	FILE *f = fopen("productos.dat", "wb");
	fwrite(&lista, sizeof(Articulo), 4, f);
	fclose(f);

	/*
	Articulo aux;
	f = fopen("productos.dat", "rb");
	fread(&aux, sizeof(Articulo), 1, f);
	while(!feof(f))
	{
		printf("%s - %d\n", aux.codigo, aux.cantidad);
		fread(&aux, sizeof(Articulo), 1, f);
	}
	fclose(f);
	*/

	f = fopen("productos.dat", "rb");
	fread (&lista, sizeof(Articulo) * 4, 1, f);
	fclose(f);

	for (int i = 0; i < 4; i++)
		printf("%s - %d\n", lista[i].codigo, lista[i].cantidad);

}