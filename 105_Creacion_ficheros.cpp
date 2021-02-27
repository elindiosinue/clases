#include <stdio.h>

typedef struct
{
	int numero;
	char nombre[30];
	char vip;
}Socio;


void main()
{
	Socio lista[] = {{1, "Miguel", 'S'}, {2, "Manuel", 'S'}, {3, "Manuela", 'N'}};
	
	FILE *f = fopen("socios.dat", "wb");
	fwrite(&lista, sizeof(Socio), 3, f);
	fclose(f);

	Socio aux;
	f = fopen("socios.dat", "rb");
	fread(&aux, sizeof(Socio), 1, f);
	while(!feof(f))
	{
		printf("%d - %s - %c\n", aux.numero, aux.nombre, aux.vip);
		fread(&aux, sizeof(Socio), 1, f);
	}
	fclose(f);
}