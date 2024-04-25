# Quantum Computing

## Informacion y computacion

#### Hay 4 postulados.

1. Unidad de informacion basica.
Qbit, Espacio vectorial complejo.
2. Como se "agrupan" estas unidades de informacion?
Producto tensorial.
3. Como opero con esta informacion? Como la hago evolucionar?
Matriz unitaria, preserva la norma.
4. Como la accedo?

## Qbit como abstraccion matematica

EL qbit puede tener dos estados $\left| 0 \right>$ y el $\left| 1 \right>$ y puede estar en una superposicion de ambos estados de la forma: $\alpha \left| 0 \right> + \beta \left| 1 \right>$ con $\alpha ,\beta \in \Bbb{C}$ y $|\alpha|^2 + |\beta|^2 = 1$

Que es $\left| 0 \right>$ y $\left| 1 \right>$?
$$|0\rangle = \begin{bmatrix} 1 \\ 0 \\ \end{bmatrix}$$
$$|1\rangle = \begin{bmatrix} 0 \\ 1 \\ \end{bmatrix}$$

---

La notacion $|\varphi\rangle$ es notacion para expresar un complejo de $\Bbb{C}^2$ pero no es mas que eso. \
ES UN VECTOR.

---

$$|\varphi\rangle = 
\begin{bmatrix}
\alpha \\ 
\beta \\
\end{bmatrix} \text{con }\alpha , \beta \in \Bbb{C}$$
En teoria, un qbit puede almacenar infinita informacion... pero vamos a ver que no es el caso.

## Primer postulado de la mecanica cuantica:


A todo sistema fisico cerrado se le asocia un espacio de Hilbert $H$. A todos los estados del sistema se les asocia un vector unitario de $H$ y describe completamente el sistema

---


$\underline{Espacio\ de\ Hilbert}$: Espacio vectorial con producto interno completo. Esto significa que toda sucesion de Cauchy (una sucesion chiquita) converge (respecto a la norma inducida por dicho producto interno).


Los Qbits son los vectores de $\Bbb{C} ^2$con norma 1 segun el PI usual.

$$ \| | \varphi \rangle \|^2 = \langle \varphi | \varphi \rangle ,\langle \varphi | = (\alpha | 0 \rangle + \beta | 1 \rangle )^\dagger = \alpha ^* \langle 0 | + \beta ^* \langle 1 |$$ 
$$ \Rightarrow \langle \varphi | \varphi \rangle = (\alpha ^* \langle 0 | + \beta ^* \langle 1 |)(\alpha | 0 \rangle + \beta | 1 \rangle ) = |\alpha |^2 \langle 0 | 0 \rangle + \beta ^* \alpha \langle 1 | 0 \rangle + \beta \alpha ^* \langle 0 | 1 \rangle + |\beta|^2 \langle 1 | 1 \rangle $$
$$ \Rightarrow \langle \varphi | \varphi \rangle = |\alpha| ^2 + |\beta| ^2 $$
$\Rightarrow$ Pedir que $|\alpha| ^2 + |\beta| ^2 = 1$ es equivalente a pedir que sea unitario.

Por que queremos que la representacion de un estado de un sistema cerrado sea unitaria?

## Segundo postulado de la mecanica cuantica:

Los resultados de las mediciones de un sistema se corresponden con la proyeccion en el espacio $H$ y cada posible resultado estara asociado a una probabilidad coincidente con la norma de la proyeccion en dicho espacio.

---

La medicion depende puramente del aparato de medida, pero solo se recupero o $|0 \rangle$ o $|1 \rangle$

$P_{|0\rangle}(|\varphi\rangle)=\underbrace{\langle 0|\varphi\rangle }_{\text{Modulo}} \overbrace{|0\rangle}^{\text{Direccion}}$

$P_{|0\rangle}(|\varphi\rangle)=\langle 0|\varphi\rangle  |0\rangle$

### Matrices de proyeccion (Operadores)

Sobre $|0\rangle$ es $|0\rangle\langle 0|$ \
Sobre $|1\rangle$ es $|1\rangle\langle 1|$

$P_{|0 \rangle}(|\varphi\rangle) = \alpha$ \
$P_{|1 \rangle}(|\varphi\rangle) = \beta$


Ademas de la base $|0\rangle,\ |1\rangle$ tambien tenemos otras bases.
$$\boxed{|+\rangle = \frac{|0\rangle + |1\rangle}{\sqrt{2}},\ 
|-\rangle = \frac{|0\rangle - |1\rangle}{\sqrt{2}} }$$
$$\boxed{|i\rangle = \frac{|0\rangle + i|1\rangle}{\sqrt{2}},\ 
|-i\rangle = \frac{|0\rangle - i|1\rangle}{\sqrt{2}} }$$


## Representacion mental del Qbit

