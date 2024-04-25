# Base de datos

# Definiciones

### Dependencia funcional
Una dependencia funcional es una restriccion que se establece entre dos conjuntos de atributos. \
Una dependencia funcional, $X \rightarrow Y$ entre dos conjuntos de atributos $X$ e $Y$ que son subconjuntos de $R$, especifica en las posibles tuplas que puedan formar un estado de relacion $r$ de $R$.

#### Otra manera de verlo:
Sean dos tuplas de la relacion $R$ $t_1$ y $t_2$ y la dependencia funcional $X \rightarrow Y$ entonces 
$$\boxed{t_1 [X] = t_2 [X] \Rightarrow t_1[Y] = t_2[Y]}$$


### Reglas de inferencia
- RI1 (regla reflexiva): Si $Y\subseteq X \Rightarrow X \rightarrow Y$
- RI2 (regla de aumento): $\{X \rightarrow Y \} \vDash XZ \rightarrow YZ$
- RI3 (regla transitiva): $\{ X \rightarrow Y, Y \rightarrow Z \} \vDash X \rightarrow Z$
- RI4 (regla de descomposicion): $\{ X \rightarrow YZ \} \vDash X \rightarrow Y$
- RI5 (regla de union): $\{ X \rightarrow Y, X \rightarrow Z \} \vDash X \rightarrow YZ$
- RI6 (regla seudotransitiva): $\{X \rightarrow Y, WY \rightarrow Z \} \vDash WX \rightarrow Z$


### Clausura
Sea $F$ un conjunto de dependencias funcionales, la **clausura** de $F$, que anotamos como $F^+$, al conjunto de dependencias funcionales de $F$ junto con todas las dependencias funcionales que pueden inferirse de $F$.

### Cobertura
Sean dos conjuntos de dependencias funcionales $F$ y $E$.\
$F$ **cubre** a $E$ si $E \subset F^+$.

### Equivalencia
Dos conjuntos de dependencias funionales $E$ y $F$ son **equivalentes** si $E^+ = F^+$.

### Cobertura minima
Una cobertura minima del conjunto de dependencias funionales $E$ es un conjunto de dependencias funcionales $F$ tal que $F$ cubre a $E$ y que $\{F - f\}$ no cubre a $E$ para cualquier dependencia funcional $f\in F$.

### Conjunto minimo de dependencias funcionales
Un conjunto de dependencias funcionales $F$ es minimo si satisface las siguientes condiciones:
1. Toda dependencia de $F$ tiene un unico atributo en su lado derecho.
2. No podemos reemplazar ninguna dependencia $X \rightarrow A$ de $F$ por otra dependencia $Y \rightarrow A$ donde $Y\subset X$ y seguir teniendo un conjunto equivalente a $F$.
3. No podemos eliminar ninguna dependencia de $F$ y seguir teniendo un conjunto equivalente a $F$.

## Formas Normales

### Primera forma normal
Una relacion $R$ esta en primera forma normal si:
1. El dominio de todos los atributos $A$ de $R$ son valores atomicos. 
2. Los atributos $A$ de $R$ no son multivaluados ni compuestos.
3. No tiene relaciones dentro de las relaciones ni relaciones como valores de atributos dentro de las tuplas.

### Clave candidata
Si una restriccion de $R$ indica que no puede haber mas de una tupla con valor $X$ concreto en cualquier instancia de relacion $r(R)$ entonces $X$ es una **clave candidata** de $R$. Se cumplira que $X \rightarrow Y ~~ \forall ~ Y \subset R$

### Clave primaria y secundaria
Si en una relacion hay mas de una clave candidata, una de ellas se designa como clave primaria y el resto son calves secundarias.

### Atributo primo
Un atributo $A$ de una relacion $R$ con una clave candidata $X$ es **primo** si $A \in X$.

### Dependencia total
Una dependencia funcional $X \rightarrow Y$ es total si la eliminacion de un atributo $A \in X$ implica que la dependencia deja de ser valida.

### Dependencia parcial
Una dependencia funcional $X \rightarrow Y$ es total si al eliminar un atributo $A \in X$ la dependencia **sigue siendo valida**

### Segunda forma normal
Una relacion $R$ esta en segunda forma normal si cumple la primera forma normal y  todo atributo no primo $A \in R$ es completa y funcionalmente dependiente de la clave principal de R. 

### Dependencia transitiva
Una dependencia funcional $X \rightarrow Y$ en un esquema de relación $R$ es transitiva si existe un conjunto de atributos $Z$, que no es clave candidata ni un subconjunto de ninguna clave de $R$, y se cumple tanto $X \rightarrow Z$ como $Z \rightarrow Y$.

### Tercera forma normal
Un esquema de relacion $R$ esta en tercera forma normal si cumple la segunda forma normal y ningun atributo no primo $A \in R$ es transitivamente dependiente de la clave principal de $R$

