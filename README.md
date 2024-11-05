


# **PARCIAL DE DESARROLLO DE SOFTWARE 2024**

Descripción del Proyecto
-

Magneto necesita reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens. Para esto, te ha contratado para desarrollar un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN. Para esto te ha pedido crear un programa con un metodo o funcion con la siguiente firma

```
boolean isMutant(String[] dna);
```
Este método recibe un arreglo de strings que representa una tabla de (NxN) con la secuencia de ADN. Las letras de los Strings solo pueden ser: A, T, C, G, que representan las bases nitrogenadas del ADN.

Objetivo
-
El objetivo de esta aplicación es analizar la estructura de una secuencia de ADN y determinar si corresponde a un mutante. Esto se logra identificando más de una secuencia de cuatro caracteres consecutivos idénticos en cualquier dirección: horizontal, vertical o diagonal.

**Ejemplo (Caso Mutante):**

```
 String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
```
En este caso el llamado a la funcion isMutant(dna) devuelve "true"

Endpoints de la API REST
-
**URL Base del Proyecto**

LINK → https://mi-api-magneto.onrender.com

**1. Detectar Mutante (POST)**

**Endpoint:** `/mutant`

**Método:** `POST`

**Descripción:** Este endpoint verifica si una secuencia de ADN pertenece a un mutante. Debe enviarse un JSON con el siguiente formato:
```
{
   "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
**Respuestas:**

`200 OK:` La secuencia corresponde a un mutante.

```
{
"mutant": true,
"message": "Es un mutante"
}
```

`403 Forbidden:` La secuencia corresponde a un humano.

```
{
    "mutant": false,
    "message": "No es un mutante"
}
```

**Ejemplo de Uso:**

POST → https://mi-api-magneto.onrender.com/mutant

**2. Obtener Estadísticas (GET)**

**Endpoint:** `/stats`

**Método:** `GET`

**Descripción:** Este endpoint devuelve estadísticas de las secuencias de ADN verificadas. La respuesta es un JSON con el siguiente formato:

```
{
    "countMutantDna": 1,
    "countHumanDna": 1,
    "ratio": 1.0
}
````
**Respuesta:**

- `countHumanDna:` Número de secuencias de ADN humano analizadas.
- `countMutantDna:` Número de secuencias de ADN mutante analizadas.
- `ratio:` Proporción de mutantes respecto a humanos analizados.
  
**Ejemplo de Uso:**
  
GET → https://mi-api-magneto.onrender.com/stats


