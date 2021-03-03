/*
Examen subgrupo 2 (Tema 4)
*/

#include <stdio.h>
#include<stdlib.h>
#include<time.h>
#include <string.h>
#include <ctype.h>

#define CAR 30
#define NIF 10
#define NOM 40

typedef struct
{
    int dia;
    int mes;
    int anio;
    int semilla;
}fecha;

typedef struct
{
    int codigo;
    char descrip[CAR];
}articulo;

typedef struct nodo_a
{
    articulo datosArticulo;
    struct nodo_a *sig;
}nodoArticulo;

typedef struct
{
    char nif[NIF];
    char nombre[NOM];
}vendedor;

typedef struct nodo_vd
{
    vendedor datosVendedor;
    struct nodo_vd *sig;
}nodoVendedor;

typedef struct
{
    articulo datosArticulo;
    vendedor datosVendedor;
    fecha fechaVenta;
    int uni_vend;
    float precio;
}venta;

typedef struct nodo_v
{
    venta datosVenta;
    struct nodo_v *sig;
}nodoVenta;

void mostrar_menu ()
{

    printf ("\n  MENU\n");
    printf ("--------\n");
    printf ("1). Alta de articulos.\n");
    printf ("2). Consulta de articulos.\n");
    printf ("3). Alta de vendedores.\n");
    printf ("4). Consulta de vendedores\n");
    printf ("5). Alta de ventas\n");
    printf ("6). Consulta de ventas de un vendedor\n");
    printf ("7). Consulta de ventas de un articulo\n");
    printf ("8). Articulo mas vendido.\n");
    printf ("9). Vendedor mas productivo.\n");
    printf ("10). Salir.\n");
}

void leer_opcion (int *op)
{
    do
    {
        printf("\nIntroduzca opcion: ");
        scanf("%d", op);
        fflush(stdin);
    }while ((*op) != 1 && (*op) != 2 && (*op) != 3 && (*op) != 4 &&
            (*op) != 5 && (*op) != 6 && (*op) != 7 && (*op) != 8 && (*op) != 9 && (*op) != 10);
}

void pedir_codigo (int *cod)
{
    do
    {
        printf("\nIntroduzca el codigo: ");
        scanf("%d", cod);
        fflush(stdin);
    }while (*cod < 100 || *cod > 999);
}

void pedir_unidades (int *unidades)
{
    do
    {
        printf("\nIntroduzca las unidades vendidas: ");
        scanf("%d", unidades);
        fflush(stdin);
    }while (*unidades < 0);
}

void pedir_precio (float *precio)
{
    do
    {
        printf("\nIntroduzca el precio: ");
        scanf("%f", precio);
        fflush(stdin);
    }while (*precio < 0);
}

void pedir_descripcion (char descripcion[])
{
    printf("\nIntroduzca la descripcion: ");
    gets (descripcion);
    fflush(stdin);
}

void insertar_articulo_en_lista (nodoArticulo **lista_art, nodoArticulo *aux)
{
    if (*lista_art == NULL)
        *lista_art = aux;
    else
    {
        if (aux->datosArticulo.codigo < (*lista_art)->datosArticulo.codigo)
        {
            aux->sig = (*lista_art);
            (*lista_art) = aux;
        }
        else
        {
            nodoArticulo *busca = (*lista_art);

            while (busca->sig != NULL && (busca->sig->datosArticulo.codigo < aux->datosArticulo.codigo))
                busca = busca->sig;

            aux->sig = busca->sig;
            busca->sig = aux;
        }
    }
    printf ("\nSe ha dado de alta un nuevo articulo.\n");
}

void alta_articulos(nodoArticulo **lista_art)
{
    nodoArticulo *aux;

    aux = (nodoArticulo*)malloc (sizeof(nodoArticulo));

    pedir_codigo (&(aux->datosArticulo.codigo));
    pedir_descripcion (aux->datosArticulo.descrip);

    aux->sig = NULL;

    insertar_articulo_en_lista (lista_art, aux);
}

void consulta_articulos (nodoArticulo *lista_art)
{
    if (lista_art == NULL)
    {
        printf ("\nNo existen articulos para mostrar.\n");
        return;
    }

    printf ("\nLISTADO ARTICULOS:\n----------------------\n");

    while (lista_art != NULL)
    {
        printf ("%d - %s\n", lista_art->datosArticulo.codigo, lista_art->datosArticulo.descrip);
        lista_art = lista_art->sig;
    }
}