$$\left.
\begin{array}{l}
\alpha = r_{\alpha}e^{i\theta_{\alpha}} \\
\beta = r_{\beta}e^{i\theta_{\beta}} \\
\end{array}
\right\}
\Rightarrow |\varphi\rangle = 
r_{\alpha}e^{i\theta_{\alpha}}|0\rangle + r_{\beta}e^{i\theta_{\beta}}|1\rangle =
e^{i\theta_{\alpha}} (r_{\alpha}|0\rangle + r_{\beta}e^{i\theta_{\beta}-i\theta_{\alpha}}|1\rangle )
$$
$$|\varphi\rangle = \underbrace{e^{i\psi}}_{\text{No medible, termino independiente}} (r_{\alpha}|0\rangle + r_{\beta}e^{i\theta}|1\rangle ) =
\boxed{r_{\alpha}|0\rangle + r_{\beta}e^{i\theta}|1\rangle }$$

Entonces:

$|\varphi\rangle = r_{\alpha}|0\rangle + r_{\beta}e^{i\theta}|1\rangle$
con $|r_{\alpha}|^2 +|r_{\beta}e^{i\theta}|^2 = 1$

$\Rightarrow r_{\alpha}^2 + r_{\beta}^2 = 1$ \
$\Rightarrow 
\left\{
\begin{array}{l}
r_{\alpha} = \cos{\frac{\theta}{2}} \\
r_{\beta} = \sin{\frac{\theta}{2}} \\
\end{array}
\right.$

$\Rightarrow |\varphi\rangle = \cos{\frac{\theta}{2}}|0\rangle + 
\sin{\frac{\theta}{2}}|1\rangle$ que es la parametrizacion de una esfera.

## Esfera de Bloch

Aqui un dibujo de la esfera quedaria muy bien. Descargar del libro o escanear dibujo.

## Tercer postulado de la mecanica cuantica:

La evolucion temporal de un sistema cuantico cerrado se describe mediante la ecuachion de Schrodinger:
$$i \hbar \frac{d|\varphi\rangle}{dt} = H|\varphi\rangle$$
donde $H$ es el $\underbrace{\underline{Hamiltoneano}}_{\text{Matriz hermitica}}$ del sistema

La solucion a la ecuacion de Schrodinger es $\boxed{e^{-i \hbar H t}|\varphi\rangle}$

### Observacion importante

Si en $t_1$ el sistema se encuentra en un estado $|\varphi_1\rangle$, entonces en un tiempo $t_2$ el sistema se encontrara en el estado
$|\varphi_2\rangle = e^{-i H (t_2 - t_1)}|\varphi_1\rangle$

los operadores de evolucion son de la forma
$e^{-i H \Delta t}$ 

$$(e^{-i H \Delta t})^\dagger e^{-i H \Delta t} = 
e^{i H \Delta t} e^{-i H \Delta t} = 
e^\mathbf{0} = I_d $$ $$\Rightarrow e^{-i H \Delta t} \text{son matrices hermiticas}
$$
>Nota cortita: el $e^\mathbf{0}$ es $e$ elevado a la matriz $0$. No al complejo $0$.


### Postulado 3 simplificado:

La evolucion temporal de un sistema cuantico cerrado es descripto por operadores unitarios.

Como preservan las normas, los Qbits siguen siendo Qbits y ademas tienen inverso. 
Las QC siempre son reversibles.
(QC significa compuera cuantica)




## Compuertas Cuanticas (QC):

$NOT|0\rangle = |1\rangle$ \
$NOT|1\rangle = |0\rangle$

$NOT = \begin{pmatrix} 0 & 1 \\ 1 & 0 \end{pmatrix} = X$

---

Defino $z\ /\ z|0\rangle = |0\rangle ,\  z|1\rangle = -|1\rangle$ \
$\Rightarrow z(\alpha |0\rangle + \beta|1\rangle ) = \alpha|0\rangle - \beta|1\rangle$

Finalmente, defino $y = \begin{pmatrix} 0 & -i \\ i & 0 \end{pmatrix} \Rightarrow
y|i\rangle = |i\rangle ,\ y|-i\rangle = -|-i\rangle$

${x,y,z}={\sigma_x,\sigma_y,\sigma_z}$ son las compuertas de Pauli, son giros de 180° en los tres ejes de la esfera de Bloch y cumplen algunas propiedades:

Si ${x,y,z}=\{1,2,3\} \Rightarrow \sigma_i \sigma_j = \delta_{ij}\sigma_0 + i\epsilon_{ijk}\sigma_k$

$$\epsilon_{ijk} = 
\left\{\begin{array}{l}
1 & \text{si}\ (i,j,k)=(1,2,3),\ (2,3,1),\ (3,1,2) \\
-1 & \text{si} ? \\
0 & \text{si no se repiten} \\
\end{array}\right.
$$


Si hago X con X, Y con Y o Z con Z me da la $I_d$ (no hace nada), pero si aplico dos seguidas distintas es como aplicar la restante.
Hay mas compuertas, por ejemplo: $H|0\rangle = |+\rangle ,\ H|1\rangle = |-\rangle$


## Teorema

Si $A^2 = I_d \Rightarrow 
e^{iAx} = \cos(x)I_d + i\sin(x)A$

(Sale por Taylor este)



