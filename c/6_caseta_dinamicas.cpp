/*
En una caseta de feria, se dispone de un fichero con los datos de los socios. Son estos:
 
-                  Codigo de socio (del 1 en adelante).
-                  Nombre del socio (de 30 caracteres).
-                  Antiguedad en la caseta (anios).
-                  Cuota a pagar (en euros).
 
Este fichero esta ordenado por codigo de socio, de forma que el codigo de socio coincide con la posicion del registro dentro del fichero.
 
Realizar un programa que lea codigos de socio por teclado y actualice la cuota a pagar de acuerdo con esta regla:
 
-                  Antiguedad 0-5 anios: subida 4%.
-                  Antiguedad 6-10 anios: subida 3%.
-                  Antiguedad mayor a 10 anios: subida 2%.
 
Se terminara el proceso cuando se introduzca el codigo de socio 0.

*/


#include <stdio.h>
#include<stdlib.h>
#include <string.h>

#define CAR 30
#define SUBIDA_MENOR 1.04
#define SUBIDA_MEDIA 1.03
#define SUBIDA_MAYOR 1.02

typedef struct {
    int codigo;
    char nombre[CAR];
    int antig;
    int cuota;
} caseta;

typedef struct nodo {
    caseta datosSocio;
    nodo *sig;
} nodoSocio;

void mostrar_menu() {

    printf("\n  MENU\n");
    printf("--------\n");
    printf("1). Alta socio.\n");
    printf("2). Actualizar cuota de socio.\n");
}

void leer_opcion(int *op) {
    do {
        printf("\nIntroduzca una opcion del menu: ");
        scanf("%d", op);
        fflush(stdin);
    } while ((*op) != 1 && (*op) != 2);
}

void insertar_nodo_en_lista(nodoSocio **lista, nodoSocio *aux) {
    if (*lista == NULL)
        *lista = aux;
    else {
        if (aux->datosSocio.codigo < (*lista)->datosSocio.codigo) {
            aux->sig = *lista;
            *lista = aux;
        } else {
            nodoSocio *busca = *lista;

            while ((busca->sig != NULL) && (aux->datosSocio.codigo > busca->sig->datosSocio.codigo))
                busca = busca->sig;

            aux->sig = busca->sig;
            busca->sig = aux;
        }
    }
    printf("\nNuevo socio dado de alta correctamente.\n");

    // mostrar_lista (borrar)
    /*nodoSocio *mostrar = *lista;
    while (mostrar != NULL)
    {
        printf("%d - %s - %d - %d\n", mostrar->datosSocio.codigo, mostrar->datosSocio.nombre, mostrar->datosSocio.antig, mostrar->datosSocio.cuota);
        mostrar = mostrar->sig;
    }*/
}

void pedir_codigo(int *codigo) {
    do {
        printf("\nIntroduzca el codigo (0 para salir): ");
        scanf("%d", codigo);
        fflush(stdin);
    } while (*codigo < 0);    // por si mete el cero para salir, que no se quede en bucle.
}

void pedir_nombre(char *nombre) {
    printf("\nIntroduzca el nombre: ");
    gets(nombre);
    fflush(stdin);
}

void pedir_antiguedad(int *antig) {
    printf("\nIntroduzca la antiguedad: ");
    scanf("%d", antig);
    fflush(stdin);
}

void pedir_cuota(int *cuota) {
    printf("\nIntroduzca la cuota: ");
    scanf("%d", cuota);
    fflush(stdin);
}

void insertar_fichero_en_lista(nodoSocio **lista, nodoSocio *nuevo) {
    if (*lista == NULL)
        *lista = nuevo;
    else {
        nodoSocio *busca_hueco = *lista;        // el fichero ya esta ordenado asi que insertamos al final

        while (busca_hueco->sig != NULL) {
            busca_hueco = busca_hueco->sig;
        }
        nuevo->sig = busca_hueco->sig;
        busca_hueco->sig = nuevo;
    }
}

void alta_socio(nodoSocio **lista) {
    nodoSocio *aux = (nodoSocio *) malloc(sizeof(nodoSocio));

    pedir_codigo(&(aux->datosSocio.codigo));

    if (aux->datosSocio.codigo == 0)
        return;
    else {
        pedir_nombre(aux->datosSocio.nombre);
        pedir_antiguedad(&(aux->datosSocio.antig));
        pedir_cuota(&(aux->datosSocio.cuota));

        aux->sig = NULL;

        insertar_nodo_en_lista(lista, aux);
    }
}