### Superclave (libro)
Sea SK un subconjunto de atributos de $R$ tal que dos tuplas en el estado $r(R)$ $t_1$ y $t_2$ no pueden tener el mismo conjunto de valores para los atributos de SK. Esto es:
$$ t_1[SK] \ne t_2[SK] $$
A partir de esto podemos deducir que para todo atributo $Y$ si:
$$ t_1[SK] = t_2[SK] \Rightarrow t_1[Y] = t_2 [Y]$$
porque seran la misma tupla. Es decir, que las superclaves determinan a todos los elementos de la relacion.

### Forma normal de Boyce-Codd
Un esquema de relacion $R$ esta en Boyce-Codd si siempre que una dependencia funcional no trivial $X \rightarrow Y$ se cumple en $R$ entonces $X$ es una superclave de R.

## Relacion universal


Una relacion $R = \{A_1,A_2,...\}$ es universal si cada nombre de atributo $A_i$ es unico en $R$.



## Algoritmo para determinar la cobertura minima canonica

1. Establecer F = E.
2. Reemplazar cada dependencia funcional en F por las n dependencias funcionales
canonicas.
3. Para cada dependencia funcional $X \to A$ en F, por cada atributo B que es
un elemento de X si 
$$ \{\{ F - \{X \to A\} \cup  (X - \{ B \})\} \to A $$
es equivalente a F, entonces eliminar B de X.
4. Para cada dependencia funcional X -> A sobrante de F 
si $$ \{\{ F - \{X \to A \}\}$$
es equivalente a F, entonces eliminar X -> A


## Descomposicion de una relacion

### Condicion de conservacion de atributos.

En la descomposicion, cada atributo de R debe aparecer, al menos, en una relacion R_i
para que no se pierdan Atributos.

### Conservacion de las dependencias

Dado un conjunto de dependencias F en R, la proyeccion de F en $R_i$ que anotamos como: 
$\pi_{R_i} (F)$
donde $R_i$ es un subconjunto de $R$, es el conjunto de dependencias $X\rightarrow Y$ en $F^+$
tales que los atributos $X \cup Y$ se encuentran todos en $R_i$.

Una descomposicion $$ D = \{ R_1,R_2,..., R_m\} $$ de R conserva las dependencias respecto de F si:
$$ ((\pi_{R_1}(F)) \cup ... \cup (\pi_{R_m}))^+ = F^+ $$

## Descomposicion en esquemas 3NF con conservacion de dependencias

### Entradas:
- Una relacion universal R.
- Un conjunto F de dependencias funcionales en los atributos de R.

### Algoritmo:
1. Localizar una cobertura minima G para F.
2. Para cada X uzquierdo de una Dependencia funcional de G, crear un esquema de relacion $R_i$ con atributos
$$ X \cup \{ A_1,A_2,...,A_m\} $$ donde $$ X \to A_1,A_2,...,A_m $$
son las unicas dependencias funcionales en G que tienen X como parte izquierda.
3. Colocar cualquier atributo sobrante en un solo esquema de relacion para asegurar la propiedad de 
conservacion de los atributos.


## Concatenacion sin perdida

Una descomposicion $D = \{R_1,R_2,...,R_m\}$ de $R$, cumple con la propiedad
de concatenación sin pérdida respecto al conjunto de dependencias funcionales F en R,
si para cada estado de relacion r de R que satisface F, se mantiene lo siguiente:
$$ join(\pi_{R_1}(r),\pi_{R_2}(r), ...,\pi_{R_m}(r))= r$$

La propiedad de concatenación sin pérdida garantiza
que no se generarán tuplas falsas cuando se aplica un
join a las relaciones de la descomposición.

- Comprobacion para caso binario:
$D=\{ R_1, R_2\}$ \
$(R_1 \cap R_2) \to (R_1 - R_2)$ \
or \
$(R_1 \cap R_2) \to (R_2 - R_1)$

### Verificacion de concatenacion sin perdida

1. Crear una matriz $S$ con una fila $i$ para cada relacion $R_i$ en D y una columna $j$ para cada atributo $A_j$ en $R$.
2. Asignar a todas las celdas de la matriz un valor $b_{ij}: S(i,j) = b_{ij}$
3. Para cada fila $i$ que representa un esquema de relacion $R_i$ si el atributo $A_j$ pertenece a $R_i$ entonces asignar $a_j$ a $S(i,j)$
4. Para cada dependencia funcional $X \to A$ en $F$, igualar los simbolos en atributos de $Y$ para las filas que coinciden en los valores de los atributos de $X$.
Repterir el paso hasta que una ejecucion completa del mismo no genere cambios en $S$.
5. Si una fila esta compuesta por simbolos $a_j$, entonces la descomposicion cumple con la propiedad de concatenacion sin perdida.

# Clase 1 de abril de 2024


## Transacciones

### Clasificacion de DBMS

Segun el num de usuarios que trabajan al mismo tiempo tenemos 2 tipos: monousuario y multiusuario
Nos preocupamos de los multiusuarios.

En la base de datos multiusuarios pueden ejecutarse procesos de forma concurrente.
Se pueden generar inconsistencias entre los datos/tablas.
(* Es como un Race condition sort of thing *)

Dos transacciones se le llaman (por ejemplo) T1 y T2

$T1:$
$$read\_item(X); \\
X:= X-N;\\
write\_item(X);\\
read\_item(Y);\\
Y:=Y+N;\\
write\_item(Y);\\
$$

$T2:$
$$read\_item(X); \\
X:= X+M;\\
write\_item(X);\\
$$


Al actuar sobre los mismos datos y la base de datos ser multiusuario (los procesos se ejecutan en paralelo, intercalados, multithreaded)
$X$ puede terminar incorrecto/inconsistente.
Por ejemplo:
1. T1 lee X 
2. T1 modifica X a X'
3. T2 lee X 
4. T2 modifica X a X''
5. T1 guarda X'
6. T2 guarda X''
7. T1 continua con la transaccion

el resultado es que X termina siendo X'' cuando tendria que haber sido otro, X''' por decir algo, que sea el resultado de leer X' y modificarlo segun T2.
Esto va a ser inconsistente con nuestra realidad.

Este problema se llama "la perdida de actualizacion"

---
Si esto no tiene mucho sentido, recorda el ejemplo de los likes de youtube, que al varios usuarios acceder al mismo tiempo la cuenta total puede quedar incorrecta.

---

Tampoco podemos separar cada transaccion por los datos que maneja porque si a lo largo de T1, debido a algo que tenga que ver con Y T1 falla, entonces T2 va a haber leido un valor *temporal* de X que como T1 fallo lo va a reescribir e ignorar T2.


## Definicion de transaccion

Es una unidad atomica de trabajo que se completa en su totalidad o no se lleva a cabo.

Hay que hacer seguimiento de cuando se inicia, termina, confirma y aborta una transaccion.


## Control de concurrencia

Coordina los procesos concurrentes que operan sobre datos compartidos y que pueden interferirse.

### Propiedades deseables (ACID)

1. $\bold{A}$tomicidad
2. conservacion de la $\bold{C}$onsistencia
3. aislamiento ($\bold{I}$solation)
4. $\bold{D}$urabilidad (esta es opcional, hay fallos que pueden hacer que se pierdan datos)

### Operaciones

Las transacciones estan compuestas por operaciones.
Estas pueden ser:

$$
\begin{array}{c|c|c|c}
read\_item(X) & write\_item(X) & commit & abort \\
r_i(X) & w_i(X) & c_i & a_i \\
\end{array}
$$

Tambien esta el ***rollback***, que ocurre cuando hay un abrot. \
El DBMS se encarga de llevar la base de datos a su estado anterior (el estado que es consistente)

## Historias

- Cuando las transacciones se están ejecutando concurrentemente en modo interpolado, el orden de ejecución de las distintas transacciones se conoce como planificación o historia
- La historia es una ordenación de todas las operaciones que intervienen en las transacciones
- Las operaciones deben aparecer en el mismo orden que en cada una de las transacciones

#### Operaciones en conflicto

Dos operaciones estan en conflicto si cumple con las tres:

1. Pertenecen a diferentes transacciones.
2. Acceden al mismo elemento X.
3. Por lo menos una de las operaciones es un write ($w_i$)

Esto es algo mas como un **puede** estar en conflicto.

#### Historia completa

Todas las operaciones de las transacciones aparecen en el mismo orden que en las transacciones.

#### Historias seriales

Una historia es serial si las transacciones se realizan en cadena.

#### Historias enlazadas

Una historia es enlazada si alterna entre transacciones en sus operaciones.

#### Historias equivalentes

**Definicion intuitiva:** Dos historias son equivalentes si dejan la base de datos en el mismo estado al finalizar las operaicones.

**Definicion por conflictos:** Dos historias son equivalentes si las operaciones en conflicto aparecen en el mismo orden en ambas.

#### Historias serializables

Un historia (enlazada) es serializable si es equivalente a una historia serial.\
Claramente todas las historias seriales son serializables.

### Grafos de seriabilidad

1. Poner un nodo por cada transaccion de la historia.
2. Crear un arco (edge) entre $T_j$ a $T_i$ si:
- Si $r_i(X)$ esta despues de $w_j(X)$ \
- Si $w_i(X)$ esta despues de $r_j(X)$ \
- Si $w_i(X)$ esta despues de $w_j(X)$

#### Ciclos y seriabilidad
Un ciclo es cuando a partir de un nodo puedo llegar a cualquier nodo de un conjunto y volver al inicial. \
Si el conjunto de nodos es todo el grafo se llama al ciclo completo. \
Si el conjunto no contiene algunos nodos, el ciclo es parcial.\
Si el grafo de seriabilidad es completo, la historia es seriabilizable.\
Si el grafo de seriabilidad tiene ciclos parciales, la historia no es seriabilizable.


### Clasificacion de historias