void consulta_vendedores (nodoVendedor *lista_vend)
{
    if (lista_vend == NULL)
    {
        printf ("\nNo existen vendedores para mostrar.\n");
        return;
    }

    printf ("\nLISTADO VENDEDORES:\n----------------------\n");

    while (lista_vend != NULL)
    {
        printf ("%s - %s\n", lista_vend->datosVendedor.nif, lista_vend->datosVendedor.nombre);
        lista_vend = lista_vend->sig;
    }
}

void pedir_nif (char nif[])
{
    printf("\nIntroduzca el nif: ");
    gets (nif);
    fflush(stdin);
}

void pedir_nombre (char nombre[])
{
    printf("\nIntroduzca el nombre: ");
    gets (nombre);
    fflush(stdin);
}

void insertar_vendedor_en_lista (nodoVendedor **lista_vend, nodoVendedor *aux)
{
    if (*lista_vend == NULL)
        *lista_vend = aux;
    else
    {
        if (strcmp(aux->datosVendedor.nif, (*lista_vend)->datosVendedor.nif) < 0)
        {
            aux->sig = (*lista_vend);
            (*lista_vend) = aux;
        }
        else
        {
            nodoVendedor *busca = (*lista_vend);

            while (busca->sig != NULL && (strcmp (busca->sig->datosVendedor.nif, aux->datosVendedor.nif) < 0))
                busca = busca->sig;

            aux->sig = busca->sig;
            busca->sig = aux;
        }
    }
    printf ("\nSe ha dado de alta un nuevo vendedor.\n");
}

void alta_vendedores (nodoVendedor **lista_vend)
{
    nodoVendedor *aux;

    aux = (nodoVendedor*)malloc (sizeof(nodoVendedor));

    pedir_nif (aux->datosVendedor.nif);
    pedir_nombre (aux->datosVendedor.nombre);

    aux->sig = NULL;

    insertar_vendedor_en_lista (lista_vend, aux);
}

int buscar_nif (nodoVendedor *lista_vend, char aux_nif[])
{
    while (lista_vend != NULL)
    {
        if (strcmp(lista_vend->datosVendedor.nif, aux_nif) == 0)
            return 1;
        else
            lista_vend = lista_vend -> sig;
    }
    return 0;
}

int buscar_cod (nodoArticulo *lista_art, int cod)
{
    while (lista_art != NULL)
    {
        if (lista_art->datosArticulo.codigo == cod)
            return 1;
        else
            lista_art = lista_art -> sig;
    }
    return 0;
}

void pedir_fecha_venta (int *dia, int *mes, int *anio)
{
    //do
    //{
    printf ("Introduzca la fecha de venta (dd/mm/aaaa): ");
    scanf ("%d/%d/%d", dia, mes, anio);
    fflush (stdin);
    //}while (!comprobar_fecha(*dia, *mes, *anio));

}

void insertar_venta_en_lista (nodoVenta **lista_vent, nodoVenta *aux)
{
    if (*lista_vent == NULL)
        *lista_vent = aux;
    else
    {
        if ((aux->datosVenta.fechaVenta.anio < (*lista_vent)->datosVenta.fechaVenta.anio) ||
            (aux->datosVenta.fechaVenta.anio == (*lista_vent)->datosVenta.fechaVenta.anio) &&
            (aux->datosVenta.fechaVenta.mes < (*lista_vent)->datosVenta.fechaVenta.mes) ||
            (aux->datosVenta.fechaVenta.anio == (*lista_vent)->datosVenta.fechaVenta.anio) &&
            (aux->datosVenta.fechaVenta.mes == (*lista_vent)->datosVenta.fechaVenta.mes) &&
            (aux->datosVenta.fechaVenta.dia <= (*lista_vent)->datosVenta.fechaVenta.dia))
        {
            aux->sig = (*lista_vent);
            (*lista_vent) = aux;
        }
        else
        {
            nodoVenta *busca = (*lista_vent);

            while (busca->sig != NULL && (busca->sig->datosVenta.fechaVenta.anio <= aux->datosVenta.fechaVenta.anio) &&
                   (aux->datosVenta.fechaVenta.mes <= (*lista_vent)->datosVenta.fechaVenta.mes) &&
                   (aux->datosVenta.fechaVenta.dia < (*lista_vent)->datosVenta.fechaVenta.dia))
                busca = busca->sig;

            aux->sig = busca->sig;
            busca->sig = aux;
        }
    }
    printf ("\nVenta efectuada correctamente.\n");
}