void calcular_cuota(nodoSocio **encontrado) {
    if ((*encontrado)->datosSocio.antig >= 0 && (*encontrado)->datosSocio.antig < 6)
        (*encontrado)->datosSocio.cuota = (*encontrado)->datosSocio.cuota * SUBIDA_MENOR;
    else {
        if ((*encontrado)->datosSocio.antig >= 6 && (*encontrado)->datosSocio.antig < 11)
            (*encontrado)->datosSocio.cuota = (*encontrado)->datosSocio.cuota * SUBIDA_MEDIA;
        else
            (*encontrado)->datosSocio.cuota = (*encontrado)->datosSocio.cuota * SUBIDA_MAYOR;
    }
}

nodoSocio *buscar_nodo(nodoSocio *lista, int codigo) {
    while (lista != NULL) {
        if (lista->datosSocio.codigo == codigo)
            return lista;
        else
            lista = lista->sig;
    }
    return NULL;
}

void actualizar_cuota_socio(nodoSocio *lista) {
    int codigo;

    if (lista == NULL) {
        printf("\nNo hay datos de socios.\n");
        return;
    }

    pedir_codigo(&codigo);

    if (codigo == 0)
        return;

    nodoSocio *encontrado = buscar_nodo(lista, codigo);

    if (encontrado == NULL)
        printf("\nEl codigo de socio no existe.\n");
    else {
        calcular_cuota(&encontrado);
        printf("\nLa cuota del socio %d se ha actualizado: %d euros.\n", encontrado->datosSocio.codigo,
               encontrado->datosSocio.cuota);
    }
}

void tratar_opcion(nodoSocio **lista, int *op) {
    switch (*op) {
        case 1:
            alta_socio(lista);
            break;
        case 2:
            actualizar_cuota_socio(*lista);
    }
}

void crear_nodo(nodoSocio **lista, caseta aux) {
    nodoSocio *nuevo = (nodoSocio *) malloc(sizeof(nodoSocio));

    nuevo->datosSocio.codigo = aux.codigo;
    strcpy(nuevo->datosSocio.nombre, aux.nombre);
    nuevo->datosSocio.antig = aux.antig;
    nuevo->datosSocio.cuota = aux.cuota;

    nuevo->sig = NULL;

    insertar_fichero_en_lista(lista, nuevo);
}

void leer_fichero_existente(nodoSocio **lista) {
    FILE *f = fopen("feria.dat", "rb");

    if (f == NULL)
        return;        // No imprimimos nada porque haya datos o no, se va a abrir el archivo y al usuario no le interesa

    caseta aux;

    fread(&aux, sizeof(caseta), 1, f);

    while (!feof(f)) {
        //printf("%d - %s - %d - %d\n", aux.codigo, aux.nombre, aux.antig, aux.cuota);		// (control: para ver lo que habia en el fichero)
        crear_nodo(lista, aux);
        fread(&aux, sizeof(caseta), 1, f);
    }
    fclose(f);
}

int desea_seguir(int *s) {
    do {
        printf("\nDesea realizar mas tramites? (1 -> Si / 0 -> No): ");
        scanf("%d", s);
        fflush(stdin);
    } while ((*s != 0) && (*s != 1));
}

void volcar_lista_en_fichero(nodoSocio *lista) {
    FILE *f = fopen("feria.dat", "wb");

    if (f == NULL)
        printf("\nNo se ha encontrado el archivo. Se creara uno nuevo.\n");

    while (lista != NULL) {
        fwrite((&lista->datosSocio), sizeof(caseta), 1, f);
        lista = lista->sig;
    }
    fclose(f);

    printf("\nSe han introducido los datos al fichero.\n");
}

void destruir_lista(nodoSocio *lista) {
    nodoSocio *aux;

    aux = lista;

    while (aux != NULL) {
        lista = lista->sig;
        free(aux);
        aux = lista;
    }
    printf("\nHemos destruido la lista.\n\n");
}

int main() {
    nodoSocio *lista = NULL;

    int opcion;

    leer_fichero_existente(&lista);

    do {
        mostrar_menu();
        leer_opcion(&opcion);
        tratar_opcion(&lista, &opcion);
        desea_seguir(&opcion);
    } while (opcion != 0);

    volcar_lista_en_fichero(lista);
    destruir_lista(lista);
}