void consulta_ventas_vendedor (nodoVenta *lista_vent)
{
    /*char nif[NIF];

    if (lista_vent == NULL)
    {
        printf ("\nNo existen articulos para mostrar.\n");
        return;
    }

    pedir_nif (nif);
    printf ("\nLISTADO DE VENTAS POR VENDEDOR:\n-------------------------------\n");

    while (lista_vent != NULL)
    {
        if (strcmp(nif, lista_vent->datosVenta.datosVendedor.nif) == 0)
            printf ("%d/%d/%d - %d - %d\n", (&(lista_vent->datosVenta.fechaVenta.dia)), &(lista_vent->datosVenta.fechaVenta.mes),
                    &(lista_vent->datosVenta.fechaVenta.anio), &(lista_vent->datosVenta.datosArticulo.codigo), &(lista_vent->datosVenta.uni_vend));
            //lista_vent = lista_vent->sig;

        lista_vent = lista_vent->sig;
    }*/
    if (lista_vent == NULL)
    {
        printf ("\nNo existen articulos para mostrar.\n");
        return;
    }

    printf ("\nLISTADO DE VENTAS:\n--------------------\n");

    while (lista_vent != NULL)
    {
        printf ("%d/%d/%d - %d - %d\n", (&(lista_vent->datosVenta.fechaVenta.dia)), (&(lista_vent->datosVenta.fechaVenta.mes)),
                (&(lista_vent->datosVenta.fechaVenta.anio)), (&(lista_vent->datosVenta.datosArticulo.codigo)), (&(lista_vent->datosVenta.uni_vend)));

        lista_vent = lista_vent->sig;
    }
}

void alta_ventas (nodoVenta **lista_vent, nodoArticulo **lista_art, nodoVendedor **lista_vend)
{
    char aux_nif[NIF];
    int cod;

    pedir_nif (aux_nif);
    pedir_codigo (&cod);

    if (buscar_nif (*lista_vend, aux_nif) && (buscar_cod (*lista_art, cod)))
    {
        nodoVenta *aux;

        aux = (nodoVenta*)malloc(sizeof(nodoVenta));

        strcpy(aux->datosVenta.datosVendedor.nif, aux_nif);
        pedir_fecha_venta (&(aux->datosVenta.fechaVenta.dia), &(aux->datosVenta.fechaVenta.mes), &(aux->datosVenta.fechaVenta.anio));
        aux->datosVenta.datosArticulo.codigo = cod;
        pedir_unidades (&(aux->datosVenta.uni_vend));
        pedir_precio (&(aux->datosVenta.precio));

        aux->sig = NULL;

        insertar_venta_en_lista (lista_vent, aux);
    }
    else
        printf ("\nNo existe algunos de los datos introducidos (dni del vendedor o codigo del articulo).\n");
}

void tratar_opcion (nodoVenta **lista_vent, nodoArticulo **lista_art, nodoVendedor **lista_vend, int op)
{
    switch (op)
    {
        case 1: alta_articulos(lista_art);
            break;
        case 2: consulta_articulos(*lista_art);
            break;
        case 3: alta_vendedores(lista_vend);
            break;
        case 4: consulta_vendedores(*lista_vend);
            break;
        case 5: alta_ventas(lista_vent, lista_art, lista_vend);
            break;
        case 6: consulta_ventas_vendedor(*lista_vent);
            break;
            /*case 7: consulta_ventas_articulo();
                    break;
            case 8: articulo_mas_vendido();
                    break;
            case 9: vendedor_mas_productivo();*/
    }
}


int main ()
{
    nodoVenta *lista_vent = NULL;
    nodoArticulo *lista_art = NULL;
    nodoVendedor *lista_vend = NULL;

    int opcion;

    do
    {
        mostrar_menu ();
        leer_opcion (&opcion);
        tratar_opcion (&lista_vent, &lista_art, &lista_vend, opcion);
    }while (opcion != 10);
}
